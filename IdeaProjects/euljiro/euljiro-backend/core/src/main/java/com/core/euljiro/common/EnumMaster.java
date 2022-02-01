package com.core.euljiro.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

public class EnumMaster {
    public enum AccountGradeType {
        A, B, C
    }

    @Getter
    @RequiredArgsConstructor
    public enum RoleType {
        EN9DOOR_STUDENT("EN9DOOR_STUDENT", "영어문 학생"),
        EN9DOOR_TEACHER("EN9DOOR_TEACHER", "영어문 선생님"),
        EN9DOOR_MANAGER("EN9DOOR_MANAGER", "영어문 관리자"),

        USER("ROLE_USER", "일반 사용자 권한"),
        ADMIN("ROLE_ADMIN", "관리자 권한"),
        GUEST("GUEST", "게스트 권한");

        private final String code;
        private final String displayName;

        public static RoleType of(String code) {
            return Arrays.stream(RoleType.values())
                    .filter(r -> r.getCode().equals(code))
                    .findAny()
                    .orElse(GUEST);
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
