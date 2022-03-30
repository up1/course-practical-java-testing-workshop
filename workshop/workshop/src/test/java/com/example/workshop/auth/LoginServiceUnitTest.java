package com.example.workshop.auth;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginServiceUnitTest {

    @InjectMocks
    private LoginService loginService;
    @Mock
    private LdapClient ldapClient;
    @Mock
    private UserRepository userRepository;
    @Mock
    private RedisClient redisClient;

    @Test
    public void login_with_success() {
        // Arrange
        when(ldapClient.check("somkiat")).thenReturn(true);
        when(userRepository.findUser("somkiat","xxxx")).thenReturn(true);
        when(redisClient.createSession("somkiat")).thenReturn("123456");
        // Act
        LoginResponse result = loginService.process("somkiat","xxxx");
        // Assert
        assertEquals("200", result.getCode());
        assertEquals("Success", result.getMessage());
    }

}