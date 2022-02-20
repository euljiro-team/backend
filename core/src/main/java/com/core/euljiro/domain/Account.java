package com.core.euljiro.domain;

import com.core.euljiro.common.EnumMaster;
import com.core.euljiro.dto.AccountDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "account", schema = "euljiro")
public class Account implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer accountId;

    @Column(name = "USER_ID", length = 64)
    //@NotNull
    @Size(max = 64)
    private String userId = "";

    @Column(name = "username")
    private String username= "";

    @Column(name = "password")
    private String password= "";

    @Column(name = "email", length = 512, unique = true)
    @NotNull
    @Size(max = 512)
    private String email= "";

    @Column(name = "korean_name")
    private String koreanName= "";

    @Column(name = "english_name")
    private String englishName= "";

    @Column(name = "phone")
    private String phone= "";

    @Column(name = "EMAIL_VERIFIED_YN", length = 1)
//    @NotNull
    @Size(min = 1, max = 1)
    private String emailVerifiedYn= "N";

    @Column(name = "PROFILE_IMAGE_URL", length = 512)
    @Size(max = 512)
    private String profileImageUrl= "";

    @Column(name = "PROVIDER_TYPE", length = 20)
    @Enumerated(EnumType.STRING)
//    @NotNull
    private EnumMaster.ProviderType providerType;

    @Enumerated(EnumType.STRING)
    private EnumMaster.RoleType role;

    @Column(name = "access_token", length = 256)
    @Size(max = 256)
    private String accessToken;

    @Column(name = "refresh_token", length = 256)
    //@NotNull
    @Size(max = 256)
    private String refreshToken;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumMaster.Status status = EnumMaster.Status.ACTIVE;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "MODIFIED_AT")
    //@NotNull
    private LocalDateTime modifiedAt = LocalDateTime.now();

    @JsonBackReference
    @OneToMany(mappedBy = "account" ,cascade = CascadeType.ALL)
    private List<AccountRole> accountRoles;

    //@JsonBackReference
    //@OneToMany(mappedBy = "account" ,cascade = CascadeType.ALL)
    //private List<AccountSns> accountSnsList;

    public Account(AccountDTO accountDto) {
       this.username = accountDto.getUsername();
       this.password = accountDto.getPassword();
       this.email = accountDto.getEmail();
       this.koreanName = accountDto.getKoreanName();
       this.englishName = accountDto.getEnglishName();
       this.phone = accountDto.getPhone();
    }

    public static Account createAccount(AccountDTO accountDTO, PasswordEncoder passwordEncoder) {
        Account account = new Account();
        account.username = accountDTO.getUsername();
        account.email = accountDTO.getEmail();
        account.password = passwordEncoder.encode(accountDTO.getPassword());
        account.phone = accountDTO.getPhone();
        return account;
    }

    public Account(
            @NotNull @Size(max = 64) String userId,
            @NotNull @Size(max = 100) String username,
            @NotNull @Size(max = 20) String phone,
            @NotNull @Size(max = 512) String email,
            @NotNull @Size(max = 1) String emailVerifiedYn,
            @NotNull @Size(max = 512) String profileImageUrl,
            @NotNull EnumMaster.ProviderType providerType,
            @NotNull EnumMaster.RoleType roleType,
            @NotNull LocalDateTime createdAt,
            @NotNull LocalDateTime modifiedAt
    ) {
        this.userId = userId;
        this.username = username;
        this.password = "NO_PASS";
        this.phone = phone;
        this.email = email != null ? email : "NO_EMAIL";
        this.emailVerifiedYn = emailVerifiedYn != null ? emailVerifiedYn : "N";
        this.profileImageUrl = profileImageUrl != null ? profileImageUrl : "";
        this.providerType = providerType;
        this.role = roleType;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.status = EnumMaster.Status.ACTIVE;

        this.englishName = username;
    }

    public Account(Integer id) {
        this.accountId = id;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        ArrayList<GrantedAuthority> auth = new ArrayList<>();
//        String prefix = "ROLE_";
//        String postfix = this.getRole().name();
//        auth.add(new SimpleGrantedAuthority(prefix + postfix));
//        return auth;
//    }

}
