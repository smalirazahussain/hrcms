package Utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class EmployerDataStorage {
    private static final Map<String, String> employerData = new ConcurrentHashMap<>();

    public static void storeData(String key, String value) {
        if (value != null && !value.trim().isEmpty()) {
            employerData.put(key, value.trim());  // ✅ Store only non-empty values
            System.out.println("✅ Stored: " + key + " = " + value.trim());
        } else {
            System.err.println("⚠️ Warning: Attempted to store empty or null value for key: " + key);
        }
    }

    public static String getData(String key) {
        return employerData.getOrDefault(key, "N/A");  // ✅ Return "N/A" only if key is completely missing
    }

    public static void printAllData() {
        System.out.println("📂 **Stored Employer Data:**");
        if (employerData.isEmpty()) {
            System.out.println("⚠️ No data stored yet!");
        } else {
            for (Map.Entry<String, String> entry : employerData.entrySet()) {
                System.out.println("🔹 " + entry.getKey() + " = " + entry.getValue());
            }
        }
    }
}
