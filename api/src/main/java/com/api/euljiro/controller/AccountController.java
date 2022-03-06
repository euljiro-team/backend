package com.api.euljiro.controller;

import com.api.oauth.entity.UserPrincipal;
import com.core.euljiro.domain.Account;
import com.core.euljiro.dto.AccountDTO;
import com.core.euljiro.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity getUserByAuth(HttpServletRequest request) {
        UserPrincipal userPrincipal;
        Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (ClassCastException e){
            return new ResponseEntity ("token is " + request.getHeader("Authorization"), HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok(accountService.getAccountDTOByUserId(userPrincipal.getUsername()));
    }

    @PostMapping
    public String save(@Valid @RequestBody AccountDTO vO) {
        return accountService.save(vO).toString();
    }


    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody AccountDTO vO) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        accountService.update(id, vO);
    }


    @PostMapping("/signUp")
    public ResponseEntity<AccountDTO> signUp(@RequestBody AccountDTO accountDTO) {
        Account newAccount =  accountService.signUp(accountDTO);
        WebMvcLinkBuilder mvcLinkBuilder = linkTo(AccountController.class).slash(newAccount.getAccountId());
        return ResponseEntity.created(mvcLinkBuilder.toUri()).body(modelMapper.map(newAccount, AccountDTO.class));
    }

}
