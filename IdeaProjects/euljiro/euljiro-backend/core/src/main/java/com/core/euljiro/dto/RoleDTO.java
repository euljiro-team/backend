package com.core.euljiro.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 사용자번호
     */
    private Integer ID;


    /**
     * 권한명
     */
    private String NAME;

}
