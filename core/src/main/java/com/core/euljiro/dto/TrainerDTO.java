package com.core.euljiro.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class TrainerDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer trainerId;

    private String awardHist;

    private Integer height;

    private String nickName;

    private Integer centerId;

}
