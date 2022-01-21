package com.core.euljiro.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class DevUsersDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 아이디
     */
    private Integer ID;


    /**
     * 사용자명
     */
    private String userName;


    /**
     * 비밀번호
     */
    private String PASSWORD;


    /**
     * 활성화여부
     */
    private String ENABLED;

}
