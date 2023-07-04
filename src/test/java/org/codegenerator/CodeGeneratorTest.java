package org.codegenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CodeGeneratorTest {

    @Test
    public void testGenerateUniqueCode() {
        int storeId = 12;
        int transactionNumber = 123;
        String expectedCode = "AL04G3ABCD";
        String actualCode = CodeGenerator.generateUniqueCode(storeId, transactionNumber);

        assertEquals(expectedCode, actualCode);
    }

    @Test
    public void testDecodeUniqueCode() {
        String uniqueCode = "AL04G3ABCD";
        String expectedInfo = "Store: 12\n" +
                "Date: 2023-07-04\n" +
                "Invoice: 123";
        String actualInfo = CodeGenerator.decodeUniqueCode(uniqueCode);

        assertEquals(expectedInfo, actualInfo);
    }

}
