package com.core.euljiro.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MetaTableDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 단어
     */
    private String WORD;


    /**
     * 코멘트
     */
    private String COMMENTS;

    private Date fstCrtDt;


    /**
     * 최초생성자
     */
    private String fstCrtId;

    private Date lstMdfDt;


    /**
     * 최종수정자
     */
    private String lstMdfId;

    private String delYn;

}
