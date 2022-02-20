package com.core.euljiro.dto.meta;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MetaUpdateRequestDto {
    private String comments;
    private String delYn;

    @Builder
    public MetaUpdateRequestDto(String comments, String delYn){
        this.comments = comments;
        this.delYn = delYn;
    }
}
