package com.core.euljiro.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "trainer")
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "trainer_id", nullable = false)
    private Integer trainerId;

    @Column(name = "award_hist")
    private String awardHist;

    @Column(name = "height")
    private Integer height;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "center_id")
    private Integer centerId;

}
