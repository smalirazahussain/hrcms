package Utils;

import java.util.HashMap;
import java.util.Map;

public class OtherBankEmployeesStorage {
    // 🔐 Internal map to store key-value pairs
    private static final Map<String, String> storage = new HashMap<>();

    // ✅ Store data with a key
    public static void storeData(String key, String value) {
        storage.put(key, value);
    }

    // ✅ Retrieve data by key
    public static String getData(String key) {
        return storage.getOrDefault(key, null);
    }

    // ✅ Clear all stored data
    public static void clearData() {
        storage.clear();
    }

    // ✅ Check if a key exists
    public static boolean containsKey(String key) {
        return storage.containsKey(key);
    }

    // ✅ Print all stored data (for debugging/logging)
    public static void printAll() {
        System.out.println("\n📋 Stored Other Bank Employee Data:");
        storage.forEach((key, value) -> System.out.println(key + " = " + value));
    }

    // ✅ Expose copy of all data (for assertions or exporting)
    public static Map<String, String> getAllData() {
        return new HashMap<>(storage); // Return defensive copy
    }
    public static void printEmployeeTable() {
        Map<String, String> data = OtherBankEmployeesStorage.getAllData();

        // Get headers
        String headerLine = data.getOrDefault("employee-headers", "");
        String[] headers = headerLine.split(",");

        int columnWidth = 20;

        // Print headers
        System.out.println("\n📋 EMPLOYEE DATA (Other Bank Employees)\n");
        for (String header : headers) {
            System.out.printf("%-" + columnWidth + "s", header);
        }
        System.out.println("\n" + "-".repeat(headers.length * columnWidth));

        // Print each employee row
        int i = 0;
        while (true) {
            boolean rowExists = false;
            for (String header : headers) {
                String key = "employee-" + i + "-" + header;
                String value = data.getOrDefault(key, "");
                if (!value.isEmpty()) {
                    rowExists = true;
                }
                System.out.printf("%-" + columnWidth + "s", value);
            }
            if (!rowExists) break; // no more rows
            System.out.println();
            i++;
        }
    }
}

