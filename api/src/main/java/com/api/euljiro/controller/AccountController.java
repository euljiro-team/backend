package com.api.euljiro.controller;

import com.core.euljiro.dto.AccountDTO;
import com.core.euljiro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public String save(@Valid @RequestBody AccountDTO vO) {
        return accountService.save(vO).toString();
    }


    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody AccountDTO vO) {
        accountService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AccountDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return accountService.getById(id);
    }

}
