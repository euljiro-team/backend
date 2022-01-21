package com.core.euljiro.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "account_sns")
public class AccountSns implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "account_sns_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountSnsId;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "email_verified_yn", nullable = false)
    private String emailVerifiedYn;

    @Column(name = "profile_image_url", nullable = false)
    private String profileImageUrl;

    @Column(name = "provider_type", nullable = false)
    private String providerType;

    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;

    @Column(name = "sns_email")
    private String snsEmail;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "account_id")
    private Integer accountId;

}
