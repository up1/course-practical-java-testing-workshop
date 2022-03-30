package com.example.workshop.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AuthControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void login_success() {
        // Arrange
        LoginRequest request = new LoginRequest("somkiat", "xxxx");
        // Act
        LoginResponse result = restTemplate.postForObject("/login", request,
                LoginResponse.class);
        // Assert
        assertEquals("200", result.getCode());
        assertEquals("Success", result.getMessage());

    }
}