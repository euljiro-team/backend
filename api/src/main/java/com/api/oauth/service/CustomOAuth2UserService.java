package com.api.oauth.service;

import com.api.oauth.entity.UserPrincipal;
import com.api.oauth.info.OAuth2UserInfo;
import com.api.oauth.info.OAuth2UserInfoFactory;
import com.core.euljiro.common.EnumMaster;
import com.core.euljiro.domain.Account;
import com.core.euljiro.domain.AccountRole;
import com.core.euljiro.repository.AccountRepository;
import com.core.euljiro.repository.AccountRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final AccountRepository accountRepository;
    private final AccountRoleRepository accountRoleRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);

        try {
            return this.process(userRequest, user);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User process(OAuth2UserRequest userRequest, OAuth2User user) {

        EnumMaster.ProviderType providerType = EnumMaster.ProviderType.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase());
        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(providerType, user.getAttributes());

        Account savedAccount = new Account();
        if (providerType.equals(EnumMaster.ProviderType.GOOGLE)) {
            savedAccount = accountRepository.findByEmail(userInfo.getEmail());
            if (savedAccount != null) {
//                if (providerType != savedAccount.getProviderType()) {
//                    throw new OAuthProviderMissMatchException(
//                            "Looks like you're signed up with " + providerType +
//                            " account. Please use your " + savedAccount.getProviderType() + " account to login."
//                    );
//                }
                updateUser(savedAccount, userInfo);
            } else {
                savedAccount = createUser(userInfo, providerType);
            }
        }

        List<AccountRole> savedAccountRoleList = accountRoleRepository.findByAccount_Email(userInfo.getEmail());
        return UserPrincipal.create(savedAccount, user.getAttributes(), savedAccountRoleList);
    }

    private Account createUser(OAuth2UserInfo userInfo, EnumMaster.ProviderType providerType) {
        LocalDateTime now = LocalDateTime.now();
        Account account = new Account(
                userInfo.getId(),
                userInfo.getName(),
                userInfo.getPhone(),
                userInfo.getEmail(),
                "Y",
                userInfo.getImageUrl(),
                providerType,
                EnumMaster.RoleType.GUEST,
                now,
                now
        );
        accountRepository.saveAndFlush(account);
        AccountRole accountRole = new AccountRole(EnumMaster.RoleType.of("GUEST"), account);
        accountRoleRepository.saveAndFlush(accountRole);
        return account;
    }

    private Account updateUser(Account account, OAuth2UserInfo userInfo) {
        if (userInfo.getName() != null && !account.getUsername().equals(userInfo.getName())) {
            account.setUsername(userInfo.getName());
        }

        if (userInfo.getImageUrl() != null && !account.getProfileImageUrl().equals(userInfo.getImageUrl())) {
            account.setProfileImageUrl(userInfo.getImageUrl());
        }

        return account;
    }
}
