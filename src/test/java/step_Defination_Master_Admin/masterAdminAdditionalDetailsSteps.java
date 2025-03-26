package step_Defination_Master_Admin;

import Pages.MasterAdmin.MasterAdminAdditionalDetailsPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static org.apache.commons.exec.util.DebugUtils.handleException;

public class masterAdminAdditionalDetailsSteps {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();
    @Then("[Additional Details] The user navigates to the {string} tab")
    public void additionalDetailsTheUserNavigatesToTheTab(String arg0) {
        try {
            WebElement additionalDetailsTab = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Additional_DetailsTab()));
            additionalDetailsTab.click();
            System.out.println("✅ Navigated to Additional Details tab");
        } catch (Exception e) {
            handleException("Navigating to Additional Details tab", e);
        }
    }


    @Then("[Additional Details] The user click to the Add\\/Edit Onboarding Source button")
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
}

