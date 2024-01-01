package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Pages.Android.AdminPage.View;


public class RequestPage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);


    public static String Request = "/requests";
    public static String Mol_Num = "(//span[.='MOL Number'])[1]//following-sibling::*";
    public static String Passport_No = "(//span[.=\"Passport Number\"])[1]//following-sibling::*";
    public static String Est_id = "li:nth-child(28) > span:nth-child(2)";
    public static String Admin_Est_id ="li:nth-child(23) > span:nth-child(2)";
    public static String Pending_Badge = ".ant-tag.ant-tag-success.activeTag";
    public static String Est_Id(String establishmentNo) {
        return "//span[text()='"+establishmentNo+"']";
    }
    private static String Approval_Types(String description) {
        return "//div[normalize-space()='"+description+"']";
    }
    public static String Loading ="div[class='ant-spin ant-spin-lg ant-spin-spinning']";


    public static WebElement get_Request() {

        return Base_Class.driver.findElement(By.id(Request));

    }

    public static WebElement get_View() {
        return Base_Class.driver.findElement(By.cssSelector(View));
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

    public static WebElement get_Pending_Badge() {
        return Base_Class.driver.findElement(By.cssSelector(Pending_Badge));
    }

    public static WebElement get_Est_Id(String establishmentNo) {
        return Base_Class.driver.findElement(By.xpath(Est_Id(establishmentNo)));
    }


    public static WebElement get_Approval_Types(String description) {
        return Base_Class.driver.findElement(By.xpath(Approval_Types(description)));
    }


    public static WebElement get_Loading() {

        return Base_Class.driver.findElement(By.cssSelector(Loading));
    }
}
