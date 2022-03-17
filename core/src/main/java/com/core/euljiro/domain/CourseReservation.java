package com.core.euljiro.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "crs_rsv")
public class CourseReservation {

    @Column(name="crs_id")
    private Long crsId; // 수업아이디

    @Column(name = "mmbrshp_id", nullable = false)
    private Integer mmbrshpId; // 멤버십 아이디

    @Id
    @Column(name = "account_id", nullable = false)
    private Integer accountId;
}
