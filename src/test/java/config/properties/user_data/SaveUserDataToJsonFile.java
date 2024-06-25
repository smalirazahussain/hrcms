package config.properties.user_data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveUserDataToJsonFile {
    private static final String JSON_FILE_PATH = "src//test//java//config//properties//user_data//user_data.json";

    public static void main(String[] args) {
        // Generate unique establishmentId and other data
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        String establishmentId = "Establishment" + timestamp;
        String companyName = "Company" + timestamp;
        String email = "user" + timestamp + "@example.com";
        String phoneNumber = "123-456-7890";
        String password = "securePassword";
        String confirmPassword = "securePassword";
        String address = "123 Main Street";
        String buildingNumber = "Building A";
        String zipCode = "12345";
        String stateCity = "New York, NY";

        // Perform user creation steps with Selenium
        createUser(establishmentId, companyName, email, phoneNumber, password, confirmPassword, address, buildingNumber, zipCode, stateCity);

        // Save user details to JSON file
        saveUserDetailsToJsonFile(establishmentId, companyName, email, phoneNumber, password, confirmPassword, address, buildingNumber, zipCode, stateCity);

    }

    private static void createUser(String establishmentId, String companyName, String email, String phoneNumber, String password, String confirmPassword, String address, String buildingNumber, String zipCode, String stateCity) {
        System.out.println(establishmentId);
        System.out.println(companyName);
        System.out.println(email);
        System.out.println(phoneNumber);
        System.out.println(password);
        System.out.println(confirmPassword);
        System.out.println(address);
        System.out.println(buildingNumber);
        System.out.println(zipCode);
        System.out.println(stateCity);

    }

    private static void saveUserDetailsToJsonFile(String establishmentId, String companyName, String email, String phoneNumber, String password, String confirmPassword, String address, String buildingNumber, String zipCode, String stateCity) {
        JSONObject userObject = new JSONObject();
        userObject.put("establishmentId", establishmentId);
        userObject.put("companyName", companyName);
        userObject.put("email", email);
        userObject.put("phoneNumber", phoneNumber);
        userObject.put("password", password);
        userObject.put("confirmPassword", confirmPassword);
        userObject.put("address", address);
        userObject.put("buildingNumber", buildingNumber);
        userObject.put("zipCode", zipCode);
        userObject.put("stateCity", stateCity);

        JSONArray userDataArray = new JSONArray();
        userDataArray.put(userObject);

        JSONObject userDataJson = new JSONObject();
        userDataJson.put("user_data", userDataArray);

        try (FileWriter fileWriter = new FileWriter(JSON_FILE_PATH)) {
            fileWriter.write(userDataJson.toString(2));  // The "2" is for indentation to make the JSON file more readable
            System.out.println("User data saved to JSON file: " + JSON_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static JSONObject readJsonFile() {
        try (FileReader fileReader = new FileReader(JSON_FILE_PATH)) {
            // Read and print the content of the JSON file
            StringBuilder content = new StringBuilder();
            int character;
            while ((character = fileReader.read()) != -1) {
                content.append((char) character);
            }
            System.out.println("File Content: " + content);

            // Parse the JSON file
            return new JSONObject(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



}
