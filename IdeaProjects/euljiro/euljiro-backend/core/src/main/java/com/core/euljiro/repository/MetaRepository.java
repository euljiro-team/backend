package com.core.euljiro.repository;


import com.core.euljiro.domain.Meta;
import com.core.euljiro.dto.MetaGetRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MetaRepository extends JpaRepository<Meta,String> {

    @Query("SELECT p from Meta p where p.delYn='N' ORDER BY p.word")
    List<Meta> findAllDesc();

    @Query("SELECT p from Meta p where " +
            "p.word like %:#{#requestDto.word}% and " +
            "p.comments like %:#{#requestDto.comments}%  and " +
            "p.fstCrtId like %:#{#requestDto.fstCrtId}% and " +
            "p.lstMdfId like %:#{#requestDto.lstMdfId}% " )
        //List<Meta> findMultiMetas (String word, String comments, String fstCrtId, String lstMdfID );
    List<Meta> findMultiMetas(@Param("requestDto") MetaGetRequestDto requestDto);

}