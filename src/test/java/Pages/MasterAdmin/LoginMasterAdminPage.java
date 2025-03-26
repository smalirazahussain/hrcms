package Pages.MasterAdmin;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginMasterAdminPage {

    public static String OTP_toast_message = "span:nth-child(2)";
    public static String User_Name = "div[class='navbar-left'] h1";
    public static WebElement get_OTP_toast_message(){
        return Base_Class.driver.findElement(By.cssSelector(OTP_toast_message));
    }

    public static WebElement get_User_Name() {

        return Base_Class.driver.findElement(By.cssSelector(User_Name));
    }
}
