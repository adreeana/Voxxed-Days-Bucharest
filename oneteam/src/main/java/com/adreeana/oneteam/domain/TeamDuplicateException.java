package com.adreeana.oneteam.domain;

public class TeamDuplicateException extends RuntimeException {
    public TeamDuplicateException(String message) {
        super("Team " + message + " already exists.");
    }
}
