package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static Hooks.Base_Class.driver;

//package Tests;
//
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.touch.WaitOptions;
//import io.appium.java_client.touch.offset.PointOption;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.openqa.selenium.Dimension;
//
//import java.time.Duration;
//import java.util.Random;
//import java.util.Random;
//
//import static Hooks.Base_Class.driver;
//
//public class Useful_functions {
//
//    public static String getRandomNumberLowerAndUpperBound(int lowerbound, int upperbound) {
//
//        //random no of characters
//        Random rand = new Random();
//        int random_integer = rand.nextInt(upperbound - lowerbound) + lowerbound;
//
//
//        String characters = "0123456789";
//        String pwd = RandomStringUtils.random(random_integer, characters);
//        return pwd;
//    }
//
//
//
//public static int getRandomDigit(int upperbound) {
//    Random rand = new Random();
//
//    // Obtain a number between [0 - 49].
//    int n = rand.nextInt(upperbound) + 1;
//
//// Add 1 to the result to get a number from the required range
//// (i.e., [1 - 50]).
//    return n;
//
//}
//
//
//    public static void scrollRight() {
//
//        //The viewing size of the device
//        Dimension size = driver.manage().window().getSize();
//
//        //x position set to mid-screen horizontally
//        int height = size.height / 4;
//
//        //Starting y location set to 80% of the height (near bottom)
//        int startPoint = (int) (size.getWidth() * 0.80);
//
//        //Ending y location set to 20% of the height (near top)
//        int endPoint = (int) (size.getWidth() * 0.20);
//
//        new TouchAction(driver).press(PointOption.point(startPoint, height)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(endPoint, height)).release().perform();
//
//    }
//
//    public static void scrollRightPre() {
//
//        //The viewing size of the device
//        Dimension size = driver.manage().window().getSize();
//
//        //x position set to mid-screen horizontally
//        int height = (int) (size.height / 2.1);
//
//        //Starting y location set to 80% of the height (near bottom)
//        int startPoint = (int) (size.getWidth() * 0.80);
//
//        //Ending y location set to 20% of the height (near top)
//        int endPoint = (int) (size.getWidth() * 0.20);
//
//        new TouchAction(driver).press(PointOption.point(startPoint, height)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(endPoint, height)).release().perform();
//
//    }
//
//    public static void scrollRightPost() {
//
//        //The viewing size of the device
//        Dimension size = driver.manage().window().getSize();
//
//        //x position set to mid-screen horizontally
//        int height = size.height / 3;
//
//        //Starting y location set to 80% of the height (near bottom)
//        int startPoint = (int) (size.getWidth() * 0.80);
//
//        //Ending y location set to 20% of the height (near top)
//        int endPoint = (int) (size.getWidth() * 0.20);
//
//        new TouchAction(driver).press(PointOption.point(startPoint, height)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(endPoint, height)).release().perform();
//
//    }
//
//    public static void scrollLeft() {
//
//        //The viewing size of the device
//        Dimension size = driver.manage().window().getSize();
//
//        //x position set to mid-screen horizontally
//        int height = size.height / 4;
//
//        //Starting y location set to 80% of the height (near bottom)
//        int startPoint = (int) (size.getWidth() * 0.20);
//
//        //Ending y location set to 20% of the height (near top)
//        int endPoint = (int) (size.getWidth() * 0.80);
//
//        new TouchAction(driver).press(PointOption.point(startPoint, height)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(endPoint, height)).release().perform();
//
//    }
//
//    public static void scrollDown() {
//
//        //The viewing size of the device
//        Dimension size = driver.manage().window().getSize();
//
//        //x position set to mid-screen horizontally
//        int width = size.width / 2;
//
//        //Starting y location set to 80% of the height (near bottom)
//        int startPoint = (int) (size.getHeight() * 0.80);
//
//        //Ending y location set to 20% of the height (near top)
//        int endPoint = (int) (size.getHeight() * 0.20);
//
//        new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(width, endPoint)).release().perform();
//
//    }
//
//    public static void scrollDown_CardManagement() {
//
//        //The viewing size of the device
//        Dimension size = driver.manage().window().getSize();
//
//        //x position set to mid-screen horizontally
//        int width = size.width / 2;
//
//        //Starting y location set to 80% of the height (near bottom)
//        int startPoint = (int) (size.getHeight() * 0.60);
//
//        //Ending y location set to 20% of the height (near top)
//        int endPoint = (int) (size.getHeight() * 0.20);
//
//        new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(width, endPoint)).release().perform();
//
//    }
//
//
//    public static void scrollUp() {
//
//        //The viewing size of the device
//        Dimension size = driver.manage().window().getSize();
//
//        //x position set to mid-screen horizontally
//        int width = size.width / 2;
//
//        //Starting y location set to 80% of the height (near bottom)
//        int startPoint = (int) (size.getHeight() * 0.20);
//
//        //Ending y location set to 20% of the height (near top)
//        int endPoint = (int) (size.getHeight() * 0.80);
//
//        new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(width, endPoint)).release().perform();
//
//
//    }
//
//
//}
public class Scroll
{
    public static void ScrollVertical(WebElement Element){
        JavascriptExecutor js = (JavascriptExecutor) driver;

                //This will scroll the page Horizontally till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);

    }
}