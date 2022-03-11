package com.api.euljiro.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableMockMvc
@WebAppConfiguration
@ActiveProfiles("local")
public class CourseReservationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    CourseReservationController courseReservationController;

    @Test
    public void getCourseList() throws Exception{
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();

        param.add("userId", "1");
        param.add("cntrId","1231");
        param.add("baseDt","20220224");

        mockMvc.perform(get("/reservation/1")
                        .params(param))
                        .andExpect(status().isOk())
                        .andDo(print());
    }
}
