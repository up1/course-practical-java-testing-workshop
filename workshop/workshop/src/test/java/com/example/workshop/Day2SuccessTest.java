package com.example.workshop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Day2SuccessTest {

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

}
