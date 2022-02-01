package com.core.euljiro.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class MembershipDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer mmbrshpId;

    private String mmbrshpCode;

    private Integer centerId;

    private String mmbrshpType;

    private String name;

    private Integer price;

    private Integer availableCnt;

}
