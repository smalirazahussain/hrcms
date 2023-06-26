package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.ProcessSalariesDepositSlipPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Step_Definitions.SignUpSteps.companyName;

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

        String fileUrl = "https://example.com/path/to/excel.xlsx";
        String destinationPath = "path/to/save/excel.xlsx";

        try {
            ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
            Thread.sleep(6000);
            ProcessSalariesDepositSlipPages.get_Download_Button().click();
            Thread.sleep(10000);

            URL url = new URL(fileUrl);
            BufferedInputStream bis = new BufferedInputStream(url.openStream());
            FileOutputStream fos = new FileOutputStream(destinationPath);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer, 0, 1024)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fos.close();
            bis.close();

            String filePath = "path/to/excel.xlsx";

            try (Workbook workbook = WorkbookFactory.create(new File(filePath))) {
                Sheet sheet = workbook.getSheetAt(0);

                for (Row row : sheet) {
                    for (Cell cell : row) {
                        CellType cellType = cell.getCellType();

                        if (cellType == CellType.STRING) {
                            System.out.print(cell.getStringCellValue() + "\t");
                        } else if (cellType == CellType.NUMERIC) {
                            System.out.print(cell.getNumericCellValue() + "\t");
                        } else if (cellType == CellType.BOOLEAN) {
                            System.out.print(cell.getBooleanCellValue() + "\t");
                        } else if (cellType == CellType.BLANK) {
                            System.out.print("\t");
                        }
                    }

                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }


//        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
//        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Download_Button)));
//        Thread.sleep(6000);
//        ProcessSalariesDepositSlipPages.get_Download_Button().click();
//        Thread.sleep(10000);
//
//        try {
//            // Load the Excel file
//            String filePath = "D:\\\\Hrcms\\\\src\\\\test\\\\java\\\\document";
//            InputStream inputStream = Files.newInputStream(Paths.get(filePath));
//            Workbook workbook = new XSSFWorkbook(inputStream);
//
//            // Access the first sheet
//            Sheet sheet = workbook.getSheetAt(0);
//
//            // Create a new Workbook and Sheet
//            Workbook newWorkbook = new XSSFWorkbook();
//            Sheet newSheet = newWorkbook.createSheet("NewSheet");
//
//            // Iterate through each row in the sheet
//            int rowIndex = 0;
//            for (Row row : sheet) {
//                // Create a new row in the new sheet
//                Row newRow = newSheet.createRow(rowIndex);
//
//                // Iterate through each cell in the row
//                int cellIndex = 0;
//                for (Cell cell : row) {
//                    // Get the cell value and set it in the new sheet
//                    CellValue cellValue = getCellValue(cell);
//                    Cell newCell = newRow.createCell(cellIndex);
//                    setCellValue(newCell, cellValue);
//
//                    cellIndex++;
//                    System.out.print(getCellValue(cell) + "\t");
//                }
//
//                System.out.println();
//                rowIndex++;
//            }
//
//            // Save the new Workbook
//            String newFilePath = "D:\\\\Hrcms\\\\src\\\\test\\\\java\\\\document\\\\file.xlsx";
//            OutputStream outputStream = Files.newOutputStream(Paths.get(newFilePath));
//            newWorkbook.write(outputStream);
//            newWorkbook.close();
//
//            System.out.println("Data copied successfully!");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static CellValue getCellValue(Cell cell) {
//        CellValue cellValue = null;
//        switch (cell.getCellType()) {
//            case STRING:
//                cellValue = new CellValue(cell.getStringCellValue());
//                break;
//            case NUMERIC:
//                cellValue = new CellValue(cell.getNumericCellValue());
//                break;
//            // Handle other cell types as needed
//        }
//        return cellValue;
//    }
//
//    private static boolean setCellValue(Cell cell, CellValue cellValue) {
//        switch (cellValue.getCellType()) {
//            case STRING:
//                cell.setCellValue(cellValue.getStringValue());
//                break;
//            case NUMERIC:
//                cell.setCellValue(cellValue.getNumberValue());
//                break;
//            // Handle other cell types as needed
//        }
//        return false;
//    }



    // Iterate over rows and columns to retrieve the dat



//    @When("[Process Salaries DepositSlip Page] User enter company name and download the salary template")
//    public  void processSalariesDepositSlipPageUserEnterCompanyNameAndDownloadTheSalaryTemplate() throws InterruptedException, IOException, AWTException, IOException {
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
//            int randomNumber = random.nextInt(100) + 10;
//
//            // Iterate over rows and columns
//            for (Row row : sheet) {
//                Cell empCodeCell = row.getCell(0); // Assuming EMP CODE is in the first column
//                if (empCodeCell != null) {
//                    String empCode = empCodeCell.getStringCellValue();
//                    if (!empCode.isEmpty()) {
//                        Cell totalCell = row.getCell(6); // Assuming TOTAL column is in the seventh column
//                        if (totalCell != null) {
//                            double totalValue = 0;
//                            CellType totalCellType = totalCell.getCellType();
//                            if (totalCellType == CellType.NUMERIC) {
//                                totalValue = totalCell.getNumericCellValue();
//                            } else if (totalCellType == CellType.STRING) {
////                                String totalCellValue = totalCell.getStringCellValue();
////                                if (totalCellValue.equalsIgnoreCase("TOTAL")) {
////                                    totalValue = 0.0;
////                                } else {
////                                   totalValue = Double.parseDouble(totalCellValue);
////                                }
////                            } else {
////                                totalValue = 0.0;
////                            }
////
////                            totalCell.setCellValue(totalValue + randomNumber);
////                            System.out.println("Total column updated for EMP CODE: " + empCode);
////                        }
////                    }
////                }
////            }
//
//                    // Close the workbook and input stream
//                    workbook.close();
//                    fileInputStream.close();
//
//                    // Perform assertions or further operations with the downloaded file name
//                    // ...
//                } else {
//                    System.out.println("No file downloaded");
//                    // Handle the case where no file is downloaded
//                    // ...
//                }
//            }
//        }}}}}
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
}

























