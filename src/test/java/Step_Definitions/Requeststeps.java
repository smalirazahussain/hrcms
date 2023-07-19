package Step_Definitions;

import Pages.Android.AdminPage;
import Pages.Android.RequestPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Pages.Android.AdminPage.*;
import static Pages.Android.RequestPage.Mol_Num;
import static Step_Definitions.AddEmployerSteps.EmpMol;
import static Step_Definitions.AddEmployerSteps.Passportno;
import static Step_Definitions.UpdateProfile.first14;

public class Requeststeps {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    @And("[Request Page] User tap on the request button")
    public void requestPageUserTapOnTheRequestButton() throws InterruptedException {
        RequestPage.get_Request().click();

    }

    @Then("[Request Page] User tap on the view button")
    public void requestPageUserTapOnTheViewButton() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(View)));
        Thread.sleep(10000);
        RequestPage.get_View().click();
    }

    @And("[Request Page] User verify the mol and passport no and then click the approve button")
    public void requestPageUserVerifyTheMolAndPassportNoAndThenClickTheApproveButton() throws InterruptedException {

        if (EmpMol == RequestPage.get_Mol_Num().getText()
                && RequestPage.get_Passport_No().getText().equals(Passportno)) ;
        {
            AdminPage.get_Approve_Button().click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Approval_Ok)));
            AdminPage.get_Approval_Ok().click();
        }
        System.out.println(EmpMol + Mol_Num + Passportno);
    }

    @And("[Request Page] User verify the establishment id and then click the approval button")
    public void requestPageUserVerifyTheEstablishmentIdAndThenClickTheApprovalButton() throws InterruptedException {
        if (first14 == Long.parseLong(RequestPage.get_Admin_Est_id().getText())) {
        }
        AdminPage.get_Approve_Button().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Approval_Ok)));
        AdminPage.get_Approval_Ok().click();

    }

    @And("[Request Page] User verify the establishment id in employer and then click the approval button")
    public void requestPageUserVerifyTheEstablishmentIdInEmployerAndThenClickTheApprovalButton() throws InterruptedException {
        if (first14 == Long.parseLong(RequestPage.get_Est_id().getText()))
        {
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Approve_Button)));
        AdminPage.get_Approve_Button().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Approval_Ok)));
        AdminPage.get_Approval_Ok().click();
        Thread.sleep(3000);
    }

    @And("[Request Page] User tap on the Approve button")
    public void requestPageUserTapOnTheApproveButton() throws InterruptedException {
        AdminPage.get_Approve_Button().click();
        Thread.sleep(5000);
        AdminPage.get_Approval_Ok().click();;
        Thread.sleep(5000);
    }
}




