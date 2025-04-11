package step_Defination_Master_Admin;

import Pages.MasterAdmin.MasterAdminAdditionalDetailsPage;
import Utils.EmployerAdditionalStorage;
import Utils.EmployerDataStorage;
import Utils.RandomDateGenerator;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;

import static Hooks.Base_Class.driver;
import static Pages.MasterAdmin.MasterAdminAdditionalDetailsPage.Enable_Cashback;
import static Step_Definitions.adminsteps.spinnerLocator;
import static org.apache.commons.exec.util.DebugUtils.handleException;

public class masterAdminAdditionalDetailsSteps {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    @Then("[Additional Details] The user navigates to the {string} tab")
    public void additionalDetailsTheUserNavigatesToTheTab(String arg0) {
//        try {
        WebElement additionalDetailsTab = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Additional_DetailsTab()));
        additionalDetailsTab.click();
        System.out.println("✅ Navigated to Additional Details tab");
//        } catch (Exception e) {
//            handleException("Navigating to Additional Details tab", e);
//        }
    }

    @Then("[Additional Details] The user click to the AddEdit Onboarding Source button")
    public void additionalDetailsTheUserClickToTheAddEditOnboardingSourceButton() {
        try {
            // ✅ Wait for the button to be clickable
            WebElement addEditOnboardingSourceButton = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Add_Edit_Onboarding_Source_button()));

            // ✅ Click the button
            addEditOnboardingSourceButton.click();

            // ✅ Print confirmation message
            System.out.println("✅ Clicked on 'Add/Edit Onboarding Source' button.");

        } catch (Exception e) {
            handleException("Clicking 'Add/Edit Onboarding Source' button", e);
        }
    }

    @Then("[Additional Details] The user selects the Onboarding Source {string}")
    public void additionalDetailsTheUserSelectsTheOnboardingSource(String source) {

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Onboarding_Source_Dropdown()));
        dropdown.sendKeys(source);
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Add_Onboarding_Source(source)));
        option.click();

        // ✅ Store the selected onboarding source
        EmployerDataStorage.storeData("onboardingSource", source);
        System.out.println("✅ Selected Onboarding Source: " + source);
        //  } catch (Exception e) {
        //    handleException("Selecting Onboarding Source", e);
    }

    @Then("[Additional Details] The user clicks on the Add Product button")
    public void additionalDetailsTheUserClicksOnTheAddProductButton() throws InterruptedException {
        //  try {
        Thread.sleep(3000);
        WebElement addProductBtn = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Add_Product_Button()));
        addProductBtn.click();
        System.out.println("✅ Clicked on Add Product button");
        //  } catch (Exception e) {
        //  handleException("Clicking Add Product button", e);
        //}
    }

    @Then("[Additional Details] The user selects product type {string}")
    public void additionalDetailsTheUserSelectsProductType(String productType) throws InterruptedException {
        //try {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Product_Type_Dropdown()));
        dropdown.sendKeys(productType + Keys.ENTER);
        //dropdown.click();

        //Thread.sleep(5000);

//            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Select_Product_Type(productType)));
//            option.sendKeys(productType+ Keys.ENTER);
//            option.click();

        // Thread.sleep(5000);

        EmployerAdditionalStorage.storeData("ProductType", productType);
        System.out.println("✅ Product Type Selected: " + productType);
        //} catch (Exception e) {
        //  handleException("Select Product Type", e);
        //    System.out.println("not match"+e);
        //  }
    }

    @Then("[Additional Details] The user enters effect from {string} and effect to {string}")
    public void additionalDetailsTheUserEntersEffectFromAndEffectTo(String arg0, String arg1) throws InterruptedException {
        try {
            WebElement from = MasterAdminAdditionalDetailsPage.get_Effect_From();

            //WebElement to = MasterAdminAdditionalDetailsPage.get_Effect_To();
            from.click();
            WebElement todayButton = MasterAdminAdditionalDetailsPage.get_Calender_Today_Button();
            todayButton.click();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
            String currentDate = LocalDate.now().format(formatter);

            EmployerAdditionalStorage.storeData("EffectFrom", currentDate);
            System.out.println("✅ Stored EffectTo as today's date: " + currentDate);
            // Store today's date manually since `.getText()` won't give you the date from a calendar

            if (todayButton.isDisplayed() && todayButton.isEnabled()) {
                todayButton.click();

//                // Store today's date manually since `.getText()` won't give you the date from a calendar
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
//                String currentDate = LocalDate.now().format(formatter);
//
//                EmployerAdditionalStorage.storeData("EffectTo", currentDate);
//                System.out.println("✅ Stored EffectTo as today's date: " + currentDate);
            }
            //from.click();
            //Thread.sleep(3000);
//            String toDate = RandomDateGenerator.generateRandomFutureExpiryDate();
//            to.sendKeys(toDate);
//            to.click();

            //EmployerAdditionalStorage.storeData("EffectFrom", fromDate);
//            EmployerAdditionalStorage.storeData("EffectTo", toDate);
//
//            System.out.println("✅ Dates Entered: " + fromDate + " → " + toDate);
        } catch (Exception e) {
            handleException("Enter Effect Dates", e);
        }
        //   try {

        WebElement to = MasterAdminAdditionalDetailsPage.get_Effect_To();
//        to.sendKeys();
//        String fromDate;
//
//        // Try clicking "Today" button
//        WebElement todayBtn = MasterAdminAdditionalDetailsPage.get_Calender_Today_Button();
//        todayBtn.click();
////        Thread.sleep(3000);
//        WebElement currentDate =driver.findElement(By.cssSelector("input[placeholder='Effect From']"));
//        String productCurrentDate = currentDate.getText();
//        System.out.println("productCurrentDate:"+productCurrentDate);
//        EmployerAdditionalStorage.storeData("EffectFrom",productCurrentDate);
//
//
//        if (currentDate.isSelected() && currentDate.isEnabled()) {
//            currentDate.click();
//            fromDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
//            System.out.println("✅ 'Today' button clicked. Using current date for Effect From: " + fromDate);
//        } else {
//
//            System.out.println("⚠️ 'Today' button not clickable. Using random date for Effect From: ");
//        }

        //  Thread.sleep(1000); // Optional: let UI settle

        String toDate = RandomDateGenerator.generateRandomFutureExpiryDate();
        to.sendKeys(toDate);

//        EmployerAdditionalStorage.storeData("EffectFrom", fromDate);
        EmployerAdditionalStorage.storeData("EffectTo", toDate);

//        System.out.println("✅ Dates Entered: " + fromDate + " → " + toDate);
        //   } catch (Exception e) {
        //     handleException("Enter Effect Dates", e);
        //}
    }

    @Then("[Additional Details] The user enables {string} and Four Line Printing")
    public void additionalDetailsTheUserEnablesAndFourLinePrinting(String pinMailerOption) throws InterruptedException {
        // MasterAdminAdditionalDetailsPage.get_Pin_Mailer().click();
        try {
            if (pinMailerOption.equalsIgnoreCase("Yes")) {
                WebElement pinCheckbox = MasterAdminAdditionalDetailsPage.get_Pin_Mailer();
                System.out.println("pinCheckbox.isSelected()" + pinCheckbox.isSelected());
                if (!pinCheckbox.isSelected()) {
                    pinCheckbox.click();
                    EmployerAdditionalStorage.storeData("PinMailer", "Yes");
                }
                EmployerAdditionalStorage.storeData("PinMailer", "Yes");
            } else {
                EmployerAdditionalStorage.storeData("PinMailer", "No");
            }

            WebElement flpCheckbox = MasterAdminAdditionalDetailsPage.get_Four_Line_Printing();
            if (!flpCheckbox.isSelected()) {
                flpCheckbox.click();
                System.out.println("✅ Checkbox Status: PinMailer=" + pinMailerOption + ", FLP=Yes");
            }
            EmployerAdditionalStorage.storeData("FourLinePrinting", "Yes");
//            else {
//                EmployerAdditionalStorage.storeData("FourLinePrinting", "Yes");
//            }
            //System.out.println("✅ Checkbox Status: PinMailer=" + pinMailerOption + ", FLP=Yes");
        } catch (Exception e) {
            handleException("Select Pin Mailer and FLP", e);
        }
        Thread.sleep(5000);
    }

    @Then("[Additional Details] The user clicks on the AddEdit Additional Details button")
    public void additionalDetailsTheUserClicksOnTheAddEditAdditionalDetailsButton() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerLocator));
        //MasterAdminAdditionalDetailsPage.get_Add_Edit_Additional_Details_Button().click();
        try {
            WebElement addEditAdditionalDetailsbutton = MasterAdminAdditionalDetailsPage.get_Add_Edit_Additional_Details_Button();
            addEditAdditionalDetailsbutton.click();
            if (addEditAdditionalDetailsbutton.isDisplayed() && addEditAdditionalDetailsbutton.isEnabled()) {
                addEditAdditionalDetailsbutton.click();
                System.out.println("✅ Clicked on Add/Edit Additional Details button.");
            } else {
                System.out.println("⚠️ Button is not clickable.");
            }
        } catch (Exception e) {
            handleException("❌ Failed to click Add/Edit Additional Details button", e);
        }
    }

    @Then("[Additional Details Modal] The user selects the Company Type {string}")
    public void additionalDetailsModalTheUserSelectsTheCompanyType(String companyType) {
        try {
            WebElement companyTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Company_Type()));

            companyTypeDropdown.sendKeys(companyType + Keys.ENTER);

            // 💾 Store value using EmployerAdditionalStorage
            EmployerAdditionalStorage.storeData("CompanyType", companyType);

            System.out.println("✅ Selected and stored Company Type: " + companyType);
        } catch (Exception e) {
            System.err.println("❌ Failed to select Company Type: " + e.getMessage());
            Assert.fail("Could not select Company Type: " + companyType);
        }
    }

    @Then("[Additional Details Modal] The user selects the Sales Agent {string}")
    public void additionalDetailsModalTheUserSelectsTheSalesAgent(String salesAgent) {
        try {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Sales_Agent()));
            dropdown.sendKeys(salesAgent + Keys.ENTER);

            // Wait and select the option (assuming dropdown opens and has visible text matching the argument)