//package Step_Definitions;
//
//import Pages.Android.AddEmployerPages;
//import Pages.Android.ProcessSalariesDepositSlipPages;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.When;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.asserts.SoftAssert;
//
//import java.awt.*;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Random;
//
//import static Hooks.Base_Class.driver;
//import static Step_Definitions.SignUpSteps.companyName;
//
//public class ProcessSalariesDepositSlipSteps {
//
//    Duration timeout = Duration.ofSeconds(30);
//    WebDriverWait wait = new WebDriverWait(driver, timeout);
//    //create a soft-assertion object
//    SoftAssert softAssert = new SoftAssert();
//
//
//    public static String companyTittle;
//
//    @And("[Process Salaries DepositSlip Page] User Tap on Process Salaries Deposit Slip")
//    public void processSalariesDepositSlipPageUserTapOnProcessSalariesDepositSlip() {
//        companyTittle = AddEmployerPages.get_Company_Tittle().getText();
//        companyName = companyTittle;
//        System.out.println(companyName);
//        ProcessSalariesDepositSlipPages.get_Process_Salaries_Deposit_Slip().click();
//    }
//
//
//
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
//            int randomNumber = random.nextInt(100) + 10;
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
//                            System.out.println(randomNumber+cellValue);
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
//
//
//
//
////    @When("[Process Salaries DepositSlip Page] User enter company name and download the salary template")
////    public void processSalariesDepositSlipPageUserEnterCompanyNameAndDownloadTheSalaryTemplate() throws InterruptedException, IOException, AWTException {
////        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
////        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Download_Button)));
////        Thread.sleep(3000);
////        ProcessSalariesDepositSlipPages.get_Download_Button().click();
////        Thread.sleep(10000);
////
////        // Get the latest downloaded file from the download directory
////        File downloadDir = new File("D:\\Hrcms\\src\\test\\java\\document"); // Replace with the actual download directory path
////        File[] files = downloadDir.listFiles();
////        File latestFile = null;
////        long lastModifiedTime = Long.MIN_VALUE;
////        for (File file : files) {
////            if (file.lastModified() > lastModifiedTime) {
////                lastModifiedTime = file.lastModified();
////                latestFile = file;
////            }
////        }
////
////        if (latestFile != null) {
////            String downloadedFileName = latestFile.getName();
////            System.out.println("Downloaded file name: " + downloadedFileName);
////            // Read the contents of the XLSX file
////            //read excel file
////            FileInputStream fileInputStream = new FileInputStream(latestFile);
////            Workbook workbook = new XSSFWorkbook(fileInputStream);
////            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet
////
////            // Generate a random number between 1 and 100
////            Random random = new Random();
////            int randomNumber = random.nextInt(100) + 1;
////
////            // Iterate over rows and columns
////            for (Row row : sheet) {
////                for (Cell cell : row) {
////                    // Access cell values
////                    CellType cellType = cell.getCellType();
////                    if (cellType == CellType.STRING) {
////                        String cellValue = cell.getStringCellValue();
////                        if (cellValue.equals("TOTAL")) {
////                            // Append the random number to the "TOTAL" header
////                            cell.setCellValue(cellValue + " " + randomNumber);
////                        }
////                        System.out.print(cellValue + "\t");
////                    } else if (cellType == CellType.NUMERIC) {
////                        double cellValue = cell.getNumericCellValue();
////                        System.out.print(cellValue + "\t");
////                    }
////                    // Add handling for other cell types as needed
////                }
////                System.out.println(); // Move to the next row
////            }
////
////            // Close the workbook and input stream
////            workbook.close();
////            fileInputStream.close();
////
////            // Perform assertions or further operations with the downloaded file name
////            // ...
////        } else {
////            System.out.println("No file downloaded");
////            // Handle the case where no file is downloaded
////            // ...
////        }
////    }
////}
//
////    @When("[Process Salaries DepositSlip Page] User enter company name and download the salary template")
////    public void processSalariesDepositSlipPageUserEnterCompanyNameAndDownloadTheSalaryTemplate() throws InterruptedException, IOException, AWTException {
////        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
////        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Download_Button)));
////        Thread.sleep(3000);
////        ProcessSalariesDepositSlipPages.get_Download_Button().click();
////        Thread.sleep(10000);
////
////        // Get the latest downloaded file from the download directory
////        File downloadDir = new File("D:\\Hrcms\\src\\test\\java\\document"); // Replace with the actual download directory path
////        File[] files = downloadDir.listFiles();
////        File latestFile = null;
////        long lastModifiedTime = Long.MIN_VALUE;
////        for (File file : files) {
////            if (file.lastModified() > lastModifiedTime) {
////                lastModifiedTime = file.lastModified();
////                latestFile = file;
////            }
////        }
////
////        if (latestFile != null) {
////            String downloadedFileName = latestFile.getName();
////            System.out.println("Downloaded file name: " + downloadedFileName);
////            // Read the contents of the XLSX file
////            //read excel file
////            FileInputStream fileInputStream = new FileInputStream(latestFile);
////            Workbook workbook = new XSSFWorkbook(fileInputStream);
////            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet
////
////            // Iterate over rows and columns
////            for (Row row : sheet) {
////                for (Cell cell : row) {
////                    // Access cell values
////                    CellType cellType = cell.getCellType();
////                    if (cellType == CellType.STRING) {
////                        String cellValue = cell.getStringCellValue();
////                        System.out.print(cellValue + "\t");
////                    } else if (cellType == CellType.NUMERIC) {
////                        double cellValue = cell.getNumericCellValue();
////                        System.out.print(cellValue + "\t");
////                    }
////                    // Add handling for other cell types as needed
////                }
////                System.out.println(); // Move to the next row
////            }
////
////            // Close the workbook and input stream
////            workbook.close();
////            fileInputStream.close();
////
////            // Perform assertions or further operations with the downloaded file name
////            // ...
////        } else {
////            System.out.println("No file downloaded");
////            // Handle the case where no file is downloaded
////            // ...
////        }
////    }
////}
//
////        String downloadDir = "D:/Hrcms/src/test/java/document";
////        ProcessSalariesDepositSlipPages.get_Download_Button().click();
////        String fileName = "salary_template.xlsx";
////        String filePath = downloadDir + "/" + fileName;
////        File file = new File(filePath);
////        System.out.println(fileName);
////        System.out.println(filePath);
////        return downloadDir;
////        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
////        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Download_Button)));
////        Thread.sleep(3000);
////        WebElement downloadButton = ProcessSalariesDepositSlipPages.get_Download_Button();
////        downloadButton.click();
////
////        // Save the download button result in a variable
////        String downloadResult = downloadButton.getAttribute("value");
////
////        // Wait for the file to be downloaded
////        String downloadDir = "D:/Hrcms/src/test/java/document";
////        String fileName = "salary_template.xlsx";
////        String filePath = downloadDir + "/" + fileName;
////        File file = new File(filePath);
////        while (!file.exists()) {
////            Thread.sleep(1000); // Wait for 1 second before checking again
////        }
////
////        // Perform further actions or validations with the downloaded file
////
////        return downloadResult;
////        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
////        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Download_Button)));
////        Thread.sleep(3000);
////        WebElement downloadButton = ProcessSalariesDepositSlipPages.get_Download_Button();
////        downloadButton.click();
////
////        // Save the download button result in a variable
////        String downloadResult = downloadButton.getAttribute("value");
////
////        // Wait for the file to be downloaded
////        String defaultDownloadDir = System.getProperty("user.home") + "/Downloads";
////        String fileName = "salary_template.xlsx";
////        File defaultDownloadFile = new File(defaultDownloadDir + "/" + fileName);
////        while (!defaultDownloadFile.exists()) {
////            Thread.sleep(1000); // Wait for 1 second before checking again
////        }
////
////        // Move the downloaded file to the desired directory
////        String desiredDir = "D:/Hrcms/src/test/java/document";
////        Path desiredPath = new File(desiredDir + "/" + fileName).toPath();
////        Files.move(defaultDownloadFile.toPath(), desiredPath, StandardCopyOption.REPLACE_EXISTING);
////
////        // Perform further actions or validations with the downloaded file
////
////        return downloadResult;
////        ProcessSalariesDepositSlipPages.get_Company_Name().sendKeys(companyTittle + Keys.ENTER);
////        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Download_Button)));
////        Thread.sleep(3000);
////        WebElement downloadButton = ProcessSalariesDepositSlipPages.get_Download_Button();
////        downloadButton.click();
////
////        // Save the download button result in a variable
////        String downloadResult = downloadButton.getAttribute("value");
////
////        // Set the desired download directory
////        String downloadDir = "D:/Hrcms/src/test/java/document";
////
////        // Set the Chrome driver executable path
////        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
////
////        // Configure Chrome options
////        ChromeOptions options = new ChromeOptions();
////        options.addArguments("--no-sandbox");
////        options.addArguments("--disable-dev-shm-usage");
////        options.addArguments("--disable-gpu");
////        options.addArguments("--headless");
////        options.addArguments("--disable-popup-blocking");
////        options.addArguments("--disable-notifications");
////        options.addArguments("--disable-infobars");
////        options.addArguments("--silent");
////        options.addArguments("--log-level=3");
////        options.addArguments("--disable-extensions");
////        options.addArguments("--disable-web-security");
////        options.addArguments("--disable-application-cache");
////        options.addArguments("--allow-file-access-from-files");
////        options.addArguments("--allow-insecure-localhost");
////        options.addArguments("--disable-save-password-bubble");
////        options.addArguments("--disable-single-click-autofill");
////
////        // Set the download directory as a Chrome preference
//////        options.addPreference("download.default_directory", downloadDir);
////
////        // Initialize ChromeDriver with the configured options
////
////        // Perform further actions or validations with the downloaded file
////Thread.sleep(5000);
////        return downloadResult;
////    }
//////        while (!file.exists()) {
//////            Thread.sleep(1000); // Wait for 1 second before checking again
//////        }
//////
//////        // Perform further actions or validations with the downloaded file
//////
//////        return filePath;
//
//
//
//
//
//
//
//
//
//
//
//
//
//
