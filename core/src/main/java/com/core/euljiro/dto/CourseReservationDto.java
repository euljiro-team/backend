package com.core.euljiro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
public class CourseReservationDto {

    @NotNull
    private Long crsId; // 수업아이디

    @NotNull
    private Integer mmbrshpId; // 멤버십 아이디

    @NotNull
    private Integer accountId;

    @Builder
    public CourseReservationDto(Long crsId, Integer mmbrshpId , Integer accountId){
        this.crsId = crsId;
        this.mmbrshpId = mmbrshpId;
        this.accountId = accountId;
    }
}
