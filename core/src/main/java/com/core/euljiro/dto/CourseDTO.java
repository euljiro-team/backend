package com.core.euljiro.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private Long crsId; // 수업아이디

    private String crsNm; // 수업명

    private Integer crsDwk; // 수업요일 0: 일, 1:월 , 2: 화, 3: 수 , 4: 목, 5:금 , 6: 토

    private Integer thcrId ; // 강사아이디

    private String crsStrtHh; //수업 시작시간
    
    private String crsStrtMi ; //수업 시작분

    private Integer crsHr ; //수업소요시간

    private Integer mbrNum; // 수강 가능 인원

    private String crsStrtDt ; //수업시작일

    private String crsEndDt ; //수업종료일
}
