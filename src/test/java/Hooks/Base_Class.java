package Hooks;

import Utils.ScreenshotUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
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
            WebDriverManager.chromedriver().setup();
            // Set ChromeDriver path
            //System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe"); // Replace with your actual path to chromedriver.exe
           // System.setProperty("webdriver.chrome.driver", "D:\\Hrcms\\src\\test\\java\\document");
            //System.setProperty("webdriver.chrome.driver", "apps/chromedriver.exe");

            // Launch Chrome browser with the desired options

//            WebDriver driver = new ChromeDriver(options);
            // Perform actions to trigger the file download
//            driver.get("https://example.com/download");

//            String projectpath = System.getProperty("user.dir");
//            System.out.println(projectpath);
//            System.out.println("Project path is:" + projectpath);


//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setBrowserName("chrome");
//            capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
//            URL gridUrl = new URL("http://192.168.105.10:4444");

          //  System.setProperty("webdriver.chrome.driver", "apps/chromedriver.exe");
            driver = new ChromeDriver(options);
            //driver = new RemoteWebDriver(gridUrl, options.merge(capabilities));
            //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            //System.setProperty("webdriver.chrome.whitelistedIps", "");
            Duration timeout = Duration.ofSeconds(30);
            wait = new WebDriverWait(driver, timeout);
            By.cssSelector(".ant-spin.ant-spin-spinning.css-qgg3xn");
            //driver.get("https://employer.getthelingo.com/");
            URL url = new URL("https://employer.getthelingo.com/");
            //String projectpath = System.getProperty("user.dir");
            File f = new File("apps");
            File fs = new File(f, "app.apk");
           // String finalpath = projectpath + File.separator + fs.getName();

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
//    public void teardown(Scenario scenario) throws IOException {
////        if (sc.isFailed()) {
////            int screenShotNo = (int) ((Math.random()*100000));
////            String fileScreenShot = "D://Hrcms//src//test//java//ScreenShot//failedScreenShoot"+screenShotNo+".png";
////            TakesScreenshot screenshot = ((TakesScreenshot) driver);
////            File ScrFile = screenshot.getScreenshotAs(OutputType.FILE);
////            File DestFile = new File(fileScreenShot);
////            try {
////                FileUtils.copyFile(ScrFile, DestFile);
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//        if (scenario.isFailed()) {
//            try {
//                int scenarioLine = ScenarioSteps.getScenarioLineNumber();
//
//                // Generate timestamp
//                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//
//                // Construct the filename for the screenshot
//                String fileScreenShot = "D:\\Hrcms\\src\\test\\java\\ScreenShot\\failedScenario_" + scenarioLine + "_" + timeStamp + ".png";
//
//                // Capture and save the screenshot
//                TakesScreenshot screenshot = ((TakesScreenshot) driver);
//                File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
//                File destFile = new File(fileScreenShot);
//                FileUtils.copyFile(scrFile, destFile);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        driver.quit();
//    }

        public void tearDown(Scenario scenario) {
        //if (scenario.isFailed()) {
            String failedStepInfo = extractFailedStepInfo(scenario);
            ScreenshotUtility.captureScreenshotWithStep(scenario, failedStepInfo);
        //}
//        if (scenario.isFailed()) {
//            captureScreenshot(scenario);
//        }
        driver.quit();
    }
    private String extractFailedStepInfo(Scenario scenario) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9.-]", "_");

            String screenshotFileName = "failedScenario_" + scenarioName + "_" + timeStamp + ".png";
            String screenshotDirectory = "D:\\Hrcms\\src\\test\\java\\ScreenShot\\";

            Path destinationPath = Paths.get(screenshotDirectory, screenshotFileName);
            File destFile = new File(destinationPath.toString());

            FileHandler.copy(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scenario.getName();
    }
}
