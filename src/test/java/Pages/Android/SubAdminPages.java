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
    public static String Sub_Admin_Employee_Eye_Button = "svg[class='c-icon large']";


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
}