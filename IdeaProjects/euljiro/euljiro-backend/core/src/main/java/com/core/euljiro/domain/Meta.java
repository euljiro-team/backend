package com.core.euljiro.domain;


import com.core.euljiro.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //생성자 자동 생성
@Entity //테이블과 연결 >> 절대 Setter 메소드를 만들지 않는다.
@Table(name="meta_table")
public class Meta extends BaseTimeEntity implements Persistable<String> {

    @Id //PK
    @Column
    private String word;

    @Column(nullable = false)
    private String comments;

    @Column(nullable = false)
    private String fstCrtId;

    @Column(nullable = false)
    private String lstMdfId;

    @Column
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
