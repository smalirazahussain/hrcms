package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.AdminPage;
import Pages.Android.SignUpPage;
import Pages.Android.SubAdminPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.*;

import static Hooks.Base_Class.driver;
import static Pages.Android.AdminPage.Company_Client;
import static Pages.Android.SignUpPage.signUpUserEnterTheEmail;
import static Pages.Android.SubAdminPages.*;
import static Step_Definitions.Employeessteps.companyID;
import static Step_Definitions.SignUpSteps.companyName;

public class SubAdminsteps {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    public static String companyTittle;
    @Given("[Sub Admin] User tap on the sub admin button")
    public void subAdminUserTapOnTheSubAdminButton() {
        companyTittle= AddEmployerPages.get_Company_Tittle().getText();
        companyID = AddEmployerPages.get_Company_Id().getText();
        String perfix = "Client ID: ";
        if (companyID.startsWith(perfix)) {
            companyID = companyID.substring(perfix.length()).trim(); // Remove prefix
        }
        System.out.println("Company ID:"+companyID);
        SubAdminPages.get_Sub_Admin_Button().click();
    }

    @Then("[Sub Admin] User tap on the add sub button")
    public void subAdminUserTapOnTheAddSubButton() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Add_Admin_BUtton)));
        SubAdminPages.get_Add_Admin_Button().click();


    }

    public static String Team_Member_Name;

    @When("[Sub Admin] User enter name {string}")
    public void subAdminUserEnterName(String name) throws InterruptedException {
        Random random = new Random();
        int randomNumber = random.nextInt(10000);
        SubAdminPages.get_Name().sendKeys(name + randomNumber);
        Team_Member_Name = name + randomNumber;
        System.out.println("Team Member Name:" + Team_Member_Name);
    }

    public static String userEmail;

    @Then("[Sub Admin] User enter the email address {string}")
    public void subAdminUserEnterTheEmailAddress(String email) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);
        SubAdminPages.get_Email().sendKeys(email + randomInt + "@mailinator.com");
        userEmail = email + randomInt + "@mailinator.com";
        System.out.println("User Email:" + userEmail);
    }

    public static String userPassword;

    @And("[Sub Admin] User enter the password {string}")
    public void subAdminUserEnterThePassword(String password) {
        SubAdminPages.get_Password().sendKeys(password);
        userPassword = password;
    }

    public static String userPhoneNo;

    @Then("[Sub Admin] Use enter the phone no {string}")
    public void subAdminUseEnterThePhoneNo(String phone) throws InterruptedException {
        long first11 = (long) (Math.random() * 10000000L);
        SubAdminPages.get_Phone().sendKeys(phone + first11);
        userPhoneNo = phone + first11;
        System.out.println("User Phone No:" + userPhoneNo);

    }

    @And("[Sub Admin] User select the Role {string}")
    public void subAdminUserSelectTheRole(String role) {
        SubAdminPages.get_Role().click();
        SubAdminPages.get_Role_Select(role).click();
    }

    @Then("[Sub Admin] Use tap on the Add sub admin")
    public void subAdminUseTapOnTheAddSubAdmin() {
        SubAdminPages.get_Add_Sub_Admin().click();
    }

    @Then("[Sub Admin] User tap the role manage access {string}")
    public void subAdminUserTapTheRoleManageAccess(String role) throws InterruptedException {
        SubAdminPages.get_Manage_Access(role).click();

    }

    @And("[Sub Admin] User tap on the submit button")
    public void subAdminUserTapOnTheSubmitButton() throws InterruptedException {
        SubAdminPages.get_Submit().click();
    }

    @And("[Sub Admin] User should validate the error message on the email {string}")
    public void subAdminUserShouldValidateTheErrorMessageOnTheEmail(String emailerror) {
        String actual = SubAdminPages.get_Error_Email(emailerror).getText();
        Assert.assertEquals(emailerror, actual);
    }


    @And("[Sub Admin] User enter the Confirm password {string}")
    public void subAdminUserEnterTheConfirmPassword(String arg0) {
        SubAdminPages.get_Confirm_Password().sendKeys(userPassword);
    }

    @Then("[Sub Admin] User land on the {string} page")
    public void subAdminUserLandOnThePage(String expectedValue) {

        String actualValue = SubAdminPages.get_User_Manage_Access().getText();
        Assert.assertEquals(expectedValue, actualValue);
        System.out.println(actualValue);

    }
    public static List<String> moduleTexts;
    @Then("[Sub Admin] User tap on all check boxes")
    public void subAdminUserTapOnAllCheckBoxes() {
        List<WebElement> checkboxes = SubAdminPages.get_All_Check_Boxes();
        List<WebElement> moduleList = SubAdminPages.get_Module_List();
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
         moduleTexts = new ArrayList<>();
        for (WebElement moduleElement : moduleList) {
            String moduleText = moduleElement.getText().toLowerCase().split(" ")[0];
            moduleTexts.add(moduleText);
        }
        Collections.sort(moduleTexts);
        System.out.println("Module: "+"\n"+moduleTexts);
    }

    @And("[Sub Admin] User search the sub admin")
    public void subAdminUserSearchTheSubAdmin() {
        SubAdminPages.get_Team_Member_Search().sendKeys(Team_Member_Name);
    }

    @Then("[Sub Admin] User verify all the check boxes are selected")
    public void subAdminUserVerifyAllTheCheckBoxesAreSelected() throws InterruptedException {
        int checkboxesSize = SubAdminPages.get_All_Check_Boxes().size();
        System.out.println("No of Check Boxes;"+checkboxesSize);
        List<WebElement> checkboxes = SubAdminPages.get_All_Check_Boxes();
        int allChecked = 0;
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                allChecked++;
            }

        }
        System.out.println("Checkbox is selected: " + allChecked);

        Assert.assertEquals(checkboxesSize,allChecked);
    }

    @Then("[Sub Admin] User tap on manage access button")
    public void subAdminUserTapOnManageAccessButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Manage_Access_Button)));
        SubAdminPages.get_Manage_Access_Button().click();
    }

    @And("[Sub Admin] Use tap on the I am not the Primary User? button")
    public void subAdminUseTapOnTheIAmNotThePrimaryUserButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(I_Am_Not_The_Primary_User)));
        SubAdminPages.get_I_Am_Not_The_Primary_User().click();
    }

    @And("[Sub Admin] Use enter the the company id {string}")
    public void subAdminUseEnterTheTheCompanyId(String arg0) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Login_Company_Id)));
        SubAdminPages.get_Login_Company_Id().sendKeys(companyID);
    }

    @And("[Sub Admin] Use enter the team member email")
    public void subAdminUseEnterTheTeamMemberEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpUserEnterTheEmail)));
        SignUpPage.signUpUserEnterTheEmail().sendKeys(userEmail);

    }

    @And("[Sub Admin] Use enter the team member password")
    public void subAdminUseEnterTheTeamMemberPassword() throws InterruptedException {
        SubAdminPages.get_Password().sendKeys(userPassword);
    }
    public static List<String> teamMemberModuleListTexts;
    @Then("[Sub Admin] User verify all the module are shown on the side bar")
    public void subAdminUserVerifyAllTheModuleAreShownOnTheSideBar() {
        List<WebElement> teamMemberModuleList = SubAdminPages.get_Team_Member_Module_List();
        teamMemberModuleListTexts = new ArrayList<>();
        for (WebElement teamMemberModuleListElement : teamMemberModuleList) {
            String teamMemberModuleListText = teamMemberModuleListElement.getText().toLowerCase().split(" ")[0];
            if (!Objects.equals(teamMemberModuleListText, "profile")) {
                if (Objects.equals(teamMemberModuleListText, "establishments")) {
                    teamMemberModuleListTexts.add("establishment");
                } else {
                    teamMemberModuleListTexts.add(teamMemberModuleListText);
                }
            }

        }
        Collections.sort(teamMemberModuleListTexts);
        System.out.println("TeamMember Module List:"+teamMemberModuleListTexts);

        Assert.assertEquals(moduleTexts,teamMemberModuleListTexts);

    }
    public static int Employee_Selected_Check_Boxes;
