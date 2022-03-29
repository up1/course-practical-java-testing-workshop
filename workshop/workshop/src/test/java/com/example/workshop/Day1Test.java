package com.example.workshop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


public class Day1Test {

    @ParameterizedTest
    @CsvSource({
            "somkiat,xxxx",
            "somkiat1,xxxx",
            "somkiat2,xxxx",
    })
    public void login_success(String username, String password) {
        // Initial
        Login login = new Login();
        // Call target class/method
        boolean result = login.process(username, password);
        // Validate/verify
        assertTrue(result);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("login ผ่านจะต้อง return ค่าเป็น true")
    public void case01() {
        // Initial
        Login login = new Login();
        // Call target class/method
        boolean result = login.process("somkiat", "xxxx");
        // Validate/verify
        assertTrue(result);
        assertEquals(true, result);
    }

    @Test
    @DisplayName("login ไม่ผ่านกรณี username ผิด จะต้อง return ค่าเป็น false")
    public void case02() {
        // Initial
        Login login = new Login();
        // Call target class/method
        boolean result = login.process("somkiatx", "xxxx");
        // Validate/verify
        assertFalse(result);
        assertEquals(false, result);
    }

    @Test
    @DisplayName("login ไม่ผ่านกรณี database ล่ม จะโยน " +
            "DatabaseFailureException กลับมา")
    public void case03() {
        // Initial
        Login login = new Login();
        // Call target class/method
        try {
            login.process("fail", "xxxx");
            // Fail
            fail("Database ไม่พัง แต่ในกรณีนี้มันต้องพังนะ");
        }catch (DatabaseFailureException e) {
            // Pass
            assertEquals("DB 500", e.getMessage());
        }
    }

    @Test
    @DisplayName("login ไม่ผ่านกรณี database ล่ม จะโยน " +
            "DatabaseFailureException กลับมา")
    public void case04() {
        // Initial
        Login login = new Login();
        // Call target class/method
        Exception exception = assertThrows(DatabaseFailureException.class, () -> {
            login.process("fail", "xxxx");
        });
        assertEquals("DB 500", exception.getMessage());
    }


}
