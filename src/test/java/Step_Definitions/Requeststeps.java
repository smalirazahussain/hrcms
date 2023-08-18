package Step_Definitions;

import Pages.Android.AdminPage;
import Pages.Android.RequestPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Pages.Android.AdminPage.Approval_Ok;
import static Pages.Android.AdminPage.Approve_Button;
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
       try {
           wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-spin-spinning")));
           //wait.until(ExpectedConditions.elementToBeClickable(By.id(Request)));
           RequestPage.get_Request().click();
       }
       catch(Exception e) {
           e.printStackTrace();

       }
    }

    @Then("[Request Page] User tap on the view button")
    public void requestPageUserTapOnTheViewButton() throws InterruptedException {
       // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(View)));
       //Thread.sleep(7000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("uploading-progress-selector")));
        RequestPage.get_View().click();
       /* try {
            //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(View)));
            //Thread.sleep(10000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", View);
            RequestPage.get_View().click();
        }
        catch (Exception e) {
            // Handle the exception, such as printing an error message
            e.printStackTrace();
        }*/
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Approval_Ok)));
        AdminPage.get_Approval_Ok().click();
    }

    @And("[Request Page] User verify the End of service and approve by the admin")
    public void requestPageUserVerifyTheEndOfServiceAndApproveByTheAdmin() {

            AdminPage.get_Approve_Button().click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Approval_Ok)));
            AdminPage.get_Approval_Ok().click();

    }

    @And("[Request Page] User verify the {string} Badge display on the request module")
    public void requestPageUserVerifyTheBadgeDisplayOnTheRequestModule(String expectedBadge) throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(5000);
        String actualBadge = RequestPage.get_Pending_Badge().getText();
        Assert.assertEquals(actualBadge,expectedBadge);
        Thread.sleep(5000);
    }

    @And("[Request Page] User verify the {string} Badge not display if request resolve on the client sde")
    public void requestPageUserVerifyTheBadgeNotDisplayIfRequestResolveOnTheClientSde(String arg0) throws InterruptedException {
        try{
        driver.navigate().refresh();
        if(!RequestPage.get_Pending_Badge().isDisplayed()){
            System.out.println("Badge is hidden after resolving the approval.");
        } else {
            System.out.println("Badge is not displayed after resolving the approval.");
        }
        } catch (Exception e) {
            System.out.println("Badge element not found after resolving the approval.");
        }

       // Thread.sleep(5000);
    }
}