//    public static String Employee;
    public static String[] employeesModule;
    @Then("[Sub Admin] Employer give him access to sub admin to creates single, multiple employees,Deactivate Employees,Download Employees and Request Checker")
    public void subAdminEmployerGiveHimAccessToSubAdminToCreatesSingleMultipleEmployeesDeactivateEmployeesDownloadEmployeesAndRequestChecker() throws InterruptedException {
        String Employee = get_Employee_Module().getText().toLowerCase();
        System.out.println("Value"+Employee);
        Employee_Selected_Check_Boxes = SubAdminPages.get_Employees_Creations().size();
         System.out.println(Employee_Selected_Check_Boxes);
        List<WebElement> Employees_Creations = SubAdminPages.get_Employees_Creations();
        if(Objects.equals(Employee, "employees :")) {
            for (WebElement Employees_Creations_List : Employees_Creations) {
                Employees_Creations_List.click();
            }
        }
        employeesModule = Employee.split(" :");
        System.out.println(Arrays.toString(employeesModule));
    }

    @Then("[Sub Admin] User verify check boxes they are selected")
    public void subAdminUserVerifyCheckBoxesTheyAreSelected() {
        int checkboxesSize = SubAdminPages.get_All_Check_Boxes().size();
        System.out.println("No of Check Boxes;"+checkboxesSize);
        List<WebElement> checkboxes = SubAdminPages.get_All_Check_Boxes();
        int allChecked = 0;
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                allChecked++;
            }

        }
        System.out.println("Checkbox is selected: " + allChecked);

        Assert.assertEquals(Employee_Selected_Check_Boxes,allChecked);
    }

    @Then("[Sub Admin] User verify the module are shown on the side bar")
    public void subAdminUserVerifyTheModuleAreShownOnTheSideBar() {
        List<WebElement> teamMemberModuleList = SubAdminPages.get_Team_Member_Module_List();
        teamMemberModuleListTexts = new ArrayList<>();
        for (WebElement teamMemberModuleListElement : teamMemberModuleList) {
            String teamMemberModuleListText = teamMemberModuleListElement.getText().toLowerCase().split(" ")[0];
            if (!Objects.equals(teamMemberModuleListText, "profile")) {
                if (Objects.equals(teamMemberModuleListText, "establishments")) {
                    teamMemberModuleListTexts.add("establishment");
                } else {
                    teamMemberModuleListTexts.add(teamMemberModuleListText);
                }
            }

        }
        Collections.sort(teamMemberModuleListTexts);
        System.out.println("TeamMember Module List:"+teamMemberModuleListTexts);

        Assert.assertEquals(Arrays.asList(employeesModule),teamMemberModuleListTexts);

    }

    @Then("[Admin Page] Sub admin enter the company")
    public void adminPageSubAdminEnterTheCompany() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Company_Client)));
        AdminPage.get_Company_Client().sendKeys(companyTittle + Keys.ENTER);
        System.out.println(companyTittle);
        System.out.println(companyName);
    }
}

