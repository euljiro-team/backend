package com.api.euljiro.controller;


import com.core.euljiro.dto.meta.MetasResponseDto;
import com.core.euljiro.service.MetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final MetaService metaService;

    @GetMapping("/")
    public String metaIndex(Model model){
        model.addAttribute("metas", metaService.findAllDesc());
        return "meta-index";
    }

    @GetMapping("/meta/save")
    public String metaSave() { return "meta-save"; }

    @GetMapping("/meta/patch/{word}")
    public String metaUpdate(@PathVariable String word , Model model){
        MetasResponseDto dto = metaService.findById(word);
        model.addAttribute("meta",dto);
        return "meta-update";
    }
}
