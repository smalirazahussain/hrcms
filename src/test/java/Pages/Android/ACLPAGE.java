package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ACLPAGE {

    public ACLPAGE(){
        String admin_Tab = "//div[@class='body-container scroll-y']";
    }
    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    public static String Deselect_Check_Box = "input[type='checkbox']:checked";
    public static List<WebElement> get_Deselect_Check_Box() {
        return Base_Class.driver.findElements(By.cssSelector(Deselect_Check_Box));
    }

    //locator

}
