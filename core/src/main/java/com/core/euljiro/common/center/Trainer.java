package com.core.euljiro.common.center;


import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "trainer", schema = "euljiro")
@Getter
@AllArgsConstructor
public class Trainer {

    @Id @GeneratedValue
    @Column(name = "trainer_id")
    Integer id;

    @Column(name = "center_id")
    Integer centerId;

    @Column(name = "nick_name")
    String nickName; // 닉네임

    @Column
    Integer height; // 신장

    @Column(name = "award_hist")
    String awardHist; // 수상경력

}
