package Step_Definitions_Head_Ofiice;

import Pages.HeadOfficePages.BranchesHeadOfficePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Pages.HeadOfficePages.BranchesHeadOfficePage.Add_Branch_Button;
import static Pages.HeadOfficePages.BranchesHeadOfficePage.Toast_message;
//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


public class BrachesStepsHeadOffice {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    @Then("[Branch Head Office Page] User tap on the add branch button")
    public void branchHeadOfficePageUserTapOnTheAddBranchButton() {
        BranchesHeadOfficePage.get_Add_Branch().click();

    }
    public static String branch;
    @When("[Branch Head Office Page] User enter branch name {string}")
    public void branchHeadOfficePageUserEnterBranchName(String branchname) {
        int randomempno = (int) ((Math.random()*100000));
        //String branch = BranchesHeadOfficePage.get_Branch_Name().sendKeys(branchname+randomempno);
        //String sendKeysCommand = "BranchesHeadOfficePage.get_Branch_Name().sendKeys(" + branchname + randomempno + ");";
        BranchesHeadOfficePage.get_Branch_Name().sendKeys(branchname+randomempno);
         branch = BranchesHeadOfficePage.get_Branch_Name().getAttribute("value");
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Add_Branch_Button)));
        BranchesHeadOfficePage.get_Add_Branch_Button().click();
    }

    @And("[Branch Head Office Page] User validate toast message {string}")
    public void branchHeadOfficePageUserValidateToastMessage(String toastMsg) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Toast_message)));
        String message = BranchesHeadOfficePage.get_Toast_message().getText();
        Assert.assertEquals(message,toastMsg);
        System.out.println(message);
    }
    public static String phno ;
    @And("[Branch Head Office Page] User enter branch phone no {string}")
    public void branchHeadOfficePageUserEnterBranchPhoneNo(String no) {
        Long randomempno = (long) ((Math.random() * 1000000000L));
        String phoneNo = String.valueOf(randomempno); // Convert Long to String
        BranchesHeadOfficePage.get_Branch_Phone_No().click();
        BranchesHeadOfficePage.get_Branch_Phone_No().sendKeys(no+randomempno);
        phno = String.valueOf(Long.parseLong(no+randomempno));

        System.out.println(randomempno);
//        SignUpPage.signUpUserEnterThePhoneNo().click();

//        SignUpPage.signUpUserEnterThePhoneNo().sendKeys(no);

    }


    @And("[Branch Head Office Page] User enter branch phone no {int}")
    public void branchHeadOfficePageUserEnterBranchPhoneNo(long NO) {
        BranchesHeadOfficePage.get_Branch_Phone_No().sendKeys(String.valueOf(NO));
    }

}

