package com.core.euljiro.dto;


import com.core.euljiro.common.EnumMaster;
import com.core.euljiro.domain.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
public class AccountDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer accountId;
    private String username;
    private String password;
    private String email;
    private String koreanName;
    private String englishName;
    private String phone;
    private EnumMaster.RoleType role;

    private List<EnumMaster.RoleType> accountRoles;
    private LocalDateTime createdAt = LocalDateTime.now();

    private Integer accountSnsId;
    private String providerType;
    private String accessToken;
    private String refreshToken;
    private LocalDateTime expired;
    private String snsAccount;
    private EnumMaster.Status status;

    public AccountDTO(String name) {
        this.username = name;
        this.englishName = name;
        this.status = EnumMaster.Status.ACTIVE;
    }

    public AccountDTO(Account account) {
        this.accountId = account.getAccountId();
        this.username = account.getUsername();
        this.password = account.getPassword();
        this.email = account.getEmail();
        this.koreanName = account.getKoreanName();
        this.englishName = account.getEnglishName();
        this.phone = account.getPhone();
        this.role = account.getRole();
        this.status = account.getStatus();
        this.accountRoles = account.getAccountRoles().stream()
                .map(role -> role.getRoleType())
                .collect(Collectors.toList());
    }
}
