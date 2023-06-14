package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.ProcessSalariesDepositSlipPages;
import Pages.Android.ProfilePage;
import Pages.Android.UpdateProliePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Random;

import static Hooks.Base_Class.driver;
import static Pages.Android.AddEmployerPages.*;
import static Pages.Android.ProcessSalariesDepositSlipPages.Download_Button;
import static Pages.Android.UpdateProliePage.get_year_arrow_xpath;
import static Pages.Android.UpdateProliePage.issueDate;
import static Step_Definitions.Employeessteps.filePath;
import static Step_Definitions.Employeessteps.randomNumbers;
import static Step_Definitions.SignUpSteps.companyName;
import static Tests.Current_Date.currentYear;

public class ProcessSalariesDepositSlipSteps {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    public static String companyTittle;

    @And("[Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip")
    public void processSalariesDepositSlipPageUserTapOnProcessSalariesDepositSlip() {
        companyTittle = AddEmployerPages.get_Company_Tittle().getText();
        companyName = companyTittle;
        System.out.println(companyName);
        ProcessSalariesDepositSlipPages.get_Process_Salaries_Deposit_Slip().click();
    }


    @When("[Process Salaries DepositSlip Page] User enter company name and download the salary template")
    public void processSalariesDepositSlipPageUserEnterCompanyNameAndDownloadTheSalaryTemplate() throws InterruptedException, IOException, AWTException {
        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Download_Button)));
        Thread.sleep(3000);
        ProcessSalariesDepositSlipPages.get_Download_Button().click();
        Thread.sleep(10000);

        // Get the latest downloaded file from the download directory
        File downloadDir = new File("D:\\Hrcms\\src\\test\\java\\document"); // Replace with the actual download directory path
        File[] files = downloadDir.listFiles();
        File latestFile = null;
        long lastModifiedTime = Long.MIN_VALUE;
        for (File file : files) {
            if (file.lastModified() > lastModifiedTime) {
                lastModifiedTime = file.lastModified();
                latestFile = file;
            }
        }

        if (latestFile != null) {
            String downloadedFileName = latestFile.getName();
            System.out.println("Downloaded file name: " + downloadedFileName);
            // Read the contents of the XLSX file
            //read excel file
            FileInputStream fileInputStream = new FileInputStream(latestFile);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

            // Generate a random number between 1 and 100
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1;

            // Iterate over rows and columns
            for (Row row : sheet) {
                for (Cell cell : row) {
                    // Access cell values
                    CellType cellType = cell.getCellType();
                    if (cellType == CellType.STRING) {
                        String cellValue = cell.getStringCellValue();
                        if (cellValue.equals("TOTAL")) {
                            // Append the random number to the "TOTAL" header
                            cell.setCellValue(cellValue + " " + randomNumber);
                            System.out.println(randomNumber+cellValue);
                        }
                        System.out.print(cellValue + "\t");
                    } else if (cellType == CellType.NUMERIC) {
                        double cellValue = cell.getNumericCellValue();
                        System.out.print(cellValue + "\t");
                    }
                    // Add handling for other cell types as needed
                }
                System.out.println(); // Move to the next row
            }

            // Close the workbook and input stream
            workbook.close();
            fileInputStream.close();

            // Perform assertions or further operations with the downloaded file name
            // ...
        } else {
            System.out.println("No file downloaded");
            // Handle the case where no file is downloaded
            // ...
        }
    }
}

