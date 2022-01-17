package com.core.euljiro.common.center;

import com.core.euljiro.common.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "center", schema = "euljiro")
@Getter
@AllArgsConstructor
public class Center {

    @Id @GeneratedValue
    @Column(name = "center_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account; // 지점관리자

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "center_id")
    private List<Trainer> trainers;

    @Column
    @NotNull
    private String name; // 지점명

    @Column
    private String address; // 주소

    @Column(name = "tel_no")
    private String telNo; // 전화번호

    @Column(name = "operating_hour")
    private String operatingHour; // 운영시간
    
}
