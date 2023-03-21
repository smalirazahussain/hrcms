package Step_Definitions;

import Pages.Android.LinkEstablishmentIdPage;
import Pages.Android.LoginPage;
import Pages.Android.UpdateProliePage;
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
import static Pages.Android.LinkEstablishmentIdPage.Est_Notification_Message;
import static Pages.Android.LoginPage.Enter_Email_Id;
import static Pages.Android.LoginPage.Enter_Password;
import static Pages.Android.UpdateProliePage.Approval_Msg;
import static Tests.Current_Date.currentYear;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class LinkEstablishmentIdSteps {

    public WebDriverWait wait = new WebDriverWait(driver, 30);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    @And("[Link EstablishmentID Page] User tap on add Establishment button")
    public void linkEstablishmentIDPageUserTapOnAddEstablishmentButton() {
        LinkEstablishmentIdPage.get_Add_Estblishment_Button().click();
    }

    @And("[Link EstablishmentID Page] User enter the expire year {int}")
    public void linkEstablishmentIDPageUserEnterTheExpireYear(int expyear) {
        LinkEstablishmentIdPage.getEstExpireDate().click();
        String year = currentYear();
        int year1 = Integer.parseInt(year);
        year1 = expyear - year1;

        for(int i=0; i<year1; i++) {
            UpdateProliePage.getExpYearArrow().click();

        }

    }

    @Then("[Link EstablishmentID Page] User verify the notification message {string}")
    public void linkEstablishmentIDPageUserVerifyTheNotificationMessage(String expect) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Est_Notification_Message)));
        String actual =LinkEstablishmentIdPage.get_Est_Notification_Message().getText();
        Assert.assertEquals(actual,expect);
    }
}

