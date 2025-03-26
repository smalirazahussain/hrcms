package step_Defination_Master_Admin;

import Pages.MasterAdmin.MasterAdminDashboardPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;

public class masterAdminDashboardSteps {
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();



    @Then("[Dashboard Page] The user navigates to {string}")
    public void navigateToModule(String moduleName) {
        try {
               wait.until(ExpectedConditions.elementToBeClickable(
                    MasterAdminDashboardPage.get_Onboard_Approvals_Button()));

            MasterAdminDashboardPage.get_Onboard_Approvals_Button().click();
            System.out.println("✅ Successfully navigated to: " + moduleName);
        } catch (Exception e) {
            System.err.println("❌ Error: Unable to navigate to '" + moduleName + "'. Retrying...");

            try {
                Thread.sleep(2000); // Adding a short delay before retrying
                wait.until(ExpectedConditions.elementToBeClickable(
                        MasterAdminDashboardPage.get_Onboard_Approvals_Button()));

                MasterAdminDashboardPage.get_Onboard_Approvals_Button().click();
                System.out.println("✅ Retried and successfully navigated to: " + moduleName);
            } catch (Exception retryException) {
                System.err.println("❌ Retried but still failed to navigate to '" + moduleName + "'.");
                retryException.printStackTrace();
                Assert.fail("Navigation to " + moduleName + " failed after retry due to: " + retryException.getMessage());
            }
        }
    }

}
