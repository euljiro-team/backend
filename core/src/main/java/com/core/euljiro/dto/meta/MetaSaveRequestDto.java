package com.core.euljiro.dto.meta;


import com.core.euljiro.domain.Meta;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MetaSaveRequestDto {
    private String word;
    private String comments;
    private String delYn;
    private String fstCrtId;
    private String lstMdfId;

    @Builder
    public MetaSaveRequestDto(String word, String comments){
        this.word = word;
        this.comments = comments;
        this.delYn="N";
        this.fstCrtId="system";
        this.lstMdfId="system";

    }

    public Meta toEntity(){
        return Meta.builder().word(this.word).comments(this.comments)
                .fstCrtId("system").lstMdfId("system").delYn("N").build();
    }
}
