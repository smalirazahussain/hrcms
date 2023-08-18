package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.SwitchToOtherBankPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.wait;
import static Pages.Android.SwitchToOtherBankPages.Bank_Name;

public class SwitchToOtherBanksteps {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    //public WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    @And("[Switch To Other Bank] User tap on the Switch to other bank button")
    public void switchToOtherBankUserTapOnTheSwitchToOtherBankButton() {
        SwitchToOtherBankPages.get_Switch_To_Other_Bank().click();
    }
     BankName[] bankName = new BankName("Ajman Bank"+"Arab Bank");
    @When("[Switch To Other Bank] User select the bank {string}")
    public void switchToOtherBankUserSelectTheBank(String bank) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Bank_Name)));
        Thread.sleep(5000);
        SwitchToOtherBankPages.get_Bank_Name().click();
        AddEmployerPages.get_Select_Bank(bank).click();
        //SwitchToOtherBankPages.get_Select_Bank(bank).click();
    }

    @And("[Switch To Other Bank] User tap on the change bank")
    public void switchToOtherBankUserTapOnTheChangeBank() {
        SwitchToOtherBankPages.get_Change_Banks().click();
    }
}



