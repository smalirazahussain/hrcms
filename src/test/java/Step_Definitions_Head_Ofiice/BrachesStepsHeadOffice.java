package Step_Definitions_Head_Ofiice;

import Pages.Android.AdminPage;
import Pages.HeadOfficePages.BranchesHeadOfficePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Pages.Android.AdminPage.Admin_Add_Employer_Button;
import static Pages.HeadOfficePages.BranchesHeadOfficePage.*;
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

    @When("[Branch Head Office Page] User search the branch {string}")
    public void branchHeadOfficePageUserSearchTheBranch(String employerName) throws InterruptedException {
        BranchesHeadOfficePage.get_Search_Branch().sendKeys(employerName);
    }

    @Then("[Branch Head Office Page] User tap on the view employees button")
    public void branchHeadOfficePageUserTapOnTheViewEmployeesButton() {
        BranchesHeadOfficePage.get_View_Employees().click();
    }

    @Then("[Branch Head Office Page] User tap on the eye button")
    public void branchHeadOfficePageUserTapOnTheEyeButton() throws InterruptedException {
        int Random;
        double rendon;
        BranchesHeadOfficePage.get_Eye_Button().click();;
        //int value = BranchesHeadOfficePage.get_Eye_Button().getText().indexOf(10);
        //System.out.println(value);
        // BranchesHeadOfficePage.get_Eye_Button().click();
        Thread.sleep(5000);
    }

    @When("[Branch Head Office Page] User tap on the statement request button")
    public void branchHeadOfficePageUserTapOnTheStatementRequestButton() throws InterruptedException {
        Thread.sleep(1000);
        BranchesHeadOfficePage.get_Statemnet_Request().click();
    }

    @And("[Branch Head Office Page] User validate the message {string} abd click ont the continue button")
    public void branchHeadOfficePageUserValidateTheMessageAbdClickOntTheContinueButton(String expectedMessage) throws InterruptedException {

        if(BranchesHeadOfficePage.get_Statement_Message().isDisplayed()){
            System.out.println("Is Statement Message Displayed: " + BranchesHeadOfficePage.get_Statement_Message().isDisplayed());
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Statement_Message)));
        String statementMessage = BranchesHeadOfficePage.get_Statement_Message().getText();

        System.out.println("Statement-Message;"+statementMessage);
        Assert.assertEquals(statementMessage,expectedMessage);
        BranchesHeadOfficePage.get_Continue_Button().click();
        Thread.sleep(5000);

    }

    @Then("[Branch Head Office Page] User validate the top-up message {string}")
    public void branchHeadOfficePageUserValidateTheTopUpMessage(String expectMessage) {
        if(BranchesHeadOfficePage.get_Top_Up_Message().isDisplayed() || BranchesHeadOfficePage.get_Statement_Message_Already_Submitted().isDisplayed() ){
            String acutalMessage = BranchesHeadOfficePage.get_Top_Up_Message().getText();
            Assert.assertEquals(acutalMessage, expectMessage);
            System.out.println("Approval Submitted;"+acutalMessage);
        }
             else if (BranchesHeadOfficePage.get_Statement_Message_Already_Submitted().isDisplayed()){
            String alreadySubmitted = BranchesHeadOfficePage.get_Statement_Message_Already_Submitted().getText();
            System.out.println("Approval Not Submitted;"+alreadySubmitted);
        }
    }

    @When("[Branch Head Office Page] User search the branch they are created {string}")
    public void branchHeadOfficePageUserSearchTheBranchTheyAreCreated(String arg0) throws InterruptedException {
         Thread.sleep(5000);
        BranchesHeadOfficePage.get_Branch_Search().sendKeys(branch+ Keys.ENTER);
    }

    @Then("[Branch Head Office Page] User tap on the add employer button")
    public void branchHeadOfficePageUserTapOnTheAddEmployerButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Admin_Add_Employer_Button)));
        AdminPage.get_Admin_Add_Employer_Button().click();
        Thread.sleep(10000);
    }
}

