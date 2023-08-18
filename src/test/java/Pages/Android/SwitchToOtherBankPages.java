package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Pages.Android.AddEmployerPages.Select_Bank;

public class SwitchToOtherBankPages {

    public static String Switch_To_Other_Bank = "button[title='Switch to Other Bank / Kamel Card']";
    public static String Bank_Name = "div.ant-select[name='bankName']";
    public static String Change_Banks = "button[title='Change Bank']";
    public static WebElement get_Switch_To_Other_Bank() {

        return Base_Class.driver.findElement(By.cssSelector(Switch_To_Other_Bank));
    }

    public static WebElement get_Select_Bank(String bank) {
        return Base_Class.driver.findElement(By.xpath(Select_Bank(bank)));
    }

    public static WebElement get_Bank_Name() {
        return Base_Class.driver.findElement(By.cssSelector(Bank_Name));
    }

    public static WebElement get_Change_Banks() {
        return Base_Class.driver.findElement(By.cssSelector(Change_Banks));
    }
}




