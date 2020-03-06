package com.adreeana.oneteam.integration;

import com.adreeana.oneteam.application.TeamApplicationService;
import com.adreeana.oneteam.domain.Team;
import com.adreeana.oneteam.domain.Teams;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class TeamApplicationServiceIT {

    @Autowired
    private TeamApplicationService service;

    @Autowired
    private Teams teams;

    @Test
    @DisplayName("Ana should be able to add a team")
    void addTeam() {
        String teamName = "A team";
        service.addTeam(teamName);

        assertThat(teams.get(teamName)).isNotNull();
    }

    @Test
    @DisplayName("Ana should be able to add an engineer to a team")
    void addsEngineers() {
        String teamName = "Team with engineers";
        service.addTeam(teamName);

        service.addEngineer(teamName, "Ana");
        service.addEngineer(teamName, "Matei");

        Team savedTeam = teams.get(teamName);
        List<String> savedEngineers = savedTeam.listEngineers();
        assertThat(savedEngineers).containsExactlyInAnyOrder("Ana", "Matei");
    }
}