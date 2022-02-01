package com.core.euljiro.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "meta_table")
public class MetaTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 단어
     */
    @Id
    @Column(name = "WORD", nullable = false)
    private String WORD;

    /**
     * 코멘트
     */
    @Column(name = "COMMENTS")
    private String COMMENTS;

    @Column(name = "fst_crt_dt")
    private Date fstCrtDt;

    /**
     * 최초생성자
     */
    @Column(name = "FST_CRT_ID")
    private String fstCrtId;

    @Column(name = "lst_mdf_dt")
    private Date lstMdfDt;

    /**
     * 최종수정자
     */
    @Column(name = "LST_MDF_ID")
    private String lstMdfId;

    @Column(name = "del_yn")
    private String delYn;

}
