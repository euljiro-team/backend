package com.core.euljiro.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class AdminDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer adminId;

    private Integer accountId;

    private String fstCrtDt;

    private String fstCrtId;

    private String lstMdfDt;

    private String lstMdfId;

}
