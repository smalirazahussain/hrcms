package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.ProcessSalariesDepositSlipPages;
import Utils.ProcessSalaryEmployeeData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.*;

import static Hooks.Base_Class.driver;
import static Pages.Android.AddEmployerPages.Company_Tittle;
import static Pages.Android.ProcessSalariesDepositSlipPages.*;
import static Pages.Android.RequestPage.Loading;
import static Step_Definitions.SignUpSteps.companyName;

public class ProcessSalariesDepositSlipSteps {

    Duration timeout = Duration.ofSeconds(900000);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    public static String companyTittle;

    @And("[Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip")
    public void processSalariesDepositSlipPageUserTapOnProcessSalariesDepositSlip() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Company_Tittle)));
        companyTittle = AddEmployerPages.get_Company_Tittle().getText();
        companyName = companyTittle;
        System.out.println(companyName);
        ProcessSalariesDepositSlipPages.get_Process_Salaries_Deposit_Slip().click();
    }


    @When("[Process Salaries DepositSlip Page] User enter company name and download the salary template then enter the salary in total colomn")
    public void processSalariesDepositSlipPageUserEnterCompanyNameAndDownloadTheSalaryTemplateThenEnterTheSalaryInTotalColomn() throws InterruptedException {
        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Download_Button)));
        Thread.sleep(5000);
        ProcessSalariesDepositSlipPages.get_Download_Button().click();
        Thread.sleep(10000);

        String filePath = "D:\\Hrcms\\src\\test\\java\\document";
        System.out.println(filePath);
        try {
            Workbook workbook = new XSSFWorkbook(Files.newInputStream(Paths.get(filePath)));
            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to work with the first sheet
            System.out.println(sheet);
            // Find the cells with specific values in the first two columns
            Cell targetCell1 = findCellWithValue(sheet, "Value1");
            Cell targetCell2 = findCellWithValue(sheet, "Value2");
            System.out.println("1"+targetCell1);
            System.out.println("2"+targetCell2);
            if (targetCell1 != null && targetCell2 != null) {
                // Get the row and column index of the target cells
                int targetRow = targetCell1.getRowIndex();
                int targetColumn = targetCell2.getColumnIndex();

                // Insert data in the third row or column based on the target cells
                Row row3 = sheet.createRow(targetRow + 1);
                Cell cell3 = row3.createCell(targetColumn);
                cell3.setCellValue("New Value");
                System.out.println(cell3);
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Target cells not found!");
            }

            // Write the updated data back to the file
            FileOutputStream fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
            System.out.println(fileOut);
            fileOut.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Cell findCellWithValue(Sheet sheet, String value) {
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(value)) {
                    return cell;
                }
            }
        }
        return null;
    }

      public static String  downloadedFileName;
    public static ArrayList<Object> allData = new ArrayList<>();

    @When("[Process Salaries DepositSlip Page] User enter company name and download the salary template")
    public void processSalariesDepositSlipPageUserEnterCompanyNameAndDownloadTheSalaryTemplate() throws InterruptedException, IOException, AWTException {

        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Loading)));
    //Thread.sleep(5000);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loading")));
       // wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Download_Button)));
        ProcessSalariesDepositSlipPages.get_Download_Button().click();
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Loading)));
    //Thread.sleep(20000);

    // Get the latest downloaded file from the download directory
    File downloadDir = new File("D:\\Hrcms\\src\\test\\java\\document"); // Replace with the actual download directory path
    File[] files = downloadDir.listFiles();
    File latestFile = null;
    long lastModifiedTime = Long.MIN_VALUE;
    assert files != null;
    for (File file : files) {
        if (file.lastModified() > lastModifiedTime) {
            lastModifiedTime = file.lastModified();
            latestFile = file;
        }
    }

    if (latestFile != null) {
        downloadedFileName = latestFile.getName();
        System.out.println("Downloaded file name: " + downloadedFileName);

        // Read the contents of the downloaded XLSX file
        FileInputStream fileInputStream = new FileInputStream(latestFile);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet
        System.out.println(sheet);
        int rowIndex = 0;
        Random random = new Random();

        for (Row row : sheet) {
            if (rowIndex > 0) {
                Cell seventhCell = row.createCell(9);
                Object empCode ;
                Object molNo;
                allData.add(new Object[]{empCode = row.getCell(0).getStringCellValue(), molNo = row.getCell(1).getStringCellValue()});
                //System.out.println("allData"+allData);
                System.out.println("empCode:"+empCode);
                System.out.println("molNo:"+molNo);
                int randomValue = random.nextInt(10000); // Generate a random number between 0 and 99
                seventhCell.setCellValue(randomValue);
                System.out.println(seventhCell);

                Thread.sleep(1);
            }
            rowIndex++;
        }

        // Save the modified workbook back to the same file
        try (FileOutputStream fos = new FileOutputStream(latestFile)) {
            workbook.write(fos);
            System.out.println("File modified and saved successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving the modified file: " + e.getMessage());
        }

        workbook.close();
        fileInputStream.close();
    } else {
        System.out.println("No file downloaded");
        // Handle the case where no file is downloaded
        // ...
    }
    Assert.assertEquals(downloadedFileName,downloadedFileName);
    System.out.println(downloadedFileName);
}

    @Then("[Process Salaries DepositSlip Page] User select the month and then upload the process file {string}")
    public void processSalariesDepositSlipPageUserSelectTheMonthAndThenUploadTheProcessFile(String date) throws InterruptedException {
        ProcessSalariesDepositSlipPages.get_Salary_Date().sendKeys(date+Keys.ENTER);
        //Thread.sleep(5000);
    }

    @And("[Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file")
    public void processSalariesDepositSlipPageUserTapOnBrowseFileAndUploadASalaryProcessFile() throws InterruptedException, AWTException {
        try {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Salary_Browse_File)));
        ProcessSalariesDepositSlipPages.get_Salary_Browse_File().click();
        Thread.sleep(3000);

            String filePath = "D:\\Hrcms\\src\\test\\java\\document\\" + salaryFile;
        Robot rb = new Robot();
        //StringSelection str = new StringSelection("D:\\Hrcms\\src\\test\\java\\document\\"+salaryFile+"");
            File file = new File(String.valueOf(salaryFile));
            StringSelection str = new StringSelection(file.getAbsolutePath());
            System.out.println("salaryFile:"+salaryFile);
            //StringSelection str = new StringSelection(salaryFile);
