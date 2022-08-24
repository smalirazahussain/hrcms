package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignUpPage {

    private WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, 30);

    //locator
    public static  String signUpUserTapOnSignUpButton = "a[href='/signup']";
    public static  String signUpUserEnterTheName ="companyName";
    public static  String signUpUserEnterTheEmail = "input[placeholder='Email Address']";
    public static  String signUpUserTapTheDropDownButton = "select[placeholder='Phone Number']";
    public static  String signUpEnterTheCompanyCode = "ant-select-selection-search-input";
    public static String signUpUserEnterThePhoneNo ="input[placeholder='Phone Number']";
    public SignUpPage(){}

    //return function

    public static  WebElement signUpUserTapOnSignUpButton(){return Base_Class.driver.findElement(By.cssSelector(signUpUserTapOnSignUpButton));}
    public static  WebElement signUpUserEnterTheName(){return Base_Class.driver.findElement(By.name(signUpUserEnterTheName));}
    public static  WebElement signUpUserEnterTheEmail(){return Base_Class.driver.findElement(By.cssSelector(signUpUserEnterTheEmail));}
    public static  WebElement signUpUserTapTheDropDownButton(){return Base_Class.driver.findElement(By.cssSelector(signUpUserTapTheDropDownButton));}
    public static  WebElement signUpEnterTheCompanyCode(){return Base_Class.driver.findElement(By.className(signUpEnterTheCompanyCode));}
    public static  WebElement signUpUserEnterThePhoneNo(){return Base_Class.driver.findElement(By.cssSelector(signUpUserEnterThePhoneNo));}
}
