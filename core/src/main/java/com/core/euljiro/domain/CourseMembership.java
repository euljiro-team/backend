package com.core.euljiro.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "crs_mmbrshp")
public class CourseMembership implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "crs_id", nullable = false)
    private Long crsId;

    @Column(name = "mmbrshp_id", nullable = false)
    private Integer mmbrshpId;

}
