package com.adreeana.oneteam.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

class TeamTest {

    @Nested
    @DisplayName("Ana should be able to list team engineers")
    class listEngineers {
        @Test
        @DisplayName("given a team it returns its engineers")
        void happyPath() {
            Team team = new Team("A team", asList("matei", "ana"));

            assertThat(team.listEngineers())
                .containsExactlyInAnyOrder("matei", "ana");
        }
    }

    @Nested
    @DisplayName("Ana should be able to add an engineer to the team")
    class addEngineer {
        @Test
        @DisplayName("given an engineer it adds it to a team")
        void happyPath() {
            Team team = new Team("A team", singletonList("matei"));

            team.addEngineer("ana");

            assertThat(team.listEngineers())
                .containsExactlyInAnyOrder("matei", "ana");
        }
    }
}