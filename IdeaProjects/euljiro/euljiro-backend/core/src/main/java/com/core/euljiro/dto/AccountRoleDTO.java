package com.core.euljiro.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AccountRoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer accountRoleId;

    private Date createdAt;

    private String roleType;

    private Integer accountId;

}
