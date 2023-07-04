package org.codegenerator;

import java.time.LocalDate;

public class CodeGenerator {

    public static String generateUniqueCode(int storeId, int transactionNumber) {
        StoreId.initializeStoreIdMap();
        String storeIdCode = StoreId.getStoreId(storeId);
        String dateCode = DateCode.generateDateCode(LocalDate.now());
        String invoiceCode = InvoiceCode.generateInvoiceCode(transactionNumber);
        return storeIdCode + dateCode + invoiceCode;
    }

    public static String decodeUniqueCode(String uniqueCode) {
        String storeIdCode = uniqueCode.substring(0, 2);
        String dateCode = uniqueCode.substring(2, 6);
        String invoiceCode = uniqueCode.substring(6);

        int storeId = StoreId.getStoreNumber(storeIdCode);
        LocalDate date = DateCode.decodeDateCode(dateCode);
        int invoiceNumber = InvoiceCode.decodeInvoiceCode(invoiceCode);

        String decodedInfo = "Store: " + storeId + "\n" +
                "Date: " + date.toString() + "\n" +
                "Invoice: " + invoiceNumber;

        return decodedInfo;
    }
}