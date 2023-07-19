package Step_Definitions;

import Pages.Android.SignUpPage;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Credentials;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import static Hooks.Base_Class.driver;
import static Pages.Android.SignUpPage.*;
import static Pages.Android.UpdateProliePage.*;
import static Tests.Current_Date.currentMonth;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class SignUpSteps {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    public static Credentials getCredentials() throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("D:\\Hrcms\\src\\json\\credential.json")) {
            return gson.fromJson(reader, Credentials.class);
        }
    }

    @Given("[Sign Up] User tap on Sign up button")
    public void signUpUserTapOnSignUpButton() throws InterruptedException {
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpUserTapOnSignUpButton)));
        SignUpPage.signUpUserTapOnSignUpButton().click();


    }
    public static int randomInt;
    public static String companyName;
    @When("[Sign Up] User enter the name {string}")
    public String signUpUserEnterTheName(String company_name) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(signUpUserEnterTheName)));
        Random randomGenerator = new Random();
         randomInt = randomGenerator.nextInt(10000);
        SignUpPage.signUpUserEnterTheName().sendKeys(company_name + randomInt);
        String abc = company_name + randomInt;
        companyName = company_name + randomInt;
        return abc;
        }



    @Then("[Sign Up] User enter the email {string}")
    public void signUpUserEnterTheEmail(String email) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpUserEnterTheEmail)));
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);
        SignUpPage.signUpUserEnterTheEmail().sendKeys(email+randomInt+"@mailinator.com");
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
    }


    @Then("[Sign Up] User enter the phone no {string}")
    public void signUpUserEnterThePhoneNo(String phone_no) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signUpUserEnterThePhoneNo)));
        Random randomGenerator = new Random();
        int randomno = randomGenerator.nextInt(999999999);
        System.out.println(randomno);
        SignUpPage.signUpUserEnterThePhoneNo().click();
        SignUpPage.signUpUserEnterThePhoneNo().sendKeys(String.valueOf(randomno));

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
        Assert.assertEquals(companynameerror, "Please enter Company name");
    }

    @Then("[Sign Up]  Validate the email error message {string}")
    public void signUpValidateTheEmailErrorMessage(String emailerror) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpUserEnterTheEmail)));
        SignUpPage.signUpUserEnterTheEmail().isDisplayed();
        Assert.assertEquals(emailerror, "Please enter your Email.");
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
        Assert.assertEquals(useralreadyexist, "Email Already Exist");

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
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(0);
        // r(keyPress(KeyEvent.VK_ENTER));
    }

    @And("[Sign Up] Validate the phone no error message {string}")
    public void signUpValidateThePhoneNoErrorMessage(String phoneerror) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(phoneOnErrorMessage)));
        SignUpPage.phoneOnErrorMessage().isDisplayed();
        Assert.assertEquals(phoneerror, "Please enter Phone Number");
    }

    @And("[Sign Up] Validate the password error message{string}")
    public void signUpValidateThePasswordErrorMessage(String passworderror) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passwordErrorMessage)));
        SignUpPage.passwordErrorMessage().isDisplayed();
        Assert.assertEquals(passworderror, "Password is required");


    }

    @And("[Sign Up] Validate the confirm password error message{string}")
    public void signUpValidateTheConfirmPasswordErrorMessage(String confirmerror) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(confirmPasswordErrorMessage)));
        SignUpPage.confirmPasswordErrorMessage().isDisplayed();
        Assert.assertEquals(confirmerror, "Confirm Password is required");
        //Assert.


    }

    @Then("[Sign Up] User enter the otp code {string}")
    public void signUpUserEnterTheOtpCode(String oc) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(otpCode)));
        SignUpPage.otpCode().sendKeys(oc);


    }

    @And("[Sign Up] User tap on verify button")
    public void signUpUderTapOnVerfiyButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(verifyButton)));
        SignUpPage.verifyButton().click();
    }

    @When("[Sign up] Enter the user name email id {string} and {string}")
    public void signUpEnterTheUserNameEmailIdAnd(String companyname, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(signUpUserEnterTheName)));
       // SignUpPage.signUpUserEnterTheName().sendKeys(companyname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpUserEnterTheEmail)));
        Random randomGeneratorname = new Random();
        int randomIntname = randomGeneratorname.nextInt(100);
        SignUpPage.signUpUserEnterTheName().sendKeys(companyname+randomIntname);
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        SignUpPage.signUpUserEnterTheEmail().sendKeys(email+randomInt+"@mailinator.com");
    }

    @Then("[Update Profile] User enter the expire month {string}")
    public void updateProfileUserEnterTheExpireMonth(String expmonth) throws InterruptedException {
        String current_month = currentMonth();

        if (current_month == expmonth) {

        }

        else {
            get_month_select(current_month).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(user_month(expmonth))));
            get_user_month(expmonth).click();
        }
    }


    public static void main(int[] ints) {
        for (int xCount =980; xCount < 987; xCount++) {
            System.out.println(Math.random()*13);

        }
    }


}
