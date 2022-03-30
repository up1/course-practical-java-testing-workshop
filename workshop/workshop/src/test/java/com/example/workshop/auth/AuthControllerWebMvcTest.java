package com.example.workshop.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(AuthController.class)
class AuthControllerWebMvcTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void login_success() throws Exception {
        // Arrange
        LoginRequest request = new LoginRequest("somkiat", "xxxx");
        // Act
        MvcResult result = mvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                        "    \"username\": \"somkiat\",\n" +
                        "    \"password\": \"xxxx\"\n" +
                        "}"))
                .andReturn();
        // Assert
        String jsonResponse = result.getResponse().getContentAsString();
        LoginResponse loginResponse =
                new ObjectMapper().readValue(jsonResponse, LoginResponse.class);
        assertEquals("200", loginResponse.getCode());
        assertEquals("Success", loginResponse.getMessage());
    }
}