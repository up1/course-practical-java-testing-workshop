package com.example.workshop.auth;

import com.example.workshop.DatabaseFailureException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginServiceFailUnitTest {

    @InjectMocks
    private LoginService loginService;
    @Mock
    private LdapClient ldapClient;
    @Mock
    private UserRepository userRepository;
    @Mock
    private RedisClient redisClient;

    @Test
    public void fail_with_notfound_in_ldap() {
        // Arrange
        when(ldapClient.check("somkiat")).thenReturn(false);
        // Act
        assertThrows(LdapDataNotFoundException.class, () -> {
            loginService.process("somkiat","xxxx");
        });
    }

    @Test
    public void fail_with_notfound_in_repository() {
        // Arrange
        when(ldapClient.check("somkiat")).thenReturn(true);
        when(userRepository.findUser("somkiat","xxxx")).thenReturn(false);
        // Act
        assertThrows(DbUserNotFoundException.class, () -> {
            loginService.process("somkiat","xxxx");
        });
    }

    @Test
    public void fail_with_cannot_create_session_from_redis() {
        // Arrange
        when(ldapClient.check("somkiat")).thenReturn(true);
        when(userRepository.findUser("somkiat","xxxx")).thenReturn(true);
        when(redisClient.createSession("somkiat")).thenReturn(null);
        // Act
        assertThrows(CannotCreateSessionException.class, () -> {
            loginService.process("somkiat","xxxx");
        });
    }

}