//    @When("[Process Salaries DepositSlip Page] User enter company name and download the salary template")
//    public void processSalariesDepositSlipPageUserEnterCompanyNameAndDownloadTheSalaryTemplate() throws InterruptedException, IOException, AWTException {
//        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
//        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Download_Button)));
//        Thread.sleep(3000);
//        ProcessSalariesDepositSlipPages.get_Download_Button().click();
//        Thread.sleep(10000);
//
//        // Get the latest downloaded file from the download directory
//        File downloadDir = new File("D:\\Hrcms\\src\\test\\java\\document"); // Replace with the actual download directory path
//        File[] files = downloadDir.listFiles();
//        File latestFile = null;
//        long lastModifiedTime = Long.MIN_VALUE;
//        for (File file : files) {
//            if (file.lastModified() > lastModifiedTime) {
//                lastModifiedTime = file.lastModified();
//                latestFile = file;
//            }
//        }
//
//        if (latestFile != null) {
//            String downloadedFileName = latestFile.getName();
//            System.out.println("Downloaded file name: " + downloadedFileName);
//            // Read the contents of the XLSX file
//            //read excel file
//            FileInputStream fileInputStream = new FileInputStream(latestFile);
//            Workbook workbook = new XSSFWorkbook(fileInputStream);
//            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet
//
//            // Generate a random number between 1 and 100
//            Random random = new Random();
//            int randomNumber = random.nextInt(100) + 1;
//
//            // Iterate over rows and columns
//            for (Row row : sheet) {
//                for (Cell cell : row) {
//                    // Access cell values
//                    CellType cellType = cell.getCellType();
//                    if (cellType == CellType.STRING) {
//                        String cellValue = cell.getStringCellValue();
//                        if (cellValue.equals("TOTAL")) {
//                            // Append the random number to the "TOTAL" header
//                            cell.setCellValue(cellValue + " " + randomNumber);
//                        }
//                        System.out.print(cellValue + "\t");
//                    } else if (cellType == CellType.NUMERIC) {
//                        double cellValue = cell.getNumericCellValue();
//                        System.out.print(cellValue + "\t");
//                    }
//                    // Add handling for other cell types as needed
//                }
//                System.out.println(); // Move to the next row
//            }
//
//            // Close the workbook and input stream
//            workbook.close();
//            fileInputStream.close();
//
//            // Perform assertions or further operations with the downloaded file name
//            // ...
//        } else {
//            System.out.println("No file downloaded");
//            // Handle the case where no file is downloaded
//            // ...
//        }
//    }
//}

//    @When("[Process Salaries DepositSlip Page] User enter company name and download the salary template")
//    public void processSalariesDepositSlipPageUserEnterCompanyNameAndDownloadTheSalaryTemplate() throws InterruptedException, IOException, AWTException {
//        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
//        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Download_Button)));
//        Thread.sleep(3000);
//        ProcessSalariesDepositSlipPages.get_Download_Button().click();
//        Thread.sleep(10000);
//
//        // Get the latest downloaded file from the download directory
//        File downloadDir = new File("D:\\Hrcms\\src\\test\\java\\document"); // Replace with the actual download directory path
//        File[] files = downloadDir.listFiles();
//        File latestFile = null;
//        long lastModifiedTime = Long.MIN_VALUE;
//        for (File file : files) {
//            if (file.lastModified() > lastModifiedTime) {
//                lastModifiedTime = file.lastModified();
//                latestFile = file;
//            }
//        }
//
//        if (latestFile != null) {
//            String downloadedFileName = latestFile.getName();
//            System.out.println("Downloaded file name: " + downloadedFileName);
//            // Read the contents of the XLSX file
//            //read excel file
//            FileInputStream fileInputStream = new FileInputStream(latestFile);
//            Workbook workbook = new XSSFWorkbook(fileInputStream);
//            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet
//
//            // Iterate over rows and columns
//            for (Row row : sheet) {
//                for (Cell cell : row) {
//                    // Access cell values
//                    CellType cellType = cell.getCellType();
//                    if (cellType == CellType.STRING) {
//                        String cellValue = cell.getStringCellValue();
//                        System.out.print(cellValue + "\t");
//                    } else if (cellType == CellType.NUMERIC) {
//                        double cellValue = cell.getNumericCellValue();
//                        System.out.print(cellValue + "\t");
//                    }
//                    // Add handling for other cell types as needed
//                }
//                System.out.println(); // Move to the next row
//            }
//
//            // Close the workbook and input stream
//            workbook.close();
//            fileInputStream.close();
//
//            // Perform assertions or further operations with the downloaded file name
//            // ...
//        } else {
//            System.out.println("No file downloaded");
//            // Handle the case where no file is downloaded
//            // ...
//        }
//    }
//}

