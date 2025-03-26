package Hooks;

import config.properties.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.log.Log;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.Headers;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class Base_Class {

    //AppiumDriver driver;
    //public static AppiumDriver<AndroidElement> driver;
    public static WebDriver driver = null;
    public static WebDriverWait wait ;
    public static DevTools devTools;
    ConfigReader configReader = new ConfigReader();


    @Before
    public void     setup() {




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
            if (driver == null) {
                ChromeOptions options = new ChromeOptions();
                options.setCapability("webSocketUrl", true);
                options.addArguments("--start-maximized");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
//                options.addArguments("--headless");
//                options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", "D:\\Hrcms\\src\\test\\java\\document");
                options.setExperimentalOption("prefs", prefs);
                //if (isSpecialPageOrScenario()) {
                //   options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                //} else {
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                // }
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
                try {
                    driver = new ChromeDriver(options);
                    //driver = new RemoteWebDriver(gridUrl, options.merge(capabilities));
                    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    devTools = ((ChromeDriver) driver).getDevTools();
                    devTools.createSession();
                }
                 catch (Exception e){
                System.out.println("BIDI: "+e.getMessage());
                     e.printStackTrace();

            }
//
//                // Example: Enable Network logging
//                enableNetworkLogging();
//
//                // Enable Console Log capturing
//                enableConsoleLog();

                //LogInspector LogInspector = new LogInspector(driver);

                //driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
                System.out.println("maximize");
                //System.setProperty("webdriver.chrome.whitelistedIps", "");
                Duration timeout = Duration.ofSeconds(30);
                wait = new WebDriverWait(driver, timeout);

                By.cssSelector(".ant-spin.ant-spin-spinning.css-qgg3xn");
                // driver.get("https://employer.getthelingo.com/");
                //URL url = new URL(configReader.getProperty("stageEmployerUrl"));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                String stageEmployerUrl = configReader.getProperty("stageEmployerUrl");
                System.out.println("Navigating to URL: " + stageEmployerUrl);
                driver.navigate().to(stageEmployerUrl);
                //String projectpath = System.getProperty("user.dir");
                File f = new File("apps");
                File fs = new File(f, "app.apk");
                // String finalpath = projectpath + File.separator + fs.getName();

                // driver.navigate().to(url);


            }
        }




        catch(Exception exp){
            System.out.println("Cause is: " + exp.getCause());
            System.out.println("Message is: " + exp.getMessage());
            exp.printStackTrace();
        }


    }

    private boolean isSpecialPageOrScenario() {
        try {
            // Check if the driver is not null and the current URL contains a special keyword
            return driver != null && driver.getCurrentUrl().contains("Statement Request");
        } catch (Exception e) {
            // Handle any exception, log it, and return false
            System.out.println("Exception in isSpecialPageOrScenario: " + e.getMessage());
            return false;
        }
    }
    public static void enableNetworkLogging() {
        try {
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        Map<String, Object> headersMap = new HashMap<>();
        //headersMap.put("Authorization", "Bearer token");
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headersMap)));
        devTools.addListener(Network.requestWillBeSent(), request -> {
            System.out.println("Request URL: " + request.getRequest().getUrl());
        });
        devTools.addListener(Network.responseReceived(), response -> {
            System.out.println("Response URL: " + response.getResponse().getUrl());
            System.out.println("Response TIME: " + response.getResponse().getResponseTime());
            System.out.println("Status: " + response.getResponse().getStatus());
            Network.GetResponseBodyResponse responseBody = devTools.send(Network.getResponseBody(response.getRequestId()));
            saveResponseToFile(response.getResponse().getUrl(), response.getResponse().getStatus(), responseBody.getBody());

        });
        } catch (Exception e) {
            System.err.println("Error enabling network logging: " + e.getMessage());
        }
    }
    public static void enableConsoleLog() {
        try {
        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(), entry -> {
            System.out.println("Log: " + entry.getText());
            System.out.println("Level: " + entry.getLevel());
        });
        } catch (Exception e) {
            System.err.println("Error enabling console log: " + e.getMessage());
        }
    }
    private static void saveResponseToFile(String url, int status,String body) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("network_responses.txt", true))) {
            writer.write("[" + getCurrentTimestamp() + "] URL: " + url);
            writer.newLine();
            writer.write("Status: " + status);
            writer.newLine();
            writer.write("Body: " + body);
            writer.newLine();
            writer.write("----------");
            writer.newLine();
            System.out.println("URL: " + url);
            System.out.println("Status: " + status);
            System.out.println("Body: " + body);
            System.out.println("----------");
            writer.newLine();
            System.out.println("[" + getCurrentTimestamp() + "] Saved response to file: " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String getCurrentTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
//
////    @Test
////    public void SampleTest(){
////        //DesiredCapabilities caps = new DesiredCapabilities();
////        System.out.println(driver);
////
////    }
//
//    public static void main(String[] args) {
//        String projectpath = System.getProperty("user.dir");
//        System.out.println(projectpath);
//    }
//
//    @After
////    public void teardown(Scenario scenario) throws IOException {
//////        if (sc.isFailed()) {
//////            int screenShotNo = (int) ((Math.random()*100000));
//////            String fileScreenShot = "D://Hrcms//src//test//java//ScreenShot//failedScreenShoot"+screenShotNo+".png";
//////            TakesScreenshot screenshot = ((TakesScreenshot) driver);
//////            File ScrFile = screenshot.getScreenshotAs(OutputType.FILE);
//////            File DestFile = new File(fileScreenShot);
//////            try {
//////                FileUtils.copyFile(ScrFile, DestFile);
//////            } catch (IOException e) {
//////                e.printStackTrace();
//////            }
////        if (scenario.isFailed()) {
////            try {
////                int scenarioLine = ScenarioSteps.getScenarioLineNumber();
////
////                // Generate timestamp
////                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
////
////                // Construct the filename for the screenshot
////                String fileScreenShot = "D:\\Hrcms\\src\\test\\java\\ScreenShot\\failedScenario_" + scenarioLine + "_" + timeStamp + ".png";
////
////                // Capture and save the screenshot
////                TakesScreenshot screenshot = ((TakesScreenshot) driver);
////                File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
////                File destFile = new File(fileScreenShot);
////                FileUtils.copyFile(scrFile, destFile);
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
////        driver.quit();
////    }
//
//        public void tearDown(@NotNull Scenario scenario) {
//        if (scenario.isFailed()) {
//            String failedStepInfo = extractFailedStepInfo(scenario);
//            ScreenshotUtility.captureScreenshotWithStep(scenario, failedStepInfo);
//        }
//
//        //}
//
////        if (scenario.isFailed()) {
////            captureScreenshot(scenario);
////        }
//        driver.quit();
//    }
//
////    private void captureScreenshot(Scenario scenario) {
////    }
//
//    private String extractFailedStepInfo(Scenario scenario) {
//        return scenario.getName();
////    private String extractFailedStepInfo(Scenario scenario) {
////        try {
////            TakesScreenshot screenshot = (TakesScreenshot) driver;
////            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
////
////            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
////            String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9.-]", "_");
////
////            String screenshotFileName = "failedScenario_" + scenarioName + "_" + timeStamp + ".png";
////            String screenshotDirectory = "D:\\Hrcms\\src\\test\\java\\ScreenShot\\";
////
////            Path destinationPath = Paths.get(screenshotDirectory, screenshotFileName);
////            File destFile = new File(destinationPath.toString());
////
////            FileHandler.copy(sourceFile, destFile);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return scenario.getName();
//    }
//}


            //neew code for screen shot

    public static void captureScreenshot(Scenario scenario) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            saveScreenshot(scenario, sourceFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveScreenshot(Scenario scenario, File sourceFile) {
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String destinationFilePath = getString(scenario, timeStamp);
            File destinationFile = new File(destinationFilePath);

            try (FileInputStream fis = new FileInputStream(sourceFile);
                 FileOutputStream fos = new FileOutputStream(destinationFile)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
            }
            System.out.println("Screenshot saved to: " + destinationFilePath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }

    private static @NotNull String getString(Scenario scenario, String timeStamp) {
        String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9.-]", "_");
        String screenshotFileName = "failedScenario_" + scenarioName + "_" + timeStamp + ".png";
        String screenshotDirectory = "D:\\Hrcms\\src\\test\\java\\ScreenShot\\";
        File destinationDir = new File(screenshotDirectory);

        if (!destinationDir.exists()) {
            destinationDir.mkdirs(); // Create directory if it doesn't exist
        }

        String destinationFilePath = "D:\\Hrcms\\src\\test\\java\\ScreenShot\\" + screenshotFileName;
        return destinationFilePath;
    }
//    }

    @After
    public void tearDown(@NotNull Scenario scenario) {
        //if (scenario.isFailed()) {
            captureScreenshot(scenario);
        //}
        driver.quit();
    }
}