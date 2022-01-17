package com.core.euljiro.common.platform;

import com.core.euljiro.common.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "admin", schema = "euljiro")
@Getter
@AllArgsConstructor
public class Admin {

    @Id @GeneratedValue
    @Column(name = "admin_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @NotNull
    Account account;

}
