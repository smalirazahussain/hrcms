package Pages.Android;

import Hooks.Base_Class;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Hooks.Base_Class.driver;


public class LoginPage {

    private WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, 30);

    //locator
    public static String create_Account_Button = "//*[@text='Create account']";
    public static String Enter_Email_Id = "userId";
    public static String Enter_Password = "input[placeholder=\"Password\"]";
    public static String Login_Button = "button[title='Login']";
    public static String Update_ProFile = "div[class='navbar-left'] h1";
    public static String Error_Message_In_Email = ".error";
    public static String Error_Message_In_Password = ".error";
    public static String Eye_Button = "img[alt='icon']";
    //public static String .ant-input-suffix img

    public LoginPage() {
    }

    //return function

    public static WebElement get_create_Account_Button() {
        return Base_Class.driver.findElement(By.xpath(create_Account_Button));
    }

    public static WebElement get_Enter_Email_Id() {
        return Base_Class.driver.findElement(By.name(Enter_Email_Id));
    }

    public static WebElement get_Enter_Password() {
        return Base_Class.driver.findElement(By.cssSelector(Enter_Password));
    }

    public static WebElement get_Login_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Login_Button));
    }

    public static WebElement get_Update_ProFile() {
        return Base_Class.driver.findElement(By.cssSelector(Update_ProFile));
    }

    public static WebElement get_Error_Message_In_Email() {
        return Base_Class.driver.findElement(By.cssSelector(Error_Message_In_Email));
    }

    public static WebElement get_Error_Message_In_Password() {
        return Base_Class.driver.findElement(By.cssSelector(Error_Message_In_Password));
    }

    public static WebElement get_Eye_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Eye_Button));
    }

}
