package com.core.euljiro.domain.pk;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class MembershipPK implements Serializable {

    @Id
    @Column(name = "mmbrshp_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mmbrshpId;

    @Id
    @Column(name = "mmbrshp_code", nullable = false)
    private String mmbrshpCode;

    @Id
    @Column(name = "center_id", nullable = false)
    private Integer centerId;

}
