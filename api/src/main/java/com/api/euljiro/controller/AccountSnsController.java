package com.api.euljiro.controller;

import com.core.euljiro.dto.AccountSnsDTO;
import com.core.euljiro.service.AccountSnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/accountSns")
public class AccountSnsController {

    @Autowired
    private AccountSnsService accountSnsService;

    @PostMapping
    public String save(@Valid @RequestBody AccountSnsDTO vO) {
        return accountSnsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        accountSnsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AccountSnsDTO vO) {
        accountSnsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AccountSnsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return accountSnsService.getById(id);
    }

    @GetMapping
    public Page<AccountSnsDTO> query(@Valid AccountSnsDTO vO) {
        return accountSnsService.query(vO);
    }
}
