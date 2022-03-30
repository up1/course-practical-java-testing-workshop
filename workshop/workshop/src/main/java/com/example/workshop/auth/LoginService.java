package com.example.workshop.auth;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public LoginResponse process(String username, String password) {
        // 1. Check data from LDAP/AD
        // 2. Check data from database
        // 3. Create user session/token in redis
        return new LoginResponse("200", "Success");
    }

}
