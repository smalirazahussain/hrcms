package Step_Definitions;

import Pages.Android.EidPages;
import Tests.Generate_Random_Date;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Random;

import static Hooks.Base_Class.wait;
import static Pages.Android.EidPages.get_Eid_Popup_Msg;
import static Pages.Android.EidPages.get_Two_Image_Button;

public class Eidsteps {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    //public WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();







    @Then("[Eid] User tap on the update eid button")
    public void eidUserTapOnTheUpdateEidButton() {
        EidPages.get_Update_Eid_Button().click();
    }

    @And("[Eid] User enter the expire date {string}")
    public void eidUserEnterTheExpireDate(String arg0) throws InterruptedException {

////        Generate_Random_Date dateGenerator = new Generate_Random_Date();
////        LocalDate randomDate = dateGenerator.generateFormattedRandomDate();
//        Generate_Random_Date dateGenerator = new Generate_Random_Date();
//        String formattedRandomDate = dateGenerator.generateFormattedRandomDate();
//        // Convert the LocalDate to the desired format (assuming "MM/dd/yyyy")
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String formattedDate = randomDate.format(formatter);
//        System.out.println("Expire Date"+formattedDate);
//        EidPages.get_Eid_Expire_Date().sendKeys(formattedDate);
//        Thread.sleep(5000);
       // Generate_Random_Date dateGenerator = new Generate_Random_Date();
        String formattedRandomDate = Generate_Random_Date.generateFormattedRandomFutureDate();

        System.out.println("Expire Date: " + formattedRandomDate);
       // System.out.println("Expire Date: " + formatter);
        EidPages.get_Eid_Expire_Date().sendKeys(formattedRandomDate, Keys.ENTER);

    }

    @And("[Eid] User tap on Update button")
    public void eidUserTapOnUpdateButton() {
        EidPages.get_Update_Button().click();
    }

    @Then("[Eid] User verify approval send to him and verify the popup message {string}")
    public void eidUserVerifyApprovalSendToHimAndVerifyThePopupMessage(String expMsg) throws InterruptedException {

        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            //wait.until(ExpectedConditions.visibilityOfElementLocated((By) get_Eid_Popup_Msg(expMsg)));
            String actualMsg = get_Eid_Popup_Msg(expMsg).getText();
            System.out.println(actualMsg);
            Assert.assertEquals(actualMsg, expMsg);
        }
        catch (Exception e){
            e.printStackTrace();
            //Thread.sleep(5000);

        }
    }

    @When("[Eid] User enter the {int} digits eid no")
    public void eidUserEnterTheDigitsEidNo(int arg0) {
        long min = 100000000000000L; // Minimum 15-digit number
        long max = 999999999999999L; // Maximum 15-digit number

        Random random = new Random();
        long eidNumber = min + ((long) (random.nextDouble() * (max - min + 1)));
        EidPages.get_Emirates_Id().sendKeys(String.valueOf(eidNumber));
        System.out.println("eidNumber 15-digit number: " + eidNumber);

    }

    @Then("[Eid] User tap on two image button")
    public void eidUserTapOnTwoImageButton() {
        String button = get_Two_Image_Button().getText();
        System.out.println(button);
        get_Two_Image_Button().click();
    }
}



