package Step_Definitions;

import Pages.Android.LoginPage;
import Pages.Android.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static Hooks.Base_Class.driver;
import static Pages.Android.LoginPage.*;
import static Pages.Android.SignUpPage.*;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class LoginSteps {

    public WebDriverWait wait = new WebDriverWait(driver, 30);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    @Given("[Login Page] User enter the email {string}")
    public void loginPageUserEnterTheEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Enter_Email_Id)));
        LoginPage.get_Enter_Email_Id().sendKeys(email);

    }

    @When("[Login Page] User enter the password {string}")
    public void loginPageUserEnterThePassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Enter_Password)));
        LoginPage.get_Enter_Password().sendKeys(password);

    }

    @Then("[Login page] User tap on login button")
    public void loginPageUserTapOnLoginButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Login_Button)));
        LoginPage.get_Login_Button().click();
        Thread.sleep(5000);
    }

    @And("[Login page] Verified user land on upadte profile page {string}")
    public void loginPageVerfiedUserLandOnUpadteProfilePage(String profile) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Update_ProFile)));
        LoginPage.get_Update_ProFile().isDisplayed();
        Thread.sleep(5000);

    }

    @And("[Login page] Validate error message in email {string}")
    public void loginPageValidateErrorMessageInEmail(String email_error) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Error_Message_In_Email)));
        LoginPage.get_Error_Message_In_Email().isDisplayed();
    }

    @And("[Login page] Validate error message in Password {string}")
    public void loginPageValidateErrorMessageInPassword(String password_error) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Error_Message_In_Password)));
        LoginPage.get_Error_Message_In_Password().isDisplayed();
    }

    @And("[Login Page] User tap on eye button")
    public void loginPageUserTapOnEyeButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Eye_Button)));
        LoginPage.get_Eye_Button().click();
        Thread.sleep(5000);
    }

    @Then("[Login Page] User validate password is hidden {string}")
    public void loginPageUserValidatePasswordIsHidden(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Enter_Password)));
        String current_password = LoginPage.get_Enter_Password().getText();
        Assert.assertEquals(current_password,password);
    }
}


