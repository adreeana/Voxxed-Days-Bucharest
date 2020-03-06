package com.adreeana.oneteam.application;

import com.adreeana.oneteam.domain.PairingService;
import com.adreeana.oneteam.domain.Team;
import com.adreeana.oneteam.domain.TeamNotFoundException;
import com.adreeana.oneteam.domain.Teams;
import com.livedocumentation.ApplicationService;
import com.livedocumentation.GuidedTour;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@ApplicationService
public class PairingApplicationService {
    private final Teams teams;
    private final PairingService pairingService;

    public PairingApplicationService(Teams teams, PairingService pairingService) {
        this.teams = teams;
        this.pairingService = pairingService;
    }

    @GuidedTour(name = "Quick Developer Tour", description = "Main functionality use case")
    public List<PairDto> shufflePairs(String teamName) {
        final Team team = teams.get(teamName);
        if (team == null) {
            throw new TeamNotFoundException(teamName);
        }

        return pairingService.shufflePairs(team.listEngineers()).stream()
            .map(p -> new PairDto(p.getDriver(), p.getNavigator()))
            .collect(toList());
    }
}
