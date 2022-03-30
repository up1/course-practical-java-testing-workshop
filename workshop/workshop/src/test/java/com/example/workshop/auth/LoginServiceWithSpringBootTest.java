package com.example.workshop.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LoginServiceWithSpringBootTest {

    @Autowired
    private LoginService loginService;

    @MockBean
    private LdapClient ldapClient;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private RedisClient redisClient;

    @Test
    void login_success() {
        // Arrange
        when(ldapClient.check("somkiat")).thenReturn(true); // Suggest from
        when(userRepository.findUser("somkiat","xxxx")).thenReturn(true);
        when(redisClient.createSession("somkiat")).thenReturn("123456");
        // Act
        LoginResponse result = loginService.process("somkiat", "xxxx");
        // Assert
        assertEquals("200", result.getCode());
        assertEquals("Success", result.getMessage());

    }
}