package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CampPages {

    public static String Select_Camp ="#camps";
    public static WebElement get_Select_Camp() {
        return Base_Class.driver.findElement(By.cssSelector(Select_Camp));
    }
}
