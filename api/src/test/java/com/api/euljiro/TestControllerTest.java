package com.api.euljiro;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"application-local-api.yml", "application-local-core.yml"})
@AutoConfigureMockMvc
@WebAppConfiguration
public class TestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser(username = "ddd", roles = "USER")
    public void test() throws Exception {
        mockMvc.perform(get("http://localhost:44000/api/test"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}