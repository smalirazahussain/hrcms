package Step_Definitions_Head_Ofiice;

import Pages.Android.AddEmployerPages;
import Pages.HeadOfficePages.DashBoardHeadOfficePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class DashBoardStepsHeadOffice {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    @Then("[Dashboard Head Office Page] User verify to toast message to {string}")
    public void dashboardHeadOfficePageUserVerifyToToastMessageTo(String toastmessage) {
        DashBoardHeadOfficePage.get_Toast_Message(toastmessage).getText();
    }
    public static String exchangeHouseTittle;
    @And("[Dashboard Head Office Page] User tap on the branches button")
    public void dashboardHeadOfficePageUserTapOnTheBranchesButton() {
        exchangeHouseTittle = AddEmployerPages.get_Company_Tittle().getText();
        DashBoardHeadOfficePage.get_Branches_Button().click();
    }

    @Then("[Dashboard Head Office Page] User tap on employers onboard button")
    public void dashboardHeadOfficePageUserTapOnEmployersOnboardButton() {
        DashBoardHeadOfficePage.get_Employers_Onboard_Button().click();
    }
}


