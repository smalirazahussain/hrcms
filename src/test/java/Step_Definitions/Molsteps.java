package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.MolPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Step_Definitions.AddEmployerSteps.companyName;

public class Molsteps {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    //public WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    @Then("[Mol] User tap on the edit personal details button")
    public void molUserTapOnTheEditPersonalDetailsButton() {
        MolPages.get_Edit_Personal_Details().click();
    }
    @And("[Mol] User tap on the edit MolEST id button")
    public void molUserTapOnTheEditMolESTIdButton() {
        MolPages.get_Mol_EST_Id_Button().click();
    }

    @Then("[Mol] User select the establishment id {string}")
    public void molUserSelectTheEstablishmentId(String arg0) {
        AddEmployerPages.get_Establishment_Id().sendKeys(companyName + Keys.ENTER);
        System.out.println(companyName);
    }

    @When("[Mol] User tap on the edit phone Number button")
    public void molUserTapOnTheEditPhoneNumberButton() {
        MolPages.get_Phone_Number_Button().click();
    }

    @And("[Mol] User enter phone no {string}")
    public void molUserEnterPhoneNo(String mobcode) {
        long mobno = (long) ((Math.random() * 9000000000L));
        MolPages.get_Phone_No().sendKeys(mobcode + mobno);
        System.out.println(mobcode + mobno);
    }
}



