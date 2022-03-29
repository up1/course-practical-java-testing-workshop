package com.example.workshop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Day1Test {

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


}
