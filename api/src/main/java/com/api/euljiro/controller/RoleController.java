package com.api.euljiro.controller;

import com.core.euljiro.dto.RoleDTO;
import com.core.euljiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public String save(@Valid @RequestBody RoleDTO vO) {
        return roleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        roleService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody RoleDTO vO) {
        roleService.update(id, vO);
    }

    @GetMapping("/{id}")
    public RoleDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return roleService.getById(id);
    }

    @GetMapping
    public Page<RoleDTO> query(@Valid RoleDTO vO) {
        return roleService.query(vO);
    }
}
