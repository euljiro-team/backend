package com.api.euljiro.controller;

import com.core.euljiro.dto.CenterDTO;
import com.core.euljiro.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/center")
public class CenterController {

    @Autowired
    private CenterService centerService;

    @PostMapping
    public String save(@Valid @RequestBody CenterDTO vO) {
        return centerService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        centerService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody CenterDTO vO) {
        centerService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CenterDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return centerService.getById(id);
    }

    @GetMapping
    public Page<CenterDTO> query(@Valid CenterDTO vO) {
        return centerService.query(vO);
    }
}
