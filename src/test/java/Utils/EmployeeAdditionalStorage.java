package Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeeAdditionalStorage {
    private static final Map<String, String> storage = new ConcurrentHashMap<>();


    // Store employee data by key
    public static void storeData(String key, String value) {
        storage.put(key, value);
    }

    // Retrieve employee data by key
    public static String getData(String key) {
        return storage.getOrDefault(key, null);
    }

    // Clear all employee data
    public static void clearData() {
        storage.clear();
    }

    // Check if a specific key exists
    public static boolean containsKey(String key) {
        return storage.containsKey(key);
    }

    // Print all stored key-value pairs (useful for debugging)
    public static void printAll() {
        System.out.println("\n📋 Stored Employee Data:");
        storage.forEach((key, value) -> System.out.println(key + " = " + value));
    }

    // ✅ Expose all data (for external filtered printing)
    public static Map<String, String> getAllData() {
        return new HashMap<>(storage); // Prevents modification from outside
    }
}
