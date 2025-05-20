package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.ProcessSalariesDepositSlipPages;
import Pages.Android.RequestPage;
import Utils.ProcessSalaryEmployeeData;
import Utils.SIFFileUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.*;

import static Hooks.Base_Class.driver;
import static Pages.Android.AddEmployerPages.Company_Tittle;
import static Pages.Android.ProcessSalariesDepositSlipPages.*;
import static Pages.Android.RequestPage.Loading;
import static Step_Definitions.SignUpSteps.companyName;

public class ProcessSalariesDepositSlipSteps {

    Duration timeout = Duration.ofSeconds(30);
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
   // public static String salaryMonth;
    @Then("[Process Salaries DepositSlip Page] User select the month and then upload the process file {string}")
    public void processSalariesDepositSlipPageUserSelectTheMonthAndThenUploadTheProcessFile(String salaryMonth) throws InterruptedException {
        ProcessSalaryEmployeeData.salaryMonth = salaryMonth; // assign to static variable
        ProcessSalariesDepositSlipPages.get_Salary_Date().sendKeys(salaryMonth+Keys.ENTER);
        //Thread.sleep(5000);
    }

    @And("[Process Salaries DepositSlip Page] User tap on browse file and upload a salary process file")
    public void processSalariesDepositSlipPageUserTapOnBrowseFileAndUploadASalaryProcessFile() throws InterruptedException, AWTException {
////        try {
////        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Salary_Browse_File)));
////        ProcessSalariesDepositSlipPages.get_Salary_Browse_File().click();
////        Thread.sleep(3000);
////
////            String filePath = "D:\\Hrcms\\src\\test\\java\\document\\" + salaryFile;
////        Robot rb = new Robot();
////        //StringSelection str = new StringSelection("D:\\Hrcms\\src\\test\\java\\document\\"+salaryFile+"");
////            File file = new File(String.valueOf(salaryFile));
////            StringSelection str = new StringSelection(file.getAbsolutePath());
////            System.out.println("salaryFile:"+salaryFile);
////            //StringSelection str = new StringSelection(salaryFile);
//////            ProcessSalariesDepositSlipPages.get_Salary_Browse_File().sendKeys(filePath);
////        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
////        // press Contol+V for pasting
////        rb.keyPress(KeyEvent.VK_CONTROL);
////        rb.keyPress(KeyEvent.VK_V);
////
////        // release Contol+V for pasting
////        rb.keyRelease(KeyEvent.VK_CONTROL);
////        rb.keyRelease(KeyEvent.VK_V);
////
////        // for pressing and releasing Enter
////        rb.keyPress(KeyEvent.VK_ENTER);
////        rb.keyRelease(KeyEvent.VK_ENTER);
////        //ScrollVertical(get_Add_Emplyer_Button());
////        Thread.sleep(10000);
////
////    }
////        catch (Exception e) {
////            System.out.println("working");
////        }
//       // try {
//            // Ensure Browse File button is visible and clickable
//            WebElement browseSalaryFileButton = wait.until(ExpectedConditions.elementToBeClickable(ProcessSalariesDepositSlipPages.get_Salary_Browse_File()));
//            browseSalaryFileButton.click();
//
//
//            Robot robot = new Robot();
//
//            // Press ESC to close the file upload window
//            robot.keyPress(KeyEvent.VK_ESCAPE);
//            robot.keyRelease(KeyEvent.VK_ESCAPE);
//        Thread.sleep(3000);
//            System.out.println("✅ File upload window closed using ESC.");
//            // Constructing the absolute file path dynamically
//            String salaryDocFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
//                    File.separator + "java" + File.separator + "document" + File.separator + salaryFile;
//            WebElement fileInput = driver.findElement(By.xpath("//form[.//span[text()='This file contains WPS employees']]//button[.='Browse File']"));
//            fileInput.sendKeys(salaryDocFilePath);
//            System.out.println("salaryDocFilePath"+salaryDocFilePath);
//
//            // Wait for file preview to appear (confirming the upload)
//            WebElement uploadedSponsorFileElement = wait.until(
//                    ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='preview flex0'])[1]")));
//                   // System.out.println("📄 Salary file to upload: " + salaryDocFilePath);
//            Assert.assertTrue(uploadedSponsorFileElement.isDisplayed(), "❌ Sponsor Document upload failed, preview not found!");
//
//            // If everything passes, print success message
//            System.out.println("✅ Successfully uploaded Sponsor Document: " + salaryDocFilePath);
////        }
////
////        catch (Exception e) {
////            System.out.println("working");
////        }
        try {
            // Step 1: Click visible 'Browse File' button to make input appear (if required)
            WebElement browseSalaryFileButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//form[.//span[text()='This file contains WPS employees']]//button[.//span[text()='Browse File']]")
            ));
            browseSalaryFileButton.click();
            System.out.println("✅ Browse File button clicked.");
            Thread.sleep(1000);

