package Pages.MasterAdmin;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Pages.Android.AdminPage.Approve_Button;


public class MasterAdminDashboardPage {
    public static String Approval_Success_Toast = "";
    public static String Onboard_Approvals_Employer_Name = "tbody tr:nth-child(2) td:nth-child(2)";
    public static String Onboard_Approvals_Approval_Status = "tbody tr:nth-child(2) td:nth-child(8)";
    public static String Onboard_Approvals_Button = "#onboardApprovals";


    public static WebElement get_Onboard_Approvals_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Onboard_Approvals_Button));
    }

    public static WebElement get_Approve_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Approve_Button));
    }

    public static WebElement get_Approval_Success_Toast() {

        return Base_Class.driver.findElement(By.cssSelector(Approval_Success_Toast));
    }

    public static WebElement get_Onboard_Approvals_Employer_Name() {
        return Base_Class.driver.findElement(By.cssSelector(Onboard_Approvals_Employer_Name));
    }

    public static WebElement get_Onboard_Approvals_Approval_Status() {
        return Base_Class.driver.findElement(By.cssSelector(Onboard_Approvals_Approval_Status));
    }
}

