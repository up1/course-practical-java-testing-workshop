package com.example.workshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpyUserRepository extends UserRepository {
    private int counter = 0;

    @Override
    public boolean login(String username, String password) {
        if("somkiat".equals(username)) {
            counter++;
        }
        return false;
    }

    public boolean verify(int expected) {
        return expected == counter;
    }
}

class LoginWithSpyTest {

    @Test
    public void login_success() {
        SpyUserRepository spy = new SpyUserRepository();
        Login login = new Login();
        login.setUserRepository(spy);
        // Call target method
        login.process("somkiat", "xxxx");
        // Assertion
        assertTrue(spy.verify(1));
    }

}