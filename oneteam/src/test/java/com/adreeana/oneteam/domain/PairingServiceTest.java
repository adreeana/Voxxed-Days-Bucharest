package com.adreeana.oneteam.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class PairingServiceTest {

    private final PairingService service = new PairingService();

    @Nested
    @DisplayName("Ana should be able to split team engineers in pairs")
    class shufflePairs {
        @Test
        @DisplayName("given some engineers it returns the pairs")
        void happyPath() {
            List<String> engineers = asList("ana", "doru", "matei", "mihaela");

            List<Pair> pairs = service.shufflePairs(engineers);

            assertThat(pairs).hasSize(2);
            assertThat(pairs.stream().flatMap(p -> p.list().stream()).collect(toList()))
                .containsAll(engineers);
        }

        @Test
        @DisplayName("when called two times it returns different pairs")
        void whenCalled2Times() {
            List<String> engineers = asList("ana", "doru", "matei", "dana", "mircea");

            assertThat(service.shufflePairs(engineers))
                .isNotEqualTo(service.shufflePairs(engineers));
        }

        @Test
        @DisplayName("when the number of engineers is odd it returns the available pairs")
        void whenTeamIsOdd() {
            List<String> engineers = asList("ana", "doru", "matei");

            List<Pair> pairs = service.shufflePairs(engineers);

            assertThat(pairs).hasSize(1);
            assertThat(pairs.get(0).getDriver())
                .isNotEqualTo(pairs.get(0).getNavigator());
        }

        @Test
        @DisplayName("when there is only one engineer it returns an empty list")
        void whenOneEngineers() {
            assertThat(service.shufflePairs(singletonList("ana"))).isEmpty();
        }
    }
}