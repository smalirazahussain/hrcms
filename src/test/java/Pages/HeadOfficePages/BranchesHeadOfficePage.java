package Pages.HeadOfficePages;

import Hooks.Base_Class;
import org.codehaus.jackson.map.MapperConfig;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Pages.Android.AddEmployerPages.Branch_Name;


public class BranchesHeadOfficePage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    //locator
    public static String create_Account_Button = "//*[@text='Create account']";
    public static String Add_Button = "div[class='d-flex gap-20 w-100 justify-end'] button:nth-child(1) span:nth-child(2)";
    public static String Branch = "companyName";
    public static String Branch_Location = "location";
    public static String Branch_Email = "email";
    public static String Branch_Password = "password";
    public static String Branch_Confirm_Password = "confirmPassword";
    public static String Branch_Phone_No = "input[placeholder='Phone Number']";
    public static String Add_Branch_Button = "button[title='Add Branch'][type='submit']";
    public static String Toast_message = "//span[contains(text(),'Branch has been created and has been sent for further approval.')]";


    //return function

    public static WebElement get_create_Account_Button() {
        return Base_Class.driver.findElement(By.xpath(create_Account_Button));
    }


    public static WebElement get_Add_Branch() {

        return Base_Class.driver.findElement(By.cssSelector(Add_Button));
    }

    public static WebElement get_Branch_Name() {
        return Base_Class.driver.findElement(By.id(Branch));
    }

    public static WebElement get_Branch_Location() {

        return Base_Class.driver.findElement(By.id(Branch_Location));
    }

    public static WebElement get_Branch_Email() {
        return Base_Class.driver.findElement(By.id(Branch_Email));
    }

    public static WebElement get_Branch_Password() {
        return Base_Class.driver.findElement(By.id(Branch_Password));
    }

    public static WebElement get_Branch_Confirm_Password() {
        return Base_Class.driver.findElement(By.id(Branch_Confirm_Password));
    }

    public static WebElement get_Branch_Phone_No() {
        return Base_Class.driver.findElement(By.cssSelector(Branch_Phone_No));
    }

    public static WebElement get_Add_Branch_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Add_Branch_Button));
    }

    public static WebElement get_Toast_message() {
        return Base_Class.driver.findElement(By.xpath(Toast_message));
    }
}
