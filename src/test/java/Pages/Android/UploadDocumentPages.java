package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Hooks.Base_Class.driver;


public class UploadDocumentPages {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);


    //locator
    public static String Add_New_Emplyer = "button[title='Add Employee'] span:nth-child(1)";
    public static String Edit_Button = "//button[@id='uploadExcel']";
    public static String  Document_Name(String document) {return "//div[contains(text(),'"+document+"')]";}
    public static String Document = "//div[@name=\"documentTitle0\"]";
    public static String Brows_Document = "uploadExcel";
    public static String Upload_Document = "button[title='Update Employee']";

    public static WebElement get_Edit_Button() {
        return Base_Class.driver.findElement(By.xpath(Edit_Button));
    }
    public static WebElement get_Document_Name(String document) {
        return Base_Class.driver.findElement(By.xpath(Document_Name(document)));
    }
    public static WebElement get_document(){
        return Base_Class.driver.findElement(By.xpath(Document));
    }
    public static WebElement get_Brows_Document(){
        return Base_Class.driver.findElement(By.id(Brows_Document));
    }
    public static WebElement get_Upload_Document(){
        return Base_Class.driver.findElement(By.cssSelector(Upload_Document));
    }

}

