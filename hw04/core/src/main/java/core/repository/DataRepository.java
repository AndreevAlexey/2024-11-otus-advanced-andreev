package core.repository;

import java.util.HashMap;
import java.util.Map;

public class DataRepository {

    private static final Map<Integer, String> dataStoreMap = new HashMap<>();

    public void addData(String value) {
        int key = value.hashCode();
        dataStoreMap.put(key, value);

        System.out.printf("Core stored data (key=%d, value=%s)\n", key, value);
    }

}
