package com.adreeana.oneteam.delivery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(PairingController.class)
@AutoConfigureMockMvc
public class PairingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //@MockBean
    //link to my application service;

    @Nested
    @DisplayName("Ana should be able to split team engineers in pairs")
    class pairing {
        @Test
        public void pairing() throws Exception {
            mockMvc.perform(get("/pairing").param("teamName", "toto"))
                .andExpect(content().string(containsString("Ana")))
                .andExpect(content().string(containsString("Matei")));
        }
    }
}