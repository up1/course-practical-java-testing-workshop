package com.example.workshop.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.process(request.getUsername(), request.getPassword());
    }

}
