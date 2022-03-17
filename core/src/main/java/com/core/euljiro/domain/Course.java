package com.core.euljiro.domain;


import com.core.euljiro.common.BaseTimeEntity;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "course")
public class Course extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="crs_id")
    private Long crsId; // 수업아이디

    @NotNull
    @Column(name="cntr_id")
    private Integer cntrId; // 센터_id

    @Column(name="crs_nm")
    private String crsNm; // 수업명

    @Column(name="crs_dwk")
    private Integer crsDwk; // 수업요일

    @NotNull
    @Column(name="thcr_id")
    private Integer thcrId ; // 강사아이디

    @NotNull
    @Column(name="crs_strt_hh")
    private String crsStrtHh; //수업 시작시간

    @NotNull
    @Column(name="crs_strt_mi")
    private String crsStrtMi; //수업 시작분

    @NotNull
    @Column(name="crs_hr")
    private Integer crsHr ; //수업소요시간

    @NotNull
    @Column(name="mbr_num")
    private Integer mbrNum; // 수강 가능 인원

    @NotNull
    @Column(name="reg_num")
    private Integer regNum;

    @NotNull
    @Column(name="crs_strt_dt")
    private LocalDate crsStrtDt ; //수업시작일

    @NotNull
    @Column(name="crs_end_dt")
    private LocalDate crsEndDt;
}
