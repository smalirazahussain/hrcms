package Pages.HeadOfficePages;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ManageEmployeesHeadOfficePage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    public static String Manage_Employees_Button = "//a[@id='manageEmployees']";
    public static String Manage_Branch = "(//input[@type='search'])[1]";

    public static WebElement get_Manage_Employees_Button() {

        return Base_Class.driver.findElement(By.xpath(Manage_Employees_Button));
    }

    public static WebElement get_Manage_Branch() {

        return Base_Class.driver.findElement(By.xpath(Manage_Branch));
    }
}
