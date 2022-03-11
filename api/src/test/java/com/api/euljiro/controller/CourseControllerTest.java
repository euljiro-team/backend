package com.api.euljiro.controller;

import com.core.euljiro.common.BaseTimeEntity;
import com.core.euljiro.domain.Course;
import com.core.euljiro.dto.CourseDTO;
import com.core.euljiro.repository.CourseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
@ActiveProfiles("local")
public class CourseControllerTest {

    @Autowired
    CourseController courseController;

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void update() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void save() throws Exception {

        //given
        CourseDTO vo = CourseDTO.builder()
                .crsDwk(1) // 수업요일
                .thcrId(111)
                .crsEndDt(LocalDate.parse("2022-02-24"))
                .crsHr(50)
                .crsId(12345L)
                .crsNm("명상요가")
                .crsStrtDt(LocalDate.parse("2022-02-24"))
                .crsStrtHh("14")
                .crsStrtMi("30")
                .mbrNum(20)
                .cntrId(1231)
                .regNum(1)
                .build();
        //when
        courseController.save(vo);
//        mockMvc.perform(post("/")
//                        .content(objectMapper.writeValueAsString(vo))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                        .andExpect(status().isOk())
//                        .andDo(print());

        //then
        Course result = courseRepository.findAll().get(0);

        System.out.println("$$$$$$$$$$1 " + result.toString());
        System.out.println("$$$$$$$$$2 " + vo.toString());
        assertEquals(result.getCrsHr(), vo.getCrsHr());
    }

    @Test
    public void query() {
    }
}