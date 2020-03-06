package com.adreeana.oneteam.delivery;

import com.adreeana.oneteam.application.TeamApplicationService;
import com.adreeana.oneteam.application.TeamDto;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(TeamController.class)
@AutoConfigureMockMvc
public class TeamControllerTest {
    private final String teamName = "Voxxed Days Bucharest";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamApplicationService service;

    @Nested
    @DisplayName("Ana should be able to add a team")
    class team {
        @Test
        public void teamForm() throws Exception {
            mockMvc.perform(get("/team"))
                .andExpect(content().string(containsString("form")));
        }

        @Test
        public void teamSubmit() throws Exception {
            when(service.addTeam(teamName))
                .thenReturn(new TeamDto(teamName));

            mockMvc.perform(post("/team").param("name", teamName))
                .andExpect(content().string(containsString(teamName)))
                .andExpect(content().string(containsString("Engineer name")));

            verify(service).addTeam(teamName);
        }
    }

    @Nested
    @DisplayName("Ana should be able to add an engineer to a team")
    class engineers {
        @Test
        public void engineersForm() throws Exception {
            when(service.getTeam(teamName)).thenReturn(new TeamDto(teamName));

            mockMvc.perform(get("/engineers").param("teamName", teamName))
                .andExpect(content().string(containsString(teamName)))
                .andExpect(content().string(containsString("form")));

            verify(service).getTeam(teamName);
        }

        @Test
        public void engineersSubmit() throws Exception {
            String engineerName = "Ana";
            when(service.addEngineer(teamName, engineerName))
                .thenReturn(new TeamDto(teamName, singletonList(engineerName)));

            mockMvc.perform(
                post("/engineers")
                    .param("teamName", teamName)
                    .param("name", engineerName))
                .andExpect(content().string(containsString("Add engineers")));

            verify(service).addEngineer(teamName, engineerName);
        }
    }
}