package com.adreeana.oneteam.infrastructure.persistence;

import com.adreeana.oneteam.domain.Team;
import com.adreeana.oneteam.domain.Teams;
import org.springframework.stereotype.Repository;

import java.util.Objects;

import static com.adreeana.oneteam.infrastructure.persistence.JpaTeams.TeamAdapter.toEntity;
import static com.adreeana.oneteam.infrastructure.persistence.JpaTeams.TeamAdapter.toJpaEntity;

@Repository
public class JpaTeams implements Teams {
    private final JpaTeamsDelegate jpaTeamsDelegate;

    public JpaTeams(JpaTeamsDelegate jpaTeamsDelegate) {
        this.jpaTeamsDelegate = jpaTeamsDelegate;
    }

    @Override
    public Team add(Team team) {
        return toEntity(jpaTeamsDelegate.save(toJpaEntity(team)));
    }

    @Override
    public Team get(String name) {
        return toEntity(jpaTeamsDelegate.findByName(name));
    }

    static class TeamAdapter {
        static Team toEntity(JpaTeam jpaTeam) {
            if (Objects.isNull(jpaTeam))
                return null;

            Team team = new Team(jpaTeam.getName(), jpaTeam.getJpaEngineers());
            team.setId(jpaTeam.getId());
            return team;
        }

        static JpaTeam toJpaEntity(Team team) {
            if (Objects.isNull(team))
                return null;

            JpaTeam jpaTeam = new JpaTeam(team.getName(), team.listEngineers());
            jpaTeam.setId(team.getId());
            return jpaTeam;
        }
    }
}
