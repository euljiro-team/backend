package com.core.euljiro.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "account_role")
public class AccountRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_role_id", nullable = false)
    private Integer accountRoleId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "role_type", nullable = false)
    private String roleType;

    @Column(name = "account_id")
    private Integer accountId;

}
