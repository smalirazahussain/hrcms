package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class Base_Class {

    //AppiumDriver driver;
    //public static AppiumDriver<AndroidElement> driver;
    public static WebDriver driver = null;
    public static WebDriverWait wait ;


    @Before
    public void setup() {

        


        try {
            /*DesiredCapabilities caps = new DesiredCapabilities();

            //System.out.println(caps);

            String projectpath = System.getProperty("user.dir");
            File f = new File("apps");
            File fs = new File(f,"app.apk");
            String finalpath = projectpath+'\\'+fs;


            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "samsung");
            caps.setCapability(MobileCapabilityType.UDID, "R58M87RMRDM");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "30");
            caps.setCapability(MobileCapabilityType.APP,finalpath);
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

            URL url = new URL("http://10.40.5.218:49525/");

            driver = new AndroidDriver<AndroidElement>(url, caps);
            */

            // Set ChromeOptions
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("download.default_directory", "D:\\Hrcms\\src\\test\\java\\document");
            options.setExperimentalOption("prefs", prefs);
            // Set ChromeDriver path
            //System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe"); // Replace with your actual path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", "D:\\Hrcms\\src\\test\\java\\document");

            // Launch Chrome browser with the desired options

//            WebDriver driver = new ChromeDriver(options);
            // Perform actions to trigger the file download
//            driver.get("https://example.com/download");

            String projectpath = System.getProperty("user.dir");
            System.out.println(projectpath);
            System.out.println("Project path is:" + projectpath);

            WebDriverManager.chromedriver().setup();

           // System.setProperty("webdriver.chrome.driver", "apps/chromedriver.exe");
            driver = new ChromeDriver(options);

            //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            //System.setProperty("webdriver.chrome.whitelistedIps", "");
            Duration timeout = Duration.ofSeconds(30);
            wait = new WebDriverWait(driver, timeout);
            By.cssSelector(".ant-spin.ant-spin-spinning.css-qgg3xn");
            URL url = new URL("https://employer.getthelingo.com");
            //String projectpath = System.getProperty("user.dir");
            File f = new File("apps");
            File fs = new File(f, "app.apk");
            String finalpath = projectpath + File.separator + fs.getName();

            driver.navigate().to(url);



        }




        catch(Exception exp){
            System.out.println("Cause is: " + exp.getCause());
            System.out.println("Message is: " + exp.getMessage());
            exp.printStackTrace();
        }


    }


//    @Test
//    public void SampleTest(){
//        //DesiredCapabilities caps = new DesiredCapabilities();
//        System.out.println(driver);
//
//    }

    public static void main(String[] args) {
        String projectpath = System.getProperty("user.dir");
        System.out.println(projectpath);
    }

    @After
    public void teardown(){

        driver.quit();
    }

}
