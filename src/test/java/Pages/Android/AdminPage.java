package Pages.Android;

import Hooks.Base_Class;
import org.codehaus.jackson.map.MapperConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import static Pages.Android.SubAdminPages.Email;


public class AdminPage {

    private WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, 30);

    //locator
    public static String admin_Tab = "//div[@class='body-container scroll-y']";
    public static String Login = "button[title='Login']";
    public static String Admin_Email = "#email";
    public static String Admin_Password = "#password";
    public static String Onboard_Approvals = "#onboardApprovals";
    //public static String Approve_Button = "div[role='dialog'] button[title='Approve']";
    public static String Approve_Button ="//div[contains(@class,'btn-group')]//span[contains(text(),'Approve')]";
    public static String Establishmentid = "ul:nth-child(1) li:nth-child(2) span:nth-child(2)";
    public static String View = "(//button[contains(@title,'View')])[1]";
    public static String company_Name = "//body//div//ul[2]";
    public static String Trade_No = "//body//div//ul[2]";
    public static String Approval_Ok = "(//span[normalize-space()='OK'])";
    public static String Client_Approval = "#approval";
    public static String Company_Client = "(//input[@id=\"client\"])[2]";
    public static String Action_Successfully = "div[class='ant-message'] span:nth-child(2)";


    public static WebElement get_Admin_Tab(){
        return Base_Class.driver.findElement(By.xpath(admin_Tab));
    }

    public static WebElement get_Login() {
        return Base_Class.driver.findElement(By.cssSelector(Login));
    }



    public static WebElement get_Email() {

        return Base_Class.driver.findElement(By.cssSelector(Admin_Email));
    }

    public static WebElement get_Password() {
        return Base_Class.driver.findElement(By.cssSelector(Admin_Password));
    }

    public static WebElement get_Onboard_Approvals() {
        return Base_Class.driver.findElement(By.cssSelector(Onboard_Approvals));
    }

    public static WebElement get_Approve_Button() {
        return Base_Class.driver.findElement(By.xpath(Approve_Button));
    }
    public static WebElement get_Establishmentid() {
        return Base_Class.driver.findElement(By.cssSelector(Establishmentid));
    }

    public static WebElement get_View() {

        return Base_Class.driver.findElement(By.xpath(View));
    }

    public static WebElement get_company_Name() {
        return Base_Class.driver.findElement(By.xpath(company_Name));
    }

    public static WebElement get_Trade_No() {
        return Base_Class.driver.findElement(By.xpath(Trade_No));
    }

    public static WebElement get_Sponsor_No() {
        String Sponsor_No = "/html/body/div[2]/div/div[3]/div/div/div[2]/div[1]/ul[1]/li[17]";
        return Base_Class.driver.findElement(By.xpath(Sponsor_No));
    }

    public static WebElement get_Approval_Ok() {

        return Base_Class.driver.findElement(By.xpath(Approval_Ok));
    }

    public static WebElement get_Client_Approval() {
        return Base_Class.driver.findElement(By.cssSelector(Client_Approval));
    }

    public static WebElement get_Company_Client() {
        return Base_Class.driver.findElement(By.xpath(Company_Client));
    }

    public static WebElement get_Action_Successfully() {
        return Base_Class.driver.findElement(By.cssSelector(Action_Successfully));
    }
}
