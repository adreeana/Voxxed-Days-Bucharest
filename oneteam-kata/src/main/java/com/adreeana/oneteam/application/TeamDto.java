package com.adreeana.oneteam.application;

import com.livedocumentation.DataTransferObject;

import java.util.List;
import java.util.Objects;

@DataTransferObject
public class TeamDto {
    private String name;
    private List<String> engineers;

    public TeamDto() {
    }

    public TeamDto(String name) {
        this.name = name;
    }

    public TeamDto(String name, List<String> engineers) {
        this.name = name;
        this.engineers = engineers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEngineers() {
        return engineers;
    }

    public void setEngineers(List<String> engineers) {
        this.engineers = engineers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamDto teamDto = (TeamDto) o;
        return Objects.equals(name, teamDto.name) &&
            Objects.equals(engineers, teamDto.engineers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, engineers);
    }
}
