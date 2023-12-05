package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.EmployeesPage;
import Pages.Android.UpdateProliePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import static Hooks.Base_Class.driver;
import static Pages.Android.AddEmployerPages.*;
import static Pages.Android.UpdateProliePage.get_year_arrow_xpath;
import static Pages.Android.UpdateProliePage.issueDate;
import static Step_Definitions.Employeessteps.randomNumbers;
import static Tests.Current_Date.currentYear;

public class AddEmployerSteps<Save_mol> {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();



    @Given("[Add Employer] user tap on new employer button")
    public void addEmployerUserTapOnNewEmployerButton() throws InterruptedException {
        Thread.sleep(3000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Add_New_Emplyer)));
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Add_New_Emplyer)));
//        AddEmployerPages.get_Add_New_Emplyer().click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Add_New_Emplyer)));
//
//        WebElement addEmployerButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Add_New_Emplyer)));
//        if (!addEmployerButton.isEnabled()) {
//            System.out.println("Add Employer button is disabled. Taking appropriate action to enable it.");
//            // Add code to enable the button or wait for it to become enabled.
//        }
//
//        addEmployerButton.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Add_New_Emplyer)));
//        WebElement addEmployerButton = driver.findElement(By.cssSelector(Add_New_Emplyer));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Add_New_Emplyer)));
        AddEmployerPages.get_Add_New_Emplyer().click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Add_New_Emplyer)));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Add_New_Emplyer)));
            AddEmployerPages.get_Add_New_Emplyer().click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on the element: " + e.getMessage());
        }
    }



    @Then("[Add Employer] user enter the first name {string}")
    public void addEmployerUserEnterTheFirstName(String firstname) {
        AddEmployerPages.get_First_name().sendKeys(firstname);
    }

    @And("[Add Employer] user enter the middle name {string}")
    public void addEmployerUserEnterTheMiddleName(String middlename) {
        AddEmployerPages.get_Middle_name().sendKeys(middlename);
    }

    @Then("[Add Employer] user enter the last name {string}")
    public void addEmployerUserEnterTheLastName(String lastname) {
        int Last_Name = (int) (Math.random() * 1000);
        AddEmployerPages.get_Last_Name().sendKeys(Last_Name + lastname);
    }

    @And("[Add Employer] user enter the display name {string}")
    public void addEmployerUserEnterTheDisplayName(String displayname) {
        AddEmployerPages.get_Display_Name().sendKeys(displayname);
    }

    @Then("[Add Employer] user tap on gender field")
    public void addEmployerUserTapOnGenderField() {
        AddEmployerPages.get_Gender_Field().click();
    }

    @And("[Add Employer] user select the gender {string}")
    public void addEmployerUserSelectTheGender(String male) throws InterruptedException {
        AddEmployerPages.get_Gender(male).click();

    }

    @Then("[Add Employer] User enter the year {int}")
    public void addEmployerUserEnterTheYear(int isyear) throws InterruptedException {
        AddEmployerPages.get_Date_Of_Birth().click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickYear_xpath)));
        String year = currentYear();
        int year1 = Integer.parseInt(year);
        year1 = year1 - isyear;

        for (int i = 0; i < year1; i++) {
            get_year_arrow_xpath().click();

        }
    }

    @And("[Add Employer] user enter the passport no {string}")
    public void addEmployerUserEnterThePassportNo(String passportno) throws InterruptedException {
        long first16 = (long) (Math.random() * 10000000000000000L);
        AddEmployerPages.get_Pass_Port_no().sendKeys(passportno + first16);

    }

    @Then("[Add Employer] user select the nationality {string}")
    public void addEmployerUserSelectTheNationality(String country) throws InterruptedException {
//        AddEmployerPages.get_Select_Country().click();
//        Thread.sleep(5000);
        AddEmployerPages.get_Nationality().sendKeys(country);
        if (get_Nationality().isDisplayed()) {
            AddEmployerPages.get_Nationality().click();
            AddEmployerPages.get_Nationality().sendKeys(Keys.ENTER);

        } else {
            AddEmployerPages.get_Nationality().sendKeys(country);
            AddEmployerPages.get_Nationality().sendKeys(Keys.ENTER);
        }

    }

    @Then("[Add Employer] user tao the nationality")
    public void addEmployerUserTaoTheNationality() throws InterruptedException {
//        AddEmployerPages.get_Nationality().click();
        AddEmployerPages.get_Nationality().sendKeys("Pakistan");
        AddEmployerPages.get_Nationality().sendKeys(Keys.ENTER);

        //Scroll.ScrollVertical(driver.findElement(By.xpath("//div[contains(text(),'Pakistan')]")));
        // Scroll.ScrollVertical(driver.findElement(By.xpath("//div[@class='rc-virtual-list-scrollbar rc-virtual-list-scrollbar-show']//div[@class='rc-virtual-list-scrollbar-thumb']")));
    }

    long first14 = (long) (Math.random() * 100000000000000L);
    long Save_mol = first14;
    public static String EmpMol;

    @And("[Add Employer] user enter the Mol no {string}")
    public void addEmployerUserEnterTheMolNo(String Molno) throws InterruptedException {
        //  AddEmployerPages.get_Mol_No().sendKeys((Math.random()+Molno);
//        Random random = new Random();
//           long randomLong = random.nextLong();
//        long  min = 100000000000000L;
        //       long  max = 900000000000000L;
        //      long randomLong = min + (long) (random.nextDouble() * (max - min));

        AddEmployerPages.get_Mol_No().sendKeys(first14 + Molno);
        EmpMol = first14 + Molno;
        System.out.println("MOL NO WHICH IS SAving.....: " + Save_mol);

    }


    @Then("[Add Employer] user enter the Employer code {string}")
    public void addEmployerUserEnterTheEmployerCode(String empcode) {
        int randomempno = (int) ((Math.random() * 100000));
        AddEmployerPages.get_Emp_Code().sendKeys(empcode + randomempno);
    }

    @And("[Add Employer] user enter the date of joining year {string}")
    public void addEmployerUserEnterTheDateOfJoiningYear(String isyear) {

    }

    @And("[Add Employer] user enter the date of joining year {int}")
    public void addEmployerUserEnterTheDateOfJoiningYear(int isyear) throws InterruptedException {
        AddEmployerPages.get_Date_Of_Joining().click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickYear_xpath)));
        String year = currentYear();
        int year1 = Integer.parseInt(year);
        year1 = year1 - isyear;

        for (int i = 0; i < year1; i++) {
            UpdateProliePage.get_year_arrow_doj_xpath().click();

        }
    }

    @Then("[Add Employer]  User enter the day {string}")
    public void addEmployerUserEnterTheDay(String isDay) throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(date_select(isDay))));
        AddEmployerPages.get_date_of_joining_select(isDay).click();
    }

    @And("[Add Employer] user enter mobile no {string}")
    public void addEmployerUserEnterMobileNo(String mobcode) {
        long mobno = (long) ((Math.random() * 90000000000L));
        AddEmployerPages.get_Mobile_No().sendKeys(mobcode + mobno);
    }

    @Then("[Add Employer] user enter  alternate mobile no {string}")
    public void addEmployerUserEnterAlternateMobileNo(String altermobno) throws InterruptedException {
        AddEmployerPages.get_Alternate_Mobile_No().sendKeys(altermobno);
    }

    @And("[Add Employer] user tap on the add employer")
    public void addEmployerUserTapOnTheAddEmployer() throws InterruptedException {
        EmployeesPage.get_Add_Emplyer_Button().sendKeys(EmpMol);
        EmployeesPage.get_Add_Emplyer_Button().click();


    }

    /*
        @Then("[Add Employer] user validate the error message {string}")
        public void addEmployerUserValidateTheErrorMessage(String useralreadyexist) {
            AddEmployerPages.get_Employee_Already_Exsist().isDisplayed();
            Assert.assertEquals(useralreadyexist,"Employee with same MOL number is already exists");
        }
    */
    @Then("[Add Employer] user validate the error message on first name {string}")
    public void addEmployerUserValidateTheErrorMessageOnFirstName(String fisrtnameerror) throws InterruptedException {
        AddEmployerPages.get_first_Name_Error().isDisplayed();
        Assert.assertEquals(fisrtnameerror, "Please enter First Name");
        //Thread.sleep(3000);

    }

    @Then("[Add Employer] user validate the error message on last name {string}")
    public void addEmployerUserValidateTheErrorMessageOnLastName(String lastnameerror) {
        AddEmployerPages.get_first_Name_Error().isDisplayed();
        Assert.assertEquals(lastnameerror, "Please enter Last Name");
    }

    @Then("[Add Employer] user validate the error message on display name {string}")
    public void addEmployerUserValidateTheErrorMessageOnDisplayName(String displaynameerror) {
        AddEmployerPages.get_first_Name_Error().isDisplayed();
        Assert.assertEquals(displaynameerror, "Please enter Display Name");
    }

    @Then("[Add Employer] user validate the error message on gender {string}")
    public void addEmployerUserValidateTheErrorMessageOnGender(String gendererror) {
        AddEmployerPages.get_first_Name_Error().isDisplayed();
        Assert.assertEquals(gendererror, "Please enter Gender");

    }

    @Then("[Add Employer] user validate the error message on date of birth {string}")
    public void addEmployerUserValidateTheErrorMessageOnDateOfBirth(String dateofbirth) {
        AddEmployerPages.get_first_Name_Error().isDisplayed();
        Assert.assertEquals(dateofbirth, "Please enter Date Of Birth");

    }

    @Then("[Add Employer] user validate the error message on passport no {string}")
    public void addEmployerUserValidateTheErrorMessageOnPassportNo(String passporterror) {
        AddEmployerPages.get_first_Name_Error().isDisplayed();
        Assert.assertEquals(passporterror, "Please enter Passport Number");
    }

    @Then("[Add Employer] user validate the error message on nationality {string}")
    public void addEmployerUserValidateTheErrorMessageOnNationality(String erroronnationality) {
        AddEmployerPages.get_first_Name_Error().isDisplayed();
        Assert.assertEquals(erroronnationality, "Please enter Nationality");
    }

    @Then("[Add Employer] user validate the error message on Mol No {string}")
    public void addEmployerUserValidateTheErrorMessageOnMolNo(String molerror) {
        AddEmployerPages.get_first_Name_Error().isDisplayed();
        Assert.assertEquals(molerror, "Please enter Mol Number");
    }

    @Then("[Add Employer] user validate the error message on employee No {string}")
    public void addEmployerUserValidateTheErrorMessageOnEmployeeNo(String employeecodeerror) {
        AddEmployerPages.get_first_Name_Error().isDisplayed();
        Assert.assertEquals(employeecodeerror, "Please enter Employee Code");
    }

    @Then("[Add Employer] user validate the error message on date of joining  {string}")
    public void addEmployerUserValidateTheErrorMessageOnDateOfJoining(String errordateofjoining) {
        AddEmployerPages.get_first_Name_Error().isDisplayed();
        Assert.assertEquals(errordateofjoining, "Please enter Date of joining");
    }

    @Then("[Add Employer] User enter issue year {int}")
    public void addEmployerUserEnterIssueYear(int isYear) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(issueDate)));
        UpdateProliePage.getIssueDate().click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickYear_xpath)));
        String year = currentYear();
        int year1 = Integer.parseInt(year);
        year1 = year1 - isYear;

        for (int i = 0; i < year1; i++) {
            AddEmployerPages.get_add_employer_year_arrow_xpath().click();

        }

    }


    @Then("[Update Profile] User enter issue add employer the day {string}")
    public void updateProfileUserEnterIssueAddEmployerTheDay(String isDay) throws InterruptedException {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(date_select(isDay))));

        AddEmployerPages.get_issue_Add_Employer_date_select(isDay).click();
    }


    @And("[Update Profile] User enter the add employer expire year {int}")
    public void updateProfileUserEnterTheAddEmployerExpireYear(int expyear) {
        UpdateProliePage.getExpireDate().click();
        String year = currentYear();
        int year1 = Integer.parseInt(year);
        year1 = expyear - year1;

        for (int i = 0; i < year1; i++) {
            AddEmployerPages.getAddEmployerExpYearArrow().click();


        }


    }

    @And("[Update Profile] User enter the add employer expire day {string}")
    public void updateProfileUserEnterTheAddEmployerExpireDay(String expDay) {
        AddEmployerPages.get_Add_Employer_Expire_Date_Select(expDay).click();
    }

    @Then("[Add Employer] User validate the error message {string}")
    public void addEmployerUserValidateTheErrorMessage(String error) throws InterruptedException {
        AddEmployerPages.getError(error).isDisplayed();
        Assert.assertEquals(error, "Please enter Mol Number");


    }

    @Then("[Add Employer] User select the document {string}")
    public void addEmployerUserSelectTheDocument(String document) {
        AddEmployerPages.get_Document_Feild().click();
        AddEmployerPages.get_Document(document).click();
    }

    @And("[Add Employer  User Select the Bank {string}")
    public void addEmployerUserSelectTheBank(String bank) {
        AddEmployerPages.get_BankDetails().click();
        AddEmployerPages.get_Select_Bank(bank).click();
    }

    @Then("[Add Employer] User Select the bask {string}")
    public void addEmployerUserSelectTheBask(String bank) {
        AddEmployerPages.get_Bank().sendKeys(bank);
//        AddEmployerPages.get_Select_Bank(bank).sendKeys(bank);
        AddEmployerPages.get_Bank().sendKeys(Keys.ENTER);
    }

    @And("[Add Employer] User enter the branch name {string}")
    public void addEmployerUserEnterTheBranchName(String BranchName) {
        AddEmployerPages.get_Branch_Name().sendKeys(BranchName);
    }
    public static String IbanNo;
    @Then("[Add Employer] User enter the iBAN no {string}")
    public void addEmployerUserEnterTheIBANNo(String Iban) {
        long iban = (long) (Math.random()*(100000000));
        System.out.println(iban);
        String generateIban = Iban+iban;
        AddEmployerPages.get_Iban().sendKeys(Iban+iban);
        IbanNo = generateIban ;
        System.out.println("IBAN"+IbanNo);
    }

    @Then("[Add Employer] Validate employees should add successfully {string}")
    public void addEmployerValidateEmployeesShouldAddSuccessfully(String expected) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Add_Employer_Successfully)));
        String actual = AddEmployerPages.get_Add_Employee_Successfully().getText();
        Assert.assertEquals(expected, actual);
        //driver.navigate().back();
        //Thread.sleep(10000);
