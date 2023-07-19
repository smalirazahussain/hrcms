package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProcessSalariesDepositSlipPages {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    public static String Process_Salaries_Deposit_Slip ="processSalaries";
    public static String Company_Name = "#establishmentId";
    public static String Download_Button = "//div//button[@title='Download Salary Template']";
    public static String Salary_Date = "salaryFileDate";
    public static String Salary_Browse_File = "//div[contains(@class,'flex0 w-40')]//span[contains(text(),'Browse File')]";
    public static String Salary_Submit_Button = "div:nth-child(7) > button:nth-child(1)";
    public static String Cross_Button = ".ant-modal-close-x";
    public static String Salary_Amount = "//div[@class='ant-modal-body']//span[1]//span[1]";

    public static WebElement get_Process_Salaries_Deposit_Slip() {

        return Base_Class.driver.findElement(By.id(Process_Salaries_Deposit_Slip));
    }

    public static WebElement get_Company_Name() {
        return Base_Class.driver.findElement(By.cssSelector(Company_Name));
    }
    public static WebElement get_Download_Button() {

        return Base_Class.driver.findElement(By.xpath(Download_Button));
    }

    public static WebElement get_Salary_Date() {
        return Base_Class.driver.findElement(By.id(Salary_Date));
    }

    public static WebElement get_Salary_Browse_File() {
        return Base_Class.driver.findElement(By.xpath(Salary_Browse_File));
    }

    public static WebElement get_Salary_Submit_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Salary_Submit_Button));
    }

    public static WebElement get_Cross_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Cross_Button));
    }

    public static WebElement get_Salary_Amount() {
        return Base_Class.driver.findElement(By.xpath(Salary_Amount));
    }

    //locator

}