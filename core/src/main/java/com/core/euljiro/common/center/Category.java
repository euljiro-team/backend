package com.core.euljiro.common.center;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
@AllArgsConstructor
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    Integer id;

    @Column
    @NotNull
    String code;

    @Column(name = "code_name")
    @NotNull
    String codeName;

}
