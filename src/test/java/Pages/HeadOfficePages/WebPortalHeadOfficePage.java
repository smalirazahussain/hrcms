package Pages.HeadOfficePages;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WebPortalHeadOfficePage {

    public WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    //locator
    public static String Side_Manu(String manu) {
        return "//label[normalize-space()='"+manu+"']";
    }
    public static String Select_Product(String exchangeHouseTittle) {
        return "//span[normalize-space()='"+exchangeHouseTittle+"']";
    }

    public static String Web_Login_Button = "span[class='mat-button-wrapper'] h3";
    public static String Select_Product_Type = "(//mat-select[@role=\"listbox\"])[11]";
    public static String Effective_From_Date = "//*[@formcontrolname='prodEffectivefrom']";
    public static String Effective_To_Date = "//*[@formcontrolname='prodEffectiveto']";
    public static String Is_Active_Button = "label[for='mat-checkbox-4-input']";
    public static String Employer_Button = "input[value='Update Employer']";
    public static String Yes_Button = "//span[normalize-space()='Yes']";
    public static String Web_Add_Button = "input[value='Add']";
    public static String Web_User_Name = "#mat-input-0";
    public static String Web_User_Password = "#mat-input-1";
    public static String Web_Company_Name = "(//input[@aria-label='Filter cell'])[1]";
    public static String Web_Edit_Button = "//i[@class='material-icons']";
    public static String Employer_Product = "//div[contains(text(),'Add Prodcut')]";





    public static WebElement get_Web_User_Name() {
        return Base_Class.driver.findElement(By.cssSelector(Web_User_Name));

    }

    public static WebElement get_Web_User_Password() {
        return Base_Class.driver.findElement(By.cssSelector(Web_User_Password));
    }

    public static WebElement get_Side_Manu(String manu) {
        return Base_Class.driver.findElement(By.xpath(Side_Manu(manu)));
    }

    public static WebElement get_Web_Company_Name() {
        return Base_Class.driver.findElement(By.xpath(Web_Company_Name));
    }

    public static WebElement get_Web_Edit_Button() {
        return Base_Class.driver.findElement(By.xpath(Web_Edit_Button));
    }

    public static WebElement get_Employer_Product() {
        return Base_Class.driver.findElement(By.xpath(Employer_Product));
    }

    public static WebElement get_Select_Product(String exchangeHouseTittle) {
        return Base_Class.driver.findElement(By.xpath(Select_Product(exchangeHouseTittle)));
    }


    public static WebElement get_Web_Login_Button() {

        return Base_Class.driver.findElement(By.cssSelector(Web_Login_Button));
    }

    public static WebElement get_Select_Product_Type() {
        return Base_Class.driver.findElement(By.xpath(Select_Product_Type));
    }

    public static WebElement get_Effective_From_Date() {
        return Base_Class.driver.findElement(By.xpath(Effective_From_Date));
    }

    public static WebElement get_Effective_To_Date() {
        return Base_Class.driver.findElement(By.xpath(Effective_To_Date));
    }

    public static WebElement get_Is_Active_Button() {

        return Base_Class.driver.findElement(By.cssSelector(Is_Active_Button));
    }

    public static WebElement get_Web_Add_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Web_Add_Button));
    }

    public static WebElement get_Employer_Button(WebDriverWait wait) {

        return Base_Class.driver.findElement(By.cssSelector(Employer_Button));
    }

    public static WebElement get_Yes_Button(WebDriverWait wait) {

        return Base_Class.driver.findElement(By.xpath(Yes_Button));
    }
}
