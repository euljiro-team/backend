package com.core.euljiro.dto;


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
        this.word = entity.getWord();
        this.comments = entity.getComments();
        this.fstCrtId = entity.getFstCrtId();
        this.fstCrtDt = entity.getFstCrtDt();
        this.lstMdfId = entity.getLstMdfId();
        this.lstMdfDt = entity.getLstMdfDt();
    }

}
