package Pages.HeadOfficePages;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class EstablishmentsHeadOfficePage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    //locator
    public static String Establishments_Button = "#establishment";
    public static String Establishment_Branch_Name = "(//input[@aria-haspopup=\"listbox\"])[1]";
    public static String Branch_Establishment_Id = "tbody tr[class='ant-table-row ant-table-row-level-0'] td:nth-child(1) div:nth-child(1)";
    public static WebElement get_Establishments_Button() {

        return Base_Class.driver.findElement(By.cssSelector(Establishments_Button));
    }


    public static WebElement get_Establishment_Branch_Name() {
        return Base_Class.driver.findElement(By.xpath(Establishment_Branch_Name));
    }

    public static WebElement get_Branch_Establishment_Id() {
        return Base_Class.driver.findElement(By.cssSelector(Branch_Establishment_Id));
    }
}
