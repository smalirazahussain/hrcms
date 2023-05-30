package Step_Definitions_Head_Ofiice;

import Pages.Android.AdminPage;
import Pages.Android.RequestPage;
import Pages.HeadOfficePages.DashBoardHeadOfficePage;
import Pages.HeadOfficePages.OnBoardApprovalHeadOfficePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Pages.Android.AdminPage.Approval_Ok;
import static Pages.HeadOfficePages.OnBoardApprovalHeadOfficePage.Onboard_Approval;
import static Pages.HeadOfficePages.OnBoardApprovalHeadOfficePage.Phone_No;
import static Step_Definitions_Head_Ofiice.BrachesStepsHeadOffice.phno;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class OnBoardApprovalStepsHeadOffice {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    @Then("[OnBoard Approval Head Office Page] User tap onboard approval")
    public void onboardApprovalHeadOfficePageUserTapOnboardApproval() {
        OnBoardApprovalHeadOfficePage.get_Onboard_Approval().click();
        OnBoardApprovalHeadOfficePage.get_Onboard_Approval().click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id(Onboard_Approval))).click().perform();
    }

    @And("[OnBoard Approval Head Office Page] User tap on view button")
    public void onboardApprovalHeadOfficePageUserTapOnViewButton() throws InterruptedException {
       // OnBoardApprovalHeadOfficePage.get_View().click();
        RequestPage.get_View().click();
        if (phno==OnBoardApprovalHeadOfficePage.get_Phone_No().getText())
            AdminPage.get_Approve_Button().click();
            //        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Approval_Ok)));
        AdminPage.get_Approve_Button().click();
        Thread.sleep(5000);
        AdminPage.get_Approval_Ok().getText();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(Approval_Ok)));
       // AdminPage.get_Approval_Ok().click();
        Thread.sleep(5000);
        System.out.println(Phone_No);

    }

}

