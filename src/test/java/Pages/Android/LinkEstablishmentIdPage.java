package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Pages.Android.AddEmployerPages.Notification_Message;


public class LinkEstablishmentIdPage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    public static String Add_Estblishment_Button = "addTradeLicense";
    public static String EstExpireDate = "expiryDate0";
    public static String Est_Notification_Message = "//span[normalize-space()='Approval is processed for further actions']";
    public static String Est_Already_Submitted = "//span[contains(text(),'You already submitted for approval. Please be pati')]";
    public static WebElement get_Add_Estblishment_Button() {
        return Base_Class.driver.findElement(By.id(Add_Estblishment_Button));

    }


    public static WebElement getEstExpireDate() {
        return Base_Class.driver.findElement(By.id(EstExpireDate));
    }

    public static WebElement get_Est_Notification_Message() {
        return Base_Class.driver.findElement(By.xpath(Est_Notification_Message));
    }

    public static WebElement get_Est_Already_Submitted() {
        return Base_Class.driver.findElement(By.xpath(Est_Already_Submitted));
    }
}
