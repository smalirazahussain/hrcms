package Pages.HeadOfficePages;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class OnBoardApprovalHeadOfficePage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    //locator
    public static String create_Account_Button = "//*[@text='Create account']";
    public static String  Onboard_Approval = "onBoardApprovals";
    public static String Phone_No = "ul:nth-child(3) > li:nth-child(7) > span:nth-child(2)";
    public static String Phone_No_admin_Side = "ul:nth-child(1) li:nth-child(6) span:nth-child(2)";
    public static String Clients_OnBoard_Button = "//label[@class=\"ant-radio-button-wrapper css-1wazalj\"]";
    public static String Head_office_Search_Branch = "(//input[@role=\"combobox\"])[2]";


    //return function

    public static WebElement get_create_Account_Button() {
        return Base_Class.driver.findElement(By.xpath(create_Account_Button));
    }

    public static WebElement get_Onboard_Approval() {
        return Base_Class.driver.findElement(By.id(Onboard_Approval));
    }

    public static WebElement get_Phone_No() {
        return Base_Class.driver.findElement(By.cssSelector(Phone_No));
    }

    public static WebElement get_Phone_No_admin_Side() {
        return Base_Class.driver.findElement(By.cssSelector(Phone_No_admin_Side));
    }

    public static WebElement get_Clients_OnBoard_Button() {
        return Base_Class.driver.findElement(By.xpath(Clients_OnBoard_Button));
    }

    public static WebElement get_Head_office_Search_Branch() {
        return Base_Class.driver.findElement(By.xpath(Head_office_Search_Branch));
    }
}

