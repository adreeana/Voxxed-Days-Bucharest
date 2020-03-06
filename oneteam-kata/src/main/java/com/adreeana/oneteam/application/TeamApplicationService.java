package com.adreeana.oneteam.application;

import com.adreeana.oneteam.domain.Team;
import com.adreeana.oneteam.domain.TeamDuplicateException;
import com.adreeana.oneteam.domain.TeamNotFoundException;
import com.adreeana.oneteam.domain.Teams;
import com.livedocumentation.ApplicationService;
import org.springframework.stereotype.Service;

@Service
@ApplicationService
public class TeamApplicationService {

    private final Teams teams;

    public TeamApplicationService(Teams teams) {
        this.teams = teams;
    }

    public TeamDto getTeam(String teamName) {
        final Team team = teams.get(teamName);
        if (team == null) {
            return null;
        }
        return new TeamDto(team.getName(), team.listEngineers());
    }

    public TeamDto addTeam(String teamName) {
        final Team existingTeam = teams.get(teamName);
        if (existingTeam != null) {
            throw new TeamDuplicateException(teamName);
        }

        final Team team = new Team(teamName);
        teams.add(team);

        return new TeamDto(team.getName());
    }

    public TeamDto addEngineer(String teamName, String engineerName) {
        final Team team = teams.get(teamName);
        if (team == null) {
            throw new TeamNotFoundException(teamName);
        }

        team.addEngineer(engineerName);
        teams.add(team);

        return new TeamDto(team.getName(), team.listEngineers());
    }
}
