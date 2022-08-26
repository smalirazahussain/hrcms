package Step_Definitions;

import Pages.Android.LoginPage;
import Pages.Android.SignUpPage;
import Tests.Scroll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ro.Si;
import io.cucumber.java8.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;

import static Hooks.Base_Class.driver;
import static Pages.Android.SignUpPage.*;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class SignUpSteps {

    public WebDriverWait wait = new WebDriverWait(driver, 30);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    @Given("[Sign Up] User tap on Sign up button")
    public void signUpUserTapOnSignUpButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpUserTapOnSignUpButton)));
        SignUpPage.signUpUserTapOnSignUpButton().click();
        Thread.sleep(4000);

    }

    @When("[Sign Up] User enter the name {string}")
    public void signUpUserEnterTheName(String company_name) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(signUpUserEnterTheName)));
        SignUpPage.signUpUserEnterTheName().sendKeys(company_name);


    }

    @Then("[Sign Up] User enter the email {string}")
    public void signUpUserEnterTheEmail(String email) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpUserEnterTheEmail)));
        SignUpPage.signUpUserEnterTheEmail().sendKeys(email);

    }

    @And("[Sign Up] User tap the drop down button")
    public void signUpUserTapTheDropDownButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signUpUserTapTheDropDownButton)));
        SignUpPage.signUpUserTapTheDropDownButton().click();
        Thread.sleep(4000);

    }

    @Then("[Sign Up] Enter the Company code \"{int}")
    public void signUpEnterTheCompanyCode(int country_code) throws InterruptedException {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(signUpEnterTheCompanyCode)));
        String cc = String.valueOf(country_code);
        SignUpPage.signUpEnterTheCompanyCode().sendKeys(cc);
        SignUpPage.signUpEnterTheCompanyCode().click();
        Thread.sleep(4000);
    }



    @Then("[Sign Up] User enter the phone no {string}")
    public void signUpUserEnterThePhoneNo(String phone_no) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signUpUserEnterThePhoneNo)));
        SignUpPage.signUpUserEnterThePhoneNo().click();
        SignUpPage.signUpUserEnterThePhoneNo().sendKeys(phone_no);
        Thread.sleep(4000);

    }

    @Then("[Sign Up] User enter the confirm password {string}")
    public void signUpUserEnterTheConfirmPassword(String confirm_password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(confirmPassword)));
        SignUpPage.confirmPassword().sendKeys(confirm_password);

    }

    @Then("[Sign Up]  Validate the company name error message {string}")
    public void signUpValidateTheCompanyNameCrrorMessage(String companynameerror) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(signUpUserEnterTheName)));
        SignUpPage.signUpUserEnterTheName().isDisplayed();
        Assert.assertEquals(companynameerror,"Please enter Company name");
    }

    @Then("[Sign Up]  Validate the email error message {string}")
    public void signUpValidateTheEmailErrorMessage(String emailerror) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpUserEnterTheEmail)));
        SignUpPage.signUpUserEnterTheEmail().isDisplayed();
        Assert.assertEquals(emailerror,"Please enter your Email.");
    }

    @And("[Sign Up] User tap on Sign up button on SignUp Page")
    public void signUpUserTapOnSignUpButtonOnSignUpPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpPageSignUpButton)));
        SignUpPage.signUpPageSignUpButton().click();
    }

    @Then("[Sign Up] Validate the error message on user {string}")
    public void signUpValidateTheErrorMessageOnUser(String useralreadyexist) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(errorMessageOnUser)));
        SignUpPage.errorMessageOnUser().isDisplayed();
        Assert.assertEquals(useralreadyexist,"Email Already Exist");

    }

    @Then("[Sign Up] Enter the Company code {string}")
    public void signUpEnterTheCompanyCode(String companycode) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signUpEnterTheCompanyCode)));
        SignUpPage.signUpEnterTheCompanyCode().sendKeys(companycode);
        Thread.sleep(5000);
    }

    @And("[Sign Up] User tap on {string}")
    public void signUpUserTapOn(String phonecode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(phoneCode)));
        SignUpPage.phoneCode().click();
    }

    @Then("[Sign Up] User tap on drop down button")
    public void signUpUserTapOnDropDownButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropDownButton)));
        SignUpPage.dropDownButton().click();
    }

    @Then("[Sign Up] Enter the Country code")
    public void signUpEnterTheCompanyCode() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(countryCode)));
        SignUpPage.countryCode().click();
        SignUpPage.countryCode().sendKeys("+92");
        Thread.sleep(4000);
    }

    @Then("[Sign Up] Enter the Phone code {string}")
    public void signUpEnterThePhoneCode(String pc) throws InterruptedException, AWTException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(phoneCode)));
        SignUpPage.phoneCode().sendKeys(pc);
        Robot robot= new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
       // r(keyPress(KeyEvent.VK_ENTER));
    }
}


