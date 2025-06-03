package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.EmployeesPage;
import Pages.Android.SubAdminPages;
import Utils.EmployeeAdditionalStorage;
import Utils.OtherBankEmployeesStorage;
import Utils.RandomDateGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.*;

import static Hooks.Base_Class.driver;
import static Pages.Android.AddEmployerPages.Company_Tittle;
import static Pages.Android.EmployeesPage.Employee_Type;
import static Pages.Android.EmployeesPage.employees;
import static Step_Definitions.AddEmployerSteps.EmpMol;
import static Step_Definitions.SignUpSteps.companyName;
import static Step_Definitions_Head_Ofiice.EstablishmentsStepsHeadOffice.branchEstablishmentId;

;


public class Employeessteps {

    //    private EstablishmentsStepsHeadOffice establishmentsSteps;
//    public Employeessteps() {
//        establishmentsSteps = new EstablishmentsStepsHeadOffice();
//    }
//public String estid(String branchEstablishmentId) {
//    // Perform logic to generate the desired estid value based on branchEstablishmentId
//    // For example:
//    String estidValue = "ESTID-" + branchEstablishmentId;
//    return estidValue;
//}
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    public static String companyTittle;
    public static String companyID;

    @Then("[Employees Page] User tap on employees button")
    public void employeesPageUserTapOnEmployeesButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Company_Tittle)));
        companyTittle = AddEmployerPages.get_Company_Tittle().getText();
        companyID = AddEmployerPages.get_Company_Id().getText();
        companyName = companyTittle;
        System.out.println("CompanyName" + companyName);
        System.out.println("Company ID:" + companyID);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(employees)));
        EmployeesPage.get_Employees().click();


    }

    @And("[Employees Page] User tap on upload excelpdf")
    public void employeesPageUserTapOnUploadExcelPdf() throws AWTException, InterruptedException {
        EmployeesPage.get_Upload_Excel().click();
        Thread.sleep(5000);
        Robot rb = new Robot();
        StringSelection str = new StringSelection("D:\\Hrcms\\src\\test\\java\\document\\Mansha List test.xlsx");
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
        Thread.sleep(5000);
    }


//    @Then("[Employees Page] User tap on Template button")
//    public void employeesPageUserTapOnTemplateButton() throws InterruptedException {
//        EmployeesPage.get_Template_Button().click();
//        Thread.sleep(5000);
//        String kamelpayEmployees = EmployeesPage.
//                String fileName = driver.getDownloadedFileName();
//        File downloadedFile = new File("C:/Downloads/" + fileName);
//        Assert.assertTrue(downloadedFile.exists());
//    }

    @Then("[Employees Page] User tap on Template button {string}")
    public void employeesPageUserTapOnTemplateButton(String downloadFile) throws InterruptedException {
        EmployeesPage.get_Template_Button().click();
        Thread.sleep(7000);
        String kamelpayEmployees = downloadFile + ".xlsx";
        File downloadFile1 = new File("C:\\Users\\Ali Raza\\Downloads\\" + kamelpayEmployees);
        System.out.println("File path: " + downloadFile1.getAbsolutePath());
        System.out.println("File exists: " + downloadFile1.exists());
        Assert.assertTrue(downloadFile1.exists());


    }

    @And("[Employees Page] User enter Employee ID {string}")
    public void employeesPageUserEnterEmployeeID(String FirstName) throws IOException {
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
        System.out.println(headers);
        Random random = new Random();

        int randomNumber = random.nextInt(10000);


        // Write the workbook to an output stream
        String filePath = "D:\\Hrcms\\src\\test\\java\\document\\" + randomNumber + ".xlsx";
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            workbook.close();
        }
    }

    public static int randomNumbers;
    public static String filePath;

    //    EstablishmentsStepsHeadOffice establishmentsStepsHeadOffice = new EstablishmentsStepsHeadOffice();
