package com.api.euljiro.controller;

import com.core.euljiro.dto.CourseMembershipDTO;
import com.core.euljiro.service.CourseMembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/courseMembership")
public class CourseMembershipController {

    @Autowired
    private CourseMembershipService courseMembershipService;

    @PostMapping
    public String save(@Valid @RequestBody CourseMembershipDTO vO) {
        return courseMembershipService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        courseMembershipService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody CourseMembershipDTO vO) {
        courseMembershipService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CourseMembershipDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return courseMembershipService.getById(id);
    }

    @GetMapping
    public Page<CourseMembershipDTO> query(@Valid CourseMembershipDTO vO) {
        return courseMembershipService.query(vO);
    }
}
