package org.codegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StoreIdTest {

    @Test
    public void testCreateStoreIdMap() {
        Map<Integer, String> storeIdMap = StoreId.createStoreIdMap();

        // Verify that the map size is 200 to cover all stores
        assertEquals(200, storeIdMap.size());

        // Test some combinations
        assertEquals("AA", storeIdMap.get(1));
        assertEquals("AB", storeIdMap.get(2));
        assertEquals("AC", storeIdMap.get(3));
        assertEquals("AZ", storeIdMap.get(26));
        assertEquals("BA", storeIdMap.get(27));
    }

    @Test
    public void testGetStoreId() {
        Map<Integer, String> storeIdMap = StoreId.createStoreIdMap();
        String storeId = StoreId.getStoreId(1);
        assertEquals("AA", storeId);
    }

    @Test
    public void testGetStoreNumber() {
        String storeLetter = "AA";
        int expectedStoreNumber1 = 1;
        int actualStoreNumber1 = StoreId.getStoreNumber(storeLetter);
        assertEquals(expectedStoreNumber1, actualStoreNumber1);
    }
}