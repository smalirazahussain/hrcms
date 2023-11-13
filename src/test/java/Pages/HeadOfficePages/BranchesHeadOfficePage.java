package Pages.HeadOfficePages;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Pages.Android.EmployeesPage.Employee_Eye_Button;


public class BranchesHeadOfficePage {


    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    //locator
    public static String create_Account_Button = "//*[@text='Create account']";
    public static String Add_Button = "div[class='d-flex gap-20 w-100 justify-end'] button:nth-child(1) span:nth-child(2)";
    public static String Branch = "companyName";
    public static String Branch_Location = "location";
    public static String Branch_Email = "email";
    public static String Branch_Password = "password";
    public static String Branch_Confirm_Password = "confirmPassword";
    public static String Branch_Phone_No = "input[placeholder='Phone Number']";
    public static String Add_Branch_Button = "button[title='Add Branch'][type='submit']";
    public static String Toast_message = "//span[contains(text(),'Branch has been created and has been sent for further approval.')]";
    public static String Search_Branch = "input[placeholder=\"Search Branch\"]";
    public static String View_Employees = "button[title=\"View Employees\"]";
    public static String Statemnet_Request ="button[title=\"Statement Request\"]";
    public static String Statement_Message = "div.ant-popconfirm-title";
    public static String Continue_Button = "button.ant-btn.css-1wazalj.ant-btn-primary.ant-btn-sm";
    public static String Top_Up_Message = "//span[text()=\"Approval is processed for further actions\"]";
    public static String Statement_Message_Already_Submitted = ".ant-message-custom-content.ant-message-error";
    public static String Branch_Search = "input.ant-select-selection-search-input[role='combobox'][id='branch']";


    //return function

    public static WebElement get_create_Account_Button() {
        return Base_Class.driver.findElement(By.xpath(create_Account_Button));
    }


    public static WebElement get_Add_Branch() {

        return Base_Class.driver.findElement(By.cssSelector(Add_Button));
    }

    public static WebElement get_Branch_Name() {
        return Base_Class.driver.findElement(By.id(Branch));
    }

    public static WebElement get_Branch_Location() {

        return Base_Class.driver.findElement(By.id(Branch_Location));
    }

    public static WebElement get_Branch_Email() {
        return Base_Class.driver.findElement(By.id(Branch_Email));
    }

    public static WebElement get_Branch_Password() {
        return Base_Class.driver.findElement(By.id(Branch_Password));
    }

    public static WebElement get_Branch_Confirm_Password() {
        return Base_Class.driver.findElement(By.id(Branch_Confirm_Password));
    }

    public static WebElement get_Branch_Phone_No() {
        return Base_Class.driver.findElement(By.cssSelector(Branch_Phone_No));
    }

    public static WebElement get_Add_Branch_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Add_Branch_Button));
    }

    public static WebElement get_Toast_message() {
        return Base_Class.driver.findElement(By.xpath(Toast_message));
    }

    public static WebElement get_Search_Branch() {
        return Base_Class.driver.findElement(By.cssSelector(Search_Branch));
    }

    public static WebElement get_View_Employees() {
        return Base_Class.driver.findElement(By.cssSelector(View_Employees));
    }

    public static WebElement get_Eye_Button() {
        return  Base_Class.driver.findElement(By.xpath(Employee_Eye_Button));
    }

    public static WebElement get_Statemnet_Request() {

        return Base_Class.driver.findElement(By.cssSelector(Statemnet_Request));
    }

    public static WebElement get_Statement_Message() {

        return Base_Class.driver.findElement(By.cssSelector(Statement_Message));
    }

    public static WebElement get_Continue_Button() {

        return Base_Class.driver.findElement(By.cssSelector(Continue_Button));
    }

    public static WebElement get_Top_Up_Message() {
        return Base_Class.driver.findElement(By.xpath(Top_Up_Message));
    }

    public static WebElement get_Statement_Message_Already_Submitted() {
        return Base_Class.driver.findElement(By.cssSelector(Statement_Message_Already_Submitted));
    }

    public static WebElement get_Branch_Search() {
        return Base_Class.driver.findElement(By.cssSelector(Branch_Search));
    }
}
