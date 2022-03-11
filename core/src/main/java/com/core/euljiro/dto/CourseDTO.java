package com.core.euljiro.dto;


import com.core.euljiro.domain.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private Long crsId; // 수업아이디

    private String crsNm; // 수업명

    private Integer crsDwk; // 수업요일 0: 일, 1:월 , 2: 화, 3: 수 , 4: 목, 5:금 , 6: 토

    private Integer cntrId; // center id

    private Integer thcrId ; // 강사아이디

    private String crsStrtHh; //수업 시작시간
    
    private String crsStrtMi ; //수업 시작분

    private Integer crsHr ; //수업소요시간

    private Integer mbrNum; // 수강 가능 인원

    private Integer regNum; // 신청 인원

    private LocalDate crsStrtDt ; //수업시작일

    private LocalDate crsEndDt ; //수업종료일

    public CourseDTO(Course course) {
        this.crsId = course.getCrsId();
        this.crsNm = course.getCrsNm();
        this.crsDwk = course.getCrsDwk();
        this.cntrId = course.getCntrId();
        this.thcrId  = course.getThcrId();
        this.crsStrtHh = course.getCrsStrtHh();
        this.crsStrtMi  = course.getCrsStrtMi();
        this.crsHr  = course.getCrsHr();
        this.mbrNum = course.getMbrNum();
        this.regNum = course.getRegNum();
        this.crsStrtDt  = course.getCrsStrtDt();
        this.crsEndDt  = course.getCrsEndDt();
    }
}
