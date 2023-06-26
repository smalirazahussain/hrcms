package Step_Definitions_Head_Ofiice;

import Pages.HeadOfficePages.ManageEmployeesHeadOfficePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Step_Definitions_Head_Ofiice.BrachesStepsHeadOffice.branch;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class ManageEmployeesStepsHeadOffice {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();




    @Then("[Exchange House Manage Employees Page] User tap on Manage employees button")
    public void exchangeHouseManageEmployeesPageUserTapOnManageEmployeesButton() throws InterruptedException {
        ManageEmployeesHeadOfficePage.get_Manage_Employees_Button().click();
        Thread.sleep(5000);
        ManageEmployeesHeadOfficePage.get_Manage_Branch().sendKeys(branch+ Keys.ENTER);

    }
}


