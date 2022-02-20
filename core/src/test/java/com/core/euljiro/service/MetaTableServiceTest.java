package com.core.euljiro.service;

import com.core.euljiro.domain.MetaTable;
import com.core.euljiro.dto.MetaTableDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("local")
class MetaTableServiceTest {

    @Test
    void getById() {
        String str = "";
//        assertEquals(metaTableDTO, this.metaTableDTO);
        assertNotNull(str);

    }
}