//    String branchEstablishmentId = establishmentsStepsHeadOffice.branchEstablishmentId;
    @And("[Employees Page] User create a multiple data for the employer {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void
    employeesPageUserCreateAMultipleDataForTheEmployer(String molNo, String empCode, String firstName, String lastName, String displayName, String dob, String gender, String nationality, String joiningDate, String email, String mobile, String altenatePhone, String homeAddress, String homeState, String homePostCode, String workAddress, String workState, String workPostCode, String PassportNo, String passportExpiry, String eid, String eidExpiry, String est) throws IOException, InterruptedException {
        //System.out.println(branchEstablishmentId);
        String[] headers = {"Mol No", "Emp Code", "First Name", "Last Name", "Display Name", "Date of Birth", "Gender(M/F)".trim(), "Nationality".trim().replaceAll("^\\s+", ""), "Date of Joining", "Email", "Mobile", "Alternate Phone", "Home Address", "Home State", "Home Post Code", "Work Address", "Work State", "Work Post Code", "Passport Number", "Passport Expiry", "EID", "EID Expiry", "Establishment Id"};
        Random random = new Random();
        //int randomNumber = random.nextInt(100000);
        //String[] raws = {molNo+randomNumber,empCode+randomNumber,firstName, lastName, displayName+randomNumber, dob, gender,nationality,joiningDate,"user"+randomNumber+email, mobile, altenatePhone, homeAddress,homeState,homePostCode, workAddress, workState,workPostCode,PassportNo+randomNumber,passportExpiry,eid+randomNumber,eidExpiry,estId};
        HSSFWorkbook workbook = new HSSFWorkbook();
        // XSSFWorkbook workbook = new XSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Bulk employees");
        // XSSFSheet sheet = workbook.createSheet("Bulk employees");
//        EstablishmentsStepsHeadOffice establishmentsStepsHeadOffice = new EstablishmentsStepsHeadOffice();
//        String branchEstablishmentId = establishmentsStepsHeadOffice.branchEstablishmentId;
        //System.out.println(establishmentsStepsHeadOffice);
        //System.out.println(branchEstablishmentId);
        //String estidValue = estid(branchEstablishmentId); // Call estid() method with branchEstablishmentId

        //System.out.println(branchEstablishmentId);

        // Create header row and cells
        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i].trim());
        }
        String[] raws = new String[0];
