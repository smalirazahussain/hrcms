package Step_Definitions;

import Pages.Android.AdminPage;
import Pages.Android.RequestPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.net.MalformedURLException;
import java.sql.SQLOutput;

import static Hooks.Base_Class.driver;
import static Pages.Android.AdminPage.Approval_Ok;
import static Pages.Android.AdminPage.View;
import static Pages.Android.LoginPage.Enter_Email_Id;
import static Pages.Android.RequestPage.Mol_Num;
import static Pages.Android.UpdateProliePage.*;
import static Step_Definitions.AddEmployerSteps.EmpMol;
import static Step_Definitions.AddEmployerSteps.Passportno;
import static Tests.Current_Date.currentMonth;

public class Requeststeps {

    public WebDriverWait wait = new WebDriverWait(driver, 30);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    @And("[Request Page] User tap on the request button")
    public void requestPageUserTapOnTheRequestButton() {
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

        if(EmpMol == RequestPage.get_Mol_Num().getText()
        && RequestPage.get_Passport_No().getText().equals(Passportno));{
           AdminPage.get_Approve_Button().click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Approval_Ok)));
           AdminPage.get_Approval_Ok().click();
        }
        System.out.println(EmpMol+Mol_Num+Passportno);
    }
}


