package com.api.euljiro.controller;

import com.core.euljiro.domain.CourseMembership;
import com.core.euljiro.dto.CourseDTO;
import com.core.euljiro.dto.CourseMembershipDTO;
import com.core.euljiro.dto.CourseReservationDto;
import com.core.euljiro.repository.CourseMembershipRepository;
import com.core.euljiro.repository.CourseReservationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableMockMvc
@WebAppConfiguration
@ActiveProfiles("local")
public class CourseReservationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    CourseReservationController courseReservationController;

    @Autowired
    CourseMembershipRepository courseMembershipRepository;

    @Test
    public void getCourseList() throws Exception{
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();

        param.add("userId", "1");
        param.add("cntrId","1231");
        param.add("baseDt","20220224");

        mockMvc.perform(get("/reservation/1")
                .params(param))
                .andExpect(status().isOk())
                .andDo(print())
        ;
    }

//    @Test
//    public void reserveOneCourse() throws Exception {
//        String content = objectMapper.writeValueAsString(new CourseReservationDto((1L),1,1));
//        mockMvc.perform(post("/reservation/1")
//                    .content(content))
//                .andExpect(status().isOk())
//                .andDo(print());
//
//        CourseMembership vo = courseMembershipRepository.getOne(1);
//        assertThat(vo.getCrsId() == 1L , is(true));
//    }
//Ø
//    @Test
//    public void deleteReservation() {
//    }
}