package com.example.workshop.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LdapClient ldapClient;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RedisClient redisClient;

    public LoginResponse process(String username, String password) {
        // 1. Check data from LDAP/AD
        boolean found = ldapClient.check(username);
        if(!found) {
            throw new LdapDataNotFoundException();
        }
        // 2. Check data from database
        boolean foundUser = userRepository.findUser(username, password);
        if(!foundUser) {
            throw new DbUserNotFoundException();
        }
        // 3. Create user session/token in redis
        String sessionId = redisClient.createSession(username);
        if(sessionId == null) {
            throw new CannotCreateSessionException();
        }
        // 4. Return sessionId
        return new LoginResponse("200", "Success");
    }

}
