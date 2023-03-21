package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.OtherCompaniesPage;
import Pages.Android.UpdateProliePage;
import Tests.Scroll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.print.attribute.standard.MediaSize;

import static Hooks.Base_Class.driver;
import static Pages.Android.UpdateProliePage.*;
import static Tests.Current_Date.currentYear;

public class OtherCompaniesSteps {

    public WebDriverWait wait = new WebDriverWait(driver, 30);
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
        driver.findElement(By.xpath("div[title='Dubai'] div[class='ant-select-item-option-content']"));
    }
}