//            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='" + salesAgent + "']")));
//            option.click();

            EmployerAdditionalStorage.storeData("SalesAgent", salesAgent);
            System.out.println("✅ Selected Sales Agent: " + salesAgent);

        } catch (Exception e) {
            System.out.println("❌ Failed to select Sales Agent: " + salesAgent);
            e.printStackTrace();
        }
    }

    @Then("[Additional Details Modal] The user enables Cashback")
    public void additionalDetailsModalTheUserEnablesCashback() {
        try {

            WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Enable_Cashback)));

            if (!checkbox.isSelected()) {
                checkbox.click();
            }

            EmployerAdditionalStorage.storeData("Cashback", "Yes");
            System.out.println("✅ Cashback checkbox enabled.");

        } catch (Exception e) {
            System.out.println("❌ Failed to enable Cashback checkbox.");
            e.printStackTrace();
        }
    }

    @Then("[Additional Details Modal] The user enters Cashback Amount {string}")
    public void additionalDetailsModalTheUserEntersCashbackAmount(String cashBackAmount) {

        try {
            WebElement amountField = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Cash_Back_Amount()));

            //amountField.clear();
            amountField.sendKeys(cashBackAmount);

            EmployerAdditionalStorage.storeData("CashbackAmount", cashBackAmount);
            System.out.println("✅ Entered Cashback Amount: " + cashBackAmount);
        } catch (Exception e) {
            System.out.println("❌ Failed to enter Cashback Amount.");
            e.printStackTrace();
        }
    }

    @Then("[Additional Details] The user verifies that Pre-Activation is set to {string}")
    public void additionalDetailsTheUserVerifiesThatPreActivationIsSetTo(String expectedValue) {
        // MasterAdminAdditionalDetailsPage.get_Card_Per_Activation().click();
        try {
            WebElement checkbox = MasterAdminAdditionalDetailsPage.get_Card_Per_Activation();

            // Click the checkbox (optional: only if needed to toggle/check UI behavior)
            checkbox.click();

            boolean isChecked = checkbox.isSelected();
            boolean shouldBeChecked = expectedValue.equalsIgnoreCase("Yes");
            EmployerAdditionalStorage.storeData("PreActivation", isChecked ? "Yes" : "No");

            if (isChecked == shouldBeChecked) {
                System.out.println("✅ Pre-Activation checkbox is correctly set to: " + expectedValue);
            } else {
                System.out.println("❌ Pre-Activation checkbox expected to be '" + expectedValue + "' but was '" + (isChecked ? "Yes" : "No") + "'");
                Assert.fail("Mismatch in Pre-Activation checkbox state");
            }

        } catch (TimeoutException e) {
            System.out.println("❌ Timeout while waiting for Pre-Activation checkbox.");
            e.printStackTrace();
            Assert.fail("Timeout while verifying Pre-Activation checkbox");
        } catch (Exception e) {
            System.out.println("❌ Failed to verify Pre-Activation checkbox.");
            e.printStackTrace();
            Assert.fail("Exception while verifying Pre-Activation checkbox");
        }
    }

    @Then("[Additional Details] The user verifies all product and additional details")
    public void additionalDetailsTheUserVerifiesAllProductAndAdditionalDetails() {
        // ✅ PRODUCT DETAILS TABLE
        Map<String, String> productFieldMapping = new LinkedHashMap<>();
        productFieldMapping.put("Product Type", "ProductType");
        productFieldMapping.put("Effect From", "EffectFrom");
        productFieldMapping.put("Effect To", "EffectTo");
        productFieldMapping.put("Four Line Printing", "FourLinePrinting");
        productFieldMapping.put("Pin Mailer", "PinMailer");

        List<WebElement> productLabels = driver.findElements(By.cssSelector("table:nth-of-type(1) thead tr th"));
        List<WebElement> productValues = driver.findElements(By.cssSelector("tr:nth-child(2) > td"));

        assertSection("📦 Product Details", productLabels, productValues, productFieldMapping, EmployerAdditionalStorage::getData);

        // ✅ ADDITIONAL DETAILS TABLE
        Map<String, String> additionalFieldMapping = new LinkedHashMap<>();
        additionalFieldMapping.put("Company Type", "CompanyType");
        additionalFieldMapping.put("Sales Agent", "SalesAgent");
        additionalFieldMapping.put("Pre-Activation", "PreActivation");
        additionalFieldMapping.put("Cashback Amount", "CashbackAmount");

        List<WebElement> additionalLabels = driver.findElements(By.cssSelector("tbody th:nth-child(n)"));
        List<WebElement> additionalValues = driver.findElements(By.cssSelector(" tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(n)"));

        assertSection("📝 Additional Details", productLabels, productValues, additionalFieldMapping, EmployerAdditionalStorage::getData);
        assertSection("📝 Additional Details", additionalLabels, additionalValues, additionalFieldMapping, EmployerAdditionalStorage::getData);
    }

    private final Set<String> assertedOnceFields = new HashSet<>();

    private void assertSection(
            String sectionTitle,
            List<WebElement> labels,
            List<WebElement> values,
            Map<String, String> fieldMapping,
            Function<String, String> dataFetcher
    )
    {
        System.out.println("\n" + sectionTitle + ":");
        System.out.printf("%-25s | %-25s | %-25s%n", "🔹 Field", "✅ Expected", "📌 Actual");
        System.out.println("----------------------------------------------------------------------------");

        List<String> failures = new ArrayList<>();
        int maxIndex = Math.min(labels.size(), values.size());

        for (int i = 0; i < maxIndex; i++) {
            String label = labels.get(i).getText().trim();
            String actualValue = values.get(i).getText().trim();

            if (!fieldMapping.containsKey(label)) {
                System.out.println("⚠️ Skipping unrecognized field: " + label);
                continue;
            }

            // ❌ Skip assertion if field was already asserted once
            if (assertedOnceFields.contains(label)) {
                System.out.println("⚠️ Skipping repeated assertion for field: " + label);
                continue;
            }

            String expectedKey = fieldMapping.get(label);
            String expectedValue = dataFetcher.apply(expectedKey);
            expectedValue = (expectedValue == null || expectedValue.isEmpty()) ? "N/A" : expectedValue.trim();

            System.out.printf("%-25s | %-25s | %-25s%n", label, expectedValue, actualValue);

            if (!expectedValue.equalsIgnoreCase(actualValue)) {
                failures.add("❌ Mismatch for " + label + ": Expected [" + expectedValue + "], Found [" + actualValue + "]");
            }

            // ✅ Mark as asserted to prevent duplicate checks
            assertedOnceFields.add(label);
        }

        if (!failures.isEmpty()) {
            failures.forEach(System.err::println);
            Assert.fail("❌ " + sectionTitle + " verification failed.");
        }

        System.out.println("✅ " + sectionTitle + " verified successfully.");
    }
}


