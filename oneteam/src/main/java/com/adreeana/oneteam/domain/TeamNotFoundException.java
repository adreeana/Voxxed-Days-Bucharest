package com.adreeana.oneteam.domain;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(String message) {
        super("Team " + message + " not found");
    }
}
