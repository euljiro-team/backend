package com.core.euljiro.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notice")
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "noticeId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noticeId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "MODIFIED_AT")
    @NotNull
    private LocalDateTime modifiedAt = LocalDateTime.now();


}
