package com.core.euljiro.service;


import com.core.euljiro.domain.Meta;
import com.core.euljiro.dto.MetaGetRequestDto;
import com.core.euljiro.dto.MetaSaveRequestDto;
import com.core.euljiro.dto.MetaUpdateRequestDto;
import com.core.euljiro.dto.MetasResponseDto;
import com.core.euljiro.repository.MetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MetaService extends Exception {
    private final MetaRepository metaRepository;

    @Transactional(readOnly = true)
    public List<MetasResponseDto> findAllDesc(){
        return metaRepository.findAllDesc().stream()
                .map(MetasResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public String save(MetaSaveRequestDto requestDto) throws Exception {
        String word="";
        if(!metaRepository.existsById(requestDto.getWord())){
            word= metaRepository.save(requestDto.toEntity()).getWord();
        }else{
            throw new Exception("이미 메타에 등록된 단어입니다.");
        }
        return word;
    }

    @Transactional
    public List<MetasResponseDto> findMultiMetas (MetaGetRequestDto requestDto) {
        return metaRepository.findMultiMetas(requestDto)
                .stream().map(MetasResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public MetasResponseDto findById(String word){
        Meta entity = metaRepository.findById(word)
                .orElseThrow(()->new IllegalArgumentException("해당 메타가 없습니다." + word));
        return new MetasResponseDto(entity);
    }

    @Transactional
    public String update(String word, MetaUpdateRequestDto requestDto){
        Meta meta = metaRepository.findById(word).orElseThrow(()-> new IllegalArgumentException("수정할 메타가 없습니다. + " + word));
        meta.update(requestDto.getComments(), "N");
        return word;
    }

    @Transactional
    public void delete(String word){
        Meta meta = metaRepository.findById(word).orElseThrow(()-> new IllegalArgumentException("삭제할 메타가 없습니다. + " + word));
        meta.update("", "Y");
    }

}
