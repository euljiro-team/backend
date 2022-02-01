package com.api.euljiro.controller;

import com.core.euljiro.dto.MetaGetRequestDto;
import com.core.euljiro.dto.MetaSaveRequestDto;
import com.core.euljiro.dto.MetaUpdateRequestDto;
import com.core.euljiro.dto.MetasResponseDto;
import com.core.euljiro.service.MetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MetaApiController {
    private final MetaService metaService;

    @PostMapping("/meta/post")
    public String save(@RequestBody MetaSaveRequestDto requestDto) throws Exception {
        return metaService.save(requestDto);
    }

    @PostMapping("/meta/get")
    public List<MetasResponseDto> findMultiMetas(@RequestBody MetaGetRequestDto requestDto) {
        return metaService.findMultiMetas(requestDto);
    }

    @PatchMapping("/meta/patch/{word}")
    public String update(@PathVariable String word, @RequestBody MetaUpdateRequestDto updateDto){
        return metaService.update(word, updateDto);
    }

    @DeleteMapping("/meta/delete/{word}")
    public void delete(@PathVariable String word){
        metaService.delete(word);
    }


}