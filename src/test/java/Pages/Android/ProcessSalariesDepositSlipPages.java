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

    public static WebElement get_Process_Salaries_Deposit_Slip() {

        return Base_Class.driver.findElement(By.id(Process_Salaries_Deposit_Slip));
    }

    public static WebElement get_Company_Name() {
        return Base_Class.driver.findElement(By.cssSelector(Company_Name));
    }
    public static WebElement get_Download_Button() {

        return Base_Class.driver.findElement(By.xpath(Download_Button));
    }

        //locator

}