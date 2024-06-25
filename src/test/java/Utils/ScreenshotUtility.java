//package Utils;
//
//import io.cucumber.java.Scenario;
//
//public class ScreenshotUtility {
//    public static void captureScreenshot(Scenario scenario) {
//        if (scenario.isFailed()) {
//            int scenarioLine = getScenarioLineNumber(); // Assume you have a method to get line number
//            // Rest of the screenshot capturing logic...
//        }
//    }
//
//    private static int getScenarioLineNumber() {
//        // Logic to retrieve scenario line number
//        // Replace this with your method to get the line number where the scenario failed
//        return 0; // Example: Replace 0 with the actual line number retrieval logic
//    }
//}
package Utils;

import Hooks.Base_Class;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {

    public static void captureScreenshotWithStep(Scenario scenario, String failedStep) {
        if (scenario.isFailed()) {
            System.out.println("Scenario failed. Capturing screenshot...");
            int scenarioLine = getScenarioLineNumber();
            System.out.println("Scenario line number: " + scenarioLine);
            File sourceFile = captureScreenshot(scenario);
            System.out.println("Source file: " + sourceFile);
            if (sourceFile != null) {
                // Specify the directory where you want to save the screenshots
                String screenshotDirectory = "D:\\Hrcms\\src\\test\\java\\ScreenShot\\";
                String timeStamp = (new SimpleDateFormat("yyyyMMdd_HHmmss")).format(new Date());
                String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9.-]", "_");
                String screenshotFileName = "failedScenario_" + scenarioName + "_Step_" + failedStep + "_" + timeStamp + ".png";
                File destFile = new File(Paths.get(screenshotDirectory, screenshotFileName).toString());
                try {
                    // Move the source file to the destination directory
                    Files.move(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Screenshot saved to: " + destFile);
                } catch (IOException e) {
                    System.out.println("Failed to move screenshot file: " + e.getMessage());
                }
            } else {
                System.out.println("Failed to capture screenshot.");
            }
        }
    }


    private static int getScenarioLineNumber() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTrace) {
            // Check if the stack trace element belongs to the Cucumber package
            if (element.getClassName().startsWith("io.cucumber")) {
                // Extract the line number from the stack trace element
                return element.getLineNumber();
            }
        }
        return -1;
    }
//        scenario.isFailed();
//        // Capture screenshot logic here...
//        int scenarioLine = getScenarioLineNumber();
//        File sourceFile = captureScreenshot(scenario); // Your logic to capture a screenshot
//
//        // Timestamp for unique file naming
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//
//        // Extract scenario name and sanitize for filename
//        String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9.-]", "_");
//
//        // Create a filename with step information appended
//        String screenshotFileName = "failedScenario_" + scenarioName + "_Step_" + failedStep + "_" + timeStamp + ".png";
//
//        // Directory where screenshots will be saved
//        String screenshotDirectory = "D:\\Hrcms\\src\\test\\java\\ScreenShot\\";
//
//        // Construct the destination file path
//        File destFile = new File(Paths.get(screenshotDirectory, screenshotFileName).toString());
//
//        // Save the screenshot to the destination file
//        // Your logic to copy the sourceFile to destFile
//        // For example:
//        // Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);


    // Placeholder method for capturing a screenshot, replace this with your actual logic
    public static File captureScreenshot(Scenario scenario) {
        try {
            // Convert WebDriver instance to TakesScreenshot
            TakesScreenshot screenshot = (TakesScreenshot) Base_Class.driver;
            System.out.println("screenshot "+screenshot );

            // Capture screenshot as File
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            System.out.println("sourceFile"+sourceFile);

            return sourceFile;
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace();
            System.out.println("e"+e);
            return null;
        }
    }
}

//    private static int getScenarioLineNumber() {
//        // Logic to retrieve scenario line number
//        // Replace this with your method to get the line number where the scenario failed
//        return 0;
//    }
