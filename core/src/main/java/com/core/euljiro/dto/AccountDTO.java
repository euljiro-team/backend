package com.core.euljiro.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AccountDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer accountId;

    private String accessToken;

    private Date createdAt;

    private String email;

    private String emailVerifiedYn;

    private String englishName;

    private String koreanName;

    private Date modifiedAt;

    private String password;

    private String phone;

    private String profileImageUrl;

    private String providerType;

    private String refreshToken;

    private String role;

    private String status;

    private String userId;

    private String username;

}