//        AddEmployerPages.get_Add_New_Emplyer().sendKeys(Keys.);

    }

    @And("[Add Employer] User enter the Emirates id {string}")
    public void addEmployerUserEnterTheEmiratesId(String eid) {
        long first14 = (long) (Math.random() * 10000000000000L);
        AddEmployerPages.get_Eid_No().sendKeys(first14 + eid);
    }

    @Then("[Add Employer] User tap on eye button")
    public void addEmployerUserTapOnEyeButton() {
        AddEmployerPages.get_Eye().click();
    }


    @Then("[Add Employer] Validate the Mol no {string}")
    public void addEmployerValidateTheMolNo(String val) throws InterruptedException {
        Thread.sleep(5000);
        String actual = AddEmployerPages.get_Validate(String.valueOf(first14)).getText();
        System.out.println("actual mol:" + actual);
        System.out.println("exp:" + first14);
        Assert.assertEquals(String.valueOf(first14), actual);

        System.out.println("print value" + actual);

    }

    @Then("[Add Employer] Validate the bank {string}")
    public void addEmployerValidateTheBank(String bank) {
        String actual = AddEmployerPages.get_Valid_Bank(bank).getText();
        Assert.assertEquals(bank, actual);
        System.out.println(actual);
    }

    @Then("[Add Employer] check")
    public void addEmployerCheck() throws InterruptedException {
        Thread.sleep(5000);
        String actual = AddEmployerPages.get_Check().getText();
        Assert.assertEquals(String.valueOf(first14), actual);
    }


    public static String Passportno;

    @Then("[Add Employer]   User enter the Passport no")
    public void addEmployerUserEnterThePassportNo() {
        long randomint = (long) (Math.random() * 100000000000L);
        AddEmployerPages.get_PassPort_no().sendKeys("Pk" + randomint);
        Passportno = "Pk" + randomint;
    }

    public static String companyName;

    @When("[Add Employer] User select the establishment id")
    public void addEmployerUserSelectTheEstablishmentId() throws InterruptedException {
        String companyTittle = AddEmployerPages.get_Company_Tittle().getText();
        AddEmployerPages.get_Establishment_Id().sendKeys(companyTittle + Keys.ENTER);
        companyName = companyTittle;
        System.out.println(companyName);

    }

    @Then("[Add Employer] User select the card type {string}")
    public void addEmployerUserSelectTheCardType(String card) {
        AddEmployerPages.get_Card().click();
        AddEmployerPages.get_Card_Type(card).click();
    }

    @Then("[Add Employer] User Validate the employee notification message {string}")
    public void addEmployerUserValidateTheEmployeeNotificationMessage(String msg) {
//        By spinnerLocator = By.cssSelector(".ant-spin.ant-spin-spinning.css-qgg3xn");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(spinnerLocator));
        String employeeOnBoardMessage = AddEmployerPages.get_Notification_Message().getText();
        boolean isEqual = employeeOnBoardMessage.equals(Notification_Message);
        if (isEqual) {
            System.out.println("notification"+Notification_Message);

            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Notification_Message)));
            String actual = AddEmployerPages.get_Notification_Message().getText();
            Assert.assertEquals(actual, msg);
            System.out.println("actualMsg" + actual);
        }
        else {
            System.out.println("Notification Not Found");
        }

