package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class EmployeesPage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //locator
    public static String employees = "#employee";
    public static String Upload_Excel = "uploadExcel";
    public static String Template_Button = "button[title='Template'] span:nth-child(1)";
    public static String Employee_Search = "ant-input";
    public static String Add_Employer_Button = "button[title='Add Employee']";
    public static String Employee_Eye_Button = "//div[@class='inner-data no-wrap']//*[name()='svg']";


    public static WebElement get_Employees() {

        return Base_Class.driver.findElement(By.cssSelector(employees));
    }
    public static WebElement get_Upload_Excel() {
        return Base_Class.driver.findElement(By.id(Upload_Excel));
    }

    public static WebElement get_Template_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Template_Button));
    }

    public static WebElement get_Employee_Search() {

        return Base_Class.driver.findElement(By.className(Employee_Search));
    }
    public static WebElement get_Add_Emplyer_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Add_Employer_Button));
    }

    public static WebElement get_Employee_Eye_Button() {
        return Base_Class.driver.findElement(By.xpath(Employee_Eye_Button));
    }
}
