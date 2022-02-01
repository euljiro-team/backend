package com.core.euljiro.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 사용자번호
     */
    @Id
    @Column(name = "ID", nullable = false)
    private Integer ID;

    /**
     * 권한명
     */
    @Column(name = "NAME")
    private String NAME;

}
