package com.adreeana.oneteam.delivery;

import com.adreeana.oneteam.application.PairDto;
import com.adreeana.oneteam.application.PairingApplicationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(PairingController.class)
@AutoConfigureMockMvc
public class PairingControllerTest {
    private final String teamName = "Voxxed Days Bucharest";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PairingApplicationService service;

    @Nested
    @DisplayName("Ana should be able to split team engineers in pairs")
    class pairing {
        @Test
        public void pairing() throws Exception {
            when(service.shufflePairs(teamName))
                .thenReturn(singletonList(new PairDto("Ana", "Matei")));

            mockMvc.perform(get("/pairing").param("teamName", teamName))
                .andExpect(content().string(containsString("Ana")))
                .andExpect(content().string(containsString("Matei")));

            verify(service).shufflePairs(teamName);
        }
    }
}