package com.core.euljiro.domain;


import com.core.euljiro.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //생성자 자동 생성
@Entity //테이블과 연결 >> 절대 Setter 메소드를 만들지 않는다.
@Table(name="meta_table")
public class Meta extends BaseTimeEntity implements Persistable<String> {

    @Id //PK
    @Column(name="WORD")
    private String word;

    @Column(nullable = false, name="COMMENTS")
    private String comments;

    @Column(name = "FST_CRT_ID")
    private String fstCrtId;


    @Column(name = "LST_MDF_ID")
    private String lstMdfId;

    @Column(name = "del_yn")
    private String delYn;




    @Override
    public String getId() {
        return word;
    }

    @Override
    public boolean isNew(){
        return fstCrtId==null;
    }

    @Builder
    public Meta (String word, String comments, String fstCrtId,
                 String lstMdfId, String delYn){
        this.word = word;
        this.comments = comments;
        this.fstCrtId = fstCrtId;
        this.lstMdfId = lstMdfId;
        this.delYn= delYn;
    }

    public void update (String comments, String delYn){
        if(!"".equals(comments)){
            this.comments = comments;
        }
        this.delYn=delYn;
    }
}
