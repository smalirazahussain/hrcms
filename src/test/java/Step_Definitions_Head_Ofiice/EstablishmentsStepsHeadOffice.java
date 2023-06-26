package Step_Definitions_Head_Ofiice;

import Pages.HeadOfficePages.EstablishmentsHeadOfficePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Step_Definitions_Head_Ofiice.BrachesStepsHeadOffice.branch;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;




public class EstablishmentsStepsHeadOffice {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    @Then("[Exchange House Establishments Page] User tap on establishments module")
    public void exchangeHouseEstablishmentsPageUserTapOnEstablishmentsModule() {
        EstablishmentsHeadOfficePage.get_Establishments_Button().click();

    }
    public static String branchEstablishmentId ;
    @Then("[Exchange House Establishments Page] User enter branch name")
    public void exchangeHouseEstablishmentsPageUserEnterBranchName() throws InterruptedException {
        //EstablishmentsHeadOfficePage.get_Establishment_Branch_Name().click();
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Establishment_Branch_Name)));
        Thread.sleep(8000);
        EstablishmentsHeadOfficePage.get_Establishment_Branch_Name().sendKeys(branch+ Keys.ENTER);
        branchEstablishmentId = EstablishmentsHeadOfficePage.get_Branch_Establishment_Id().getText().toLowerCase();
//        Employeessteps objB = new Employeessteps();
//        objB.employeesPageUserCreateAMultipleDataForTheEmployer();
        System.out.println(branchEstablishmentId);
        System.out.println(branch);


    }

//    @Then("[Exchange House Establishments Page] User enter branch name {string}")
//    public void exchangeHouseEstablishmentsPageUserEnterBranchName(String branch) throws InterruptedException {
//        Thread.sleep(8000);
//        //EstablishmentsHeadOfficePage.get_Establishment_Branch_Name().click();
//        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Establishment_Branch_Name)));
//        EstablishmentsHeadOfficePage.get_Establishment_Branch_Name().sendKeys(branch);
//        branchEstablishmentId = EstablishmentsHeadOfficePage.get_Branch_Establishment_Id().getText();
//        System.out.println(branchEstablishmentId);
//        System.out.println(branch);
//    }
}

