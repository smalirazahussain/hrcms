package Pages.Android;

import Hooks.Base_Class;
import org.codehaus.jackson.map.MapperConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.nimbus.State;
import java.time.Duration;

import static Hooks.Base_Class.driver;


public class OtherCompaniesPage {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    //locator
    public static String Other_Companies = "#companies";
    public static String Add_Other_Company = "button[title='Add Other Company']";
    public static String State = "span[title='State *']";



    public static WebElement get_Other_Companies() {
        return Base_Class.driver.findElement(By.cssSelector(Other_Companies));
    }

    public static WebElement get_Add_Other_Company() {
        return Base_Class.driver.findElement(By.cssSelector(Add_Other_Company));
    }

    public static WebElement get_State() {
        return Base_Class.driver.findElement(By.cssSelector(State));
    }
}
