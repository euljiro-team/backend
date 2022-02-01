package com.core.euljiro.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "admin")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "admin_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    @Column(name = "account_id", nullable = false)
    private Integer accountId;

    @Column(name = "fst_crt_dt")
    private String fstCrtDt;

    @Column(name = "fst_crt_id")
    private String fstCrtId;

    @Column(name = "lst_mdf_dt")
    private String lstMdfDt;

    @Column(name = "lst_mdf_id")
    private String lstMdfId;

}
