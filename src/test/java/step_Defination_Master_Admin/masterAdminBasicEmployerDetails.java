package step_Defination_Master_Admin;

import Utils.EmployerDataStorage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static Hooks.Base_Class.driver;

public class masterAdminBasicEmployerDetails {
    @Then("[Basic EmployerDetails] The user verifies all employer details")
    public void basicEmployerDetailsTheUserVerifiesAllEmployerDetails() {

        // ✅ Map field names from UI to keys stored in EmployerDataStorage
        Map<String, String> fieldMapping = new LinkedHashMap<>();
        fieldMapping.put("Company Name", "EmployerName");
        fieldMapping.put("Email", "Email");
        fieldMapping.put("Phone Number", "PhoneNumber");
        fieldMapping.put("Address", "companyAddress");
        fieldMapping.put("Building Number", "BuildingNumber");
        fieldMapping.put("City", "City");
        fieldMapping.put("State", "State");
        fieldMapping.put("Trade License Number", "tradeLicenseNumber");
        fieldMapping.put("Issue Date", "tradeLicenseIssueDate");
        fieldMapping.put("Expiry Date", "tradeLicenseExpiryDate");
        fieldMapping.put("Sponsor Document Number", "sponsorDocumentNumber");
        fieldMapping.put("Sponsor Document Issue Date", "sponsorDocumentIssueDate");
        fieldMapping.put("Sponsor Document Expiry Date", "sponsorDocumentExpiryDate");
        fieldMapping.put("Payroll Types", "PayrollType");
        fieldMapping.put("Establishment ID", "EstablishmentId");
        fieldMapping.put("Free Zone", "freeZone");
        fieldMapping.put("Migrated", "MigratedEmployer");
        fieldMapping.put("ZipCode", "ZipCode");

        // ✅ Find all elements dynamically
        List<WebElement> fieldLabels = driver.findElements(By.cssSelector("li:nth-child(n) > span:nth-child(1)")); // Labels
        List<WebElement> fieldValues = driver.findElements(By.cssSelector("li:nth-child(n) > span:nth-child(2)")); // Values

        // ✅ Ensure both lists are of the same size
        if (fieldLabels.size() != fieldValues.size()) {
            Assert.fail("❌ Mismatch in field labels and values count! UI structure may have changed.");
        }

        // 📂 Print All Stored Employer Data Before Validation
        System.out.println("\n📂 **Stored Employer Data:**");
        EmployerDataStorage.printAllData();

        // 📌 Print Debugging Table Before Assertion
        System.out.println("\n📋 **Verifying All Employer Details:**");
        System.out.printf("%-35s | %-30s | %-30s%n", "🔹 Field Name", "✅ Expected", "📌 Actual");
        System.out.println("------------------------------------------------------------------------------------------------");

        // ✅ Print UI field labels before assertions
        System.out.println("\n🔍 **Detected Field Labels in UI:**");
        for (WebElement label : fieldLabels) {
            System.out.println("📌 Field Label: " + label.getText().trim());
        }

        // ✅ Iterate over each field in UI
        List<String> failedFields = new ArrayList<>();

        for (int i = 0; i < fieldLabels.size(); i++) {
            String actualFieldName = fieldLabels.get(i).getText().trim().replaceAll("\\s+", " ");
            String actualValue = fieldValues.get(i).getText().trim();

            // ✅ **Skip assertion for "Document Name"**
            if (actualFieldName.equalsIgnoreCase("Document Name")) {
                System.out.println("⚠️ Skipping assertion for field: " + actualFieldName);
                continue;
            }

            // ✅ Handle Unexpected Fields in UI
            if (!fieldMapping.containsKey(actualFieldName)) {
                System.err.println("⚠️ Unexpected field found on UI: " + actualFieldName);
                continue; // Skip fields that are not in our expected mapping
            }

            // ✅ Retrieve the expected value from EmployerDataStorage
            String expectedValue = EmployerDataStorage.getData(fieldMapping.get(actualFieldName)).trim();
            expectedValue = expectedValue.isEmpty() ? "N/A" : expectedValue; // Handle empty values

            // ✅ Fix Phone Number by removing the country code (971)
            if (actualFieldName.equalsIgnoreCase("Phone Number") && actualValue.startsWith("971")) {
                actualValue = actualValue.substring(3);  // Remove first 3 characters ("971")
            }

            // 🔥 Print Debug Info BEFORE Assertion
            System.out.printf("%-35s | %-30s | %-30s%n", actualFieldName, expectedValue, actualValue);

            // ✅ Validate the field and store failed assertions
            if (!actualValue.equals(expectedValue)) {
                failedFields.add("❌ Mismatch for: " + actualFieldName + " expected [" + expectedValue + "] but found [" + actualValue + "]");
            }
        }

        // ✅ Final assertion AFTER printing all data
        if (!failedFields.isEmpty()) {
            for (String failure : failedFields) {
                System.err.println(failure);
            }
            Assert.fail("❌ Employer details validation failed! See mismatches above.");
        }

        System.out.println("\n✅ All employer details have been successfully verified!");
    }


}


//        // ✅ Find all elements dynamically
//        List<WebElement> fieldLabels = driver.findElements(By.cssSelector("li:nth-child(n) > span:nth-child(1)")); // Labels
//        List<WebElement> fieldValues = driver.findElements(By.cssSelector("li:nth-child(n) > span:nth-child(2)")); // Values
//
//        // 🛠️ Print retrieved locators
//        System.out.println("\n📋 **Printing All Employer Details Locators:**");
//
//        // ✅ Print all field labels
//        System.out.println("\n🔹 **Field Labels Found:**");
//        for (WebElement label : fieldLabels) {
//            System.out.println("📌 Field Label: " + label.getText().trim());
//        }
//
//        // ✅ Print all field values
//        System.out.println("\n🔹 **Field Values Found:**");
//        for (WebElement value : fieldValues) {
//            System.out.println("📌 Field Value: " + value.getText().trim());
//        }
//
//        System.out.println("\n✅ Successfully printed all employer detail locators!");
//    }


