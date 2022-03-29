package com.example.workshop;

public class Login {

    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean process(String username, String password) {
        boolean result = userRepository.login(username, password);
        return result;
//        if("fail".equals(username)) {
//            throw new DatabaseFailureException("DB 500");
//        }
//        return "somkiat".equals(username);
    }
}
