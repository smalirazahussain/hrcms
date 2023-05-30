package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Hooks.Base_Class.driver;


public class EmployeesPage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //locator
    public static String employees = "(//li[@class='side-menu-list-item']//child::a)[3]";
    public static String Upload_Excel = "uploadExcel";
    public static String Template_Button = "button[title='Template'] span:nth-child(1)";

    public static WebElement get_Employees() {
        return Base_Class.driver.findElement(By.xpath(employees));
    }
    public static WebElement get_Upload_Excel() {
        return Base_Class.driver.findElement(By.id(Upload_Excel));
    }

    public static WebElement get_Template_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Template_Button));
    }
}