//            ProcessSalariesDepositSlipPages.get_Salary_Browse_File().sendKeys(filePath);
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
        Thread.sleep(10000);

    }
        catch (Exception e) {
            System.out.println("working");
        }
    }
    public static String actualamount ;
    @Then("[Process Salaries DepositSlip Page] User tap on submit button")
    public void processSalariesDepositSlipPageUserTapOnSubmitButton() throws InterruptedException {

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Salary_Amount)));
            actualamount = ProcessSalariesDepositSlipPages.get_Salary_Amount().getText();
            System.out.println("clientsalary" + actualamount);
        List<WebElement> empElements = ProcessSalariesDepositSlipPages.get_Emp_Codes();
        Set<String> uniqueEmpCodes = new HashSet<>();

        for (WebElement element : empElements) {
            String empCode = element.getText();
            uniqueEmpCodes.add(empCode);
            System.out.println("empCode"+empCode);
        }

        StringBuilder result = new StringBuilder();
        for (String empCode : uniqueEmpCodes) {
            result.append(empCode).append("\n");
        }

        System.out.println("modifyEmpCode"+result);

        String[] empCodesArray = new String[allData.size()];
        System.out.println("empCodesArray"+ Arrays.toString(empCodesArray));

        // Extract empCode from allData list and store them in a separate array
        String[] allEmpCodesArray = new String[allData.size()];
        for (int i = 0; i < allData.size(); i++) {
            Object[] data = (Object[]) allData.get(i);
            allEmpCodesArray[i] = (String) data[0]; // Assuming empCode is stored at index 0
            System.out.println("allEmpCodesArray[i]"+allEmpCodesArray[i]);
        }

        // Assert that the arrays are equal
        for (int i = 0; i < empCodesArray.length; i++) {
            System.out.println();
            Assert.assertEquals(empCodesArray[i], allEmpCodesArray[i]);
        }
