package com.api.euljiro.controller;

import com.core.euljiro.dto.AdminDTO;
import com.core.euljiro.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public String save(@Valid @RequestBody AdminDTO vO) {
        return adminService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        adminService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody AdminDTO vO) {
        adminService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AdminDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return adminService.getById(id);
    }

    @GetMapping
    public Page<AdminDTO> query(@Valid AdminDTO vO) {
        return adminService.query(vO);
    }
}
