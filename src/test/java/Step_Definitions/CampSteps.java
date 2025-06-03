package Step_Definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Pages.Android.CampPages.get_Select_Camp;
import static Step_Definitions.Employeessteps.companyTittle;

public class CampSteps {
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();
    //public static By spinnerLocator;

    @Then("[Admin Page] User selects the employee camp {string}")
    public void adminPageUserSelectsTheEmployeeCamp(String campName) {
        wait.until(ExpectedConditions.elementToBeClickable(get_Select_Camp()));
        get_Select_Camp().sendKeys(companyTittle+ Keys.ENTER);
        System.out.println("✅ Selected camp: " + companyTittle);
    }
}
