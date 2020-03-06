package com.adreeana.oneteam.application;

import com.livedocumentation.DataTransferObject;

import java.util.Objects;

@DataTransferObject
public class EngineerDto {
    private String name;

    public EngineerDto() {}

    public EngineerDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EngineerDto that = (EngineerDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
