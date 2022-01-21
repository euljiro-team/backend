package com.core.euljiro.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "account_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "email")
    private String email;

    @Column(name = "EMAIL_VERIFIED_YN")
    private String emailVerifiedYn;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "korean_name")
    private String koreanName;

    @Column(name = "MODIFIED_AT", nullable = false)
    private Date modifiedAt;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "PROFILE_IMAGE_URL")
    private String profileImageUrl;

    @Column(name = "PROVIDER_TYPE")
    private String providerType;

    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;

    @Column(name = "role")
    private String role;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Column(name = "username")
    private String username;

}