//        if (AddEmployerPages.get_Notification_Message().equals(Notification_Message)) {
//            System.out.println("notification"+Notification_Message);
//
//            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Notification_Message)));
//            String actual = AddEmployerPages.get_Notification_Message().getText();
//            Assert.assertEquals(actual, msg);
//            System.out.println("actualMsg" + actual);
//        }
//        else {
//            System.out.println("Notification Not Found");
//        }
    }

    @When("[Add Employer] User tap on the add document")
    public void addEmployerUserTapOnTheAddDocument() {
        AddEmployerPages.get_Add_Document().click();
    }

    @Then("[Add Employer] User enter issue year {string}")
    public void addEmployerUserEnterIssueYear(String date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(issueDate)));
        UpdateProliePage.getIssueDate().sendKeys(date + Keys.ENTER);

    }

    @Then("[Add Employer] User forget employee type and validate  the error message {string}")
    public void addEmployerUserForgetEmployeeTypeAndValidateTheErrorMessage(String ext) throws InterruptedException {
        String act = AddEmployerPages.get_Error_Msg_Emp(ext).getText();
        Assert.assertEquals(ext, act);
        System.out.println(act + ext);
        Thread.sleep(5000);
    }




    @And("[Employees Page] User create a multiple data for the employer")
    public void employeesPageUserCreateAMultipleDataForTheEmployer() throws IOException {
        String[] headers = {"Mol No", "Emp Code", "First Name", "Last Name", "Display Name", "Date of Birth", "Gender(M/F)", "Nationality", "Date of Joining", "Email", "Mobile", "Alternate Phone", "Home Address", "Home State", "Home Post Code", "Work Address", "Work State", "Work Post Code", "Passport Number", "Passport Expiry", "EID", "EID Expiry", "Establishment Id"};
        HSSFWorkbook workbook = new HSSFWorkbook();
        // XSSFWorkbook workbook = new XSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Bulk employees");
        // XSSFSheet sheet = workbook.createSheet("Bulk employees");

        // Create header row and cells
        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        Random random = new Random();

          int randomNumbers = random.nextInt(10000);


        // Write the workbook to an output stream
        String filePath = "D:\\Hrcms\\src\\test\\java\\document\\" + randomNumbers + ".xlsx";
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            workbook.close();
        }
    }


    @And("[Employees Page] User upload a bulk employees file {string}")
    public void employeesPageUserUploadABulkEmployeesFile(String arg0) throws InterruptedException, AWTException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(uploadExcel)));
        Thread.sleep(5000);
        AddEmployerPages.get_uploadExcel().click();

