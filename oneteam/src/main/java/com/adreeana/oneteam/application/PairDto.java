package com.adreeana.oneteam.application;

import java.util.Objects;

public class PairDto {
    private String driver;
    private String navigator;

    public PairDto(String driver, String navigator) {
        this.driver = driver;
        this.navigator = navigator;
    }

    public String getNavigator() {
        return navigator;
    }

    public String getDriver() {
        return driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairDto pairDto = (PairDto) o;
        return Objects.equals(driver, pairDto.driver) &&
            Objects.equals(navigator, pairDto.navigator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, navigator);
    }
}
