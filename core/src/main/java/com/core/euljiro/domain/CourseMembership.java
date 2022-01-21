package com.core.euljiro.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "course_membership")
public class CourseMembership implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "course_membership_id", nullable = false)
    private Integer courseMembershipId;

    @Column(name = "course_course_id", nullable = false)
    private Integer courseCourseId;

}
