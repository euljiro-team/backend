package com.core.euljiro.domain;

import com.core.euljiro.common.EnumMaster;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "account_role")
public class AccountRole {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "account_role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountRoleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type",nullable = false)
    private EnumMaster.RoleType roleType;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "center_id")
    private Center center;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    public AccountRole(EnumMaster.RoleType roleType, Account account) {
        this.roleType = roleType;
        this.account = account;
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
