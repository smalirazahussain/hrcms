package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.AdminPage;
import Pages.Android.EmployeesPage;
import com.google.common.collect.Table;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import static Hooks.Base_Class.driver;
import static Pages.Android.UpdateProliePage.getSubmitButton;
import static Tests.Scroll.ScrollVertical;

public class Employeessteps {

    public WebDriverWait wait = new WebDriverWait(driver, 30);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    @Then("[Employees Page] User tap on employees button")
    public void employeesPageUserTapOnEmployeesButton() throws InterruptedException {
        EmployeesPage.get_Employees().click();
        Thread.sleep(5000);

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
        File downloadFile1 = new File("C:\\Users\\Ali Raza\\Downloads\\"+ kamelpayEmployees);
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

        Random random = new Random();

        int randomNumber = random.nextInt(10000);


        // Write the workbook to an output stream
        String filePath = "D:\\Hrcms\\src\\test\\java\\document\\"+randomNumber+".xlsx";
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            workbook.close();
        }
    }

//                HSSFWorkbook workbook = new HSSFWorkbook();
//
//        HSSFSheet sheet = workbook.createSheet("Bulk employees");
//
//// Create a new row
//        HSSFRow row = sheet.createRow(0);
//
//
//
//// Create cells and add values to them
//        HSSFCell cell1 = row.createCell(0);
//        cell1.setCellValue("Mol No");
//
//
//
//        HSSFCell cell2 = row.createCell(1);
//        cell2.setCellValue("Emp Code");
//
//        HSSFCell cell3 = row.createCell(2);
//        cell3.setCellValue("First Name");
//
//        HSSFCell cell4 = row.createCell(3);
//        cell4.setCellValue("Last Name");
//
//        HSSFCell cell5 = row.createCell(4);
//        cell5.setCellValue("Display Name");
//
//        HSSFCell cell6 = row.createCell(5);
//        cell6.setCellValue("Date of Birth");
//
//        HSSFCell cell7 = row.createCell(6);
//        cell7.setCellValue("Gender(M/F)");
//
//        HSSFCell cell8 = row.createCell(7);
//        cell8.setCellValue("Nationality");
//
//        HSSFCell cell9 = row.createCell(8);
//        cell9.setCellValue("Date of Joining");
//
//        HSSFCell cell10 = row.createCell(9);
//        cell10.setCellValue("Email");
//
//        HSSFCell cell11 = row.createCell(10);
//        cell11.setCellValue("Mobile");
//
//        HSSFCell cell12 = row.createCell(11);
//        cell12.setCellValue("Alternate Phone");
//
//        HSSFCell cell13 = row.createCell(12);
//        cell13.setCellValue("Home Address");
//
//        HSSFCell cell14 = row.createCell(13);
//        cell14.setCellValue("Home State");
//
//        HSSFCell cell15 = row.createCell(14);
//        cell15.setCellValue("Home Post Code");
//
//        HSSFCell cell16 = row.createCell(15);
//        cell16.setCellValue("Work Address");
//
//        HSSFCell cell17 = row.createCell(16);
//        cell17.setCellValue("Work State");
//
//        HSSFCell cell18 = row.createCell(17);
//        cell18.setCellValue("Work Post Code");
//
//        HSSFCell cell19 = row.createCell(18);
//        cell19.setCellValue("Passport Number");
//
//        HSSFCell cell20 = row.createCell(19);
//        cell20.setCellValue("Passport Expiry");
//
//        HSSFCell cell21 = row.createCell(20);
//        cell21.setCellValue("EID");
//
//        HSSFCell cell22 = row.createCell(21);
//        cell22.setCellValue("EID Expiry");
//
//        HSSFCell cell23 = row.createCell(22);
//        cell23.setCellValue("Establishment Id");
//
//
//
//// Write the workbook to an output stream
//        FileOutputStream fileOut = new FileOutputStream("downloadFile + \".xls\"");
//        File file = new File("D:\\Hrcms\\src\\test\\java\\document\\Testing1.xlsx");
//        workbook.write(file);
//////        fileOut.close();
////
////// Close the workbook
//            workbook.close();

}
