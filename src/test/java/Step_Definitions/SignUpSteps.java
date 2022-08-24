package Step_Definitions;

import Pages.Android.LoginPage;
import Pages.Android.SignUpPage;
import Tests.Scroll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import static Hooks.Base_Class.driver;
import static Pages.Android.SignUpPage.*;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class SignUpSteps {

    public WebDriverWait wait = new WebDriverWait(driver, 30);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    @Given("[Sign Up] User tap on Sign up button")
    public void signUpUserTapOnSignUpButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpUserTapOnSignUpButton)));
        SignUpPage.signUpUserTapOnSignUpButton().click();

    }

    @When("[Sign Up] User enter the name {string}")
    public void signUpUserEnterTheName(String company_name) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(signUpUserEnterTheName)));
        SignUpPage.signUpUserEnterTheName().sendKeys(company_name);
        Thread.sleep(5000);

    }

    @Then("[Sign Up] User enter the email {string}")
    public void signUpUserEnterTheEmail(String email) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpUserEnterTheEmail)));
        SignUpPage.signUpUserEnterTheEmail().sendKeys(email);
        Thread.sleep(5000);

    }

    @And("[Sign Up] User tap the drop down button")
    public void signUpUserTapTheDropDownButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpUserTapTheDropDownButton)));
        SignUpPage.signUpUserTapTheDropDownButton().click();

    }

    @Then("[Sign Up] Enter the Company code \"{int}'")
    public void signUpEnterTheCompanyCode(int country_code) {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(signUpEnterTheCompanyCode)));
        String cc = String.valueOf(country_code);
        SignUpPage.signUpEnterTheCompanyCode().sendKeys(cc);

    }

    @Then("[Sign Up] User enter the phone no {string}")
    public void signUpUserEnterThePhoneNo(String phone_no) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(signUpUserEnterThePhoneNo)));
        SignUpPage.signUpUserEnterThePhoneNo().sendKeys(phone_no);

    }

}


