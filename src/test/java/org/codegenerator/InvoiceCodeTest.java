package org.codegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceCodeTest {

    @Test
    public void testCreateNumbersMap() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method createNumbersMapMethod = InvoiceCode.class.getDeclaredMethod("createNumbersMap");
        ((Method) createNumbersMapMethod).setAccessible(true);

        Map<Integer, Character> numbersMap = (Map<Integer, Character>) createNumbersMapMethod.invoke(null);

        assertEquals(10, numbersMap.size(), "Size of map is not the expected");
        assertEquals('A', numbersMap.get(0), "Key 0 should be associated with A");
        assertEquals('C', numbersMap.get(2), "Key 2 should be associated with C");
    }
    @Test
    public void testGenerateInvoiceCode() {
        String expectedCode = "AABB";
        int invoiceNumber = 11;
        String actualCode = InvoiceCode.generateInvoiceCode(invoiceNumber);

        assertEquals(expectedCode, actualCode);
    }

    @Test
    public void testDecodeInvoiceCode() {
        String code = "BBBB";
        int expectedInvoiceNumber = 1111;
        int actualInvoiceNumber = InvoiceCode.decodeInvoiceCode(code);

        assertEquals(expectedInvoiceNumber, actualInvoiceNumber);
    }
}