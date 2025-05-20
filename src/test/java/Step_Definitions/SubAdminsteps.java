package Step_Definitions;

import Pages.Android.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.*;

import static Hooks.Base_Class.driver;
import static Pages.Android.AddEmployerPages.Mol_No;
import static Pages.Android.AdminPage.Company_Client;
import static Pages.Android.EidPages.Update_Button;
import static Pages.Android.MolPages.Edit_Personal_Details;
import static Pages.Android.RequestPage.Loading;
import static Pages.Android.SignUpPage.signUpUserEnterTheEmail;
import static Pages.Android.SubAdminPages.*;
import static Step_Definitions.SignUpSteps.companyName;

public class SubAdminsteps {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    public static String companyTittle;
    public static String companyID;
    public static String subadmincompanyTittle;
    @Given("[Sub Admin] User tap on the sub admin button")
    public void subAdminUserTapOnTheSubAdminButton() {
        companyTittle= AddEmployerPages.get_Company_Tittle().getText();
        subadmincompanyTittle= AddEmployerPages.get_Company_Tittle().getText();
        companyID = AddEmployerPages.get_Company_Id().getText();
        String perfix = "Client ID: ";
        if (companyID.startsWith(perfix)) {
            companyID = companyID.substring(perfix.length()).trim(); // Remove prefix
            System.out.println("Company Name:"+companyTittle);
            System.out.println("Company ID:"+companyID);
            SubAdminPages.get_Sub_Admin_Button().click();
        }

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
        Random random = new Random();
        int phoneNo = 1000000 + random.nextInt(9000000);
        SubAdminPages.get_Phone().sendKeys(phone + phoneNo);
        userPhoneNo = phone + phoneNo;
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
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            shortWait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("⚠️ Alert detected with text: " + alert.getText());
            alert.accept();
        } catch (TimeoutException | NoAlertPresentException e) {
            System.out.println("✅ No alert present. Proceeding normally.");
        } catch (UnhandledAlertException e) {
            // In case alert appears after the previous steps
            Alert alert = driver.switchTo().alert();
            System.out.println("⚠️ Unexpected alert handled: " + alert.getText());
            alert.accept();
        }

