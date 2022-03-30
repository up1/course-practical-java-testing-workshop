package com.example.workshop.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return new LoginResponse("200", "Success");
    }

}