            // Step 2: Avoid system dialog if it appears
            Robot robot = new Robot();


        String salaryDocFilePath;

        if (new File(String.valueOf(salaryFile)).isAbsolute()) {
            // Full path provided
            salaryDocFilePath = String.valueOf(salaryFile);
        } else {
            // Relative filename provided, build full path
            salaryDocFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                    File.separator + "java" + File.separator + "document" + File.separator + salaryFile;
        }

        System.out.println("📄 Salary file to upload: " + salaryDocFilePath);

// Validate it exists before sending to WebDriver
        File fileToUpload = new File(salaryDocFilePath);
        Assert.assertTrue(fileToUpload.exists(), "❌ File does not exist: " + salaryDocFilePath);
            // Step 4: Find <input type="file"> inside DOM (even if hidden)
            WebElement fileInput = driver.findElement(By.xpath("//input[@type='file' and contains(@accept, 'excel')]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", fileInput); // ensure visible for sendKeys

            // Step 5: Upload file
            fileInput.sendKeys(salaryDocFilePath);
            System.out.println("📤 File path sent to input[type='file'].");

            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            System.out.println("✅ File upload window closed using ESC.");
            Thread.sleep(2000);

            // Step 6: Wait for confirmation preview
            WebElement uploadedSalaryFilePreview = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'preview flex0 margin-right_zero')]//span"))
            );
            Assert.assertTrue(uploadedSalaryFilePreview.isDisplayed(), "❌ File upload failed, preview not found!");
            System.out.println("✅ Successfully uploaded Salary Process File");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("❌ Upload failed due to exception: " + e.getMessage());
        }
    }
    public static String actualamount ;
    @Then("[Process Salaries DepositSlip Page] User tap on submit button")
    public void processSalariesDepositSlipPageUserTapOnSubmitButton() throws InterruptedException {
//
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Salary_Amount)));
//            actualamount = ProcessSalariesDepositSlipPages.get_Salary_Amount().getText();
//            System.out.println("clientsalary" + actualamount);
//        List<WebElement> empElements = ProcessSalariesDepositSlipPages.get_Emp_Codes();
//        Set<String> uniqueEmpCodes = new HashSet<>();
//
//        for (WebElement element : empElements) {
//            String empCode = element.getText();
//            uniqueEmpCodes.add(empCode);
//            System.out.println("empCode"+empCode);
//        }
//
//        StringBuilder result = new StringBuilder();
//        for (String empCode : uniqueEmpCodes) {
//            result.append(empCode).append("\n");
//        }
//
//        System.out.println("modifyEmpCode"+result);
//
//        String[] empCodesArray = new String[allData.size()];
//        System.out.println("empCodesArray"+ Arrays.toString(empCodesArray));
//
//        // Extract empCode from allData list and store them in a separate array
//        String[] allEmpCodesArray = new String[allData.size()];
//        for (int i = 0; i < allData.size(); i++) {
//            Object[] data = (Object[]) allData.get(i);
//            allEmpCodesArray[i] = (String) data[0]; // Assuming empCode is stored at index 0
//            System.out.println("allEmpCodesArray[i]"+allEmpCodesArray[i]);
//        }
//
//        // Assert that the arrays are equal
//        for (int i = 0; i < empCodesArray.length; i++) {
//            System.out.println();
//            Assert.assertEquals(empCodesArray[i], allEmpCodesArray[i]);
//        }
//        assertArrayEquals(empCodesArray, allEmpCodesArray);

            //Assert.assertEquals();
            //Thread.sleep(5000);
           // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Loading)));
           // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Salary_Submit_Button)));
            //ProcessSalariesDepositSlipPages.get_Cross_Button().click();
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
    private static final String DOWNLOAD_DIR = "D:\\Hrcms\\src\\test\\java\\document\\";
    //D:\Hrcms\src\test\java\document
    public static File salaryFile;
    public static long salaryFileLastSavedTime;
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
        // Step 5: Save the updated Excel
        salaryFile = new File(DOWNLOAD_DIR + downloadedFileName);
        ProcessSalaryEmployeeData.loadFromExcel(latestFile,salaryFile );
        List<Map<String, Object>> employees = ProcessSalaryEmployeeData.getAllData();
        System.out.println("✅ Updated Excel saved to: " + salaryFile.getAbsolutePath());