//        assertArrayEquals(empCodesArray, allEmpCodesArray);

            //Assert.assertEquals();
            //Thread.sleep(5000);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Loading)));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Salary_Submit_Button)));
            ProcessSalariesDepositSlipPages.get_Cross_Button().click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Salary_Submit_Button)));
            ProcessSalariesDepositSlipPages.get_Salary_Submit_Button().click();
            //Thread.sleep(5000);
        }

//        catch (Exception e) {
//            // Handle any exceptions here
//            e.printStackTrace();
//        }
//        }
    //public static String downloadedFileName;
    private static final String DOWNLOAD_DIR = "D:\\Hrcms\\src\\test\\java\\document";
    public static File salaryFile;

    @When("[Process Salaries DepositSlip Page] User enter company name and download the salary template save all the data and give them salary")
    public void processSalariesDepositSlipPageUserEnterCompanyNameAndDownloadTheSalaryTemplateSaveAllDataAndGiveThemSalary() throws IOException, InterruptedException {

        // Step 1: Trigger download from UI
        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Loading)));
        ProcessSalariesDepositSlipPages.get_Download_Button().click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Loading)));

        // Step 2: Identify the latest downloaded file
        File downloadDir = new File(DOWNLOAD_DIR);
        File[] files = downloadDir.listFiles();
        File latestFile = null;
        long lastModifiedTime = Long.MIN_VALUE;

        if (files == null || files.length == 0) {
            throw new RuntimeException("No files found in the download directory.");
        }

        for (File file : files) {
            if (file.lastModified() > lastModifiedTime) {
                lastModifiedTime = file.lastModified();
                latestFile = file;
            }
        }

        if (latestFile == null) {
            throw new RuntimeException("Failed to find the latest downloaded file.");
        }

        downloadedFileName = latestFile.getName();
        System.out.println("\uD83D\uDCC1 Downloaded File: " + downloadedFileName);

        // Step 3: Load Excel data using utility
        ProcessSalaryEmployeeData.loadFromExcel(latestFile);
        List<Map<String, Object>> employees = ProcessSalaryEmployeeData.getAllData();

        // Step 4: Generate and assign salary + print info
        Random random = new Random();
        for (Map<String, Object> employee : employees) {
            double fixAmount = 4000 + random.nextInt(4001);
            double varAmount = random.nextInt(2001);
            double total = fixAmount + varAmount;

            employee.put("FIX AMOUNT", fixAmount);
            employee.put("VAR AMT", varAmount);
            employee.put("TOTAL", total);

            System.out.println("\uD83D\uDCB8 Paying Salary to: " + employee.get("EMPLOYEE NAME"));
            System.out.println("MOL NO: " + employee.get("MOL NO"));
            System.out.println("EMP CODE: " + employee.get("EMP CODE"));
            System.out.println("FIX AMOUNT: " + fixAmount);
            System.out.println("VAR AMT: " + varAmount);
            System.out.println("TOTAL: " + total);
            System.out.println("WALLET ID/IBAN: " + employee.get("WALLET ID/IBAN"));
            System.out.println("DETAIL TYPE: " + employee.get("DETAIL TYPE"));
            System.out.println("ESTABLISHMENT ID: " + employee.get("ESTABLISHMENT ID"));
            System.out.println("NO OF LEAVE DAYS: " + employee.get("NO OF LEAVE DAYS"));
            System.out.println("--------------------------------------");

            // salaryService.sendSalary(employee);
        }

        // Step 5: Save the updated Excel
        salaryFile = new File(DOWNLOAD_DIR+downloadedFileName);
        ProcessSalaryEmployeeData.writeUpdatedExcel(latestFile, salaryFile);
        System.out.println("\u2705 Updated Excel saved to: " + salaryFile.getAbsolutePath());

        Assert.assertNotNull(downloadedFileName, "Downloaded file name should not be null");
    }}


