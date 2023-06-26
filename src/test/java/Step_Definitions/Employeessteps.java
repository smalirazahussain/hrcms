package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.EmployeesPage;;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import java.util.Arrays;
import java.util.Random;

import static Hooks.Base_Class.driver;
import static Step_Definitions.SignUpSteps.companyName;
import static Step_Definitions_Head_Ofiice.EstablishmentsStepsHeadOffice.branchEstablishmentId;


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
    @Then("[Employees Page] User tap on employees button")
    public void employeesPageUserTapOnEmployeesButton() throws InterruptedException {
         companyTittle = AddEmployerPages.get_Company_Tittle().getText();
        companyName = companyTittle;
        System.out.println(companyName);
        EmployeesPage.get_Employees().click();
        //Thread.sleep(5000);



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
    public void employeesPageUserCreateAMultipleDataForTheEmployer(String molNo,String empCode,String firstName,String lastName,String displayName,String dob,String gender,String nationality,String joiningDate,String email,String mobile,String altenatePhone,String homeAddress,String homeState,String homePostCode,String workAddress,String workState,String workPostCode,String PassportNo,String passportExpiry,String eid,String eidExpiry,String est) throws IOException, InterruptedException {
        //System.out.println(branchEstablishmentId);
        String[] headers = {"Mol No","Emp Code","First Name","Last Name","Display Name","Date of Birth","Gender(M/F)".trim(),"Nationality".trim().replaceAll("^\\s+", ""),"Date of Joining","Email","Mobile","Alternate Phone","Home Address","Home State","Home Post Code","Work Address","Work State","Work Post Code","Passport Number","Passport Expiry","EID","EID Expiry","Establishment Id"};
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
            for (int j = 0; j < 10; j++) {
                int randomNumber = random.nextInt(1000000000);



                raws = new String[]{molNo+randomNumber,empCode+randomNumber,firstName,lastName,displayName+randomNumber,dob,gender.trim(),nationality.trim().replaceAll("^\\s+", ""),joiningDate,"user"+randomNumber+email,mobile+randomNumber,altenatePhone+randomNumber,homeAddress+randomNumber,homeState,homePostCode,workAddress,workState,workPostCode,PassportNo+randomNumber,passportExpiry,eid+randomNumber,eidExpiry,branchEstablishmentId+est};
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

}





