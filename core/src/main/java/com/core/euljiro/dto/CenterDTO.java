package com.core.euljiro.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CenterDTO {

    //private Integer centerId;
    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    private String operatingHour;

    private String telNo;

    private Integer accountId;

}