//        String downloadDir = "D:/Hrcms/src/test/java/document";
//        ProcessSalariesDepositSlipPages.get_Download_Button().click();
//        String fileName = "salary_template.xlsx";
//        String filePath = downloadDir + "/" + fileName;
//        File file = new File(filePath);
//        System.out.println(fileName);
//        System.out.println(filePath);
//        return downloadDir;
//        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
//        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Download_Button)));
//        Thread.sleep(3000);
//        WebElement downloadButton = ProcessSalariesDepositSlipPages.get_Download_Button();
//        downloadButton.click();
//
//        // Save the download button result in a variable
//        String downloadResult = downloadButton.getAttribute("value");
//
//        // Wait for the file to be downloaded
//        String downloadDir = "D:/Hrcms/src/test/java/document";
//        String fileName = "salary_template.xlsx";
//        String filePath = downloadDir + "/" + fileName;
//        File file = new File(filePath);
//        while (!file.exists()) {
//            Thread.sleep(1000); // Wait for 1 second before checking again
//        }
//
//        // Perform further actions or validations with the downloaded file
//
//        return downloadResult;
//        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
//        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Download_Button)));
//        Thread.sleep(3000);
//        WebElement downloadButton = ProcessSalariesDepositSlipPages.get_Download_Button();
//        downloadButton.click();
//
//        // Save the download button result in a variable
//        String downloadResult = downloadButton.getAttribute("value");
//
//        // Wait for the file to be downloaded
//        String defaultDownloadDir = System.getProperty("user.home") + "/Downloads";
//        String fileName = "salary_template.xlsx";
//        File defaultDownloadFile = new File(defaultDownloadDir + "/" + fileName);
//        while (!defaultDownloadFile.exists()) {
//            Thread.sleep(1000); // Wait for 1 second before checking again
//        }
//
//        // Move the downloaded file to the desired directory
//        String desiredDir = "D:/Hrcms/src/test/java/document";
//        Path desiredPath = new File(desiredDir + "/" + fileName).toPath();
//        Files.move(defaultDownloadFile.toPath(), desiredPath, StandardCopyOption.REPLACE_EXISTING);
//
//        // Perform further actions or validations with the downloaded file
//
//        return downloadResult;
//        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
//        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Download_Button)));
//        Thread.sleep(3000);
//        WebElement downloadButton = ProcessSalariesDepositSlipPages.get_Download_Button();
//        downloadButton.click();
//
//        // Save the download button result in a variable
//        String downloadResult = downloadButton.getAttribute("value");
//
//        // Set the desired download directory
//        String downloadDir = "D:/Hrcms/src/test/java/document";
//
//        // Set the Chrome driver executable path
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//
//        // Configure Chrome options
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--headless");
//        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-infobars");
//        options.addArguments("--silent");
//        options.addArguments("--log-level=3");
//        options.addArguments("--disable-extensions");
//        options.addArguments("--disable-web-security");
//        options.addArguments("--disable-application-cache");
//        options.addArguments("--allow-file-access-from-files");
//        options.addArguments("--allow-insecure-localhost");
//        options.addArguments("--disable-save-password-bubble");
//        options.addArguments("--disable-single-click-autofill");
//
//        // Set the download directory as a Chrome preference
////        options.addPreference("download.default_directory", downloadDir);
//
//        // Initialize ChromeDriver with the configured options
//
//        // Perform further actions or validations with the downloaded file
//Thread.sleep(5000);
//        return downloadResult;
//    }
////        while (!file.exists()) {
////            Thread.sleep(1000); // Wait for 1 second before checking again
////        }
////
////        // Perform further actions or validations with the downloaded file
////
////        return filePath;














