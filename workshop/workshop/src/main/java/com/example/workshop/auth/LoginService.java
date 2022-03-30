package com.example.workshop.auth;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public LoginResponse process(String username, String password) {
        // 1. Check data from LDAP/AD
        LdapClient ldapClient = new LdapClient();
        boolean found = ldapClient.check(username);
        if(!found) {
            throw new LdapDataNotFoundException();
        }
        // 2. Check data from database
        UserRepository userRepository = new UserRepository();
        boolean foundUser = userRepository.findUser(username, password);
        if(!foundUser) {
            throw new DbUserNotFoundException();
        }
        // 3. Create user session/token in redis
        RedisClient redisClient = new RedisClient();
        String sessionId = redisClient.createSession(username);
        // 4. Return sessionId
        return new LoginResponse("200", "Success");
    }

}
