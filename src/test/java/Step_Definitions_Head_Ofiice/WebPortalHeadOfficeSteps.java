package Step_Definitions_Head_Ofiice;

import Pages.HeadOfficePages.WebPortalHeadOfficePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Pages.HeadOfficePages.WebPortalHeadOfficePage.Web_Company_Name;
import static Pages.HeadOfficePages.WebPortalHeadOfficePage.get_Select_Product;
import static Step_Definitions_Head_Ofiice.BrachesStepsHeadOffice.branch;
import static Step_Definitions_Head_Ofiice.DashBoardStepsHeadOffice.exchangeHouseTittle;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class WebPortalHeadOfficeSteps {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    @Then("[Web Portal Page] User enter the user name {string}")
    public void webPortalPageUserEnterTheUserName(String userName) {
        WebPortalHeadOfficePage.get_Web_User_Name().sendKeys(userName);

    }

    @Then("[Web Portal Page] User enter the Password {string}")
    public void webPortalPageUserEnterThePassword(String userPassword) {
        WebPortalHeadOfficePage.get_Web_User_Password().sendKeys(userPassword);

    }

    @When("[Web Portal Page] User tap on the side manu {string}")
    public void webPortalPageUserTapOnTheSideManu(String manu) throws InterruptedException {
        Thread.sleep(3000);
        WebPortalHeadOfficePage.get_Side_Manu(manu).click();

    }

    @When("[Web Portal Page] User enter the branch name {string}")
    public void webPortalPageUserEnterTheBranchName(String args) throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Web_Company_Name)));
        WebPortalHeadOfficePage.get_Web_Company_Name().sendKeys(branch+ Keys.ENTER);
    }

    @Then("[Web Portal Page] User tap edit button")
    public void webPortalPageUserTapEditButton() throws InterruptedException {
        Thread.sleep(3000);
        WebPortalHeadOfficePage.get_Web_Edit_Button().click();
    }

    @When("[Web Portal Page] User tap on the employer product")
    public void webPortalPageUserTapOnTheEmployerProduct() throws InterruptedException {
         WebPortalHeadOfficePage.get_Employer_Product().click();
    }

    @Then("[Web Portal Page] User select the product {string}")
    public void webPortalPageUserSelectTheProduct(String company) throws InterruptedException {

        Thread.sleep(1000);
        WebPortalHeadOfficePage.get_Select_Product_Type().sendKeys(Keys.ENTER);
        //WebPortalHeadOfficePage.get_Select_Product_Type().click();
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript("arguments[0].click();", Select_Product_Type);
        //executor.executeScript(Select_Product_Type,).;
        //get_Select_Product_Type().submit();
        //Select select = new Select(get_Select_Product_Type().findElement(By.xpath(Select_Product_Type)));
        //select.selectByVisibleText(exchangeHouseTittle);
        //get_Select_Product_Type().click();
        //Actions actions = new Actions(driver);
        //actions.moveToElement(get_Select_Product_Type()).click().perform();
        //get_Select_Product(company).click();
        get_Select_Product(exchangeHouseTittle).click();
        Thread.sleep(5000);
    }

    @Then("[Web Portal Page] User tap on the login button")
    public void webPortalPageUserTapOnTheLoginButton() {
        WebPortalHeadOfficePage.get_Web_Login_Button().click();
    }

    @Then("[Web Portal Page] User select the effective from date {string}")
    public void webPortalPageUserSelectTheEffectiveFromDate(String date) throws InterruptedException {
        WebPortalHeadOfficePage.get_Effective_From_Date().sendKeys(date+Keys.ENTER);
        Thread.sleep(4000);
    }

    @Then("[Web Portal Page] User select the effective to date {string}")
    public void webPortalPageUserSelectTheEffectiveToDate(String date) throws InterruptedException {
        WebPortalHeadOfficePage.get_Effective_To_Date().sendKeys(date+Keys.ENTER);
        Thread.sleep(4000);



    }

    @Then("[Web Portal Page] User tap on add button")
    public void webPortalPageUserTapOnAddButton() {
        WebPortalHeadOfficePage.get_Web_Add_Button().click();
    }

    @Then("[Web Portal Page] User tap on Update employer button")
    public void webPortalPageUserTapOnUpdateEmployerButton() throws InterruptedException {
        Thread.sleep(3000);
        WebPortalHeadOfficePage.get_Employer_Button(wait).click();
        Thread.sleep(3000);
        WebPortalHeadOfficePage.get_Yes_Button(wait).click();
    }
}