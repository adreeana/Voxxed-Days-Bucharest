package com.adreeana.oneteam.application;

import com.adreeana.oneteam.domain.Team;
import com.adreeana.oneteam.domain.TeamDuplicateException;
import com.adreeana.oneteam.domain.TeamNotFoundException;
import com.adreeana.oneteam.domain.Teams;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TeamApplicationServiceTest {
    private final String teamName = "Voxxed Days Bucharest";

    private final Teams teams = mock(Teams.class);

    private final TeamApplicationService service =
        new TeamApplicationService(teams);

    @Nested
    @DisplayName("Ana should be able to get a team by its name")
    class findTeam {
        @Test
        @DisplayName("given a team name when the team exists it returns the team")
        void whenTeamExists() {
            when(teams.get(teamName)).thenReturn(new Team(teamName));

            final TeamDto teamDto = service.getTeam(teamName);

            assertThat(teamDto).isNotNull();
            assertThat(teamDto.getName()).isEqualTo(teamName);
        }

        @Test
        @DisplayName("given a team name when the team noes not exist it returns null")
        void whenTeamDoesNotExist() {
            assertThat(service.getTeam(teamName)).isNull();
        }
    }

    @Nested
    @DisplayName("Ana should be able to add a team")
    class addTeam {
        @Test
        @DisplayName("given a team name it returns a new team")
        void happyPath() {
            final TeamDto teamDto = service.addTeam(teamName);

            assertThat(teamDto).isNotNull();
            verify(teams).add(any());
        }

        @Test
        @DisplayName("when the team exists, throws an exception")
        void whenTeamExists() {
            when(teams.get(teamName)).thenReturn(new Team(teamName));

            assertThatThrownBy(() -> service.addTeam(teamName))
                .isInstanceOf(TeamDuplicateException.class);
        }
    }

    @Nested
    @DisplayName("Ana should be able to add an engineer to a team")
    class addEngineer {
        @Test
        @DisplayName("given an engineer it adds it to a team")
        void happyPath() {
            when(teams.get(teamName)).thenReturn(new Team(teamName));

            final TeamDto teamDto = service.addEngineer(teamName, "Ana");

            assertThat(teamDto).isNotNull();
            assertThat(teamDto.getEngineers()).containsExactly("Ana");
        }

        @Test
        @DisplayName("when the team does not exist, throws team not found exception")
        void whenTeamNotFound() {
            assertThatThrownBy(() -> service.addEngineer(teamName, "Ana"))
                .isInstanceOf(TeamNotFoundException.class);
        }
    }
}