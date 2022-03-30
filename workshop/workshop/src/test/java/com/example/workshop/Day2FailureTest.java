package com.example.workshop;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class Day2FailureTest {

    private Login login;

    @BeforeAll
    public static void start() {
        System.out.println("Call start");
    }

    @AfterAll
    public static void finish() {
        System.out.println("Call finish");
    }

    @BeforeEach
    public void initial() {
        // Initial
        login = new Login();
        System.out.println("Call initial");
    }

    @AfterEach
    public void cleanup() {
        System.out.println("Call cleanup");
    }

    @Test
    @DisplayName("login ไม่ผ่านกรณี username ผิด จะต้อง return ค่าเป็น false")
    public void case02() {

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
        // Call target class/method
        Exception exception = assertThrows(DatabaseFailureException.class, () -> {
            login.process("fail", "xxxx");
        });
        assertEquals("DB 500", exception.getMessage());
    }


}
