package com.core.euljiro.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer categoryId;

    private String code;

    private String codeName;

}
