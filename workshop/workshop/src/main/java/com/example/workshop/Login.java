package com.example.workshop;

public class Login {
    public boolean process(String username, String password) {
        if("fail".equals(username)) {
            throw new DatabaseFailureException("DB 500");
        }
        return "somkiat".equals(username);
    }
}
