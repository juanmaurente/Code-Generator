package org.codegenerator;
import java.time.LocalDate;

public class DateCode {

    /*  Methods for decoding the date */

    public static String generateDateCode(LocalDate date) {
        String dayCode = String.format("%02d", date.getDayOfMonth());
        String monthCode = generateMonthCode(date.getMonthValue());
        String yearCode = String.valueOf(date.getYear() % 10);
        return dayCode + monthCode + yearCode;
    }

    private static String generateMonthCode(int month){
        return String.valueOf((char) ('A' + month - 1));
    }

    /*  Methods for decoding the date */

    public static LocalDate decodeDateCode(String code) {
        String dayCode = code.substring(0, 2);
        String monthCode = code.substring(2, 3);
        String yearCode = code.substring(3, 4);

        int day = Integer.parseInt(dayCode);
        int month = decodeMonthCode(monthCode);
        int year = Integer.parseInt(yearCode);

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month value: " + month);
        }

        return LocalDate.of(2020 + year, month, day);
    }

    static int decodeMonthCode(String monthCode) {
        char monthChar = monthCode.charAt(0);
        return monthChar - 'A' + 1;
    }
}