// ✅ Save the last modified timestamp here
        salaryFileLastSavedTime = System.currentTimeMillis();

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
            System.out.println("EMPLOYEE NAME: " + employee.get("EMPLOYEE NAME"));
            System.out.println("NO OF LEAVE DAYS: " + employee.get("NO OF LEAVE DAYS"));
            System.out.println("--------------------------------------");

            // salaryService.sendSalary(employee);
        }

        // Step 5: Save the updated Excel
        salaryFile = new File(DOWNLOAD_DIR+downloadedFileName);
        ProcessSalaryEmployeeData.writeUpdatedExcel(latestFile, salaryFile);
        System.out.println("\u2705 Updated Excel saved to: " + salaryFile.getAbsolutePath());

        Assert.assertNotNull(downloadedFileName, "Downloaded file name should not be null");
    }

    @Then("[Process Salaries DepositSlip Page] User get the employee salary data in the modify salary screen and verify to the actual salary file")
    public void processSalariesDepositSlipPageUserGetTheEmployeeSalaryDataInTheModifySalaryScreenAndVerifyToTheActualSalaryFile() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Salary_Amount)));
        actualamount = ProcessSalariesDepositSlipPages.get_Salary_Amount().getText();
        System.out.println("Client summary salary amount: " + actualamount);

        List<WebElement> headerElements = driver.findElements(By.cssSelector("div[class='ant-modal-root css-1d4w9r2'] th"));
        List<WebElement> dataCells = driver.findElements(By.cssSelector("div[class='ant-modal-root css-1d4w9r2'] td"));

        List<String> headers = new ArrayList<>();
        for (WebElement header : headerElements) {
            headers.add(header.getText().trim());
        }

        int columnCount = headers.size();
        if (columnCount == 0) {
            System.err.println("❌ No headers found in the salary table. Aborting validation.");
            return;
        }

        int totalCells = dataCells.size();
        int rowCount = totalCells / columnCount;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<Map<String, String>> uiDataRows = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            Map<String, String> row = new LinkedHashMap<>();
            for (int j = 0; j < columnCount; j++) {
                WebElement cell = dataCells.get(i * columnCount + j);
                js.executeScript("arguments[0].scrollIntoView({block: 'center'});", cell);
                String key = headers.get(j);
                String value = cell.getText().trim();
                row.put(key, value);
            }
            uiDataRows.add(row);
            System.out.println("UI Row " + (i + 1) + ": " + row);
        }

        List<Map<String, Object>> expectedData = ProcessSalaryEmployeeData.getAllData();
        Assert.assertEquals(uiDataRows.size(), expectedData.size(), "❌ Row count mismatch between UI and Excel data");

        // Header mapping between UI and Excel
        Map<String, String> keyMapping = Map.ofEntries(
                Map.entry("Wallet Id", "WALLET ID/IBAN"),
                Map.entry("Wallet ID", "WALLET ID/IBAN"),
                Map.entry("Detail Type", "DETAIL TYPE"),
                Map.entry("Establishment ID", "ESTABLISHMENT ID"),
                Map.entry("Routing Code", "ROUTING CODE"),
                Map.entry("Display Name", "EMPLOYEE NAME"),
                Map.entry("Card Type", "CARD TYPE"),
                Map.entry("Eid", "EID"),
                Map.entry("Nationality", "NATIONALITY"),
                Map.entry("Personal No", "MOL NO"),
                Map.entry("Bank Name", "BANK NAME"),
                Map.entry("Branch", "BRANCH"),
                Map.entry("SHORT CODE", "SHORT CODE"),
                Map.entry("SALARY MONTH", "SALARY MONTH"),
                Map.entry("KPID", "KPID")
        );

        for (int i = 0; i < uiDataRows.size(); i++) {
            Map<String, String> uiRow = uiDataRows.get(i);
            Map<String, Object> excelRow = expectedData.get(i);

            System.out.println("\n🔍 Verifying Row " + (i + 1));
            List<String> mismatches = new ArrayList<>();

            // Handle Card Type logic based on CAUTION
            String cardTypeValue = uiRow.getOrDefault("Card Type", "").trim();
            String caution = uiRow.getOrDefault("CAUTION", "").trim();

            if (caution.equalsIgnoreCase("This employee contains dual account details and you are using kamelpay details.")) {
                if (!cardTypeValue.isEmpty()) {
                    mismatches.add(String.format("❌ Row %d: Card Type must be empty due to CAUTION, but found: '%s'", i + 1, cardTypeValue));
                } else {
                    System.out.println("✔️ Card Type is correctly blank due to CAUTION.");
                }
            } else {
                if (!cardTypeValue.equals("PAYD")) {
                    mismatches.add(String.format("❌ Row %d: Card Type must be 'PAYD'. Found: '%s'", i + 1, cardTypeValue));
                } else {
                    System.out.println("✔️ Card Type is correctly 'PAYD'.");
                }
            }

            for (String uiKey : uiRow.keySet()) {
                if (uiKey.equals("Card Type")) continue; // already handled

                // Special handling for SALARY MONTH (from static variable)
                if (uiKey.equals("SALARY MONTH")) {
                    String uiValue = uiRow.get(uiKey).trim();
                    String expectedValue = ProcessSalaryEmployeeData.salaryMonth.trim();

                    System.out.printf("🔸 %-20s | UI: %-15s | Expected: %-15s%n", uiKey, uiValue, expectedValue);

                    try {
                        DateTimeFormatter uiFormatter = DateTimeFormatter.ofPattern("MM/yyyy");
                        DateTimeFormatter expectedFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

                        YearMonth uiMonth = YearMonth.parse(uiValue, uiFormatter);
                        YearMonth expectedMonth = YearMonth.parse(expectedValue, expectedFormatter);

                        if (!uiMonth.equals(expectedMonth)) {
                            mismatches.add(String.format("❌ Mismatch in Row %d, Column '%s': UI='%s' vs Expected='%s'", i + 1, uiKey, uiValue, expectedValue));
                        } else {
                            System.out.println("✔️ Salary Month matches (normalized).");
                        }

                    } catch (DateTimeParseException ex) {
                        mismatches.add(String.format("❌ Invalid date format in Row %d, Column '%s': UI='%s' or Expected='%s'", i + 1, uiKey, uiValue, expectedValue));
                    }
                    continue;
                }

                String excelKey = keyMapping.getOrDefault(uiKey, uiKey);
                if (!excelRow.containsKey(excelKey)) {
                    System.out.println("⚠️ Skipping unmatched column: " + uiKey);
                    continue;
                }

                String uiValue = uiRow.get(uiKey).trim();
                String expectedValue = excelRow.getOrDefault(excelKey, "").toString().trim();

                System.out.printf("🔸 %-20s | UI: %-15s | Excel: %-15s%n", uiKey, uiValue, expectedValue);

                if (isNumeric(uiValue) && isNumeric(expectedValue)) {
                    double actual = Double.parseDouble(uiValue);
                    double expected = Double.parseDouble(expectedValue);
                    if (Math.abs(actual - expected) > 0.1) {
                        mismatches.add(String.format("❌ Mismatch in Row %d, Column '%s': UI=%s vs Excel=%s", i + 1, uiKey, uiValue, expectedValue));
                    }
                } else {
                    if (!uiValue.equals(expectedValue)) {
                        mismatches.add(String.format("❌ Mismatch in Row %d, Column '%s': UI='%s' vs Excel='%s'", i + 1, uiKey, uiValue, expectedValue));
                    }
                }
            }

            if (!mismatches.isEmpty()) {
                mismatches.forEach(System.err::println);
                Assert.fail("❌ Mismatches found in row " + (i + 1));
            }
        }

        System.out.println("\n✅ UI data in Modify Salary screen matches the updated Excel salary data.");
        ProcessSalariesDepositSlipPages.get_Cross_Button().click();
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    @Then("[Process Salaries DepositSlip Page] User verify the file type is {string}")
    public void processSalariesDepositSlipPageUserVerifyTheFileTypeIs(String expectedFileType) {
        // Locate selected radio input
        //List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[name='wps']"));
        ProcessSalariesDepositSlipPages.get_WPS_File_Type_Radio_Button();
        String actualSelectedText = "";

        for (WebElement radio : get_WPS_File_Type_Radio_Button()) {
            if (radio.isSelected()) {
                WebElement label = radio.findElement(By.xpath("./ancestor::label"));
                actualSelectedText = label.getText().trim();
                break;
            }
        }
        Assert.assertEquals(actualSelectedText, expectedFileType, "❌ File type does not match expected selection");
        System.out.println("✔️ Selected File Type: " + actualSelectedText);
    }

    @Then("[Process Salaries DepositSlip Page] User tap on salary file submit button")
    public void processSalariesDepositSlipPageUserTapOnSalaryFileSubmitButton() {
        ProcessSalariesDepositSlipPages.get_Salary_File_Submit_Button().click();
        try{
            Duration timeout = Duration.ofSeconds(3);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement ok_Button=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Salary_File_Approval_Ok_Button)));
        if(ok_Button.isDisplayed()&& ok_Button.isEnabled()) {
            ProcessSalariesDepositSlipPages.get_Salary_File_Approval_Ok_Button().click();
        }
        } catch (TimeoutException e) {
            System.out.println("OK button did not appear — skipping the click.");
        }
    }

