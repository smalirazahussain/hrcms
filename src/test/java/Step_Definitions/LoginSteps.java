package Step_Definitions;

import Pages.Android.LoginPage;
import config.properties.ConfigReader;
import config.properties.user_data.SaveUserDataToJsonFile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Hooks.Base_Class.enableNetworkLogging;
import static Pages.Android.LoginPage.Enter_Email_Id;
import static Pages.Android.LoginPage.Enter_Password;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;



public class LoginSteps {
    ConfigReader configReader = new ConfigReader();
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    @Given("[Login Page] User enter the email {string}")
    public void loginPageUserEnterTheEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Enter_Email_Id)));
        // Random randomGenerator = new Random();
        // int randomInt = randomGenerator.nextInt(1000);
        // LoginPage.get_Enter_Email_Id().sendKeys(email+randomInt+"@mailinator.com");
        LoginPage.get_Enter_Email_Id().sendKeys(configReader.getProperty("stageUserName"));

        JSONObject userDataJson = SaveUserDataToJsonFile.readJsonFile();

        if (userDataJson != null && userDataJson.has("user_data")) {
            // Access individual fields from the JSON data
//            String zipCode = userDataJson.getJSONArray("user_data").getJSONObject(0).getString("zipCode");
//            String password = userDataJson.getJSONArray("user_data").getJSONObject(0).getString("password");
//            String phoneNumber = userDataJson.getJSONArray("user_data").getJSONObject(0).getString("phoneNumber");
//
//            // ... (access other fields as needed)
//
//            // Print or use the retrieved data in your step
//            System.out.println("Zip Code: " + zipCode);
//            System.out.println("Password: " + password);
//            System.out.println("Phone Number: " + phoneNumber);

            // ... (print or use other fields as needed)
        } else {
            // Handle the case where "user_data" is not found
            throw new RuntimeException("Error: 'user_data' not found in the JSON file");
        }
    }

    @When("[Login Page] User enter the password {string}")
    public void loginPageUserEnterThePassword(String password) throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Enter_Password)));
        LoginPage.get_Enter_Password().sendKeys(configReader.getProperty("stageUserPassword"));


    }

    @Then("[Login page] User tap on login button")
    public void loginPageUserTapOnLoginButton() throws InterruptedException {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Login_Button)));
        LoginPage.get_Login_Button().click();
        Thread.sleep(5000);
    }

    @And("[Login page] Verified user land on update profile page {string}")
    public void loginPageVerfiedUserLandOnUpadteProfilePage(String profile) throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Update_ProFile)));
        LoginPage.get_Update_ProFile().isDisplayed();
        Assert.assertEquals(profile, "Update Profile");
        Thread.sleep(5000);

    }

    @And("[Login page] Validate error message in email {string}")
    public void loginPageValidateErrorMessageInEmail(String email_error) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Error_Message_In_Email)));
        LoginPage.get_Error_Message_In_Email().isDisplayed();
        Assert.assertEquals(email_error, "Please enter your Email.");
    }

    @And("[Login page] Validate error message in Password {string}")
    public void loginPageValidateErrorMessageInPassword(String password_error) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Error_Message_In_Password)));
        LoginPage.get_Error_Message_In_Password().isDisplayed();
        Assert.assertEquals(password_error, "Please enter your Password.");
    }

    @And("[Login Page] User tap on eye button")
    public void loginPageUserTapOnEyeButton() throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Eye_Button)));
        LoginPage.get_Eye_Button().click();
        Thread.sleep(5000);
    }

    @Then("[Login Page] User validate password is hidden {string}")
    public void loginPageUserValidatePasswordIsHidden(String password) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Enter_Password)));
        LoginPage.get_Enter_Password().isDisplayed();
        Assert.assertEquals(password, ".........");
        //String current_password = LoginPage.get_Enter_Password().getAttribute("value");
        //Assert.assertEquals(current_password,password);
    }

    @Then("[Login Page] Validate the password {string}")
    public void loginPageValidateThePassword(String current_password) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Enter_Password)));
        LoginPage.get_Enter_Password().isDisplayed();
        Assert.assertEquals(current_password, "Password1");
        //String current_password = LoginPage.get_Enter_Password().getText();
        Thread.sleep(5000);
    }


    @Given("[Login Page] User upgrade  the email  {string}")
    public void loginPageUserUpgradeTheEmail(String id) {
        LoginPage.get_Enter_Email_Id().sendKeys(id);
    }


    public static void main(String[] num) {
        long first16 = (long) (Math.random() * 10000000000000000L);
        System.out.println(first16);
    }

    @Then("[Login page] User verify toast msg {string}")
    public void loginPageUserVerifyToastMsg(String expected_Toast_Msg) {
        enableNetworkLogging();
        String actual_Toast_Msg = LoginPage.get_Toast_Msg().getText();
        System.out.println("actual_Toast_Msg:"+actual_Toast_Msg);
        Assert.assertEquals(actual_Toast_Msg,expected_Toast_Msg);
    }
}

