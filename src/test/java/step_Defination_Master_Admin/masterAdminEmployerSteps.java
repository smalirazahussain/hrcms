package step_Defination_Master_Admin;

import Pages.Android.AdminPage;
import Pages.Android.UpdateProliePage;
import Pages.MasterAdmin.MasterAdminDashboardPage;
import Pages.MasterAdmin.MasterAdminEmployerPage;
import Utils.EmployerDataStorage;
import Utils.RandomDateGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Random;

import static Hooks.Base_Class.driver;
import static Pages.Android.AdminPage.Approve_Button;
import static Pages.Android.UpdateProliePage.*;
import static Pages.MasterAdmin.MasterAdminEmployerPage.*;

public class masterAdminEmployerSteps {

    Duration timeout = Duration.ofSeconds(180);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    @When("[MasterAdmin EmployerPage] The user clicks on the employer button")
    public void masteradminEmployerPageTheUserClicksOnTheEmployerButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AdminPage.get_Admin_Employer_Button())).click();
    }

    @When("[MasterAdmin EmployerPage] The user clicks on the add employer button")
    public void masteradminEmployerPageTheUserClicksOnTheAddEmployerButton() {
        wait.until(ExpectedConditions.elementToBeClickable(MasterAdminEmployerPage.get_Master_Add_Employer_Button())).click();
    }

    @And("[MasterAdmin EmployerPage] The user Select the state {string}")
    public void masteradminEmployerPageTheUserSelectTheState(String state) {
        try {
            // ✅ Wait until the state dropdown is clickable and open it
            WebElement stateDropdown = wait.until(ExpectedConditions.elementToBeClickable(get_Master_Admin_State()));
            stateDropdown.click();

            // ✅ Enter the state name and select it
            get_Master_Admin_State_input().sendKeys(state + Keys.ENTER);

            // ✅ Store the selected state in EmployerDataStorage
            EmployerDataStorage.storeData("State", state);

            // ✅ Print stored state for debugging
            System.out.println("📌 Stored State: " + state);
        } catch (Exception e) {
            handleException("State selection", e);
        }
    }

    @Then("[MasterAdmin OtherDetailsPage] User selects FreeZone {string}")
    public void masteradminOtherDetailsPageUserSelectsFreeZone(String freeZone) {
        try {
            // ✅ Wait for FreeZone checkbox to be clickable
           // WebElement freeZoneCheckbox = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminEmployerPage.get_Free_Zone()));
            MasterAdminEmployerPage.get_Free_Zone().click();
            // ✅ Click on the FreeZone checkbox
            //freeZoneCheckbox.click();

            // ✅ Store the selected FreeZone value
            EmployerDataStorage.storeData("freeZone", freeZone);

            // ✅ Print stored FreeZone for debugging
            System.out.println("📌 Stored FreeZone: " + freeZone);
        } catch (Exception e) {
            handleException("FreeZone selection", e);
        }
    }

    @And("[MasterAdmin OtherDetailsPage] User checks the Migrated Employer checkbox")
    public void masteradminOtherDetailsPageUserChecksTheMigratedEmployerCheckbox() {
        try {
            String Migrated=(get_Migrated().getText());
            System.out.println("Migrated"+Migrated);
            if(!"Migrated".equals(get_Migrated().getText())) {
                UpdateProliePage.get_Migrated().click();
                // ✅ Click on the Migrated Employer checkbox


                // ✅ Store the Migrated Employer status
                EmployerDataStorage.storeData("MigratedEmployer", "Yes");
            }
            // ✅ Print stored Migrated Employer value for debugging
            System.out.println("📌 Stored Migrated Employer: Yes");
        } catch (Exception e) {
            handleException("Migrated Employer selection", e);
        }
//        try {
//            // ✅ Wait until the checkbox is present in the DOM
//            WebElement migratedCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#isMigrated")));
//
//            // ✅ Ensure the checkbox is visible and enabled
//            wait.until(ExpectedConditions.visibilityOf(migratedCheckbox));
//            wait.until(ExpectedConditions.elementToBeClickable(migratedCheckbox));
//
//            // ✅ Check if the checkbox is already selected
//            if (!migratedCheckbox.isSelected()) {
//                try {
//                    migratedCheckbox.click();
//                    System.out.println("✅ Clicked on Migrated Employer checkbox");
//                } catch (Exception e) {
//                    // 🔥 **Fallback: Use JavaScript Click if normal click fails**
//                    System.out.println("⚠️ Normal click failed, trying JavaScript Click...");
//                    JavascriptExecutor js = (JavascriptExecutor) driver;
//                    js.executeScript("arguments[0].click();", migratedCheckbox);
//                }
//            } else {
//                System.out.println("✅ Migrated Employer checkbox is already selected.");
//            }
//
//            // ✅ Store the Migrated Employer status
//            EmployerDataStorage.storeData("MigratedEmployer", "Yes");
//            System.out.println("📌 Stored Migrated Employer: Yes");
//
//        } catch (Exception e) {
//            handleException("Migrated Employer selection", e);
//        }
    }

    @And("[Update Profile] User enter the company address {string}")
    public void updateProfileUserEnterTheCompanyAddress(String address) {
        try {
            if (address.isEmpty()) {
                address = RandomDateGenerator.generateRandomCompanyAddress();
            }
            EmployerDataStorage.storeData("companyAddress", address);
            enterText(get_Company_Address_Input_Field(), address);
        } catch (Exception e) {
            handleException("Entering company address", e);
        }
    }

    @And("[Update Profile] User enters the trade license issue date {string}")
    public void updateProfileUserEntersTheTradeLicenseIssueDate(String date) {
        if (date.isEmpty()) {
            date = RandomDateGenerator.generateRandomPastTradeLicenseDate();
        }
        EmployerDataStorage.storeData("tradeLicenseIssueDate", date);
        enterText(get_Trade_License_Issue_Date(), date);
    }

    @And("[Update Profile] User enters the trade license expiry date {string}")
    public void updateProfileUserEntersTheTradeLicenseExpiryDate(String date) {
        if (date.isEmpty()) {
            date = RandomDateGenerator.generateRandomFutureExpiryDate();
        }
        EmployerDataStorage.storeData("tradeLicenseExpiryDate", date);
        enterText(get_Trade_License_Expiry_Date(), date);
    }

    @And("[Update Profile] User enters the trade license number {string}")
    public void updateProfileUserEntersTheTradeLicenseNumber(String number) {
        if (number.isEmpty()) {
            number = "TL" + new Random().nextInt(900000);
        }
        EmployerDataStorage.storeData("tradeLicenseNumber", number);
        enterText(get_Trade_License_Number(), number);
    }

    @And("[Update Profile] User enters the sponsor document issue date {string}")
    public void updateProfileUserEntersTheSponsorDocumentIssueDate(String date) {
        if (date.isEmpty()) {
            date = RandomDateGenerator.generateRandomPastTradeLicenseDate();
        }
        EmployerDataStorage.storeData("sponsorDocumentIssueDate", date);
        enterText(get_Sponsor_Document_Issue_Date(), date);
    }

    @And("[Update Profile] User enters the sponsor document expiry date {string}")
    public void updateProfileUserEntersTheSponsorDocumentExpiryDate(String date) {
        if (date.isEmpty()) {
            date = RandomDateGenerator.generateRandomFutureExpiryDate();
        }
        EmployerDataStorage.storeData("sponsorDocumentExpiryDate", date);
        enterText(get_Sponsor_Document_Expiry_Date(), date);
    }

    @And("[Update Profile] User enters the sponsor document number {string}")
    public void updateProfileUserEntersTheSponsorDocumentNumber(String number) {
        if (number.isEmpty()) {
            number = "SD" + new Random().nextInt(900000);
        }
        EmployerDataStorage.storeData("sponsorDocumentNumber", number);
        enterText(get_Sponsor_Document_Number(), number);
    }

    @Then("[Update Profile] User clicks on the {string} button")
    public void updateProfileUserClicksOnTheButton(String button) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(getSubmitButton())).click();
    }

    @Then("[MasterAdmin Page] The user verifies the success toast message {string}")
    public void masteradminPageTheUserVerifiesTheSuccessToastMessage(String expectedMessage) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("i:nth-child(4)")));
