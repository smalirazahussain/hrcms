package Pages.MasterAdmin;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Pages.Android.AdminPage.Admin_Employer_Button;
import static Pages.Android.UpdateProliePage.Free_Zone;


public class MasterAdminEmployerPage {

    public static String Master_Add_Employer_Button = "button[title='Add Employer']";
    public static String Master_Admin_State = "div[name='state'] .ant-select-selector";
    public static String Master_Admin_State_input = "#state";
    public static String Trade_License_Issue_Date = "#issueDate0";
    public static String Trade_License_Expiry_Date = "#expiryDate0";
    public static String Trade_License_Number = "#documentNumber0";
    public static String Trade_License_Upload_Input = "input[type='file']";
    public static String Sponsor_Document_Issue_Date = "#issueDate1";
    public static String Sponsor_Document_Expiry_Date = "#expiryDate1";
    public static String Sponsor_Document_Upload_Input = "input[type='file']";
    public static String Sponsor_Document_Number = "#documentNumber1";
    public static String Success_Toast_Message = "";
    public static String Company_Address_Input_Field = "#address";
    public static String Zip_Code = "#zipCode";
    public static WebElement get_Admin_Employer_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Admin_Employer_Button));
    }

    public static WebElement get_Master_Add_Employer_Button() {

        return Base_Class.driver.findElement(By.cssSelector(Master_Add_Employer_Button));
    }

    public static WebElement get_Master_Admin_State() {

        return Base_Class.driver.findElement(By.cssSelector(Master_Admin_State));
    }

    public static WebElement get_Master_Admin_State_input() {

        return Base_Class.driver.findElement(By.cssSelector(Master_Admin_State_input));
    }

    public static WebElement get_Free_Zone() {
        return Base_Class.driver.findElement(By.cssSelector(Free_Zone));
    }

    public static WebElement get_Trade_License_Issue_Date() {
        return Base_Class.driver.findElement(By.cssSelector(Trade_License_Issue_Date));
    }

    public static WebElement get_Trade_License_Expiry_Date() {
        return Base_Class.driver.findElement(By.cssSelector(Trade_License_Expiry_Date));
    }

    public static WebElement get_Trade_License_Number() {
        return Base_Class.driver.findElement(By.cssSelector(Trade_License_Number));
    }

    public static WebElement get_Trade_License_Upload_Input() {
        return Base_Class.driver.findElement(By.cssSelector(Trade_License_Upload_Input));
    }

    public static WebElement get_Sponsor_Document_Issue_Date() {
        return Base_Class.driver.findElement(By.cssSelector(Sponsor_Document_Issue_Date));
    }

    public static WebElement get_Sponsor_Document_Expiry_Date() {
        return Base_Class.driver.findElement(By.cssSelector(Sponsor_Document_Expiry_Date));
    }

    public static WebElement get_Sponsor_Document_Upload_Input() {
        return Base_Class.driver.findElement(By.cssSelector(Sponsor_Document_Upload_Input));
    }

    public static WebElement get_Sponsor_Document_Number() {
        return Base_Class.driver.findElement(By.cssSelector(Sponsor_Document_Number));
    }

    public static WebElement get_Success_Toast_Message() {
        return Base_Class.driver.findElement(By.xpath(Success_Toast_Message));
    }

    public static WebElement get_Company_Address_Input_Field() {
        return Base_Class.driver.findElement(By.cssSelector(Company_Address_Input_Field));
    }

    public static WebElement get_Zip_Code() {
        return Base_Class.driver.findElement(By.cssSelector(Zip_Code));
    }
}
