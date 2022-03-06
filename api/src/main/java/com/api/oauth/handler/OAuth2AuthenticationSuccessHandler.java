package com.api.oauth.handler;

import com.api.config.properties.AppProperties;
import com.api.oauth.info.OAuth2UserInfo;
import com.api.oauth.info.OAuth2UserInfoFactory;
import com.api.oauth.repository.OAuth2AuthorizationRequestBasedOnCookieRepository;
import com.api.oauth.token.JwtTokenProvider;
import com.core.common.util.CookieUtil;
import com.core.euljiro.common.EnumMaster;
import com.core.euljiro.domain.Account;
import com.core.euljiro.domain.AccountSns;
import com.core.euljiro.repository.AccountRepository;
import com.core.euljiro.repository.AccountRoleRepository;
import com.core.euljiro.repository.AccountSnsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.api.oauth.repository.OAuth2AuthorizationRequestBasedOnCookieRepository.REDIRECT_URI_PARAM_COOKIE_NAME;
import static com.api.oauth.repository.OAuth2AuthorizationRequestBasedOnCookieRepository.REFRESH_TOKEN;

@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired      private JwtTokenProvider jwtTokenProvider;
    @Autowired    private AccountRepository accountRepository;
    @Autowired    private AccountRoleRepository accountRoleRepository;
    @Autowired    private AccountSnsRepository accountSnsRepository;
    private final AppProperties appProperties;
    private final OAuth2AuthorizationRequestBasedOnCookieRepository authorizationRequestRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(request, response, authentication);

        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

        clearAuthenticationAttributes(request, response);
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Optional<String> redirectUri = CookieUtil.getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME)
                .map(Cookie::getValue);

        if(redirectUri.isPresent() && !isAuthorizedRedirectUri(redirectUri.get())) {
            throw new IllegalArgumentException("Sorry! We've got an Unauthorized Redirect URI and can't proceed with the authentication");
        }

        String targetUrl = redirectUri.orElse(getDefaultTargetUrl());

        OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) authentication;
        EnumMaster.ProviderType providerType = EnumMaster.ProviderType.valueOf(authToken.getAuthorizedClientRegistrationId().toUpperCase());

        OidcUser user = ((OidcUser) authentication.getPrincipal());
        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(providerType, user.getAttributes());
        Collection<? extends GrantedAuthority> authorities = ((OidcUser) authentication.getPrincipal()).getAuthorities();

        Account account = accountRepository.findByEmail(userInfo.getEmail());
        EnumMaster.RoleType roleType = account.getRole();
        List<String> roleList = accountRoleRepository.findByAccount_AccountId(account.getAccountId()).stream()
                .map(accountRole -> accountRole.getRoleType().getCode())
                .collect(Collectors.toList());

        String accessToken = jwtTokenProvider.createAccessToken(
                userInfo.getEmail(),
                roleList
        );

        String refreshToken = jwtTokenProvider.createRefreshToken(
                appProperties.getAuth().getTokenSecret(),
                roleList
        );

        account.setAccessToken(accessToken);
        account.setRefreshToken(refreshToken);
        accountRepository.save(account);

        // DB 저장
        AccountSns accountSns = accountSnsRepository.findBySnsEmail(userInfo.getEmail());
        if (accountSns != null) {
        } else {
            accountSns = new AccountSns(
                    userInfo.getId(),
                    userInfo.getEmail(),
                    "Y",
                    userInfo.getImageUrl(),
                    providerType,
                    accessToken,
                    refreshToken,
                    account);
            accountSnsRepository.saveAndFlush(accountSns);
        }

        CookieUtil.deleteCookie(request, response, REFRESH_TOKEN);
        CookieUtil.addCookie(response, REFRESH_TOKEN, refreshToken, 30 * 60 * 1000);

        return UriComponentsBuilder.fromUriString(targetUrl)
                .queryParam("token", accessToken)
                .build().toUriString();
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response) {
        super.clearAuthenticationAttributes(request);
        authorizationRequestRepository.removeAuthorizationRequestCookies(request, response);
    }

    private boolean hasAuthority(Collection<? extends GrantedAuthority> authorities, String authority) {
        if (authorities == null) {
            return false;
        }

        for (GrantedAuthority grantedAuthority : authorities) {
            if (authority.equals(grantedAuthority.getAuthority())) {
                return true;
            }
        }
        return false;
    }

    private boolean isAuthorizedRedirectUri(String uri) {
        URI clientRedirectUri = URI.create(uri);

        return appProperties.getOauth2().getAuthorizedRedirectUris()
                .stream()
                .anyMatch(authorizedRedirectUri -> {
                    // Only validate host and port. Let the clients use different paths if they want to
                    URI authorizedURI = URI.create(authorizedRedirectUri);
                    if(authorizedURI.getHost().equalsIgnoreCase(clientRedirectUri.getHost())
                            && authorizedURI.getPort() == clientRedirectUri.getPort()) {
                        return true;
                    }
                    return false;
                });
    }
}
