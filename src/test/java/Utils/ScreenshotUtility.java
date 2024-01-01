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

import io.cucumber.java.Scenario;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {

    public static void captureScreenshotWithStep(Scenario scenario, String failedStep) {
        // Capture screenshot logic here...
        File sourceFile = captureScreenshot(); // Your logic to capture a screenshot

        // Timestamp for unique file naming
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Extract scenario name and sanitize for filename
        String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9.-]", "_");

        // Create a filename with step information appended
        String screenshotFileName = "failedScenario_" + scenarioName + "_Step_" + failedStep + "_" + timeStamp + ".png";

        // Directory where screenshots will be saved
        String screenshotDirectory = "D:\\Hrcms\\src\\test\\java\\ScreenShot\\";

        // Construct the destination file path
        File destFile = new File(Paths.get(screenshotDirectory, screenshotFileName).toString());

        // Save the screenshot to the destination file
        // Your logic to copy the sourceFile to destFile
        // For example:
        // Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

    }

    // Placeholder method for capturing a screenshot, replace this with your actual logic
    private static File captureScreenshot() {
        // Your logic to capture a screenshot and return the File object
        return null; // Replace this with actual screenshot capture logic
    }
}
