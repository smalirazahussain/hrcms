package Step_Definitions;

import Pages.Android.AdminPage;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;

import static Hooks.Base_Class.driver;
import static Step_Definitions.AddEmployerSteps.IbanNo;
import static Step_Definitions.AddEmployerSteps.companyName;

public class EndOfServicesSteps<Save_mol> {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    @Then("[Admin Employer Page] User tap on the employer page and enter the company name")
    public void adminEmployerPageUserTapOnTheEmployerPageAndEnterTheCompanyName() throws InterruptedException {
        AdminPage.get_Admin_Employer_Button().click();
        AdminPage.get_Admin_Company_Name().sendKeys(companyName);
        Thread.sleep(5000);

    }

    @Then("[Admin Employer Page] User create a EOS file against the wallet id then appload {string}")
    public void adminEmployerPageUserCreateAEOSFileAgainstTheWalletIdThenAppload(String arg0) throws InterruptedException {
        // Create a new Excel workbook
        Workbook workbook = new XSSFWorkbook();

        // Create a sheet in the workbook
        Sheet sheet = workbook.createSheet("Employee Data");
        // Create a header row with column names
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("WALLET ID");
        headerRow.createCell(1).setCellValue("EOS TYPE");
        String[] walletIds = {IbanNo};
        String status = "EOS";


        // Populate the sheet with data
        for (int i = 0; i < walletIds.length; i++) {
            Row dataRow = sheet.createRow(i + 1);
            dataRow.createCell(0).setCellValue(walletIds[i]);
            dataRow.createCell(1).setCellValue(status);
        }
        String projectPath = "D:\\Hrcms\\src\\test\\java\\document";

        // Generate a random number
        long randomNumber = (long) (Math.random() * 100000000);

        // Generate the file path with random number
        String filePath = Paths.get(projectPath, "EmployeeData" + randomNumber + ".xlsx").toString();
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        System.out.println("Excel file created successfully!");
        Thread.sleep(5000);
    }

}





