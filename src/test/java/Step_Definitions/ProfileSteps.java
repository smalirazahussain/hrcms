package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.LoginPage;
import Pages.Android.ProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Pages.Android.LoginPage.Enter_Email_Id;
import static Pages.Android.LoginPage.Enter_Password;
import static Step_Definitions.AddEmployerSteps.companyName;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class ProfileSteps {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();



    @Then("[Profile Page] User tap oon the profile button")
    public void profilePageUserTapOonTheProfileButton() {
        String companyTittle = AddEmployerPages.get_Company_Tittle().getText();
        //AddEmployerPages.get_Establishment_Id().sendKeys(companyTittle+ Keys.ENTER);
        companyName = companyTittle;
        System.out.println(companyName);
        ProfilePage.get_Profile_Button().click();
    }
}

