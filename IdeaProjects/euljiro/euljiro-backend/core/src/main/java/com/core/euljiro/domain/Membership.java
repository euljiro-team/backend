package com.core.euljiro.domain;

import com.core.euljiro.domain.pk.MembershipPK;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "membership")
@IdClass(MembershipPK.class)
public class Membership implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @Column(name = "mmbrshp_type", nullable = false)
    private String mmbrshpType;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "available_cnt")
    private Integer availableCnt;

}
