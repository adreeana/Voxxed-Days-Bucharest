package com.adreeana.oneteam.infrastructure.persistence;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JpaTeam {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Convert(converter = StringListConverter.class)
    private List<String> engineers = new ArrayList<>();

    public JpaTeam() {
    }

    public JpaTeam(String name, List<String> engineers) {
        this.name = name;
        this.engineers.addAll(engineers);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public List<String> getJpaEngineers() {
        return engineers;
    }
}