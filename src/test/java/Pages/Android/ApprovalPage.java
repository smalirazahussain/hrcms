package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ApprovalPage {

    private WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, 30);

    //locator

    public static String Approval = "a[href='/approval']";
    public static String Accept = "//*[@class='bold-text primary-back']";


    public static WebElement get_Approval(){
        return Base_Class.driver.findElement(By.cssSelector(Approval));
    }
    public static List <WebElement> get_accept(){
        return Base_Class.driver.findElements(By.xpath(Accept));
    }

    public static WebElement get_approve_index(int is_index){
        return Base_Class.driver.findElement(By.cssSelector("(button[title='Approve'])["+is_index+"]"));
    }
}


