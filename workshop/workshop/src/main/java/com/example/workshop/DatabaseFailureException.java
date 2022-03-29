package com.example.workshop;

public class DatabaseFailureException extends RuntimeException {
    public DatabaseFailureException(String s) {
        super(s);
    }
}
