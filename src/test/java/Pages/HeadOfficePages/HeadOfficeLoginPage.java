package Pages.HeadOfficePages;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HeadOfficeLoginPage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    //locator
    public static String create_Account_Button = "//*[@text='Create account']";



    //return function
    public static String Head_office_Email = "email";
    public static String Head_office_Password = "password";
    public static String Head_office_Login_Button = "button:nth-child(1) span:nth-child(2)";
    public static String Log_Out_Button = "//a[@class=\"side-menu-footer-text side-menu-footer-link\"]";
    public static String User_Role(String role) {
        return "//div[@title='"+role+"']";
    }
    public static String User_Select_Role = "span.ant-select-selection-item";

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

    public static WebElement get_Log_Out_Button() {
        return Base_Class.driver.findElement(By.xpath(Log_Out_Button));
    }

    public static WebElement get_User_Role(String role) {
        return Base_Class.driver.findElement(By.xpath(User_Role(role)));
    }

    public static WebElement get_User_Select_Role() {
        return Base_Class.driver.findElement(By.cssSelector(User_Select_Role));
    }
}
