package com.api.oauth.info;

import com.api.oauth.info.impl.FacebookOAuth2UserInfo;
import com.api.oauth.info.impl.GoogleOAuth2UserInfo;
import com.api.oauth.info.impl.KakaoOAuth2UserInfo;
import com.api.oauth.info.impl.NaverOAuth2UserInfo;
import com.core.euljiro.common.EnumMaster;

import java.util.Map;

public class OAuth2UserInfoFactory {
    public static OAuth2UserInfo getOAuth2UserInfo(EnumMaster.ProviderType providerType, Map<String, Object> attributes) {
        switch (providerType) {
            case GOOGLE: return new GoogleOAuth2UserInfo(attributes);
            case FACEBOOK: return new FacebookOAuth2UserInfo(attributes);
            case NAVER: return new NaverOAuth2UserInfo(attributes);
            case KAKAO: return new KakaoOAuth2UserInfo(attributes);
            default: throw new IllegalArgumentException("Invalid Provider Type.");
        }
    }
}
