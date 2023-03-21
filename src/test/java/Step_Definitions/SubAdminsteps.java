package Step_Definitions;

import Pages.Android.SignUpPage;
import Pages.Android.SubAdminPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Random;

import static Hooks.Base_Class.driver;
import static Pages.Android.SignUpPage.signUpUserEnterTheName;
import static Pages.Android.SubAdminPages.Add_Admin_BUtton;

public class SubAdminsteps {

    public WebDriverWait wait = new WebDriverWait(driver, 30);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();



    @Given("[Sub Admin] User tap on the sub admin button")
    public void subAdminUserTapOnTheSubAdminButton() {
        SubAdminPages.get_Sub_Admin_Button().click();
    }

    @Then("[Sub Admin] User tap on the add sub button")
    public void subAdminUserTapOnTheAddSubButton() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Add_Admin_BUtton)));
        SubAdminPages.get_Add_Admin_Button().click();


    }

    @When("[Sub Admin] User enter name {string}")
    public void subAdminUserEnterName(String name) throws InterruptedException {
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        SubAdminPages.get_Name().sendKeys(name+randomNumber);
    }

    @Then("[Sub Admin] User enter the email address {string}")
    public void subAdminUserEnterTheEmailAddress(String email) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        SubAdminPages.get_Email().sendKeys(email+randomInt+"@mailinator.com");
    }

    @And("[Sub Admin] User enter the password {string}")
    public void subAdminUserEnterThePassword(String password) {
        SubAdminPages.get_Password().sendKeys(password);
    }

    @Then("[Sub Admin] Use enter the phone no {string}")
    public void subAdminUseEnterThePhoneNo(String phone) throws InterruptedException {
        long first11 = (long) (Math.random() * 10000000000L);
        SubAdminPages.get_Phone().sendKeys(first11+phone);

    }

    @And("[Sub Admin] User select the Role {string}")
    public void subAdminUserSelectTheRole(String role) {
        SubAdminPages.get_Role().click();
        SubAdminPages.get_Role_Select(role).click();
    }

    @Then("[Sub Admin] Use tap on the Add sub admin")
    public void subAdminUseTapOnTheAddSubAdmin() {
        SubAdminPages.get_Add_Sub_Admin().click();
    }

    @Then("[Sub Admin] User tap the role manage access {string}")
    public void subAdminUserTapTheRoleManageAccess(String role) throws InterruptedException {
        SubAdminPages.get_Manage_Access(role).click();

    }

    @And("[Sub Admin] User tap on the submit button")
    public void subAdminUserTapOnTheSubmitButton() throws InterruptedException {
        SubAdminPages.get_Submit().click();
        Thread.sleep(10000);

    }

    @And("[Sub Admin] User should validate the error message on the email {string}")
    public void subAdminUserShouldValidateTheErrorMessageOnTheEmail(String emailerror) {
        String actual = SubAdminPages.get_Error_Email(emailerror).getText();
        Assert.assertEquals(emailerror,actual);
    }


}


