package org.lesson21;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.lesson21.Task2.isValidAccountNumber;

class Task2Test {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;  // Сохранение оригинального System.out


    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMain() {
        Task2.main(null);
        String expectedOutput = "true" + System.lineSeparator();  // Использование System.lineSeparator()
        assertEquals(expectedOutput, outContent.toString());  // trim() удаляет конечные символы новой строки
    }

    @Test
    void isValidAccountNumber_StringNull_Test() {
        assertFalse(isValidAccountNumber(null));
    }

    @Test
    void isValidAccountNumber_StringEmpty_Test() {
        assertFalse(isValidAccountNumber(""));
    }

    @Test
    void isValidAccountNumber_StringAllZero_Test() {
        assertFalse(isValidAccountNumber("00000000000000"));
    }

    @Test
    void isValidAccountNumber_StringNotDigits_Test() {
        assertFalse(isValidAccountNumber("0123456789ABCD"));
    }

    @Test
    void isValidAccountNumber_ShortString_Test() {
        assertFalse(isValidAccountNumber("123456"));
    }

    @Test
    void isValidAccountNumber_LongString_Test() {
        assertFalse(isValidAccountNumber("123456789012345"));
    }

    @Test
    void isValidAccountNumber_String14Digits_Test() {
        assertTrue(isValidAccountNumber("12345678901234"));
    }

}