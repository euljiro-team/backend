package com.api.euljiro.controller;

import com.core.euljiro.domain.Account;
import com.core.euljiro.domain.Center;
import com.core.euljiro.dto.AccountDTO;
import com.core.euljiro.dto.CenterAccountFormDTO;
import com.core.euljiro.dto.CenterDTO;
import com.core.euljiro.service.AccountService;
import com.core.euljiro.service.CenterService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Validated
@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {

    @Autowired private AccountService accountService;
    @Autowired private CenterService centerService;

    @Autowired
    ModelMapper modelMapper;

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

    @PostMapping("/signUp")
    public ResponseEntity<AccountDTO> signUp(@RequestBody AccountDTO accountDTO) {
        Account account =  accountService.signUp(accountDTO);
        WebMvcLinkBuilder mvcLinkBuilder = linkTo(AccountController.class).slash("/signUp");
        return ResponseEntity.created(mvcLinkBuilder.toUri()).body(modelMapper.map(account, AccountDTO.class));
    }

    @PostMapping("/center/signUp")
    public ResponseEntity<CenterAccountFormDTO> centerSignUp(@RequestBody CenterAccountFormDTO centerAccountFormDTO) {
        AccountDTO accountDTO = centerAccountFormDTO.toAccountDTO(centerAccountFormDTO);
        CenterDTO centerDTO = centerAccountFormDTO.toCenterDTO(centerAccountFormDTO);

        Account centerAccount = accountService.signUp(accountDTO);
        accountDTO.setAccountId(centerAccount.getAccountId());
        centerDTO.setAccountId(centerAccount.getAccountId());
        //centerDTO.setCenterId(centerService.save(centerDTO));
        log.debug("69LINE : " + centerAccount.toString());
        centerService.save(centerDTO);
        CenterAccountFormDTO createdCenterAccountFormDTO = CenterAccountFormDTO.toCenterAccountFormDTO(accountDTO, centerDTO);
        WebMvcLinkBuilder mvcLinkBuilder = linkTo(AccountController.class).slash("/center/signUp");
        return ResponseEntity.created(mvcLinkBuilder.toUri()).body(createdCenterAccountFormDTO);
    }
}
