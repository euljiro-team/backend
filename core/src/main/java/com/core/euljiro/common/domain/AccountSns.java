package com.core.euljiro.common.domain;


import com.core.euljiro.EnumMaster;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_sns")
public class AccountSns {
    @JsonIgnore
    @Id
    @Column(name = "account_sns_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountSnsId;

    @Column(name = "user_id", length = 64, unique = true)
    @NotNull
    @Size(max = 64)
    private String userId;

    @Column(name = "sns_email")
    private String snsEmail;

    @Column(name = "access_token", length = 256)
    @Size(max = 256)
    private String accessToken;

    @Column(name = "refresh_token", length = 256)
    @NotNull
    @Size(max = 256)
    private String refreshToken;

    @Column(name = "email_verified_yn", length = 1)
    @NotNull
    @Size(min = 1, max = 1)
    private String emailVerifiedYn;

    @Column(name = "profile_image_url", length = 512)
    @NotNull
    @Size(max = 512)
    private String profileImageUrl;

    @Column(name = "provider_type", length = 20)
    @Enumerated(EnumType.STRING)
    @NotNull
    private EnumMaster.ProviderType providerType;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;

    public AccountSns(
            @NotNull @Size(max = 64) String userId,
            @NotNull String snsEmail,
            @NotNull @Size(max = 1) String emailVerifiedYn,
            @NotNull @Size(max = 512) String profileImageUrl,
            @NotNull EnumMaster.ProviderType providerType,
            @NotNull String accessToken,
            @NotNull @Size(max = 256) String refreshToken,
            Account account
    ) {
        this.userId = userId;
        this.snsEmail = snsEmail;

        this.emailVerifiedYn = emailVerifiedYn;
        this.profileImageUrl = profileImageUrl != null ? profileImageUrl : "";
        this.providerType = providerType;

        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.account = account;
    }

}
