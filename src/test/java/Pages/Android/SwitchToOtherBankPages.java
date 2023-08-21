package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SwitchToOtherBankPages {

    public static String Switch_To_Other_Bank = "button[title='Switch to Other Bank / Kamel Card']";
    public static String Bank_Name = "input.ant-select-selection-search-input[id='bankName']";
    public static String Change_Banks = "button[title='Change Bank']";
    public static String Switch_Bank(String randomBankName) {
        return "//div[@class='ant-select-item ant-select-item-option' and @title='"+ randomBankName +"']";
        //return "//span[@class='ant-select-selection-item' and @title='"+ randomBankName +"']";
    }
    public static WebElement get_Switch_To_Other_Bank() {

        return Base_Class.driver.findElement(By.cssSelector(Switch_To_Other_Bank));
    }
    public static WebElement get_Bank_Name() {
        return Base_Class.driver.findElement(By.cssSelector(Bank_Name));
    }

    public static WebElement get_Change_Banks() {
        return Base_Class.driver.findElement(By.cssSelector(Change_Banks));
    }

    public static WebElement get_Switch_Bank(String randomBankName) {
        return Base_Class.driver.findElement(By.xpath(Switch_Bank(randomBankName)));
    }
}




