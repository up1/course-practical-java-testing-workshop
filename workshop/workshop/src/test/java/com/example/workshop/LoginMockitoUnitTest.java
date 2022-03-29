package com.example.workshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class LoginMockitoUnitTest {

    @InjectMocks
    private Login login;

    @Mock
    private UserRepository userRepository;

    @Test
    public void login_success() {
        // Initial
        // BDD => Given-When-Then
        when(userRepository.login("somkiat", "xxxx"))
                .thenReturn(true);
        // Call target method
        boolean result = login.process("somkiat", "xxxx");
        // Assertion
        assertTrue(result);
    }

    @Test
    public void login_fail() {
        // Initial
        when(userRepository.login("somkiatx", "xxxx"))
                .thenReturn(false);
        // Call target method
        boolean result = login.process("somkiatx", "xxxx");
        // Assertion
        assertFalse(result);
    }

    @Test
    public void login_fail_with_exception() {
        // Initial
        when(userRepository.login("fail", "xxxx"))
                .thenThrow(new DatabaseFailureException("DB 500"));
        // Call target method
        Exception exception = assertThrows(DatabaseFailureException.class, () -> {
            login.process("fail", "xxxx");
        });
        assertEquals("DB 500", exception.getMessage());
    }

}