//            EstablishmentsStepsHeadOffice establishmentsStepsHeadOffice = new EstablishmentsStepsHeadOffice();
//            String branchEstablishmentId = establishmentsStepsHeadOffice.branchEstablishmentId;

        //System.out.println(branchEstablishmentId);
        for (int j = 0; j < 20000; j++) {
            System.out.println(j);
            int randomNumber = random.nextInt(1000000000);
            //int eidNumber = random.nextInt(1000000000000000);
            long random16DigitNumber = (long) (Math.random() * 9_000_000_000_000_000L) + 1_000_000_000_000_000L;

            raws = new String[]{molNo + randomNumber, empCode + randomNumber, firstName, lastName + randomNumber, displayName, dob, gender.trim(), nationality.trim().replaceAll("^\\s+", ""), joiningDate, "user" + randomNumber + email, mobile + randomNumber, altenatePhone + randomNumber, homeAddress + randomNumber, homeState, homePostCode, workAddress, workState, workPostCode, PassportNo + randomNumber, passportExpiry, eid + random16DigitNumber, eidExpiry,/*branchEstablishmentId +*/ est};
            System.out.println("BranchESTID;" + branchEstablishmentId);
            //System.out.println(branchEstablishmentId);
            //System.out.println(raws[j]);
            // Create data rows and populate cells
            HSSFRow dataRow = sheet.createRow(j + 1);
            for (int i = 0; i < raws.length; i++) {
                //raws[i] = raws[i].trim();
                HSSFCell cell = dataRow.createCell(i);
                cell.setCellValue(raws[i]);

            }
        }
        System.out.println(Arrays.toString(headers));
        System.out.println(Arrays.toString(new String[]{"RAWS" + Arrays.toString(raws)}));

        randomNumbers = random.nextInt(10000);


        // Write the workbook to an output stream
        filePath = "D:\\Hrcms\\src\\test\\java\\document\\" + randomNumbers + ".xlsx";
        System.out.println("File No:" + filePath);
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            workbook.close();
            //Thread.sleep(5000);

        }
        System.out.println(randomNumbers);
    }

    @And("[Employees Page] User create a multiple data for the any employer {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void employeesPageUserCreateAMultipleDataForTheAnyEmployer(String molNo, String empCode, String firstName, String lastName, String displayName, String dob, String gender, String nationality, String joiningDate, String email, String mobile, String altenatePhone, String homeAddress, String homeState, String homePostCode, String workAddress, String workState, String workPostCode, String PassportNo, String passportExpiry, String eid, String eidExpiry, String est) throws IOException {
        String[] headers = {"Mol No", "Emp Code", "First Name", "Last Name", "Display Name", "Date of Birth", "Gender(M/F)".trim(), "Nationality".trim().replaceAll("^\\s+", ""), "Date of Joining", "Email", "Mobile", "Alternate Phone", "Home Address", "Home State", "Home Post Code", "Work Address", "Work State", "Work Post Code", "Passport Number", "Passport Expiry", "EID", "EID Expiry", "Establishment Id"};
        Random random = new Random();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Bulk employees");
        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i].trim());
        }
        String[] raws = new String[0];
        for (int j = 0; j < 5000; j++) {
            int randomNumber = random.nextInt(1000000000);


            raws = new String[]{molNo + randomNumber, empCode + randomNumber, firstName, lastName, displayName + randomNumber, dob, gender.trim(), nationality.trim().replaceAll("^\\s+", ""), joiningDate, "user" + randomNumber + email, mobile + randomNumber, altenatePhone + randomNumber, homeAddress + randomNumber, homeState, homePostCode, workAddress, workState, workPostCode, PassportNo + randomNumber, passportExpiry, eid + randomNumber, eidExpiry, est};
            System.out.println(Arrays.toString(raws));
            System.out.println(branchEstablishmentId);
            //System.out.println(raws[j]);
            // Create data rows and populate cells
            HSSFRow dataRow = sheet.createRow(j + 1);
            for (int i = 0; i < raws.length; i++) {
                //raws[i] = raws[i].trim();
                HSSFCell cell = dataRow.createCell(i);
                cell.setCellValue(raws[i]);
            }
        }
        System.out.println(Arrays.toString(headers));
        System.out.println(Arrays.toString(raws));
        randomNumbers = random.nextInt(10000);


        // Write the workbook to an output stream
        filePath = "D:\\Hrcms\\src\\test\\java\\document\\" + randomNumbers + ".xlsx";
        System.out.println(filePath);
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            workbook.close();
            //Thread.sleep(5000);

        }
        System.out.println(randomNumbers);
    }

    @Then("[Employees Page] User enter MOL no then click on the eye button {string}")
    public void employeesPageUserEnterMOLNoThenClickOnTheEyeButton(String arg0) throws InterruptedException {
        EmployeesPage.get_Employee_Search().sendKeys(EmpMol);
        Thread.sleep(5000);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(Employee_Eye_Button)));
        EmployeesPage.get_Employee_Eye_Button().click();
        Thread.sleep(5000);
    }

    @And("[Employees Page] User create a multiple data for the employer and check duplication  {string} {string} {string} {string} {string} {string} {string}   {string} {string}   {string} {string}   {string} {string} {string} {string}  {string} {string} {string} {string}     {string} {string} {string} {string}")
    public void employeesPageUserCreateAMultipleDataForTheEmployerAndCheckDuplication(String molNo, String empCode, String firstName, String lastName, String displayName, String dob, String gender, String nationality, String joiningDate, String email, String mobile, String altenatePhone, String homeAddress, String homeState, String homePostCode, String workAddress, String workState, String workPostCode, String PassportNo, String passportExpiry, String eid, String eidExpiry, String est) throws IOException {

        String[] headers = {"Mol No", "Emp Code", "First Name", "Last Name", "Display Name", "Date of Birth", "Gender(M/F)".trim(), "Nationality".trim().replaceAll("^\\s+", ""), "Date of Joining", "Email", "Mobile", "Alternate Phone", "Home Address", "Home State", "Home Post Code", "Work Address", "Work State", "Work Post Code", "Passport Number", "Passport Expiry", "EID", "EID Expiry", "Establishment Id"};
        Random random = new Random();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Bulk employees");
        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i].trim());
        }
        String[] raws = new String[0];
        for (int j = 0; j < 5; j++) {
            int randomNumber = random.nextInt(1000000000);


            raws = new String[]{molNo /*+ randomNumber*/, empCode + randomNumber, firstName, lastName, displayName + randomNumber, dob, gender.trim(), nationality.trim().replaceAll("^\\s+", ""), joiningDate, "user" + randomNumber + email, mobile + randomNumber, altenatePhone + randomNumber, homeAddress + randomNumber, homeState, homePostCode, workAddress, workState, workPostCode, PassportNo + randomNumber, passportExpiry, eid + randomNumber, eidExpiry, est};
            System.out.println(Arrays.toString(raws));
            System.out.println(branchEstablishmentId);
            //System.out.println(raws[j]);
            // Create data rows and populate cells
            HSSFRow dataRow = sheet.createRow(j + 1);
            for (int i = 0; i < raws.length; i++) {
                //raws[i] = raws[i].trim();
                HSSFCell cell = dataRow.createCell(i);
                cell.setCellValue(raws[i]);
                System.out.println(Arrays.toString(raws));
            }
        }
        //System.out.println(Arrays.toString(headers));
        //System.out.println(Arrays.toString(raws));
        randomNumbers = random.nextInt(10000);


        // Write the workbook to an output stream
        filePath = "D:\\Hrcms\\src\\test\\java\\document\\" + randomNumbers + ".xlsx";
        System.out.println(filePath);
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            workbook.close();
            //Thread.sleep(5000);

        }
        System.out.println(randomNumbers);
    }

    private final List<String> generatedData = new ArrayList<String>();
    public static String filePaths;

    @SuppressWarnings("ConstantConditions")
    @And("[Employees Page] User create a multiple data with non WPS process for the employer {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void employeesPageUserCreateAMultipleDataWithNonWPSProcessForTheEmployer(

            String molNo, String empCode, String firstName, String lastName, String displayName,
            String dob, String gender, String nationality, String joiningDate, String email,
            String mobile, String alternatePhone, String homeAddress, String homeState,
            String homePostCode, String workAddress, String workState, String workPostCode,
            String passportNo, String passportExpiry, String eid, String eidExpiry, String est) throws IOException {


        String[] headers = {
                "Mol No", "Emp Code", "First Name", "Last Name", "Display Name",
                "Date of Birth", "Gender(M/F)", "Nationality", "Date of Joining", "Email",
                "Mobile", "Alternate Phone", "Home Address", "Home State", "Home Post Code",
                "Work Address", "Work State", "Work Post Code", "Passport Number",
                "Passport Expiry", "EID", "EID Expiry", "Establishment Id"};
        // ✅ Save headers to EmployeeAdditionalStorage
        for (int i = 0; i < headers.length; i++) {
            String key = "employee-header-" + i;
            EmployeeAdditionalStorage.storeData(key, headers[i]);
        }

        // ✅ Also save full header list as comma-separated string
        EmployeeAdditionalStorage.storeData("employee-headers", String.join(",", headers));


        List<String> firstNames = Arrays.asList("John", "Michael", "Sara", "Laura", "Robert", "Emily",
                "William", "Oliver", "Sophia", "James", "Liam", "Benjamin", "Emma", "Charlotte",
                "Ethan", "Noah", "Mason", "Logan", "Harper", "Amelia", "Ava", "Isabella", "Mia", "Abigail",
                "Lucas", "Alexander", "Henry", "Sebastian", "Madison", "Grace", "Elijah", "Daniel", "Samuel",
                "David", "Jacob", "Ella", "Scarlett", "Evelyn", "Olivia", "Aria", "Chloe", "Matthew", "Isaac",
                "Victoria", "Layla", "Zoe", "Hannah", "Natalie", "Mila", "Aurora");

        List<String> lastNames = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia",
                "Martinez", "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez",
                "Wilson", "Anderson", "Thomas", "Taylor", "Moore", "Jackson", "Martin", "Lee", "Perez", "Thompson",
                "White", "Harris", "Sanchez", "Clark", "Ramirez", "Lewis", "Robinson", "Walker", "Young", "Allen",
                "King", "Wright", "Scott", "Torres", "Nguyen", "Hill", "Flores", "Green", "Adams", "Nelson", "Baker",
                "Hall", "Rivera", "Campbell", "Mitchell", "Carter", "Roberts");

        Random random = new Random();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Bulk employees");

        // Create header row and cells
        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }
        LocalDate startDate = LocalDate.of(1950, 1, 1);
        LocalDate endDate = LocalDate.of(2010, 12, 31);
        // Print headers
        System.out.println("Headers:");
        for (String header : headers) {
            System.out.print(header + "\t");
        }
        System.out.println();  // New line after headers
        for (int j = 0; j < 30; j++) {
            int randomNumber = random.nextInt(8999999) + 1000000; // Generate random 7-digit number
            long randomMolNumber = (long) (random.nextDouble() * 9_000_000_000_000_00L) + 1_000_000_000_000_00L;

            // Generate random first and last names
            firstName = firstNames.get(random.nextInt(firstNames.size()));
            lastName = lastNames.get(random.nextInt(lastNames.size()));

            // Merge first and last name into display name
            displayName = firstName + " " + lastName;
            dob = RandomDateGenerator.generateAdultDOB();
            String[] raws = {
                    molNo + randomMolNumber, empCode, firstName, lastName,
                    displayName, dob, gender.trim(), nationality.trim().replaceAll("^\\s+", ""),
                    joiningDate, "user" + randomNumber + email, mobile + randomNumber,
                    alternatePhone + randomNumber, homeAddress + randomNumber, homeState,
                    homePostCode, workAddress, workState, workPostCode,
                    passportNo + randomNumber, passportExpiry, eid + randomNumber, eidExpiry, est
            };

            // ✅ Validate array lengths to avoid ArrayIndexOutOfBoundsException
            if (headers.length != raws.length) {
                System.out.println("❌ Header and data length mismatch at row #" + j);
                System.out.println("Headers count : " + headers.length);
                System.out.println("Values count  : " + raws.length);
                System.out.println("Headers: " + Arrays.toString(headers));
                System.out.println("Values : " + Arrays.toString(raws));
                throw new IllegalStateException("Mismatch: headers.length != raws.length at row #" + j);
            }


            // ✅ Save to key-value storage
            for (int i = 0; i < headers.length; i++) {
                String key = "employee-" + j + "-" + headers[i];
                EmployeeAdditionalStorage.storeData(key, raws[i]);
            }
            EmployeeAdditionalStorage.printAll();

            // ✅ Save to list (existing)
            generatedData.add(Arrays.toString(raws));

            // Create data rows and populate cells in the Excel sheet
            HSSFRow dataRow = sheet.createRow(j + 1);
            for (int i = 0; i < raws.length; i++) {
                HSSFCell cell = dataRow.createCell(i);
                cell.setCellValue(raws[i]);
            }
            // Print rows
            // System.out.println("Row " + (j + 1) + ":");
            for (String data : raws) {
                System.out.print(data + "\t");
            }
            System.out.println();  // New line after each row
        }


        // Write the workbook to an output stream
        int randomNumbers = random.nextInt(1000000);
        System.out.println("randomNumbers: " + randomNumbers);
        filePaths = "D:\\Hrcms\\src\\test\\java\\document\\" + randomNumbers + ".xlsx";
        System.out.println("File Path: " + filePaths);

        try (FileOutputStream fileOut = new FileOutputStream(filePaths)) {
            System.out.println("File Path:" + filePaths);
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw e;
        } finally {
            workbook.close();
        }

        System.out.println("Data saved to Excel file successfully.");
    }

    // }
    public List<String> getGeneratedData() {
        System.out.println("generatedData" + generatedData);
        return generatedData;

    }


    @And("[Employees Page] User create a multiple data for the other bank employer {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void employeesPageUserCreateAMultipleDataForTheOtherBankEmployer(
            String empId, String empName, String empDesignation, String employerWPSEstId, String empIBAN,
            String empBankName, String empWPSPersonId, String empPassPortNo, String empNationality,
            String empLabourCard) throws IOException {

        String[] headers = {"Employee ID", "Name", "Designation", "WPS Establishment ID", "IBAN", "Bank Name", "WPS Person ID", "Passport Number", "Nationality", "Labor card"};
        Random random = new Random();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Bulk employees");

        HSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i].trim());
        }
        String[] raws = new String[0];

        for (int j = 0; j < 20; j++) {
            System.out.println(j);
            int randomNumber = random.nextInt(1000000000);


            raws = new String[]{empId + randomNumber, empName + randomNumber, empDesignation, employerWPSEstId, empIBAN + randomNumber, empBankName, empWPSPersonId + randomNumber, empPassPortNo + randomNumber, empNationality, empLabourCard + randomNumber};

            HSSFRow dataRow = sheet.createRow(j + 1);
            for (int i = 0; i < raws.length; i++) {
                HSSFCell cell = dataRow.createCell(i);
                cell.setCellValue(raws[i]);

            }
        }
        System.out.println(Arrays.toString(headers));
        System.out.println(Arrays.toString(new String[]{"" + Arrays.toString(raws)}));


        String fileName;
        File file;
        do {
            randomNumbers = random.nextInt(10000);
            // Write the workbook to an output stream
            fileName = "D:\\Hrcms\\src\\test\\java\\document\\" + randomNumbers + ".xlsx";
            file = new File(fileName);
        } while (file.exists());
        filePaths = fileName;
        System.out.println("Generated File Path: " + filePaths);
        System.out.println(filePath);
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            workbook.close();
            //Thread.sleep(5000);

        }
        System.out.println(randomNumbers);
    }

    @And("[Employees Page] User tap on the employee type")
    public void employeesPageUserTapOnTheEmployeeType() {
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Employee_Type)));
        //driver.navigate().refresh();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("span[class='ant-spin-dot ant-spin-dot-spin']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Employee_Type)));
        EmployeesPage.get_Employee_Type().click();
        EmployeesPage.get_Payd_Card().click();
        SubAdminPages.get_Search_Button().click();
    }

    @And("[Employees Page] User create a multiple other banks employee {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void employeesPageUserCreateAMultipleOtherBanksEmployee(
            String molNo, String empCode, String firstName, String lastName, String displayName,
            String dob, String gender, String nationality, String joiningDate, String email,
            String mobile, String alternatePhone, String homeAddress, String homeState,
            String homePostCode, String workAddress, String workState, String workPostCode,
            String passportNo, String passportExpiry, String eid, String eidExpiry, String est) throws IOException {

        List<Map.Entry<String, String>> banks = Arrays.asList(
                Map.entry("Abu Dhabi Commercial Bank", "600310101"),
                Map.entry("Abu Dhabi Islamic Bank", "405010101"),
                Map.entry("Ajman Bank", "805740101"),
                Map.entry("Al Hilal Bank", "105310101"),
                Map.entry("Al Maryah Community Bank", "009710001"),
                Map.entry("Al Masraf Arab Bank for Investment & Foreign Trade", "100810101"),
                Map.entry("Bank of Sharjah", "401230101"),
                Map.entry("Commercial Bank International", "002220101"),
                Map.entry("Commercial Bank of Dubai", "102320150"),
                Map.entry("Dubai Bank", "005120101"),
                Map.entry("Dubai Islamic Bank", "802420101"),
                Map.entry("Emirates Investment Bank", "004820101"),
                Map.entry("Emirates Islamic", "703420114"),
                Map.entry("Emirates NBD", "302620122"),
                Map.entry("First Abu Dhabi Bank", "803510106"),
                Map.entry("Invest Bank", "503030102"),
                Map.entry("Mashreq", "203320101"),
                Map.entry("National Bank of Fujairah", "703820101"),
                Map.entry("National Bank of Ras Al-Khaimah PJSC (RAKBANK)", "104060106"),
                Map.entry("National Bank of Umm Al-Quwain", "104251001"),
                Map.entry("Noor Bank", "905220101"),
                Map.entry("Sharjah Islamic Bank", "404130101"),
                Map.entry("United Arab Bank", "904630101"),
                Map.entry("United Bank Ltd.", "604720106"),
                Map.entry("Standard Chartered Bank", "504420120"),
                Map.entry("Saudi National Bank", "605520101"),
                Map.entry("Rafidain Bank", "400510101"),
                Map.entry("National Bank of Oman", "903910101"),
                Map.entry("National Bank of Kuwait", "505620101"),
                Map.entry("National Bank of Bahrain", "203610101")
        );

        List<Map.Entry<String, String>> nationalities = Arrays.asList(
                Map.entry("DOMINICAN", "DO"), Map.entry("Egypt", "EG"), Map.entry("Lebanon", "LB"),
                Map.entry("Jordan", "JO"), Map.entry("Syrian Arab Re", "SY"), Map.entry("Sudan", "SD"),
                Map.entry("Tunisia", "TN"), Map.entry("Morocco", "MA"), Map.entry("Mauritania", "MR"),
                Map.entry("Yemen", "YE"), Map.entry("UAE", "AE"), Map.entry("Bahrain", "BH"),
                Map.entry("Saudi Arabia", "SA"), Map.entry("India", "IN"), Map.entry("Cameroon", "CM"),
                Map.entry("pakistan", "PK"), Map.entry("Bangladesh", "BD"), Map.entry("Iran", "IR"),
                Map.entry("Sri Lanka", "LK"), Map.entry("Philippines", "PH"), Map.entry("Afghanistan", "AF"),
                Map.entry("Indonesia", "ID"), Map.entry("Nepal", "NP"), Map.entry("Myanmar", "MM"),
                Map.entry("Kenya", "KE"), Map.entry("Ethiopia", "ET"), Map.entry("Senegal", "SN"),
                Map.entry("Uganda", "UG"), Map.entry("Ghana", "GH"), Map.entry("Zimbabwe", "ZW"),
                Map.entry("Gambia", "GM"), Map.entry("Nigeria", "NG")
        );

        Random random = new Random();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Other Banks Employees");

        String[] headers = {
                "Employee ID",
                "Name",
                "Date of Birth",
                "Designation",
                "WPS Establishment ID",
                "IBAN",
                "Bank Name",
                "WPS Person ID",
                "Passport Number",
                "Nationality",
                "Labor card",
                "Routing Code"
        };

        for (int i = 0; i < headers.length; i++) {
            OtherBankEmployeesStorage.storeData("employee-header-" + i, headers[i]);
        }
        OtherBankEmployeesStorage.storeData("employee-headers", String.join(",", headers));

        List<String> firstNames = Arrays.asList("John", "Michael", "Sara", "Laura", "Robert", "Emily");
        List<String> lastNames = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia");

        XSSFRow headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        for (int j = 0; j < 500; j++) {
            int randomNumber = 100000 + random.nextInt(900000);
            Map.Entry<String, String> selectedBank = banks.get(random.nextInt(banks.size()));
            Map.Entry<String, String> selectedNationality = nationalities.get(random.nextInt(nationalities.size()));
            String countryCode = selectedNationality.getValue();

            String empCodeValue = "EMP" + (1000 + j);
            String randomFirst = firstNames.get(random.nextInt(firstNames.size()));
            String randomLast = lastNames.get(random.nextInt(lastNames.size()));
            String displayNameValue = randomFirst + " " + randomLast;
            dob = RandomDateGenerator.generateAdultDOB();
            String designation = "Worker";
            String iban = "AE" + String.format("%021d", random.nextLong() & Long.MAX_VALUE);
            //String molNoVal = String.valueOf((long) (random.nextDouble() * 9_000_000_000_000_00L) + 1_000_000_000_000_00L);
            long wpsPersonId = (long) (random.nextDouble() * 9_000_000_000_000_00L) + 1_000_000_000_000_00L;
            String passport = passportNo + randomNumber;
            String laborCard = "L" + (random.nextInt(99999));

            String[] raws = {
                    empCodeValue,             // "Employee ID"
                    displayNameValue,         // "Name"
                    dob,
                    designation,
                    est,
                    iban,
                    selectedBank.getKey(),
                    String.valueOf(wpsPersonId), // Use this
                    passport,
                    countryCode,
                    laborCard,
                    selectedBank.getValue()
            };

            if (headers.length != raws.length) {
                System.out.println("❌ Header and data length mismatch at row #" + j);
                throw new IllegalStateException("Mismatch: headers.length != raws.length at row #" + j);
            }

            for (int i = 0; i < headers.length; i++) {
                OtherBankEmployeesStorage.storeData("employee-" + j + "-" + headers[i], raws[i]);
            }

            XSSFRow row = sheet.createRow(j + 1);
            for (int i = 0; i < raws.length; i++) {
                row.createCell(i).setCellValue(raws[i]);
            }
        }

        int fileSuffix = random.nextInt(100000);
        filePaths = "D:\\Hrcms\\src\\test\\java\\document\\other_employees_" + fileSuffix + ".xlsx";
        try (FileOutputStream fileOut = new FileOutputStream(filePaths)) {
            workbook.write(fileOut);
        } finally {
            workbook.close();
        }

        System.out.println("✅ Other banks employee data saved to: " + filePaths);
        System.out.println("📋 Stored Other Bank Employee Data:");
        OtherBankEmployeesStorage.printEmployeeTable();
    }
}