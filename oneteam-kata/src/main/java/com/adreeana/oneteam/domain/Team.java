package com.adreeana.oneteam.domain;

import com.adreeana.oneteam.domain.internal.InternalEntity;
import com.livedocumentation.CoreConcept;
import com.livedocumentation.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@CoreConcept
public class Team extends InternalEntity {
    private final String name;
    private final Set<String> engineers = new HashSet<>();

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, List<String> engineers) {
        this.name = name;
        this.engineers.addAll(engineers);
    }

    public String getName() {
        return name;
    }

    public List<String> listEngineers() {
        return new ArrayList<>(engineers);
    }

    public void addEngineer(String engineer) {
        engineers.add(engineer);
    }

    @Override
    public String toString() {
        return "Team{" +
            "name='" + name + '\'' +
            ", engineers=" + engineers +
            '}';
    }
}