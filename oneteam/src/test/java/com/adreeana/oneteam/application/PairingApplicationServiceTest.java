package com.adreeana.oneteam.application;

import com.adreeana.oneteam.domain.Pair;
import com.adreeana.oneteam.domain.PairingService;
import com.adreeana.oneteam.domain.Team;
import com.adreeana.oneteam.domain.TeamNotFoundException;
import com.adreeana.oneteam.domain.Teams;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PairingApplicationServiceTest {
    private final String teamName = "Voxxed Days Bucharest";

    private final Teams teams = mock(Teams.class);
    private final PairingService pairingService = mock(PairingService.class);

    private final PairingApplicationService service =
        new PairingApplicationService(teams, pairingService);

    @Nested
    @DisplayName("Ana should be able to split team engineers in pairs")
    class shufflePairs {
        @Test
        @DisplayName("given a team with engineers it returns the pairs")
        void happyPath() {
            final Team team = new Team(teamName, asList("Ana", "Matei"));
            when(teams.get(teamName)).thenReturn(team);
            when(pairingService.shufflePairs(team.listEngineers()))
                 .thenReturn(singletonList(new Pair("Ana", "Matei")));

            List<PairDto> pairDtos = service.shufflePairs(teamName);
            assertThat(pairDtos).hasSize(1);
            assertThat(pairDtos).containsExactly(new PairDto("Ana", "Matei"));

            verify(pairingService).shufflePairs(team.listEngineers());
        }

        @Test
        @DisplayName("when the team does not exist, throws an exception")
        void whenTeamNotFound() {
            assertThatThrownBy(() -> service.shufflePairs(teamName))
                .isInstanceOf(TeamNotFoundException.class);
        }
    }
}