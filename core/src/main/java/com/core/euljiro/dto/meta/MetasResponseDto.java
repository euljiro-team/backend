package com.core.euljiro.dto.meta;


import com.core.euljiro.domain.Meta;
import lombok.Getter;

@Getter
public class MetasResponseDto {
    private String word;
    private String comments;
    private String fstCrtId;
    private String fstCrtDt;
    private String lstMdfId;
    private String lstMdfDt;

    public MetasResponseDto(Meta entity){
        this.word = entity.getWord()== null ? "" : entity.getWord();
        this.comments = entity.getComments() == null ? "" : entity.getComments();
        this.fstCrtId = entity.getFstCrtId() == null ? "" : entity.getFstCrtId();
        this.fstCrtDt = entity.getFstCrtDt() == null ? "" : entity.getFstCrtDt();
        this.lstMdfId = entity.getLstMdfId() == null ? "" : entity.getLstMdfId();
        this.lstMdfDt = entity.getLstMdfDt() == null ? "" : entity.getLstMdfDt();
    }

}

