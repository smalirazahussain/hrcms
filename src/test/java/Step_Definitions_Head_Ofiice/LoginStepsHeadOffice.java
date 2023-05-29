package Step_Definitions_Head_Ofiice;

import Pages.Android.LoginPage;
import Pages.HeadOfficePages.HeadOfficeLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.Instant;

import static Hooks.Base_Class.driver;
import static Pages.Android.LoginPage.Enter_Email_Id;
import static Pages.Android.LoginPage.Enter_Password;
import static Pages.HeadOfficePages.HeadOfficeLoginPage.Head_office_Email;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class LoginStepsHeadOffice {

//    Duration timeout = Duration.ofSeconds(30);
//    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    @Given("[Login Head Office Page] User enter the URL {string}")
    public void loginHeadOfficePageUserEnterTheURL(String headOfficeURL) throws InterruptedException {
        driver.navigate().to(headOfficeURL);
    }

    @When("[Login Head Office Page] User enter email id {string}")
    public void loginHeadOfficePageUserEnterEmailId(String email) {
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Head_office_Email)));
        HeadOfficeLoginPage.get_Head_office_Email().sendKeys(email);
    }


    @Then("[Login Head Office Page] User enter the Password {string}")
    public void loginHeadOfficePageUserEnterThePassword(String password) {
        HeadOfficeLoginPage.get_Head_office_Password().sendKeys(password);
    }

    @And("[Login Head Office Page] User tap on the login button")
    public void loginHeadOfficePageUserTapOnTheLoginButton() throws InterruptedException {

        HeadOfficeLoginPage.get_Head_office_Login_Button().click();
        Thread.sleep(5000);
    }
}