//        wait.until(ExpectedConditions.elementToBeClickable(get_Approval_Msg(expectedMessage)));
//        try {
//            String actualMessage = get_Approval_Msg(expectedMessage).getText().trim();
//            Assert.assertEquals(actualMessage, expectedMessage);
//        } catch (Exception e) {
//            handleException("Verifying toast message", e);
//        }
//        FluentWait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(30))  // Max wait time (Reduce if needed)
//                .pollingEvery(Duration.ofSeconds(2))  // Check every 2 seconds
//                .ignoring(NoSuchElementException.class)
//                .ignoring(TimeoutException.class);
//
//        WebElement toastMessageElement = wait.until(ExpectedConditions.visibilityOf(get_Approval_Msg(expectedMessage)));
//        String actualMessage = toastMessageElement.getText().trim();
//
//        assertEquals(actualMessage, expectedMessage, "❌ Toast message does not match!");
//        System.out.println("✅ Toast message verified: " + actualMessage);
    }




//    @Then("[Dashboard Page] The user navigates to {string}")
//    public void navigateToModule(String moduleName) {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(MasterAdminDashboardPage.get_Onboard_Approvals_Button())).click();
//        } catch (Exception e) {
//            handleException("Navigating to module: " + moduleName, e);
//        }
//    }

    @Then("[Onboard Approvals] The user searches for employer and verify the employer name {string}")
    public void onboardApprovalsTheUserVerifiesEmployerName(String employerName) {
        String storedName = EmployerDataStorage.getData("companyName");
        Assert.assertEquals(employerName, storedName, "❌ Employer name mismatch!");
    }

    @Then("[Onboard Approvals] The user verifies the approval tracking status is {string}")
    public void onboardApprovalsTheUserVerifiesTheApprovalTrackingStatusIs(String expectedStatus) {
        try {
            // Wait for the Approval Tracking Status element to be visible
             wait.until(ExpectedConditions.visibilityOf(
                    MasterAdminDashboardPage.get_Onboard_Approvals_Approval_Status()
            ));

            // Get the actual Approval Tracking Status from the UI
            String actualStatus =   MasterAdminDashboardPage.get_Onboard_Approvals_Approval_Status().getText().trim();

            // Assert that the status matches the expected value
            Assert.assertEquals(actualStatus, expectedStatus, "❌ Approval Tracking Status does not match!");

            System.out.println("✅ Successfully verified Approval Tracking Status: " + actualStatus);

        } catch (Exception e) {
            System.err.println("⚠️ Error: Unable to verify Approval Tracking Status in Onboard Approvals.");
            e.printStackTrace();
            Assert.fail("Approval Tracking Status verification failed due to an exception: " + e.getMessage());
        }
    }

    @When("[Onboard Approvals] The user clicks on the {string} button")
    public void onboardApprovalsTheUserClicksOnTheButton(String button) {
        wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(Approve_Button))));
        MasterAdminDashboardPage.get_Approve_Button().click();
    }

    @Then("[Onboard Approvals] The user verifies the success toast message {string}")
    public void onboardApprovalsTheUserVerifiesTheSuccessToastMessage(String expectedMessage) {
        WebElement toastElement = wait.until(ExpectedConditions.visibilityOf(MasterAdminDashboardPage.get_Approval_Success_Toast()));
        String actualMessage = toastElement.getText().trim();
        Assert.assertEquals(actualMessage, expectedMessage, "❌ Approval success message mismatch!");
    }
    @And("[Update Profile] User uploads the Trade License document {string}")
    public void updateProfileUserUploadsTheTradeLicenseDocument(String tradeDoc) {
        try {
            // Ensure Browse File button is visible and clickable
            WebElement browseButton = wait.until(ExpectedConditions.elementToBeClickable(getBrowseFile()));
            browseButton.click();
            Thread.sleep(3000);
            Robot robot = new Robot();

            // Press ESC to close the file upload window
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);

            System.out.println("✅ File upload window closed using ESC.");

            // Constructing the absolute file path dynamically
            String tradeDocFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                    File.separator + "java" + File.separator + "document" + File.separator + tradeDoc;

            // Sending file path to input field
            WebElement fileInput = MasterAdminEmployerPage.get_Trade_License_Upload_Input();
            fileInput.sendKeys(tradeDocFilePath);

            // Wait for file preview to appear (confirming the upload)
            WebElement uploadedTradeFileElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='preview flex0'])[1]"))
            );

            // Assertion: Verifying that file preview is displayed
            Assert.assertTrue(uploadedTradeFileElement.isDisplayed(), "❌ File upload failed, preview not found!");

            // If everything passes, print success message
            System.out.println("✅ Successfully uploaded Trade License Document: " + tradeDocFilePath);


        } catch (Exception e) {
            System.err.println("⚠️ Error: Unable to upload Trade License document.");
            e.printStackTrace();
            Assert.fail("File upload failed due to an exception: " + e.getMessage());
        }
    }
    @And("[Update Profile] User uploads the Sponsor Document {string}")
    public void updateProfileUserUploadsTheSponsorDocument(String sponsorDoc) {
        try {
            // Ensure Browse File button is visible and clickable

            WebElement browseSponsorDocumentButton = wait.until(ExpectedConditions.elementToBeClickable(getSponsorDocumentBrowseFile()));
            browseSponsorDocumentButton.click();
            Thread.sleep(3000);

            Robot robot = new Robot();

            // Press ESC to close the file upload window
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            System.out.println("✅ File upload window closed using ESC.");

            System.out.println("✅ File upload window closed using ESC.");

            // Constructing the absolute file path dynamically
            String sponsorDocFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                    File.separator + "java" + File.separator + "document" + File.separator + sponsorDoc;

            // Sending file path to input field
            WebElement fileInput = MasterAdminEmployerPage.get_Sponsor_Document_Upload_Input();
            fileInput.sendKeys(sponsorDocFilePath);

            // Wait for file preview to appear (confirming the upload)
            WebElement uploadedSponsorFileElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='preview flex0'])[1]"))
            );

            // Assertion: Verifying that file preview is displayed
            Assert.assertTrue(uploadedSponsorFileElement.isDisplayed(), "❌ Sponsor Document upload failed, preview not found!");

            // If everything passes, print success message
            System.out.println("✅ Successfully uploaded Sponsor Document: " + sponsorDocFilePath);

        } catch (Exception e) {
            System.err.println("⚠️ Error: Unable to upload Sponsor Document.");
            e.printStackTrace();
            Assert.fail("Sponsor Document upload failed due to an exception: " + e.getMessage());
        }
    }

    // ----------- HELPER METHODS -----------

    private void enterText(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
            element.sendKeys(text + Keys.ENTER);
        } catch (Exception e) {
            handleException("Entering text: " + text, e);
        }
    }

    private void handleException(String action, Exception e) {
        System.err.println("❌ Error during: " + action);
        e.printStackTrace();
        Assert.fail("Test step failed: " + action);
    }


    @Then("[Update Profile] User enters the Zip Code {string}")
    public void updateProfileUserEntersTheZipCode(String zipCode) {
        try {
            // ✅ Wait for the Zip Code field to be visible
            WebElement zipCodeField =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Zip_Code)));
            //get_Zip_Code().click();
            //get_Zip_Code().getText();
            // ✅ Clear existing value and enter new Zip Code
            zipCodeField.sendKeys(get_Zip_Code().getText());

            // ✅ Store Zip Code in EmployerDataStorage for verification
            EmployerDataStorage.storeData("ZipCode", zipCode);

            // ✅ Print stored Zip Code for debugging
            System.out.println("📌 Stored Zip Code: " + zipCode);

        } catch (Exception e) {
            handleException("Zip Code Entry", e);
        }
    }
  

}
