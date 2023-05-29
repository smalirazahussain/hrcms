package Pages.Android;

import Hooks.Base_Class;
import io.cucumber.java8.Bs;
import org.codehaus.jackson.map.MapperConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.BitSet;

import static Hooks.Base_Class.driver;


public class SubAdminPages {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //locator
    public static String Sub_Admin_Button = "#user";
    public static String Add_Admin_BUtton= "//button[@title='Add Team Member']";
    public static String Name = "#name";
    public static String Email = "#email";
    public static String Password = "#password";
    public static String Phone = "#phone";
    public static String Role = "span[title='Select Role']";
    public static String Role_Select(String role){
        return "div[title='"+role+"']";
    }
    public static String Manage_Access(String role){
        return "input[value='"+role+"']";
    }
    public static String Add_Sub_Admin = "button[title='Add Team Member'][type='submit']";
    public static String Submit = "div[class='ant-row ant-form-item mb-0'] span:nth-child(2)";
    public static String Error_Email(String error){
        return "//div[normalize-space()='"+error+"']";
    }


    public static WebElement get_Sub_Admin_Button(){
        return Base_Class.driver.findElement(By.cssSelector(Sub_Admin_Button));
    }
    public static WebElement get_Add_Admin_Button(){
        return Base_Class.driver.findElement(By.xpath(Add_Admin_BUtton));
    }
    public static WebElement get_Name(){
        return Base_Class.driver.findElement(By.cssSelector(Name));
    }
    public static WebElement get_Email(){
        return Base_Class.driver.findElement(By.cssSelector(Email));
    }
    public static WebElement get_Password(){
        return Base_Class.driver.findElement(By.cssSelector(Password));
    }
    public static WebElement get_Phone(){
        return Base_Class.driver.findElement(By.cssSelector(Phone));
    }
    public static WebElement get_Role(){
        return Base_Class.driver.findElement(By.cssSelector(Role));
    }
    public static WebElement get_Role_Select(String role){
        return Base_Class.driver.findElement(By.cssSelector(Role_Select(role)));
    }
    public static WebElement get_Add_Sub_Admin(){
        return Base_Class.driver.findElement(By.cssSelector(Add_Sub_Admin));
    }
    public static WebElement get_Manage_Access(String role){
        return Base_Class.driver.findElement(By.cssSelector(Manage_Access(role)));
    }
    public static WebElement get_Submit(){
        return Base_Class.driver.findElement(By.cssSelector(Submit));
    }

    public static WebElement get_Error_Email(String error) {
        return Base_Class.driver.findElement(By.xpath(Error_Email(error)));
    }
}