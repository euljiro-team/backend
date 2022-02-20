package com.core.euljiro.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    @CreatedDate
    @Column(name="FST_CRT_DT")
    private String fstCrtDt;

    @LastModifiedDate
    @Column(name="LST_MDF_DT")
    private String lstMdfDt;

    @PrePersist
    public void onPrePersist(){
        this.fstCrtDt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        this.lstMdfDt = this.fstCrtDt;
    }

    @PreUpdate
    public void onPreUpdate(){
        this.lstMdfDt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }
}
