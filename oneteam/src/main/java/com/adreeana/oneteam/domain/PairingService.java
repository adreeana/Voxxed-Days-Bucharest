package com.adreeana.oneteam.domain;

import com.livedocumentation.CoreConcept;
import com.livedocumentation.DomainService;
import com.livedocumentation.GuidedTour;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@DomainService
@CoreConcept
public class PairingService {

    @GuidedTour(name = "Quick Developer Tour", description = "Main functionality business rules :)")
    public List<Pair> shufflePairs(List<String> engineers) {
        final List<String> shuffled = engineers;
        Collections.shuffle(shuffled);

        return IntStream.range(1, shuffled.size())
            .filter(n -> n % 2 != 0)
            .mapToObj(n -> new Pair(shuffled.get(n - 1), shuffled.get(n)))
            .collect(toList());
    }
}
