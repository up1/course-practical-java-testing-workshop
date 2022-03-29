package com.example.workshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class LoginWithSpyMpckitoTest {

    @InjectMocks
    private Login login;

    @Mock
    private UserRepository userRepository;

    @Test
    public void called_login_from_repository() {
        // Call target method
        login.process("somkiat", "xxxx");
        // Assertion
        verify(userRepository).login("somkiat", "xxxx");
    }

}