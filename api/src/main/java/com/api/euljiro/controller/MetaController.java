package com.api.euljiro.controller;

import com.core.euljiro.dto.meta.MetaGetRequestDto;
import com.core.euljiro.dto.meta.MetaSaveRequestDto;
import com.core.euljiro.dto.meta.MetaUpdateRequestDto;
import com.core.euljiro.dto.meta.MetasResponseDto;
import com.core.euljiro.service.MetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/meta")
public class MetaController {

    @Autowired
    private final MetaService metaService;

    @PostMapping
    public String save(@RequestBody MetaSaveRequestDto requestDto) throws Exception {
        return metaService.save(requestDto);
    }

    @GetMapping
    public List<MetasResponseDto> findMultiMetas(@RequestBody MetaGetRequestDto requestDto) {
        return metaService.findMultiMetas(requestDto);
    }

    @PatchMapping("/{word}")
    public String update(@PathVariable String word, @RequestBody MetaUpdateRequestDto updateDto){
        return metaService.update(word, updateDto);
    }

    @DeleteMapping("/delete/{word}")
    public void delete(@PathVariable String word){
        metaService.delete(word);
    }


}
