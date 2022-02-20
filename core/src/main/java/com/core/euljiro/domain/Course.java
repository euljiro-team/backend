package com.core.euljiro.domain;


import com.core.euljiro.common.BaseTimeEntity;
import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "course")
public class Course extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crsId; // 수업아이디

    private String crsNm; // 수업명

    @NotNull
    private Integer crsDwk; // 수업요일

    @NotNull
    private Integer thcrId ; // 강사아이디

    @NotNull
    private String crsStrtHh; //수업 시작시간

    @NotNull
    private String crsStrtMi; //수업 시작분

    @NotNull
    private Integer crsHr ; //수업소요시간

    @NotNull
    private Integer mbrNum; // 수강 가능 인원

    @NotNull
    private String crsStrtDt ; //수업시작일

    @NotNull
    private String crsEndDt ; //수업종료일

}
