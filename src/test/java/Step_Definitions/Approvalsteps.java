package Step_Definitions;

import Pages.Android.AdminPage;
import Pages.Android.ApprovalPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.net.MalformedURLException;

import static Hooks.Base_Class.driver;
import static Pages.Android.AdminPage.admin_Tab;
import static Pages.Android.ApprovalPage.*;
import static Pages.Android.UpdateProliePage.*;
import static Tests.Current_Date.currentMonth;

public class Approvalsteps {

    public WebDriverWait wait = new WebDriverWait(driver, 30);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    @Then("[Approval Page] User tap on approval")
    public void approvalPageUserTapOnApproval() throws InterruptedException {
        ApprovalPage.get_Approval().click();
        Thread.sleep(10000);

    }

    @And("[Approval Page] User create a new company and also approve by admin {string}")
    public void approvalPageUserCearteANewCompanyAndAlsoApproveByAdmin(String arg0) throws InterruptedException {

        for (int i=0; i<get_accept().size(); i++)
        {
            int index = 0;
            String approval_id = get_accept().get(i).getText();
            if(approval_id == arg0){
                index = i;
                System.out.println(index);
                get_approve_index(index).click();
                break;}
        }


        Thread.sleep(10000);

    }
}


