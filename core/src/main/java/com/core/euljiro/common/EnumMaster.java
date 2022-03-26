package com.core.euljiro.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

public class EnumMaster {

    @Getter
    @RequiredArgsConstructor
    public enum RoleType {
        ROLE_SYS_ADMIN("ROLE_ADMIN", "시스템관리자"),
        ROLE_CENTER_ADMIN("ROLE_CENTER", "지점관리자"),
        ROLE_USER("ROLE_USER", "일반사용자"),
        ROLE_TRAINER("ROLE_TRAINER", "트레이너"),
        ROLE_GUEST("ROLE_GUEST", "게스트");

        private final String code;
        private final String displayName;

        public static RoleType of(String code) {
            return Arrays.stream(RoleType.values())
                    .filter(r -> r.getCode().equals(code))
                    .findAny()
                    .orElse(ROLE_GUEST);
        }
    }

    @Getter
    public enum ProviderType {
        GOOGLE,
        FACEBOOK,
        NAVER,
        KAKAO,
        LOCAL;
    }

    public enum Status {
        ACTIVE, INACTIVE
    }

    public enum PagingType {
        DEFAULT, POST
    }

    public enum SortType {
        NEWEST, OLDEST, VIEW_COUNT
    }

    @Getter
    @RequiredArgsConstructor
    public enum PaymentType{
        TOSSPAY("tossPay"),
        KAKAOPAY("kakaoPay"),
        NAVERPAY("naverPay");

        private final String payType;
    }
}
