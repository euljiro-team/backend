package com.api.euljiro.controller;

import com.core.euljiro.dto.NoticeDTO;
import com.core.euljiro.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/manager/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping
    public String save(@Valid @RequestBody NoticeDTO vO) {
        return noticeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        noticeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody NoticeDTO vO) {
        noticeService.update(id, vO);
    }

    @GetMapping("/{id}")
    public NoticeDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return noticeService.getById(id);
    }

    @GetMapping
    public List<NoticeDTO> query(@Valid NoticeDTO vO) {
        return noticeService.findAll();
    }
}
