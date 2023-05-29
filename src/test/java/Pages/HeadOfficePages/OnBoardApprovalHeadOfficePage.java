package Pages.HeadOfficePages;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

import static Hooks.Base_Class.driver;


public class OnBoardApprovalHeadOfficePage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    //locator
    public static String create_Account_Button = "//*[@text='Create account']";
    public static String Onboard_Approval = "onBoardApprovals";
    public static String Phone_No = "ul:nth-child(3) > li:nth-child(7) > span:nth-child(2)";


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
}

