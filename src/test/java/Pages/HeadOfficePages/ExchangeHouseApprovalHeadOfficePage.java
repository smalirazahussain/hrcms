package Pages.HeadOfficePages;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ExchangeHouseApprovalHeadOfficePage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    public static String Exchange_House_Approval_Button = "#approval";
    public static WebElement get_Exchange_House_Approval_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Exchange_House_Approval_Button));
    }

    //locator

}
