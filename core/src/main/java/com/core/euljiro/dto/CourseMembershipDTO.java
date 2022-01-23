package com.core.euljiro.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CourseMembershipDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer courseMembershipId;

    private Integer courseCourseId;

}
