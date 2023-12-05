package Step_Definitions_Head_Ofiice;

import Pages.Android.AdminPage;
import Pages.HeadOfficePages.DomesticEmployerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.wait;

public class DomesticEmployersteps {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    //public WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    @And("[Exchange House Domestic Employer Page] User tap on the domestic employer page")
    public void exchangeHouseDomesticEmployerPageUserTapOnTheDomesticEmployerPage() throws InterruptedException {
        DomesticEmployerPage.get_Domestic_Employer_Button().click();
        Thread.sleep(5000);
    }

    @Then("[Exchange House Domestic Employer Page] User tap on the domestic employer add button")
    public void exchangeHouseDomesticEmployerPageUserTapOnTheDomesticEmployerAddButton() {
        DomesticEmployerPage.get_Domestic_Employer_Add_Button().click();
    }

    @And("[Exchange House Domestic Employer Page] User verify the notification message {string}")
    public void exchangeHouseDomesticEmployerPageUserVerifyTheNotificationMessage(String msg) {
        DomesticEmployerPage.get_Domestic_Employer_Add_Notification().getText();
    }
    public static String domesticEstablishmentId;
    @And("[Exchange House Domestic Employer Page] User tap on view button and approve by exchange house")
    public void exchangeHouseDomesticEmployerPageUserTapOnViewButtonAndApproveByExchangeHouse() throws InterruptedException {
        By spinnerLocator = By.cssSelector(".ant-spin.ant-spin-spinning.css-qgg3xn");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerLocator));
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(View)));
        AdminPage.get_View().click();
        domesticEstablishmentId = DomesticEmployerPage.get_Domestic_Establishment_Id().getText();
        System.out.println("Domestic Establishment Id;"+domesticEstablishmentId);
        AdminPage.get_Approve_Button().click();
        Thread.sleep(5000);
        AdminPage.get_Approval_Ok().click();
    }
}



