package org.codegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateCodeTest {
    @Test
    public void testGenerateDateCode() {
        LocalDate date = LocalDate.of(2023, 7, 4);
        String expectedCode = "04G3";
        String actualCode = DateCode.generateDateCode(date);
        assertEquals(expectedCode, actualCode);
    }

    @Test
    public void testGenerateDateCodeWithSingleDigitDay() {
        LocalDate date = LocalDate.of(2023, 10, 9);
        String expectedCode = "09J3";
        String actualCode = DateCode.generateDateCode(date);
        assertEquals(expectedCode, actualCode);
    }

    @Test
    public void testGenerateDateCodeWithSingleDigitMonth() {
        LocalDate date = LocalDate.of(2023, 1, 15);
        String expectedCode = "15A3";
        String actualCode = DateCode.generateDateCode(date);
        assertEquals(expectedCode, actualCode);
    }

    @Test
    public void testGenerateDateCodeWithLeapYear() {
        LocalDate date = LocalDate.of(2024, 2, 29);
        String expectedCode = "29B4";
        String actualCode = DateCode.generateDateCode(date);
        assertEquals(expectedCode, actualCode);
    }

    @Test
    public void testDecodeDateCode() {
        String code = "04G3";
        LocalDate decodedDate = DateCode.decodeDateCode(code);
        LocalDate expectedDate = LocalDate.of(2023, 7, 4);
        Assertions.assertEquals(expectedDate, decodedDate);
    }

    @Test
    public void testDecodeMonthCode() {
        String monthCode = "G";
        int decodedMonth = DateCode.decodeMonthCode(monthCode);
        int expectedMonth = 7;
        Assertions.assertEquals(expectedMonth, decodedMonth);
    }
}
