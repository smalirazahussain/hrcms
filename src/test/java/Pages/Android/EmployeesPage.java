package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EmployeesPage {

    private WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, 30);

    //locator
    public static String employees = "(//li[@class='side-menu-list-item']//child::a)[3]";
    public static String Upload_Excel = "uploadExcel";

    public static WebElement get_Employees(){
        return Base_Class.driver.findElement(By.xpath(employees));
    }
    public static WebElement get_Upload_Excel(){
        return Base_Class.driver.findElement(By.id(Upload_Excel));
    }
}
