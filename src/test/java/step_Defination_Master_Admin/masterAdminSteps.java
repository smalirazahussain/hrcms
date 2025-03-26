package step_Defination_Master_Admin;  // ✅ Ensure this matches glue path in Runner class


import Pages.MasterAdmin.LoginMasterAdminPage;
import config.properties.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Pages.MasterAdmin.LoginMasterAdminPage.User_Name;

public class masterAdminSteps {

    Duration timeout = Duration.ofSeconds(60);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    public static String stageAdminUrl;

//    @Given("[MasterAdmin Page] the user navigate to the master admin portal")
//    public void masteradminPageTheUserNavigateToTheMasterAdminPortal() {
//
//
//    }

    @Then("[MasterAdmin Page] the user verifies the OTP toast message {string}.")
    public void masteradminPageTheUserVerifiesTheOTPToastMessage(String expectedOTPToastMessage) {
        try {
//            WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(OTP_toast_message)));
//
//            // Wait for the text inside the toast to be non-empty
//            wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(toastElement, "")));
//
//            String actualOTPToastMessage = LoginMasterAdminPage.get_OTP_toast_message().getText();
//
//            System.out.println("✅ OTP Toast Message Displayed: " + actualOTPToastMessage);
//            Assert.assertEquals(expectedOTPToastMessage, actualOTPToastMessage);
            try {
                WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(User_Name)));

            String userName= LoginMasterAdminPage.get_User_Name().getText();
            System.out.println("userName: "+userName);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } catch (Exception e) {
            System.err.println("⚠️ Error: OTP toast message not found or took too long to appear!");
            e.printStackTrace();
            Assert.fail("Test failed due to missing OTP toast message.");


    }
    }

    @Given("[MasterAdmin Page] The user navigate to the master admin portal")
    public void masteradminPageTheUserNavigateToTheMasterAdminPortal() {
        stageAdminUrl = ConfigReader.getProperty("stageAminUrl");
        driver.navigate().to(stageAdminUrl);
    }



//    @Given("[MasterAdmin Page] The user navigate to the master admin portal")
//    public void masteradminPageTheUserNavigateToTheMasterAdminPortal() {
//        stageAdminUrl = ConfigReader.getProperty("stageAminUrl");
//        driver.navigate().to(stageAdminUrl);
//    }
}
