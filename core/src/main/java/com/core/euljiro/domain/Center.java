package com.core.euljiro.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "center")
public class Center implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "center_id", nullable = false)
    private Integer centerId;

    @Column(name = "address")
    private String address;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "operating_hour")
    private String operatingHour;

    @Column(name = "tel_no")
    private String telNo;

    @Column(name = "account_id")
    private Integer accountId;

}
