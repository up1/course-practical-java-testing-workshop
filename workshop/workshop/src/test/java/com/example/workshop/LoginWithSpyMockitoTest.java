package com.example.workshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class LoginWithSpyMpckitoTest {

    @InjectMocks
    private Login login;

    @Spy
    private UserRepository userRepository;

    @Test
    public void called_login_from_repository() {
        // Initial
//        when(userRepository.login("somkiat", "xxxx")).thenReturn(false);
        doReturn(false)
                .when(userRepository).login("somkiat", "xxxx");
        // Call target method
        login.process("somkiat", "xxxx");
        // Assertion
        verify(userRepository).login("somkiat", "xxxx");
    }

}