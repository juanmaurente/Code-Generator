package org.codegenerator;

import java.util.HashMap;
import java.util.Map;

public class StoreId {
    static Map<Integer, String> storeIdMap  = new HashMap<>();


    static Map<Integer, String> createStoreIdMap() {
        int count = 1;
        for (int i = 0; i < 200; i++) {
            String storeId = getLetter(i / 26) + getLetter(i % 26);
            storeIdMap .put(count, storeId);
            count++;
        }
        return storeIdMap ;
    }
    static String getLetter(int index) {
        return String.valueOf((char) ('A' + index));
    }

    public static String getStoreId(int storeId) {
        return storeIdMap.get(storeId);
    }

    static void initializeStoreIdMap() {
        Map<Integer, String> originalMap = createStoreIdMap();
        for (Map.Entry<Integer, String> entry : originalMap.entrySet()) {
            storeIdMap.put(entry.getKey(), entry.getValue());
        }
    }

    public static int getStoreNumber(String storeLetter) {
        if (storeIdMap.isEmpty()) {
            initializeStoreIdMap();
        }

        for (Map.Entry<Integer, String> entry : storeIdMap.entrySet()) {
            if (entry.getValue().startsWith(storeLetter)) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