        wait.until(ExpectedConditions.elementToBeClickable(SubAdminPages.get_Submit()));
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
        System.out.println(companyID);
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
    public static int Employees_Creations_Check_Boxes;
    public static String Employee;
    public static String actualEmployee;
    @Then("[Sub Admin] Employer give him access to sub admin to creates single, multiple employees,Deactivate Employees,Download Employees and Request Checker")
    public void subAdminEmployerGiveHimAccessToSubAdminToCreatesSingleMultipleEmployeesDeactivateEmployeesDownloadEmployeesAndRequestChecker() throws InterruptedException {
        actualEmployee = get_Employee_Module().getText()
                .toLowerCase()  // Convert to lower case
                .replaceAll("[^a-zA-Z0-9]", "")  // Remove all non-alphanumeric characters
                .replaceAll("\\s+$", "");  // Remove trailing spaces (though non-alphanumeric removal handles this)

// Capitalize the first letter and keep the rest in lower case
        actualEmployee = actualEmployee.substring(0, 1).toUpperCase() + actualEmployee.substring(1);
        System.out.println("Employee value"+actualEmployee);
        Employee = get_Employee_Module().getText().toLowerCase();
        System.out.println("Value:"+Employee);
        Employee_Selected_Check_Boxes = SubAdminPages.get_Employees_Creations().size();
         System.out.println(Employee_Selected_Check_Boxes);
        Employees_Creations_Check_Boxes = SubAdminPages.get_Employee_Creations().size();

        List<WebElement> Employees_Creations = SubAdminPages.get_Employees_Creations();
        List<WebElement> Employee_Creations = SubAdminPages.get_Employee_Creations();
        if(Objects.equals(Employee, "employees :")) {
            for (WebElement Employees_Creations_List : Employees_Creations) {
                Employees_Creations_List.click();
            }
            for (WebElement Employee_Creations_List :Employee_Creations){
                Employee_Creations_List.click();
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

        Assert.assertEquals(Employees_Creations_Check_Boxes+Employee_Selected_Check_Boxes,allChecked);
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

    @Then("[Sub Admin] User employee is active then click on eye button")
    public void subAdminUserEmployeeIsActiveThenClickOnEyeButton() {

    }

    @Then("[Sub Admin] User employee is active then click on checkbox button")
    public void subAdminUserEmployeeIsActiveThenClickOnCheckboxButton() {
            List<WebElement> activeStatus = get_Employee_Active_Status();

            int activeEmployee = activeStatus.size();
            for(WebElement employee :activeStatus){
                System.out.println(employee);
                SubAdminPages.get_Is_User_Active_Drop_Down().click();
                SubAdminPages.get_Active_Button().click();
                //EmployeesPage.get_Payd_Card().click();
                SubAdminPages.get_Is_User_Active_Search_Button().click();
                SubAdminPages.get_Employee_Eye_Button().click();
                System.out.println("User Active");
                break;
            }
    }

    @Then("[Sub Admin] User tap on the Deactivate button")
    public void subAdminUserTapOnTheDeactivateButton() throws InterruptedException {
        Thread.sleep(3000);
        SubAdminPages.get_Deactivate_Button().click();
    }



    @Then("[Sub Admin] User the deactivate the pop-up message {string}")
    public void subAdminUserTheDeactivateThePopUpMessage(String deactivateEmployeeMsg) {
//        String deactivateMsg =  SubAdminPages.get_Deactivate_Message().getText();
//        System.out.println("Deactivate Message:"+ deactivateMsg);
//        Assert.assertEquals(deactivateMsg,deactivateEmployeeMsg);
//        String approvalCreated = "Approval Created";
//        String approcalAlreadyCreated = "You already submitted for approval. Please be patient";
//        String expect = AdminPage.get_Action_Successfully().getText();
//        String actualText;
//        if(actualText.equals(approvalCreated)||actualText.equals(approcalAlreadyCreated)) {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Action_Successfully(actualText))));
//            String expect = AdminPage.get_Action_Successfully(actualText).getText();
//            System.out.println(expect);
//            Assert.assertEquals(expect,actualText );
//        }
         WebElement msg = driver.findElement(By.cssSelector("div[class='ant-message'] span:nth-child(2)"));
        String[] messagesToCheck = {"You already submitted for approval","Approval Created","Updated Phone Number" };
        String actualText = null;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='ant-message'] span:nth-child(2)")));
        for (String message : messagesToCheck) {
            try {
                actualText = AdminPage.get_Action_Successfully(message).getText();
            }
            catch (Exception ignored){

            }
                if (Objects.equals(actualText, message)) {
                    actualText = AdminPage.get_Action_Successfully(message).getText();
                    System.out.println("MSG"+actualText);
                    System.out.println("Retrieved text: " + actualText);
                    break; // Exit the loop if text is retrieved successfully
                }
            System.out.println("Could Not Found");
        }

//        if (actualText == null) {
//            System.out.println("Text not found");
//        }

    }

    @Then("[Sub Admin] User tap on the Edit Personal Details button")
    public void subAdminUserTapOnTheEditPersonalDetailsButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Edit_Personal_Details)));
        MolPages.get_Edit_Personal_Details().click();
        Thread.sleep(3000);
    }



    @Then("[Sub Admin] User tap on the Edit Phone Number button {string}")
    public void subAdminUserTapOnTheEditPhoneNumberButton(String empPhone) {
        long first11 = (long) (Math.random() * 10000000L);
        Random random = new Random();
        int phoneNo = 1000000 + random.nextInt(9000000);
        SubAdminPages.get_Edit_Phone_Number().click();
        MolPages.get_Phone_No().sendKeys(empPhone + phoneNo);
        userPhoneNo = empPhone + phoneNo;
        System.out.println("User Phone No:" + userPhoneNo);
        EidPages.get_Update_Button().click();
    }

    @Then("[Sub Admin] User verify the Personal Details phone no updated")
    public void subAdminUserVerifyThePersonalDetailsPhoneNoUpdated() {
        String updatedPhoneNo =SubAdminPages.get_Updated_Phone_No().getText();
        System.out.println("Employer Phone No:"+updatedPhoneNo);
        Assert.assertEquals(updatedPhoneNo,userPhoneNo);
    }

    @Then("[Sub Admin] User tap on the Edit Mol Est Id Details button")
    public void subAdminUserTapOnTheEditMolEstIdDetailsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Edit_Mol_Est_Id)));
        SubAdminPages.get_Edit_Mol_Est_Id().click();

    }
    public static Long first20;
    public static  String EmployerMol;
    @Then("[Sub Admin] User enter the {string} no")
    public void subAdminUserEnterTheNo(String employeeMolNo) throws InterruptedException {
        Random random = new Random();
        long min = 100000000000000000L;
        long max = 999999999999999999L;
        first20 = min + ((long) (random.nextDouble() * (max - min)));
        wait.until(ExpectedConditions.elementToBeClickable(By.id(Mol_No)));
        AddEmployerPages.get_Mol_No().sendKeys(employeeMolNo + first20);
        EmployerMol = first20 + employeeMolNo;
        System.out.println(EmployerMol);
        Thread.sleep(5000);
    }

    @Then("[Sub Admin] User select the company establishment id no")
    public void subAdminUserSelectTheCompanyEstablishmentIdNo() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Employer_Establishment_Id)));
        SubAdminPages.get_Employer_Establishment_Id().sendKeys(companyTittle+Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Update_Button)));
        EidPages.get_Update_Button().click();
    }

    @Then("[Add Employer] Sub admin select the establishment id")
    public void addEmployerSubAdminSelectTheEstablishmentId() {
        //String companyTittle = AddEmployerPages.get_Company_Tittle().getText();
        AddEmployerPages.get_Establishment_Id().sendKeys(companyTittle + Keys.ENTER);
        companyName = companyTittle;
        System.out.println(companyName);
    }
    public static String teamMemberEmailId;
    @When("[Sub Admin] User tap on the search button")
    public void subAdminUserTapOnTheSearchButton() {
        SubAdminPages.get_Sub_Search_Button().sendKeys("565256598");
        teamMemberEmailId = SubAdminPages.get_team_Member_Email_Id().getText();
        System.out.println("Team Member Email id:"+teamMemberEmailId);
    }

    @When("[Sub Admin] User tap on the manage access button")
    public void subAdminUserTapOnTheManageAccessButton() {
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Loading)));
        //wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(Manage_Access_Button))));
        SubAdminPages.get_Manage_Access_Button().click();
    }

    @And("[Sub Admin] Use paste the team member email")
    public void subAdminUsePasteTheTeamMemberEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signUpUserEnterTheEmail)));
        System.out.println("Team member Email:"+teamMemberEmailId);
        SignUpPage.signUpUserEnterTheEmail().sendKeys(teamMemberEmailId);
    }

    @Then("[Sub Admin] User validate the button are present")
    public void subAdminUserValidateTheButtonArePresent() {
        String employee_Button = SubAdminPages.get_Employee_Button().getText();
        System.out.println("employee_Button:"+employee_Button);
        Assert.assertEquals(employee_Button,actualEmployee);
    }
}





