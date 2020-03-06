package com.adreeana.oneteam.domain;

import com.livedocumentation.CoreConcept;
import com.livedocumentation.ValueObject;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

@ValueObject
@CoreConcept
public class Pair {
    private final String driver;
    private final String navigator;

    public Pair(String driver, String navigator) {
        this.driver = driver;
        this.navigator = navigator;
    }

    public String getDriver() {
        return driver;
    }

    public String getNavigator() {
        return navigator;
    }

    public List<String> list() {
        return asList(driver, navigator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(driver, pair.driver) &&
            Objects.equals(navigator, pair.navigator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, navigator);
    }

    @Override
    public String toString() {
        return "Pair{" +
            "driver='" + driver + '\'' +
            ", navigator='" + navigator + '\'' +
            '}';
    }
}
