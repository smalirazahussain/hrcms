package Step_Definitions;

import Pages.Android.LoginPage;
import Pages.Android.ProfilePage;
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
import static Pages.Android.LoginPage.Enter_Email_Id;
import static Pages.Android.LoginPage.Enter_Password;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class ProfileSteps {

    public WebDriverWait wait = new WebDriverWait(driver, 30);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();



    @Then("[Profile Page] User tap oon the profile button")
    public void profilePageUserTapOonTheProfileButton() {
        ProfilePage.get_Profile_Button().click();
    }
}

