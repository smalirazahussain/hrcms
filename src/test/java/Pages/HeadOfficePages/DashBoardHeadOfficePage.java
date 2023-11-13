package Pages.HeadOfficePages;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DashBoardHeadOfficePage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    //locator
    public static String create_Account_Button = "//*[@text='Create account']";

    //return function
    public static String Head_office_Email = "email";
    public static String Head_office_Password = "password";
    public static String Head_office_Login_Button = "button:nth-child(1) span:nth-child(2)";
    public static String Branches_Button = "//a[@id='branches']";
    public static String Employers_Onboard_Button = "#employer";

    public static String toast_message(String message) {
        return "";
    }

    public static WebElement get_create_Account_Button() {
        return Base_Class.driver.findElement(By.xpath(create_Account_Button));
    }



    public static WebElement get_Head_office_Email() {

        return Base_Class.driver.findElement(By.id(Head_office_Email));
    }

    public static WebElement get_Head_office_Password() {
        return Base_Class.driver.findElement(By.id(Head_office_Password));
    }

    public static WebElement get_Head_office_Login_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Head_office_Login_Button));
    }

    public static WebElement get_Toast_Message(String message) {
        return Base_Class.driver.findElement(By.xpath(toast_message(message)));
    }

    public static WebElement get_Branches_Button() {
        return Base_Class.driver.findElement(By.xpath(Branches_Button));
    }

    public static WebElement get_Employers_Onboard_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Employers_Onboard_Button));
    }
}
