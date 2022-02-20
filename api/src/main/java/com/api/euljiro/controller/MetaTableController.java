package com.api.euljiro.controller;

import com.core.euljiro.dto.MetaTableDTO;
import com.core.euljiro.service.MetaTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/metaTable")
public class MetaTableController {

    @Autowired
    private MetaTableService metaTableService;

    @PostMapping
    public String save(@Valid @RequestBody MetaTableDTO vO) {
        return metaTableService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        metaTableService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody MetaTableDTO vO) {
        metaTableService.update(id, vO);
    }

//    @GetMapping("/{id}")
//    public MetaTableDTO getById(@Valid @NotNull @PathVariable("id") String id) {
//        return metaTableService.getById(id);
//    }
//
//
//    @GetMapping
//    public Page<MetaTableDTO> query(@Valid MetaTableDTO vO) {
//        return metaTableService.query(vO);
//    }
}
