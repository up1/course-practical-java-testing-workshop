package com.example.workshop.auth;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LoginServiceUnitTest {

    @InjectMocks
    private LoginService loginService;

    @Test
    public void login_with_success() {
        loginService.process("somkiat","xxxx");
    }

}