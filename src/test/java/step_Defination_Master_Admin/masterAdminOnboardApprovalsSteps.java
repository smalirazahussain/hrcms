package step_Defination_Master_Admin;

import Pages.Android.AdminPage;
import Pages.MasterAdmin.MasterAdminDashboardPage;
import Utils.EmployerDataStorage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Pages.Android.AdminPage.*;

public class masterAdminOnboardApprovalsSteps {
    Duration timeout = Duration.ofSeconds(60);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    @Then("[Onboard Approvals] The user searches for employer and verify the employer name in the onboard approvals table   {string}")
    public void onboardApprovalsTheUserSearchesForEmployerAndVerifyTheEmployerNameInTheOnboardApprovalsTable(String arg0) {
        try {
            // Retrieve the expected employer name from EmployerDataStorage
            String expectedEmployerName = EmployerDataStorage.getData("EmployerName");

            // Validate if the employer name exists in storage
            if (expectedEmployerName == null || expectedEmployerName.isEmpty()) {
                throw new IllegalArgumentException("❌ Employer name not found in EmployerDataStorage.");
            }
            // Wait for the employer name element in the Onboard Approvals table
                wait.until(ExpectedConditions.visibilityOf(
                    MasterAdminDashboardPage.get_Onboard_Approvals_Employer_Name()
            ));
            // Get the actual employer name from the UI
            String actualEmployerName = MasterAdminDashboardPage.get_Onboard_Approvals_Employer_Name().getText().trim();
            // Assert that the employer name matches the stored value
            Assert.assertEquals(actualEmployerName, expectedEmployerName, "❌ Employer name does not match!");

            System.out.println("✅ Successfully verified employer name in Onboard Approvals: " + actualEmployerName);

        } catch (Exception e) {
            System.err.println("⚠️ Error: Unable to verify employer name in Onboard Approvals table.");
            e.printStackTrace();
            Assert.fail("Employer name verification failed due to an exception: " + e.getMessage());
        }
    }

    @Then("[Onboard Approvals] The user confirms the approval action")
    public void onboardApprovalsTheUserConfirmsTheApprovalAction() {
       // try {
            // Wait and click "Approve" button
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Edit_Employer_Approve_Button)));
            AdminPage.get_Edit_Employer_Approve_Button().click();
            System.out.println("✅ Clicked on Approve button.");

            // Wait and click "OK" in confirmation modal
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Approval_Ok)));
            AdminPage.get_Approval_Ok().click();
            System.out.println("✅ Clicked on OK to confirm approval.");

        //} catch (Exception e) {
          //  System.err.println("❌ Approval flow failed.");
            //e.printStackTrace();
          //  Assert.fail("Approval process interrupted: " + e.getMessage());
        //}
    }
}
