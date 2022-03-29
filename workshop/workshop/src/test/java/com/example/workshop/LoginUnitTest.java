package com.example.workshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginUnitTest {

    @Test
    public void login_success() {
        // Initial
        UserRepository stub = new UserRepository() {
            @Override
            public boolean login(String username, String password) {
                return true;
            }
        };
        Login login = new Login();
        login.setUserRepository(stub);
        // Call target method
        boolean result = login.process("somkiat", "xxxx");
        // Assertion
        assertTrue(result);
    }

    @Test
    public void login_fail() {
        // Initial
        UserRepository stub = new UserRepository() {
            @Override
            public boolean login(String username, String password) {
                return false;
            }
        };
        Login login = new Login();
        login.setUserRepository(stub);
        // Call target method
        boolean result = login.process("somkiatx", "xxxx");
        // Assertion
        assertFalse(result);
    }

    @Test
    public void login_fail_with_exception() {
        // Initial
        UserRepository stub = new UserRepository() {
            @Override
            public boolean login(String username, String password) {
                throw new DatabaseFailureException("DB 500");
            }
        };
        Login login = new Login();
        login.setUserRepository(stub);
        // Call target method
        Exception exception = assertThrows(DatabaseFailureException.class, () -> {
            login.process("fail", "xxxx");
        });
        assertEquals("DB 500", exception.getMessage());
    }

}