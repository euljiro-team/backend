package com.core.euljiro.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "dev_users")
public class DevUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 아이디
     */
    @Id
    @Column(name = "ID", nullable = false)
    private Integer ID;

    /**
     * 사용자명
     */
    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    /**
     * 비밀번호
     */
    @Column(name = "PASSWORD", nullable = false)
    private String PASSWORD;

    /**
     * 활성화여부
     */
    @Column(name = "ENABLED", nullable = false)
    private String ENABLED;

}
