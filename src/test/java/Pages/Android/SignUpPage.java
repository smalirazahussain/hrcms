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
    public static String signUpUserTapOnSignUpButton = "a[href='/signup']";
    public static String signUpUserEnterTheName = "companyName";
    public static String signUpUserEnterTheEmail = "input[placeholder='Email Address']";
    public static String signUpUserTapTheDropDownButton = "(//div[@class='ant-select-item-option-content'])[4]";
    public static String signUpEnterTheCompanyCode = "//span[@class='ant-select-selection-search']";
    public static String signUpUserEnterThePhoneNo = "//input[@placeholder='Phone Number']";
    public static String confirmPassword = "[placeholder='Confirm Password']";
    public static String signUpPageSignUpButton = "button[title='Sign Up'] span";
    public static String errorMessageOnUser = "div[class='ant-message'] span:nth-child(1)";
    public static String phoneCode ="ant-select-selection-search-input";
            //".ant-select-selection-item";
    public static String dropDownButton = "//span[@role='img']";
    public static String countryCode = "//span[@class='ant-select-selection-search']";

    public SignUpPage() {
    }

    //return function

    public static WebElement signUpUserTapOnSignUpButton() {
        return Base_Class.driver.findElement(By.cssSelector(signUpUserTapOnSignUpButton));
    }

    public static WebElement signUpUserEnterTheName() {
        return Base_Class.driver.findElement(By.name(signUpUserEnterTheName));
    }

    public static WebElement signUpUserEnterTheEmail() {
        return Base_Class.driver.findElement(By.cssSelector(signUpUserEnterTheEmail));
    }

    public static WebElement signUpUserTapTheDropDownButton() {
        return Base_Class.driver.findElement(By.xpath(signUpUserTapTheDropDownButton));
    }

    public static WebElement signUpEnterTheCompanyCode() {
        return Base_Class.driver.findElement(By.xpath(signUpEnterTheCompanyCode));
    }

    public static WebElement signUpUserEnterThePhoneNo() {
        return Base_Class.driver.findElement(By.xpath(signUpUserEnterThePhoneNo));
    }

    public static WebElement confirmPassword() {
        return Base_Class.driver.findElement(By.cssSelector(confirmPassword));
    }

    public static WebElement signUpPageSignUpButton() {
        {
            return Base_Class.driver.findElement(By.cssSelector(signUpPageSignUpButton));
        }


    }

    public static WebElement errorMessageOnUser() {
        {
            return Base_Class.driver.findElement(By.cssSelector(errorMessageOnUser));
        }
    }

    public static WebElement phoneCode() {
        return Base_Class.driver.findElement(By.className(phoneCode));
    }

    public static WebElement dropDownButton() {
        return Base_Class.driver.findElement(By.xpath(dropDownButton));
    }
    public static WebElement countryCode(){
        return Base_Class.driver.findElement(By.xpath(countryCode));
    }
}