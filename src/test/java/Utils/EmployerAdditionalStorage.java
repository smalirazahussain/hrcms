package Utils;

import java.util.HashMap;
import java.util.Map;

public class EmployerAdditionalStorage {
    private static final Map<String, String> storage = new HashMap<>();

    // Store data by key
    public static void storeData(String key, String value) {
        storage.put(key, value);
    }

    // Retrieve stored data by key
    public static String getData(String key) {
        return storage.getOrDefault(key, null);
    }

    // Clear all stored data (optional)
    public static void clearData() {
        storage.clear();
    }

    // Optional: Check if a key exists
    public static boolean containsKey(String key) {
        return storage.containsKey(key);
    }

    // Optional: Print all stored data (for debugging)
    public static void printAll() {
        storage.forEach((key, value) -> System.out.println(key + " = " + value));
    }
}
