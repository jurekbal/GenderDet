package com.balwinski.genderdet.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GenderDetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void firstTokenEndpointTest() throws Exception {
        this.mockMvc.perform(get("/genderdet/first/Jan%20Kowalski"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void multiTokenEndpointTest() throws Exception {
        this.mockMvc.perform(get("/genderdet/multi/Jan%20Kowalski"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //TODO add more test cases
}