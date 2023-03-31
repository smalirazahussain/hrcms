package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.AdminPage;
import Pages.Android.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.Th;
import org.bouncycastle.jcajce.provider.symmetric.Threefish;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static Hooks.Base_Class.driver;
import static Pages.Android.AdminPage.*;
import static Pages.Android.LoginPage.Enter_Password;
import static Pages.Android.UpdateProliePage.*;
import static Step_Definitions.AddEmployerSteps.companyName;
import static Tests.Current_Date.currentMonth;

public class adminsteps {

    public WebDriverWait wait = new WebDriverWait(driver, 30);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    @Then("[Admin Page] Open the admin tab {string}")
    public void adminPageOpenTheAdminTab(String admintabURL) throws AWTException, InterruptedException, MalformedURLException {

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(admin_Tab)));
        //AdminPage.get_Admin_Tab().click();
        driver.navigate().to(admintabURL);
        Thread.sleep(10000);

/*        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_T);
        driver.navigate().to(admintabURL);

        Thread.sleep(4000);

          /*  String currentURL  = driver.getCurrentUrl();
            driver.navigate().to();
            Thread.sleep(10000);

       /* //System.setProperty("webdriver.chrome.whitelistedIps", "");
        URL url = new URL("http://10.40.5.43:49653");
        driver.navigate().to(url);

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        driver.get(admintabURL);

        Thread.sleep(3000);

       */
    }

    @And("[Update Profile] User enter the month of joining  {string}")
    public void updateProfileUserEnterTheMonthOfJoining(String expmonth) throws InterruptedException {
        String current_month = currentMonth();

        if (current_month == expmonth) {
            Thread.sleep(100);
        } else {
            get_month_select(current_month).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(user_month(expmonth))));
            get_user_month(expmonth).click();
        }
    }

    @And("[Admin Page] User tap on login page")
    public void adminPageUserTapOnLoginPage() throws InterruptedException {
        Thread.sleep(10000);
        AdminPage.get_Login().click();
    }

    @Then("[Admin Page] User enter the  email {string}")
    public void adminPageUserEnterTheEmail(String email) {
        AdminPage.get_Email().sendKeys(email);
    }

    @When("[Admin Page] User enter the Password {string}")
    public void adminPageUserEnterThePassword(String paswword) {
        AdminPage.get_Password().sendKeys(paswword);
    }

    @When("[Admin Page] User tap on onboard Approvals")
    public void adminPageUserTapOnOnboardApprovals() {
        AdminPage.get_Onboard_Approvals().click();
    }

    @And("[Admin Page] User tap on view button")
    public void adminPageUserTapOnViewButton() {
        AdminPage.get_View().click();
    }

    @When("[Admin Page] User tap on client Approvals")
    public void adminPageUserTapOnClientApprovals() {
        AdminPage.get_Client_Approval().click();
    }

    @Then("[Admin Page] User enter the company name")
    public void adminPageUserEnterTheCompanyName() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Company_Client)));
        AdminPage.get_Company_Client().sendKeys(companyName+Keys.ENTER);
        Thread.sleep(5000);

    }

    @Then("[Admin Page] User enter the company name {string}")
    public void adminPageUserEnterTheCompanyName(String arg) throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Company_Client)));
        //AdminPage.get_Company_Client().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Company_Client)));
        AdminPage.get_Company_Client().sendKeys(company_Name+Keys.ENTER);
    }

    @Then("[Admin Page] User validate the toast message {string}")
    public void adminPageUserValidateTheToastMessage(String actual) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Action_Successfully)));
        String expect = AdminPage.get_Action_Successfully().getText();
        Assert.assertEquals(actual,expect);
    }


}


