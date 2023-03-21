package Pages.Android;

import Hooks.Base_Class;
import org.codehaus.jackson.map.MapperConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.management.Notification;
import java.awt.*;
import java.util.BitSet;

import static Pages.Android.UpdateProliePage.*;
import static Pages.Android.UpdateProliePage.document;


public class AddEmployerPages {

    private WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, 30);


    //locator
    public static String Add_New_Emplyer = "button[title='Add Employee'] span:nth-child(1)";
    public static String First_Name = "//input[@placeholder='First Name']";
    public static String Middle_Name = "#middleName";
    public static String Last_Name = "#lastName";
    public static String Display_Name = "//input[@placeholder='Display Name']";
    public static String Gender_Field = "span[title='Gender']";

    public static String get_date(String date) {
        return "(//div[@class='ant-picker-cell-inner'][normalize-space()='" + date + "'])[3]";
    }

    public static String Mobile_No = "mobileNo";
    public static String Alternate_Mobile_no = "altMobileNo";
    public static String Add_Employer_Button = "button[title='Add Employee']";


    public static String Gender(String gender) {
        return "//div[contains(text(),'" + gender + "')]";
    }

    public static String Date_Of_Birth = "dob";
    public static String Pass_Port_no = "passportNumber";

    public static String Country(String country) {
        return "//div[contains(text(),'"+country+"')]";
    }

    public static String Nationality = "#nationality";
    public static String Mol_No = "molNo";
    public static String Emp_Code = "empCode";
    public static String Date_Of_Joining = "doj";
    public static String first_Name_Error = ".error";
    public static String year_arrow_xpath = "(//*[@class='ant-picker-header-super-prev-btn'])[3]";
    public static String Branch_Name= "#branchName";
    public static String Iban = "#iban";
    public static String Add_Employer_Successfully = "div[class='ant-message'] span:nth-child(2)";
    public static String Select_COuntry = "(//*[@class='ant-select ant-select-single ant-select-show-arrow ant-select-show-search'])[2]";
    public static String Eid_No = "#eid";

    public static WebElement get_Add_New_Emplyer() {
        return Base_Class.driver.findElement(By.cssSelector(Add_New_Emplyer));
    }

    public static WebElement get_First_name() {
        return Base_Class.driver.findElement(By.xpath(First_Name));
    }

    public static WebElement get_Middle_name() {
        return Base_Class.driver.findElement(By.cssSelector(Middle_Name));
    }

    public static WebElement get_Last_Name() {
        return Base_Class.driver.findElement(By.cssSelector(Last_Name));
    }

    public static WebElement get_Display_Name() {
        return Base_Class.driver.findElement(By.xpath(Display_Name));
    }

    public static WebElement get_Gender_Field() {
        return Base_Class.driver.findElement(By.cssSelector(Gender_Field));
    }

    public static WebElement get_Gender(String gender) {
        return Base_Class.driver.findElement(By.xpath(Gender(gender)));
    }

    public static WebElement get_Date_Of_Birth() {
        return Base_Class.driver.findElement(By.id(Date_Of_Birth));
    }

    public static WebElement get_Pass_Port_no() {
        return Base_Class.driver.findElement(By.id(Pass_Port_no));
    }

    public static String date_select(String date) {
        return "(//div[@class='ant-picker-cell-inner'][normalize-space()='" + date + "'])[3]";
    }

    public static String expYearArrow = "(//button[@class='ant-picker-header-super-next-btn'])[4]";

    public static String expire_date_select(String date) {
        return "(//div[@class='ant-picker-cell-inner'][normalize-space()='" + date + "'])[4]";
    }
    public static String Error_Xpath(String error){
        return "//div[normalize-space()='"+error+"']";
    }
    public static String Document(String document){
        return "div[title='"+document+"']";
    }
    public static String Document_Name = "documentTitle0";
    public static String BankDetails = "span[title='Employee Type']";
    public static String Select_Bank(String bank){
        return "div[title='"+bank+"'] ";
    }
    public static String Bank = "#bankName";
    public static String Eye = "(//*[@class='c-icon large'])[1]";
    public static String Validation(String valid){
        return "//span[normalize-space()='"+valid+"']";
    }
    private static String Valid_Bank(String bank) {
        return "//span[normalize-space()='"+bank+"']";
    }
    public static String Passport_month_select(String current_month) {
        return "//button[normalize-space()='"+ current_month +"']";
    }
    public static String PassPort_no = "#documentNumber0";
    public static String Company_Tittle = "div[class='user-detail'] h3";
    public static String Establishment_Id = "#establishmentId";

    public static String Card_Type(String card) {
        return "//div[contains(text(),'"+card+"')]";
    }
    public static String Card = "span[title='Card Type']";
    public static String Notification_Message = "//span[contains(text(),'New employee added successfully, Please wait for a')]";
    public static String  Add_Document = "div[class='inline-form col'] button:nth-child(1) span:nth-child(2)";
    public static String Check = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[1]/div/div[2]/div/ul/li[3]/span[2]";

    public static WebElement get_Country(String country) {
        return Base_Class.driver.findElement(By.xpath(Country(country)));
    }

    public static WebElement get_Nationality() {
        return Base_Class.driver.findElement(By.cssSelector(Nationality));
    }

    public static WebElement get_Mol_No() {
        return Base_Class.driver.findElement(By.id(Mol_No));
    }

    public static WebElement get_Emp_Code() {
        return Base_Class.driver.findElement(By.id(Emp_Code));
    }

    public static WebElement get_Date_Of_Joining() {
        return Base_Class.driver.findElement(By.id(Date_Of_Joining));
    }

    public static WebElement get_date_of_joining_select(String date) {
        return Base_Class.driver.findElement(By.xpath(get_date(date)));
    }

    public static WebElement get_Mobile_No() {
        return Base_Class.driver.findElement(By.id(Mobile_No));
    }

    public static WebElement get_Alternate_Mobile_No() {
        return Base_Class.driver.findElement(By.id(Alternate_Mobile_no));
    }

    public static WebElement get_Add_Emplyer_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Add_Employer_Button));
    }

    /*  public static WebElement get_Employee_Already_Exsist(){
          return Base_Class.driver.findElement(By.cssSelector());
      */
    public static WebElement get_first_Name_Error() {
        return Base_Class.driver.findElement(By.cssSelector(first_Name_Error));
    }

    public static WebElement get_add_employer_year_arrow_xpath() {
        return Base_Class.driver.findElement(By.xpath(year_arrow_xpath));
    }

    public static WebElement get_issue_Add_Employer_date_select(String date) {
        return Base_Class.driver.findElement(By.xpath(date_select(date)));
    }

    public static WebElement getAddEmployerExpYearArrow() {
        return Base_Class.driver.findElement(By.xpath(expYearArrow));
    }

    public static WebElement get_Add_Employer_Expire_Date_Select(String date) {
        return Base_Class.driver.findElement(By.xpath(expire_date_select(date)));
    }
    public static WebElement getError(String error){
        return Base_Class.driver.findElement(By.xpath(Error_Xpath(error)));
    }
    public static WebElement get_Document(String document){
        return Base_Class.driver.findElement(By.cssSelector(Document(document)));
    }
    public static WebElement get_Document_Feild(){
        return Base_Class.driver.findElement(By.name(Document_Name));
    }

    public static WebElement get_BankDetails() {

        return Base_Class.driver.findElement(By.cssSelector(BankDetails));

    }

    public static WebElement get_Select_Bank(String bank) {
        return Base_Class.driver.findElement(By.cssSelector(Select_Bank(bank)));

    }

    public static WebElement get_Bank() {
        return Base_Class.driver.findElement(By.cssSelector(Bank));
    }

    public static WebElement get_Branch_Name() {

        return Base_Class.driver.findElement(By.cssSelector(Branch_Name));
    }

    public static WebElement get_Iban() {
        return Base_Class.driver.findElement(By.cssSelector(Iban));
    }

    public static WebElement get_Add_Employee_Successfully() {
        return Base_Class.driver.findElement(By.cssSelector(Add_Employer_Successfully));
    }

    public static WebElement get_Select_Country() {
        return Base_Class.driver.findElement(By.xpath(Select_COuntry));
    }

    public static WebElement get_Eid_No() {
        return Base_Class.driver.findElement(By.cssSelector(Eid_No));
    }

    public static WebElement get_Eye() {

        return Base_Class.driver.findElement(By.xpath(Eye));
    }


    public static WebElement get_Validate(String save_mol) {
        return Base_Class.driver.findElement(By.xpath(Validation(save_mol)));
    }

    public static WebElement get_Valid_Bank(String bank) {
        return Base_Class.driver.findElement(By.xpath(Valid_Bank(bank)));
    }


    public static WebElement get_Check() {

        return Base_Class.driver.findElement(By.xpath(Check));
    }


    public static WebElement get_Passport_month_select(String current_month) {
        return Base_Class.driver.findElement(By.xpath(Passport_month_select(current_month)));
    }


    public static WebElement get_PassPort_no() {

        return Base_Class.driver.findElement(By.cssSelector(PassPort_no));
    }

    public static WebElement  get_Company_Tittle() {
        return Base_Class.driver.findElement(By.cssSelector(Company_Tittle));
    }

    public static WebElement get_Establishment_Id() {
        return Base_Class.driver.findElement(By.cssSelector(Establishment_Id));
    }

    public static WebElement get_Card_Type(String card) {
        return Base_Class.driver.findElement(By.xpath(Card_Type(card)));
    }

    public static WebElement get_Card() {
        return Base_Class.driver.findElement(By.cssSelector(Card));
    }

    public static WebElement get_Notification_Message() {
        return Base_Class.driver.findElement(By.xpath(Notification_Message));
    }

    public static WebElement get_Add_Document() {
        return Base_Class.driver.findElement(By.cssSelector(Add_Document));
    }

    public static WebElement get_Error_Msg_Emp(String error) {
        return Base_Class.driver.findElement(By.xpath(Error_Msg_Emp(error)));
    }

    public static String Error_Msg_Emp(String error) {
        return "//div[normalize-space()='"+error+"']";
    }
}