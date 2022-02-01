package com.api.euljiro.resource;

import com.core.euljiro.domain.Center;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class CenterResource extends EntityModel<Center> {

    public CenterResource(Center center, Link... links) {
        super(center, links);
        //add(likTo)
    }
}
