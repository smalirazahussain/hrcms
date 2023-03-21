package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfilePage {

    private WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, 30);

    public static String Profile_Button = "li:nth-child(10) > a:nth-child(1)";

    public static WebElement get_Profile_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Profile_Button));
    }
}
