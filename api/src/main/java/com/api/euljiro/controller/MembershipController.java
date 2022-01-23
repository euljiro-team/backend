package com.api.euljiro.controller;

import com.core.euljiro.dto.MembershipDTO;
import com.core.euljiro.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/membership")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @PostMapping
    public String save(@Valid @RequestBody MembershipDTO vO) {
        return membershipService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        membershipService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody MembershipDTO vO) {
        membershipService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MembershipDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return membershipService.getById(id);
    }

    @GetMapping
    public Page<MembershipDTO> query(@Valid MembershipDTO vO) {
        return membershipService.query(vO);
    }
}
