package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Hooks.Base_Class.driver;


public class ProfilePage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    public static String Profile_Button = "li:nth-child(10) > a:nth-child(1)";

    public static WebElement get_Profile_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Profile_Button));
    }
}
