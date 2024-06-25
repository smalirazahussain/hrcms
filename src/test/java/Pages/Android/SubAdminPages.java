package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class SubAdminPages {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //locator
    public static String Sub_Admin_Button = "#user";
    public static String Add_Admin_BUtton= "//button[@title='Add Team Member']";
    public static String Name = "#name";
    public static String Email = "#email";
    public static String Password = "#password";
    public static String Phone = "#phone";
    public static String Role = "span[title='Select Role']";
    public static String Role_Select(String role){
        return "div[title='"+role+"']";
    }
    public static String Manage_Access(String role){
        return "input[value='"+role+"']";
    }
    public static String Add_Sub_Admin = "button[title='Add Team Member'][type='submit']";
    public static String Submit = "button[type='submit']";
    public static String Confirm_Password ="confirmPassword";
    public static String User_Manage_Access = "//h1[text()='Manage Access']";
    public static String All_Check_Boxes="input.ant-checkbox-input";
    public static String Team_Member_Search = "input[placeholder=\"Search\"]";
    public static  String Manage_Access_Button = "button[title=\"Manage Access\"]";
    public static String Module_List = ".form-container > .c-section > .list > .list-item  > .text.flex02";
    public static String Error_Email(String error){
        return "//div[normalize-space()='"+error+"']";
    }
    public static String I_Am_Not_The_Primary_User ="div:nth-child(1) > p";
    public static String Login_Company_Id = "#userId";
    public static String Team_Member_Module_List = ".side-menu-list-item";
    public static String Employees_Creations = "#add-appointment-form_EMPLOYEES > label";
    public static String Employee_Module="div:nth-child(3) >ul >li >div:nth-child(1)";
    public static String Employee_Active_Status = "span[class='ant-tag ant-tag-green']";
    public static String Sub_Admin_Employee_Eye_Button = "tr:nth-child(2) > td:nth-child(2) div svg";
    public static String Is_User_Active_Drop_Down = "tr th:nth-child(5) div span:nth-child(2)";
    public static String Active_Button = "input[value='ACTIVE']";
    public static String Search_Button = "(//button[@title='Search'])[1]";
    public static String Deactivate_Button = "button[title=Deactivate]";
    public static String Employee_Creations ="#add-appointment-form_EMPLOYEE > label";
    public static String Deactivate_Message ="";
    public static String Is_User_Active_Search_Button =" (//button[@title='Search'])[2]";
    public static String Edit_Phone_Number ="button[title='Edit Phone Number']";
    public static String Updated_Phone_No = "li:nth-child(7) li:nth-child(1) span:nth-child(2)";
    public static String Edit_Mol_Est_Id = "button[title='Edit Mol/Est Id']";
    public static String Employee_Mol_No = "molNo";
    public static String Employer_Establishment_Id = "#establishmentId";
    public static String Sub_Search_Button = ".search-view input.ant-input";



    public static WebElement get_Sub_Admin_Button(){
        return Base_Class.driver.findElement(By.cssSelector(Sub_Admin_Button));
    }
    public static WebElement get_Add_Admin_Button(){
        return Base_Class.driver.findElement(By.xpath(Add_Admin_BUtton));
    }
    public static WebElement get_Name(){
        return Base_Class.driver.findElement(By.cssSelector(Name));
    }
    public static WebElement get_Email(){
        return Base_Class.driver.findElement(By.cssSelector(Email));
    }
    public static WebElement get_Password(){
        return Base_Class.driver.findElement(By.cssSelector(Password));
    }
    public static WebElement get_Phone(){
        return Base_Class.driver.findElement(By.cssSelector(Phone));
    }
    public static WebElement get_Role(){
        return Base_Class.driver.findElement(By.cssSelector(Role));
    }
    public static WebElement get_Role_Select(String role){
        return Base_Class.driver.findElement(By.cssSelector(Role_Select(role)));
    }
    public static WebElement get_Add_Sub_Admin(){
        return Base_Class.driver.findElement(By.cssSelector(Add_Sub_Admin));
    }
    public static WebElement get_Manage_Access(String role){
        return Base_Class.driver.findElement(By.cssSelector(Manage_Access(role)));
    }
    public static WebElement get_Submit(){
        return Base_Class.driver.findElement(By.cssSelector(Submit));
    }

    public static WebElement get_Error_Email(String error) {
        return Base_Class.driver.findElement(By.xpath(Error_Email(error)));
    }

    public static WebElement get_Confirm_Password() {
        return Base_Class.driver.findElement(By.name(Confirm_Password));
    }

    public static WebElement get_User_Manage_Access() {
        return Base_Class.driver.findElement(By.xpath(User_Manage_Access));
    }

    public static List<WebElement> get_All_Check_Boxes() {
        return Base_Class.driver.findElements(By.cssSelector(All_Check_Boxes));
    }

    public static WebElement get_Team_Member_Search() {
        return Base_Class.driver.findElement(By.cssSelector(Team_Member_Search));
    }

    public static WebElement get_Manage_Access_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Manage_Access_Button));
    }

    public static List<WebElement> get_Module_List() {
        return Base_Class.driver.findElements(By.cssSelector(Module_List));
    }

    public static WebElement get_I_Am_Not_The_Primary_User() {
        return Base_Class.driver.findElement(By.cssSelector(I_Am_Not_The_Primary_User));
    }

    public static WebElement get_Login_Company_Id() {
        return Base_Class.driver.findElement(By.cssSelector(Login_Company_Id));
    }

    public static List<WebElement> get_Team_Member_Module_List() {
        return Base_Class.driver.findElements(By.cssSelector(Team_Member_Module_List));
    }

    public static List<WebElement> get_Employees_Creations() {
        return Base_Class.driver.findElements(By.cssSelector(Employees_Creations));
    }

    public static WebElement get_Employee_Module() {
        return Base_Class.driver.findElement(By.cssSelector(Employee_Module));
    }
    public static  List<WebElement> get_Employee_Active_Status() {
        return  Base_Class.driver.findElements(By.cssSelector(Employee_Active_Status));

    }

    public static WebElement get_Employee_Eye_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Sub_Admin_Employee_Eye_Button));
    }

    public static WebElement get_Is_User_Active_Drop_Down() {
        return Base_Class.driver.findElement(By.cssSelector(Is_User_Active_Drop_Down));
    }

    public static WebElement get_Active_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Active_Button));
    }

    public static WebElement get_Search_Button() {
        return Base_Class.driver.findElement(By.xpath(Search_Button));
    }

    public static WebElement get_Deactivate_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Deactivate_Button));
    }

    public static List<WebElement> get_Employee_Creations() {
        return Base_Class.driver.findElements(By.cssSelector(Employee_Creations));
    }

    public static WebElement get_Deactivate_Message() {
        return Base_Class.driver.findElement(By.cssSelector(Deactivate_Message));
    }

    public static WebElement get_Is_User_Active_Search_Button() {
        return Base_Class.driver.findElement(By.xpath(Is_User_Active_Search_Button));
    }

    public static WebElement get_Edit_Phone_Number() {
        return Base_Class.driver.findElement(By.cssSelector(Edit_Phone_Number));
    }

    public static WebElement get_Updated_Phone_No() {
        return Base_Class.driver.findElement(By.cssSelector(Updated_Phone_No));
    }

    public static WebElement get_Edit_Mol_Est_Id() {
        return Base_Class.driver.findElement(By.cssSelector(Edit_Mol_Est_Id));
    }

    public static WebElement get_Employee_Mol_No() {
        return Base_Class.driver.findElement(By.id(Employee_Mol_No));
    }

    public static WebElement get_Employer_Establishment_Id() {
        return Base_Class.driver.findElement(By.cssSelector(Employer_Establishment_Id));
    }

    public static WebElement get_Sub_Search_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Sub_Search_Button));
    }
}