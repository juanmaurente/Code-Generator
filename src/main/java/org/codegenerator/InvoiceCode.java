package org.codegenerator;

import java.util.HashMap;
import java.util.Map;

public class InvoiceCode {


    private static Map<Integer, Character> createNumbersMap() {
        Map<Integer, Character> numbersMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            numbersMap.put(i, (char) ('A' + i));
        }
        return numbersMap;
    }

    public static String generateInvoiceCode(int invoiceNumber) {
        if (invoiceNumber < 0 || invoiceNumber > 9999) {
            throw new IllegalArgumentException("Invalid invoice number: " + invoiceNumber);
        }

        StringBuilder codeBuilder = new StringBuilder();
        String invoiceString = String.valueOf(invoiceNumber);

        Map<Integer, Character> numbersMap = createNumbersMap();

        if (invoiceNumber == 0) {
            codeBuilder.append("AAA");
        } else {
            int leadingZeroes = 4 - invoiceString.length();
            for (int i = 0; i < leadingZeroes; i++) {
                codeBuilder.append("A");
            }

            for (char digitChar : invoiceString.toCharArray()) {
                int digit = Character.getNumericValue(digitChar);
                char codeChar = numbersMap.get(digit);
                codeBuilder.append(codeChar);
            }
        }

        return codeBuilder.toString();
    }


    private static Map<Character, Integer> charToDigitMap = new HashMap<>();

    private static void initializeCharToDigitMap() {
        Map<Integer, Character> numbersMap = createNumbersMap();
        for (Map.Entry<Integer, Character> entry : numbersMap.entrySet()) {
            charToDigitMap.put(entry.getValue(), entry.getKey());
        }
    }

    public static int decodeInvoiceCode(String code) {
        if (charToDigitMap.isEmpty()) {
            initializeCharToDigitMap();
        }

        StringBuilder invoiceBuilder = new StringBuilder();

        for (char codeChar : code.toCharArray()) {
            int digit = charToDigitMap.get(codeChar);
            invoiceBuilder.append(digit);
        }

        return Integer.parseInt(invoiceBuilder.toString());
    }
}
