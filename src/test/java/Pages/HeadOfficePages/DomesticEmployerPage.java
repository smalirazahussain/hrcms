package Pages.HeadOfficePages;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class DomesticEmployerPage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    public static String Domestic_Employer_Button ="domesticEmployer";
    public static String Domestic_Employer_Add_Button = "button:nth-child(1) span:nth-child(2)";
    public static String Domestic_Employer_Add_Notification = "//span[contains(text(),'On Board request has been sent for further approva')]";
    public static String Domestic_Establishment_Id = "ul:nth-child(1) > li:nth-child(3) > span:nth-child(2)";
    public static WebElement get_Domestic_Employer_Button() {

        return Base_Class.driver.findElement(By.id(Domestic_Employer_Button));
    }

    public static WebElement get_Domestic_Employer_Add_Button() {

        return Base_Class.driver.findElement(By.cssSelector(Domestic_Employer_Add_Button));
    }

    public static WebElement get_Domestic_Employer_Add_Notification() {
        return Base_Class.driver.findElement(By.xpath(Domestic_Employer_Add_Notification));
    }

    public static WebElement get_Domestic_Establishment_Id() {
        return Base_Class.driver.findElement(By.cssSelector(Domestic_Establishment_Id));
    }

    //locator

}