//        Robot rb = new Robot();
//        System.out.println(filePath);
//        //StringSelection str = new StringSelection(filePath);
//        StringSelection str = new StringSelection("D:\\Hrcms\\src\\test\\java\\document\\965.xlsx");
//        System.out.println(str);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
//        // press Contol+V for pasting
//        rb.keyPress(KeyEvent.VK_CONTROL);
//        rb.keyPress(KeyEvent.VK_V);
//
//        // release Contol+V for pasting
//        rb.keyRelease(KeyEvent.VK_CONTROL);
//        rb.keyRelease(KeyEvent.VK_V);
//
//        // for pressing and releasing Enter
//        rb.keyPress(KeyEvent.VK_ENTER);
//        rb.keyRelease(KeyEvent.VK_ENTER);
//        //ScrollVertical(get_Add_Emplyer_Button());
//        Thread.sleep(10000);
        Thread.sleep(3000);


        Robot rb = new Robot();
        StringSelection str = new StringSelection("D:\\Hrcms\\src\\test\\java\\document\\"+randomNumbers+".xlsx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        //ScrollVertical(get_Add_Emplyer_Button());
        Thread.sleep(5000);

    }

    @And("[Add Employer] User tap on the Add More Documents button")
    public void addEmployerUserTapOnTheAddMoreDocumentsButton() {
        AddEmployerPages.get_Add_More_Documents().click();
    }

    @And("[Add Employer] user tao the Add New Establishment")
    public void addEmployerUserTaoTheAddNewEstablishment() {
        AddEmployerPages.get_Add_New_Establishment().click();
    }
    public static String establishmentNo;

    @When("[Add Employer] User enter the establishment id")
    public void addEmployerUserEnterTheEstablishmentId() {
        String companyTitle = AddEmployerPages.get_Company_Tittle().getText();
        Random estNO = new Random();
        String generatedEstablishmentNo = companyTitle + estNO.nextInt(1000000000*2);
        AddEmployerPages.get_Establishment_Id().sendKeys(generatedEstablishmentNo);
        establishmentNo = generatedEstablishmentNo;
        companyName = companyTitle;
        System.out.println(companyName);
        System.out.println("ESTID" + establishmentNo);
    }
}




