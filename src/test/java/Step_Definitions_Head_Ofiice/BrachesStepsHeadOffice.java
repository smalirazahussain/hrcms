package Step_Definitions_Head_Ofiice;

import Pages.HeadOfficePages.BranchesHeadOfficePage;
import Pages.HeadOfficePages.HeadOfficeLoginPage;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import static Hooks.Base_Class.driver;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class BrachesStepsHeadOffice {

    public WebDriverWait wait = new WebDriverWait(driver, 30);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    @Then("[Branch Head Office Page] User tap on the add branch button")
    public void branchHeadOfficePageUserTapOnTheAddBranchButton() {
        BranchesHeadOfficePage.get_Add_Branch().click();

    }

    @When("[Branch Head Office Page] User enter branch name {string}")
    public void branchHeadOfficePageUserEnterBranchName(String branchname) {
        int randomempno = (int) ((Math.random()*100000));
        //String branch = BranchesHeadOfficePage.get_Branch_Name().sendKeys(branchname+randomempno);
        //String sendKeysCommand = "BranchesHeadOfficePage.get_Branch_Name().sendKeys(" + branchname + randomempno + ");";
        BranchesHeadOfficePage.get_Branch_Name().sendKeys(branchname+randomempno);
        String branch = BranchesHeadOfficePage.get_Branch_Name().getAttribute("value");
        System.out.println(branch);
    }

    @When("[Branch Head Office Page] User enter the branch location {string}")
    public void branchHeadOfficePageUserEnterTheBranchLocation(String location) {
        BranchesHeadOfficePage.get_Branch_Location().sendKeys(location);
    }

    @Then("[Branch Head Office Page] User enter the email address {string}")
    public void branchHeadOfficePageUserEnterTheEmailAddress(String email) {
        int randomempno = (int) ((Math.random()*100000));
        BranchesHeadOfficePage.get_Branch_Email().sendKeys(email+randomempno+"@mailinator.com");
    }

    @And("[Branch Head Office Page] User enter the Password {string}")
    public void branchHeadOfficePageUserEnterThePassword(String password) {
        BranchesHeadOfficePage.get_Branch_Password().sendKeys(password);
    }

    @When("[Branch Head Office Page] User enter the confirm Password {string}")
    public void branchHeadOfficePageUserEnterTheConfirmPassword(String confirmpassword) {
        BranchesHeadOfficePage.get_Branch_Confirm_Password().sendKeys(confirmpassword);
    }

    @And("[Branch Head Office Page] User enter branch phone no")
    public void branchHeadOfficePageUserEnterBranchPhoneNo() {

    }

    @Then("[Branch Head Office Page] User tap on add branch button")
    public void branchHeadOfficePageUserTapOnAddBranchButton() {
        BranchesHeadOfficePage.get_Add_Branch_Button().click();
    }

    @And("[Branch Head Office Page] User validate toast message {string}")
    public void branchHeadOfficePageUserValidateToastMessage(String arg0) {
        String message = BranchesHeadOfficePage.get_Toast_message().getText();
        System.out.println(message);
    }

    @And("[Branch Head Office Page] User enter branch phone no {string}")
    public void branchHeadOfficePageUserEnterBranchPhoneNo(String no) {
        Long randomempno = (long) ((Math.random() * 10000000L));
        String phoneNo = String.valueOf(randomempno); // Convert Long to String
        BranchesHeadOfficePage.get_Branch_Phone_No().sendKeys(no);
        System.out.println(randomempno);
    }


    @And("[Branch Head Office Page] User enter branch phone no {int}")
    public void branchHeadOfficePageUserEnterBranchPhoneNo(long NO) {
        BranchesHeadOfficePage.get_Branch_Phone_No().sendKeys(String.valueOf(NO));
    }

}

