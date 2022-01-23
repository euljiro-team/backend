package com.api.euljiro.controller;

import com.core.euljiro.dto.TrainerDTO;
import com.core.euljiro.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @PostMapping
    public String save(@Valid @RequestBody TrainerDTO vO) {
        return trainerService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        trainerService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody TrainerDTO vO) {
        trainerService.update(id, vO);
    }

    @GetMapping("/{id}")
    public TrainerDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return trainerService.getById(id);
    }

    @GetMapping
    public Page<TrainerDTO> query(@Valid TrainerDTO vO) {
        return trainerService.query(vO);
    }
}