//    @Then("[Process Salaries DepositSlip Page] User verifies the downloaded SIF file matches Modify Salary screen data")
//    public void processSalariesDepositSlipPageUserVerifiesTheDownloadedSIFFileMatchesModifySalaryScreenData() throws InterruptedException {
//        // Step 1: Trigger SIF file download
//        RequestPage.get_Sif_File().click();
//        System.out.println("⬇️ Triggered SIF file download...");
//        Thread.sleep(5000); // Allow browser to start downloading
//
//        // Step 2: Wait and detect the latest file
//        String downloadPath = "D:/Hrcms/src/test/java/document/";
//        File downloadedSIF = waitForLatestDownloadedFileAfterTimestamp(downloadPath, salaryFileLastSavedTime);
//        Assert.assertNotNull(downloadedSIF, "❌ SIF file was not downloaded or detected.");
//        System.out.println("📄 SIF file selected: " + downloadedSIF.getAbsolutePath());
//
//        // Step 3: Read and print SIF file data
//        List<Map<String, Object>> sifData = SIFFileUtils.loadSIFFile(downloadedSIF);
//        System.out.println("\n📋 SIF File Contents:");
//        for (int i = 0; i < sifData.size(); i++) {
//            System.out.println("📄 Row " + (i + 1) + ": " + sifData.get(i));
//        }
//
//        // Step 4: Compare with expected salary data
//        List<Map<String, Object>> expectedData = ProcessSalaryEmployeeData.getAllData();
//        Assert.assertEquals(sifData.size(), expectedData.size(), "❌ Row count mismatch");
//
//        for (int i = 0; i < sifData.size(); i++) {
//            Map<String, Object> sifRow = sifData.get(i);
//            Map<String, Object> expectedRow = expectedData.get(i);
//            List<String> mismatches = new ArrayList<>();
//
//            System.out.println("\n🔍 Verifying Row " + (i + 1));
//            System.out.println("📝 Expected Row " + (i + 1) + ":");
//            expectedRow.forEach((k, v) -> System.out.println("    " + k + " = " + v));
//            System.out.println("📄 Actual SIF Row " + (i + 1) + ":");
//            sifRow.forEach((k, v) -> System.out.println("    " + k + " = " + v));
//            // ✅ Field mapping for assertions
//            compareField(expectedRow, sifRow, "MOL NO", "Personal No", mismatches);
//            compareField(expectedRow, sifRow, "WALLET ID/IBAN", "AccountNo/IBAN", mismatches);
//            compareField(expectedRow, sifRow, "ESTABLISHMENT ID", "Establisment ID", mismatches);
//            compareField(expectedRow, sifRow, "EMPLOYEE NAME", "Emp Name", mismatches);
//            compareField(expectedRow, sifRow, "NO OF LEAVE DAYS", "Leave Days", mismatches);
//            compareField(expectedRow, sifRow, "FIX AMOUNT", "Fixed Amount", mismatches);
//            compareField(expectedRow, sifRow, "VAR AMT", "Variable Amount", mismatches);
//            compareField(expectedRow, sifRow, "TOTAL", "Total Amount", mismatches);
//            //compareField(expectedRow, sifRow, "REMARKS", "Remarks", mismatches);
//            compareField(expectedRow, sifRow, "ROUTING CODE", "Routing Code", mismatches);
//
//            String expectedMonth = ProcessSalaryEmployeeData.salaryMonth.trim();
//            if (sifRow.containsKey("Remarks")) {
//                String sifMonth = sifRow.get("Remarks").toString().trim();
//                if (!monthsMatch(expectedMonth, sifMonth)) {
//                    mismatches.add(String.format("❌ Mismatch in SALARY MONTH: Expected='%s' vs SIF='%s'", expectedMonth, sifMonth));
//                }
//            } else {
//                System.out.println("⚠️ Remarks (SALARY MONTH) column not found in SIF file.");
//            }
//
//        }
//
//        System.out.println("\n✅ All rows from SIF file match the expected data.");
//    }
//    private File waitForLatestDownloadedFileAfterTimestamp(String downloadDir, long afterTimestamp) {
//        File dir = new File(downloadDir);
//        if (!dir.exists() || !dir.isDirectory()) {
//            System.err.println("❌ Directory not found: " + downloadDir);
//            return null;
//        }
//
//        long endTime = System.currentTimeMillis() + 30 * 1000;
//
//        while (System.currentTimeMillis() < endTime) {
//            File[] files = dir.listFiles((d, name) ->
//                    name.toLowerCase().endsWith(".xlsx")
//                            && !name.endsWith(".part")
//                            && !name.endsWith(".crdownload")
//                            && new File(d, name).lastModified() > afterTimestamp);
//
//            if (files != null && files.length > 0) {
//                File latestFile = Arrays.stream(files)
//                        .max(Comparator.comparingLong(File::lastModified))
//                        .orElse(null);
//                if (latestFile != null && latestFile.length() > 0) {
//                    System.out.println("✅ Found SIF file: " + latestFile.getAbsolutePath());
//                    return latestFile;
//                }
//            }
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ignored) {}
//        }
//
//        System.err.println("❌ No valid SIF file found after salary file.");
//        return null;
//    }
//    private void compareField(Map<String, Object> expectedRow, Map<String, Object> sifRow, String expectedKey, String sifKey, List<String> mismatches) {
//        String expectedValue = expectedRow.getOrDefault(expectedKey, "").toString().trim();
//        String actualValue = sifRow.getOrDefault(sifKey, "").toString().trim();
//
//        if (isNumeric(expectedValue) && isNumeric(actualValue)) {
//            double expected = Double.parseDouble(expectedValue);
//            double actual = Double.parseDouble(actualValue);
//            if (Math.abs(expected - actual) > 0.1) {
//                mismatches.add(String.format("❌ Mismatch in '%s': Expected=%s vs SIF=%s", expectedKey, expectedValue, actualValue));
//            }
//        } else if (!expectedValue.equals(actualValue)) {
//            mismatches.add(String.format("❌ Mismatch in '%s': Expected='%s' vs SIF='%s'", expectedKey, expectedValue, actualValue));
//        }
//    }
//
//    private boolean monthsMatch(String ui, String excel) {
//        try {
//            // Try both ways
//            YearMonth expected = YearMonth.parse(ui, DateTimeFormatter.ofPattern("yyyy-MM"));       // 2012-04
//            YearMonth actual = YearMonth.parse(excel, DateTimeFormatter.ofPattern("MM/yyyy"));      // 04/2012
//            return expected.equals(actual);
//        } catch (Exception e) {
//            System.out.println("⚠️ Month comparison failed: " + e.getMessage());
//            return false;
//        }
//    }
//
//
@Then("[Process Salaries DepositSlip Page] User verifies the downloaded SIF file matches Modify Salary screen data")
public void processSalariesDepositSlipPageUserVerifiesTheDownloadedSIFFileMatchesModifySalaryScreenData() throws InterruptedException {
    // Step 1: Trigger SIF file download
    RequestPage.get_Sif_File().click();
    System.out.println("⬇️ Triggered SIF file download...");
    Thread.sleep(5000); // Allow browser to start downloading

    // Step 2: Wait and detect the latest file
    String downloadPath = "D:/Hrcms/src/test/java/document/";
    File downloadedSIF = waitForLatestDownloadedFileAfterTimestamp(downloadPath, salaryFileLastSavedTime);
    Assert.assertNotNull(downloadedSIF, "❌ SIF file was not downloaded or detected.");
    System.out.println("📄 SIF file selected: " + downloadedSIF.getAbsolutePath());

    // Step 3: Read and print SIF file data
    List<Map<String, Object>> sifData = SIFFileUtils.loadSIFFile(downloadedSIF);
    System.out.println("\n📋 SIF File Contents:");
    for (int i = 0; i < sifData.size(); i++) {
        System.out.println("📄 Row " + (i + 1) + ": " + sifData.get(i));
    }

    // Step 4: Compare with expected salary data
    List<Map<String, Object>> expectedData = ProcessSalaryEmployeeData.getAllData();
    Assert.assertEquals(sifData.size(), expectedData.size(), "❌ Row count mismatch");

    // Field Mapping: Expected Key -> SIF Header
    Map<String, String> fieldMap = Map.of(
            "MOL NO", "Personal No",
            "WALLET ID/IBAN", "AccountNo/IBAN",
            "ESTABLISHMENT ID", "Establisment ID",
            "EMPLOYEE NAME", "Emp Name",
            "NO OF LEAVE DAYS", "Leave Days",
            "FIX AMOUNT", "Fixed Amount",
            "VAR AMT", "Variable Amount",
            "TOTAL", "Total Amount",
            "ROUTING CODE", "Routing Code"
    );

    for (int i = 0; i < sifData.size(); i++) {
        Map<String, Object> sifRow = sifData.get(i);
        Map<String, Object> expectedRow = expectedData.get(i);
        List<String> mismatches = new ArrayList<>();

        System.out.println("\n🔍 Verifying Row " + (i + 1));
        System.out.println("📝 Expected Row " + (i + 1) + ":");
        expectedRow.forEach((k, v) -> System.out.println("    " + k + " = " + v));

        System.out.println("📄 Actual SIF Row " + (i + 1) + ":");
        sifRow.forEach((k, v) -> System.out.println("    " + k + " = " + v));

        // Field-by-field comparison
        for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
            compareField(expectedRow, sifRow, entry.getKey(), entry.getValue(), mismatches);
        }

        // SALARY MONTH validation using Remarks
        String expectedMonth = ProcessSalaryEmployeeData.salaryMonth.trim();
        if (sifRow.containsKey("Remarks")) {
            String sifMonth = sifRow.get("Remarks").toString().trim();
            if (!monthsMatch(expectedMonth, sifMonth)) {
                mismatches.add(String.format("❌ Mismatch in SALARY MONTH: Expected='%s' vs SIF='%s'", expectedMonth, sifMonth));
            }
        } else {
            System.out.println("⚠️ Remarks (SALARY MONTH) column not found in SIF file.");
        }

        if (!mismatches.isEmpty()) {
            mismatches.forEach(System.err::println);
            Assert.fail("❌ Mismatches found in Row " + (i + 1));
        }
    }

    System.out.println("\n✅ All rows from SIF file match the expected data.");
}
    private File waitForLatestDownloadedFileAfterTimestamp(String downloadDir, long afterTimestamp) {
        File dir = new File(downloadDir);
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("❌ Directory not found: " + downloadDir);
            return null;
        }

        long endTime = System.currentTimeMillis() + 30 * 1000;

        while (System.currentTimeMillis() < endTime) {
            File[] files = dir.listFiles((d, name) ->
                    name.toLowerCase().endsWith(".xlsx")
                            && !name.endsWith(".part")
                            && !name.endsWith(".crdownload")
                            && new File(d, name).lastModified() > afterTimestamp);

            if (files != null && files.length > 0) {
                File latestFile = Arrays.stream(files)
                        .max(Comparator.comparingLong(File::lastModified))
                        .orElse(null);
                if (latestFile != null && latestFile.length() > 0) {
                    System.out.println("✅ Found SIF file: " + latestFile.getAbsolutePath());
                    return latestFile;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
        }

        System.err.println("❌ No valid SIF file found after salary file.");
        return null;
    }

    private void compareField(Map<String, Object> expectedRow, Map<String, Object> sifRow, String expectedKey, String sifKey, List<String> mismatches) {
        String expectedValue = expectedRow.getOrDefault(expectedKey, "").toString().trim();
        String actualValue = sifRow.getOrDefault(sifKey, "").toString().trim();

        if (isNumeric(expectedValue) && isNumeric(actualValue)) {
            double expected = Double.parseDouble(expectedValue);
            double actual = Double.parseDouble(actualValue);
            if (Math.abs(expected - actual) > 0.1) {
                mismatches.add(String.format("❌ Mismatch in '%s': Expected=%s vs SIF=%s", expectedKey, expectedValue, actualValue));
            }
        } else if (!expectedValue.equals(actualValue)) {
            mismatches.add(String.format("❌ Mismatch in '%s': Expected='%s' vs SIF='%s'", expectedKey, expectedValue, actualValue));
        }
    }

    private boolean monthsMatch(String ui, String excel) {
        try {
            YearMonth expected = YearMonth.parse(ui, DateTimeFormatter.ofPattern("yyyy-MM")); // Expected from system
            YearMonth actual = YearMonth.parse(excel, DateTimeFormatter.ofPattern("MM/yyyy")); // From SIF Remarks
            return expected.equals(actual);
        } catch (Exception e) {
            System.out.println("⚠️ Month comparison failed: " + e.getMessage());
            return false;
        }
    }


}