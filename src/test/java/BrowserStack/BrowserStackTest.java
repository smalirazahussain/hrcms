package BrowserStack;

import Hooks.Base_Class;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserStackTest {

    public static final String USERNAME = "aliraza_7ulipE"; // Update with your BrowserStack credentials
    public static final String ACCESS_KEY = "qEyu4qURtfsmUQjeENsE";
    public static  String BROWSERSTACK_URL;/* = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";*/

    public static void main(String[] args) throws Exception {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "119.0.6045.199");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("project", "Hrcms");
            caps.setCapability("build", "Hrcms");
            caps.setCapability("name", "login");
            RemoteWebDriver driver = new RemoteWebDriver(new URL(BROWSERSTACK_URL),caps);
            BROWSERSTACK_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
            Base_Class baseClass = new Base_Class();
            baseClass.setup(); // Initializes WebDriver from Base_Class


            baseClass.navigateToURL("https://employe.getthelingo.com");

            System.out.println(driver.getTitle());

            baseClass.teardown(); // Quits WebDriver initialized in Base_Class
        } catch (Exception exp) {
            System.out.println("Cause is: " + exp.getCause());
            System.out.println("Message is: " + exp.getMessage());
            exp.printStackTrace();
        }
    }
}
