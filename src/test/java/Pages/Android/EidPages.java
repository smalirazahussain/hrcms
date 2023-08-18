package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class EidPages {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    public static String Update_Eid_Button = "button[title='Update EID']";
    public static String Eid_Expire_Date = "eidExpiry";
    public static String Update_Button = "button[title='Update']";
    public static String Eid_Popup_Msg(String msg) {
        return "//span[normalize-space()="+msg+"]";
    }
    public static String Emirates_Id = "eid";
    private static String nthChildIndex;
    public static String Two_Image_Button = "label.ant-radio-button-wrapper:nth-child(2)";
    public static WebElement get_Update_Eid_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Update_Eid_Button));
    }


    public static WebElement get_Eid_Expire_Date() {
        return Base_Class.driver.findElement(By.id(Eid_Expire_Date));
    }

    public static WebElement get_Update_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Update_Button));
    }

    public static WebElement get_Eid_Popup_Msg(String msg) {
        return Base_Class.driver.findElement(By.xpath(Eid_Popup_Msg(msg)));
    }


    public static WebElement get_Emirates_Id() {

        return Base_Class.driver.findElement(By.id(Emirates_Id));
    }

    public static WebElement get_Two_Image_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Two_Image_Button));
    }
}




