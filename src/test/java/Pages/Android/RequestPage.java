package Pages.Android;

import Hooks.Base_Class;
import org.codehaus.jackson.map.MapperConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import static Pages.Android.AdminPage.View;


public class RequestPage {

    private WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, 30);

    public static String Request = "/requests";
    public static String Mol_Num = "(//span[.='MOL Number'])[1]//following-sibling::*";
    public static String Passport_No = "(//span[.=\"Passport Number\"])[1]//following-sibling::*";
    public static String Est_id = "li:nth-child(28) > span:nth-child(2)";
    public static String Admin_Est_id ="li:nth-child(23) > span:nth-child(2)";



    public static WebElement get_Request() {

        return Base_Class.driver.findElement(By.id(Request));

    }

    public static WebElement get_View() {
        return Base_Class.driver.findElement(By.xpath(View));
    }

    public static WebElement get_Mol_Num() {

        return Base_Class.driver.findElement(By.xpath(Mol_Num));
    }

    public static WebElement get_Passport_No() {

        return Base_Class.driver.findElement(By.xpath(Passport_No));
    }

    public static WebElement get_Est_id() {
        return Base_Class.driver.findElement(By.cssSelector(Est_id));
    }

    public static WebElement get_Admin_Est_id() {
        return Base_Class.driver.findElement(By.cssSelector(Admin_Est_id));
    }
}
