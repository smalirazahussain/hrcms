package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AdminPage {


    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);

    //locator
    public static String admin_Tab = "//div[@class='body-container scroll-y']";
    public static String Login = "button[title='Login']";
    public static String Admin_Email = "#email";
    public static String Admin_Password = "#password";
    public static String Onboard_Approvals = "#onboardApprovals";
    //public static String Approve_Button = "div[role='dialog'] button[title='Approve']";
    public static String Approve_Button ="//div[contains(@class,'btn-group')]//button[contains(@title,'Approve')]";
    public static String Establishmentid = "ul:nth-child(1) li:nth-child(2) span:nth-child(2)";
    public static String View = "button[title='View']:nth-child(1)";
    public static String company_Name = "//body//div//ul[2]";
    public static String Trade_No = "//body//div//ul[2]";
    public static String Approval_Ok = "//span[normalize-space()='OK']";
    public static String Client_Approval = "#approval";
    public static String Company_Client = "(//input[@id=\"client\"])[2]";
    public static String Action_Successfully = "//span[normalize-space()='Action Successfully']";
    public static String Admin_Approval_Ok = "//button[@class='ant-btn css-dev-only-do-not-override-1vtf12y ant-btn-primary ant-btn-sm']";

    public static String Browse_Button = "div:nth-child(4) > button:nth-child(2)";

    public static String Card_Tpye(String card) {
        return "//span[@title='"+card+"']";
    }
    public static String  Approve_Bulk_Button = "//div[contains(@class,'ant-drawer-body')]//button[contains(@title,'Approve')]";
    public static String Card_Button = "#cardType";
    public static String  ExchangeHouseClientButton = " label:nth-child(2)";
    public static String No_Other_Bank_Employees = "isOtherBankEmployees";
    public static String message = "//*[@text='Action Successfully']";
    public static String ExchangeHouse_Client_Approvals_Button = "//a[@id='exchangeHouseApproval']";
    public static String Admin_Branch_Name = "(//input[@type='search'])[2]";
    public static String Exchange_House_Browse_Button = "button.ant-btn#uploadExcel.primary-outline-filled[title='Browse File'";
    public static String admin_Client_Salary = "div:first-child > ul:first-child > li:nth-child(32) > span:nth-child(2)";
    public static  String Admin_Employer_Button = "#employer";
    public static  String Admin_Add_Employer_Button = "button[title='Add Employer']";
    public static String Admin_Company_Name = "input[placeholder='Search']";
    public static String Upload_EOS_Button = "div:nth-child(4) button:nth-child(1) span:nth-child(2)";
    public static String Eos_Template = "button[title='EOS Template']";
    public static String Select_Exchange_House = "client";
    private static String Admin_Bank_Name(String randomBankName) {
        return "//span[text()='"+randomBankName+"']";
    }
    public static WebElement get_Admin_Tab(){
        return Base_Class.driver.findElement(By.xpath(admin_Tab));
    }

    public static WebElement get_Login() {

        return Base_Class.driver.findElement(By.cssSelector(Login));

    }



    public static WebElement get_Email() {

        return Base_Class.driver.findElement(By.cssSelector(Admin_Email));
    }

    public static WebElement get_Password() {
        return Base_Class.driver.findElement(By.cssSelector(Admin_Password));
    }

    public static WebElement get_Onboard_Approvals() {
        return Base_Class.driver.findElement(By.cssSelector(Onboard_Approvals));
    }

    public static WebElement get_Approve_Button() {
        return Base_Class.driver.findElement(By.xpath(Approve_Button));
    }
    public static WebElement get_Establishmentid() {
        return Base_Class.driver.findElement(By.cssSelector(Establishmentid));
    }

    public static WebElement get_View() {

        return Base_Class.driver.findElement(By.cssSelector(View));
    }

    public static WebElement get_company_Name() {
        return Base_Class.driver.findElement(By.xpath(company_Name));
    }

    public static WebElement get_Trade_No() {
        return Base_Class.driver.findElement(By.xpath(Trade_No));
    }

    public static WebElement get_Sponsor_No() {
        String Sponsor_No = "/html/body/div[2]/div/div[3]/div/div/div[2]/div[1]/ul[1]/li[17]";
        return Base_Class.driver.findElement(By.xpath(Sponsor_No));
    }

    public static WebElement get_Approval_Ok() {

        return Base_Class.driver.findElement(By.xpath(Approval_Ok));
    }

    public static WebElement get_Client_Approval() {
        return Base_Class.driver.findElement(By.cssSelector(Client_Approval));
    }

    public static WebElement get_Company_Client() {
        return Base_Class.driver.findElement(By.xpath(Company_Client));
    }

    public static WebElement get_Action_Successfully() {
        return Base_Class.driver.findElement(By.xpath(Action_Successfully));
    }

    public static WebElement get_Admin_Approval_Ok() {
        return Base_Class.driver.findElement(By.xpath(Admin_Approval_Ok));
    }

    public static WebElement get_Browse_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Browse_Button));
    }

    public static WebElement get_Card_Tpye(String Card) {
        return Base_Class.driver.findElement(By.xpath(Card_Tpye(Card)));
    }

    public static WebElement get_Approve_Bulk_Button() {

        return Base_Class.driver.findElement(By.xpath(Approve_Bulk_Button));
    }

    public static WebElement get_Card_Button() {

        return Base_Class.driver.findElement(By.cssSelector(Card_Button));
    }

    public static WebElement get_ExchangeHouseClientButton() {

        return Base_Class.driver.findElement(By.cssSelector(ExchangeHouseClientButton));
    }

    public static WebElement get_Select_Exchange_House() {

        return Base_Class.driver.findElement(By.id(Select_Exchange_House));
    }

    public static WebElement get_No_Other_Bank_Employees() {
        return Base_Class.driver.findElement(By.id(No_Other_Bank_Employees));
    }

    public static WebElement get_message() {
        return Base_Class.driver.findElement(By.xpath(message));
    }

    public static WebElement get_ExchangeHouse_Client_Approvals_Button() {

        return Base_Class.driver.findElement(By.xpath(ExchangeHouse_Client_Approvals_Button));
    }

    public static WebElement get_Admin_Branch_Name() {
        return Base_Class.driver.findElement(By.xpath(Admin_Branch_Name));
    }

    public static WebElement get_Exchange_House_Browse_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Exchange_House_Browse_Button));
    }

    public static WebElement get_admin_Client_Salary() {
        return Base_Class.driver.findElement(By.cssSelector(admin_Client_Salary));
    }

    public static WebElement get_Admin_Employer_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Admin_Employer_Button));
    }

    public static WebElement get_Admin_Add_Employer_Button() {

        return Base_Class.driver.findElement(By.cssSelector(Admin_Add_Employer_Button));
    }

    public static WebElement get_Admin_Company_Name() {

        return Base_Class.driver.findElement(By.cssSelector(Admin_Company_Name));
    }

    public static WebElement get_Upload_EOS_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Upload_EOS_Button));
    }

    public static WebElement get_Eos_Template() {
        return Base_Class.driver.findElement(By.cssSelector(Eos_Template));
    }

    public static WebElement get_Admin_Bank_Name(String randomBankName) {
        return Base_Class.driver.findElement(By.xpath(Admin_Bank_Name(randomBankName)));
    }


}
