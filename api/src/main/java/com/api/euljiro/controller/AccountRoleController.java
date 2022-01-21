package com.api.euljiro.controller;

import com.core.euljiro.dto.AccountRoleDTO;
import com.core.euljiro.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/accountRole")
public class AccountRoleController {

    @Autowired
    private AccountRoleService accountRoleService;

    @PostMapping
    public String save(@Valid @RequestBody AccountRoleDTO vO) {
        return accountRoleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        accountRoleService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody AccountRoleDTO vO) {
        accountRoleService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AccountRoleDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return accountRoleService.getById(id);
    }

    @GetMapping
    public Page<AccountRoleDTO> query(@Valid AccountRoleDTO vO) {
        return accountRoleService.query(vO);
    }
}
