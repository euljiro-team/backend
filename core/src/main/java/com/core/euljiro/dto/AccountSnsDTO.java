package com.core.euljiro.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AccountSnsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long accountSnsId;

    private String accessToken;

    private Date createdAt;

    private String emailVerifiedYn;

    private String profileImageUrl;

    private String providerType;

    private String refreshToken;

    private String snsEmail;

    private String userId;

    private Integer accountId;

}
