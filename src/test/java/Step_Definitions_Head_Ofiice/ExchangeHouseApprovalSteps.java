package Step_Definitions_Head_Ofiice;

import Pages.Android.AdminPage;
import Pages.HeadOfficePages.ExchangeHouseApprovalHeadOfficePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import static Hooks.Base_Class.wait;
import static Pages.Android.AdminPage.Enter_Branch_Name;
import static Step_Definitions_Head_Ofiice.BrachesStepsHeadOffice.branch;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class ExchangeHouseApprovalSteps {

//    Duration timeout = Duration.ofSeconds(30);
//    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();




    @And("[ExchangeHouse Approval Page] User tap on the exchange house approval button")
    public void exchangehouseApprovalPageUserTapOnTheExchangeHouseApprovalButton() {
        ExchangeHouseApprovalHeadOfficePage.get_Exchange_House_Approval_Button().click();
    }

    @Then("[ExchangeHouse Approval Page] User select the branch")
    public void exchangehouseApprovalPageUserSelectTheBranch() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Enter_Branch_Name)));
        AdminPage.get_Enter_Branch_Name().sendKeys(branch+ Keys.ENTER);
    }
}

