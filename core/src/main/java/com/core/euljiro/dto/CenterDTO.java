package com.core.euljiro.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CenterDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer centerId;

    private String address;

    private String name;

    private String operatingHour;

    private String telNo;

    private Integer accountId;

}
