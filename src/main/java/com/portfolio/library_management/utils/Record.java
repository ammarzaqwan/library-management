package com.portfolio.library_management.utils;

public enum Record {
    CREATE("Record Created"),
    RETRIEVE("Record Retrieved"),
    UPDATE("Record Updated"),
    DELETE("Record Deleted");

    private final String message;

    Record(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
