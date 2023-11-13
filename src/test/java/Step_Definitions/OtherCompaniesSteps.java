package Step_Definitions;

import Pages.Android.OtherCompaniesPage;
import Pages.Android.UpdateProliePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;

public class OtherCompaniesSteps {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    @Then("[Other Company] User tap on my other companies")
    public void otherCompanyUserTapOnMyOtherCompanies() {
        OtherCompaniesPage.get_Other_Companies().click();
    }


    @Given("[Add Employer] user tap on Add other company button")
    public void addEmployerUserTapOnAddOtherCompanyButton() {
        OtherCompaniesPage.get_Add_Other_Company().click();
    }

    @Then("[Other Company] User tap on State on other company")
    public void otherCompanyUserTapOnStateOnOtherCompany() throws InterruptedException {
        UpdateProliePage.getState().click();
        Thread.sleep(5000);
        //driver.findElement(By.xpath("div[title='Dubai'] div[class='ant-select-item-option-content']"));
    }
}

