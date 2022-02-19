package com.core.euljiro.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class NoticeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer noticeId;

    private String title;

    private String content;

}
