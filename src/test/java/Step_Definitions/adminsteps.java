package Step_Definitions;

import Pages.Android.AdminPage;
import Pages.Android.UpdateProliePage;
import Pages.HeadOfficePages.ManageEmployeesHeadOfficePage;
import Pages.HeadOfficePages.OnBoardApprovalHeadOfficePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;

import static Hooks.Base_Class.driver;
import static Pages.Android.AdminPage.*;
import static Pages.Android.UpdateProliePage.*;
import static Pages.HeadOfficePages.OnBoardApprovalHeadOfficePage.Phone_No;
import static Step_Definitions.AddEmployerSteps.IbanNo;
import static Step_Definitions.Employeessteps.companyTittle;
import static Step_Definitions.Employeessteps.randomNumbers;
import static Step_Definitions.EndOfServicesSteps.filePath;
import static Step_Definitions.ProcessSalariesDepositSlipSteps.actualamount;
import static Step_Definitions.SignUpSteps.companyName;
import static Step_Definitions_Head_Ofiice.BrachesStepsHeadOffice.branch;
import static Step_Definitions_Head_Ofiice.BrachesStepsHeadOffice.phno;
import static Step_Definitions_Head_Ofiice.DashBoardStepsHeadOffice.exchangeHouseTittle;
import static Tests.Current_Date.currentMonth;

public class adminsteps {
    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    @Then("[Admin Page] Open the admin tab {string}")
    public void adminPageOpenTheAdminTab(String admintabURL) throws AWTException, InterruptedException, MalformedURLException {
        driver.navigate().to(admintabURL);

    }

    @And("[Update Profile] User enter the month of joining  {string}")
    public void updateProfileUserEnterTheMonthOfJoining(String expmonth) throws InterruptedException {
        String current_month = currentMonth();

        if (current_month == expmonth) {
            Thread.sleep(100);
        } else {
            get_month_select(current_month).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(user_month(expmonth))));
            get_user_month(expmonth).click();
        }
    }

    @And("[Admin Page] User tap on login page")
    public void adminPageUserTapOnLoginPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Login)));
        AdminPage.get_Login().click();
    }

    @Then("[Admin Page] User enter the  email {string}")
    public void adminPageUserEnterTheEmail(String email) {
        AdminPage.get_Email().sendKeys(email);
    }

    @When("[Admin Page] User enter the Password {string}")
    public void adminPageUserEnterThePassword(String paswword) {
        AdminPage.get_Password().sendKeys(paswword);
    }

    @When("[Admin Page] User tap on onboard Approvals")
    public void adminPageUserTapOnOnboardApprovals() {
        AdminPage.get_Onboard_Approvals().click();
    }

    @And("[Admin Page] User tap on view button")
    public void adminPageUserTapOnViewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(View)));
        AdminPage.get_View().click();
    }

    @When("[Admin Page] User tap on client Approvals")
    public void adminPageUserTapOnClientApprovals() {
        AdminPage.get_Client_Approval().click();
    }

    @Then("[Admin Page] User enter the company name")
    public void adminPageUserEnterTheCompanyName() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Company_Client)));
        AdminPage.get_Company_Client().sendKeys(companyName + Keys.ENTER);
        System.out.println(companyTittle);
        System.out.println(companyName);
        //Thread.sleep(5000);

    }

    @Then("[Admin Page] User enter the company name {string}")
    public void adminPageUserEnterTheCompanyName(String arg) throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Company_Client)));
        //AdminPage.get_Company_Client().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Company_Client)));
        AdminPage.get_Company_Client().sendKeys(company_Name + Keys.ENTER);
    }

    @Then("[Admin Page] User validate the toast message {string}")
    public void adminPageUserValidateTheToastMessage(String actual) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Action_Successfully)));
        String expect = AdminPage.get_Action_Successfully().getText();
        Assert.assertEquals(actual, expect);
    }


    @Then("[Admin Page] User tap on approve button")
    public void adminPageUserTapOnApproveButton() throws InterruptedException {
        AdminPage.get_Approve_Button().click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Approval_Ok)));
        Thread.sleep(3000);
        AdminPage.get_Approval_Ok().click();
        // AdminPage.get_Admin_Approval_Ok().click();
    }

    @Then("[Admin Page] User Tap om the browse button")
    public void adminPageUserTapOmTheBrowseButton() throws AWTException, InterruptedException {
        AdminPage.get_Browse_Button().click();
        Thread.sleep(3000);


        Robot rb = new Robot();
        StringSelection str = new StringSelection("D:\\Hrcms\\src\\test\\java\\document\\" + randomNumbers + ".xlsx");
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

    @Then("[Admin Page] User select the card type {string}")
    public void adminPageUserSelectTheCardType(String card) {
        //AdminPage.get_Card_Button().click();
        AdminPage.get_Card_Button().sendKeys(card, Keys.ENTER);
        // AdminPage.get_Card_Tpye(card).click();
    }

    @And("[Admin Page] User Tap on the approve button")
    public void adminPageUserTapOnTheApproveButton() throws InterruptedException {
        Thread.sleep(3000);
        AdminPage.get_Approve_Bulk_Button().click();
//        Thread.sleep(30000);
    }

    @Then("[Admin Page] User tap on Exchange House Clients button")
    public void adminPageUserTapOnExchangeHouseClientsButton() {
        AdminPage.get_ExchangeHouseClientButton().click();
    }

    @Then("[Admin Page] User select the exchange house {string}")
    public void adminPageUserSelectTheExchangeHouse(String arg0) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(exchangeHouseTittle);
        // AdminPage.get_Select_Exchange_House().click();
        AdminPage.get_Select_Exchange_House().sendKeys(exchangeHouseTittle, Keys.ENTER);
        Thread.sleep(5000);
    }

    @Then("[Admin Page] Admin verification the branch and then approve")
    public void adminPageAdminVerificationTheBranchAndThenApprove() throws InterruptedException {
        if (phno == OnBoardApprovalHeadOfficePage.get_Phone_No_admin_Side().getText())
            AdminPage.get_Approve_Button().click();
        //        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Approval_Ok)));
        AdminPage.get_Approve_Button().click();
        Thread.sleep(5000);
        AdminPage.get_Approval_Ok().click();
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(Approval_Ok)));
        // AdminPage.get_Approval_Ok().click();
        Thread.sleep(5000);
        System.out.println(Phone_No);
        Thread.sleep(5000);

    }

    @Then("[Admin Page] User tap No other bank employees in given file")
    public void adminPageUserTapNoOtherBankEmployeesInGivenFile() {
        AdminPage.get_No_Other_Bank_Employees().click();
    }

    @Then("[Admin Page] User verify the notification message {string}")
    public void adminPageUserVerifyTheNotificationMessage(String after) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Action_Successfully)));
        String actual = AdminPage.get_Action_Successfully().getText();
        System.out.println("Actual MSG" + actual);
        Assert.assertEquals(actual, after);
    }

    @When("[Admin Page] User tap on Exchange house client Approvals")
    public void adminPageUserTapOnExchangeHouseClientApprovals() throws InterruptedException {
        AdminPage.get_ExchangeHouse_Client_Approvals_Button().click();
        ManageEmployeesHeadOfficePage.get_Manage_Branch().sendKeys(exchangeHouseTittle + Keys.ENTER);
        Thread.sleep(5000);
        AdminPage.get_Admin_Branch_Name().sendKeys(branch + Keys.ENTER);
    }

    @Then("[Admin Page] User Tap om the exchange house browse button")
    public void adminPageUserTapOmTheExchangeHouseBrowseButton() throws InterruptedException, AWTException {
        AdminPage.get_Exchange_House_Browse_Button().click();
        Thread.sleep(3000);


        Robot rb = new Robot();
        StringSelection str = new StringSelection("D:\\Hrcms\\src\\test\\java\\document\\" + randomNumbers + ".xlsx");
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

    @Then("[Admin Page] User tap on process salary approve button")
    public void adminPageUserTapOnProcessSalaryApproveButton() throws InterruptedException {
        try {
            String adminSalary = AdminPage.get_admin_Client_Salary().getText();
            System.out.println("adminSalary: " + adminSalary);
            Assert.assertEquals(actualamount, adminSalary);

            AdminPage.get_Approve_Button().click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Approval_Ok)));
            AdminPage.get_Approval_Ok().click();
        } catch (StaleElementReferenceException e) {
            // Re-fetch the elements and retry the actions
        }
        //        try {
//            String adminSalary = AdminPage.get_admin_Client_Salary().getText();
//        System.out.println("adminSalary"+adminSalary);
//        Assert.assertEquals(actualamount,adminSalary);
//        AdminPage.get_Approve_Button().click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Approval_Ok)));
//        AdminPage.get_Approval_Ok().click();
//
//        } catch (StaleElementReferenceException e) {
//            // Re-fetch the elements and retry the actions
//
//        }
//        String adminSalary = AdminPage.get_admin_Client_Salary().getText();
//        System.out.println("adminSalary"+adminSalary);
//        Assert.assertEquals(actualamount,adminSalary);
//        AdminPage.get_Approve_Button().click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Approval_Ok)));
//        AdminPage.get_Approval_Ok().click();

    }

    @And("[Admin Page] User verify the employer approve by the admin {string}")
    public void adminPageUserVerifyTheEmployerApproveByTheAdmin(String beforemsg) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Approval_Msg(beforemsg))));
        String actualmsg = UpdateProliePage.get_Approval_Msg(beforemsg).getText();
        System.out.println("Admin approval msg" + actualmsg);
        Assert.assertEquals(actualmsg, beforemsg);
    }

    @Then("[Admin Page] User tap on employer")
    public void adminPageUserTapOnEmployer() {
        AdminPage.get_Admin_Employer_Button().click();
    }

    @And("[Admin Page] User tap on Add employer")
    public void adminPageUserTapOnAddEmployer() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Admin_Add_Employer_Button)));
        AdminPage.get_Admin_Add_Employer_Button().click();
    }

    @And("[Admin Employer Page] Upload end of service file on the admin portal")
    public void adminEmployerPageUploadEndOfServiceFileOnTheAdminPortal() throws AWTException, InterruptedException {
        AdminPage.get_Upload_EOS_Button().click();
        Thread.sleep(3000);


        Robot rb = new Robot();
        StringSelection str = new StringSelection(filePath);
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

    public String downloadFileName;

    @And("[Admin Employer Page] User tap on DOS Template button and download file then  create a user data")
    public void adminEmployerPageUserTapOnDOSTemplateButtonAndDownloadFileThenCreateAUserData() throws IOException, InterruptedException {
        /*AdminPage.get_Eos_Template().click();
        // Get the latest downloaded file from the download directory
        File downloadDir = new File("D:\\Hrcms\\src\\test\\java\\document"); // Replace with the actual download directory path
        File[] files = downloadDir.listFiles();
        System.out.println(files);
        File latestFile = null;
        long lastModifiedTime = Long.MIN_VALUE;
        for (File file : files) {
            if (file.lastModified() > lastModifiedTime) {
                lastModifiedTime = file.lastModified();
                latestFile = file;
            }
        }

//        File latestFile = null;
        Sheet sheet = null;
        if (latestFile != null) {
            String downloadedFileName = latestFile.getName();
            System.out.println("Downloaded file name: " + downloadedFileName);
            System.out.println("Downloaded file name: " + latestFile);
            // Read the contents of the downloaded XLSX file
            FileInputStream fileInputStream = new FileInputStream(latestFile);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheetAt(0);
            System.out.println(sheet);
        }
        int rowIndex = 0;
       // Random random = new Random();
        for (Row row : sheet) {
            if (rowIndex > 0) {
                Cell firstCell = row.createCell(1);

               // int randomValue = random.nextInt(10000); // Generate a random number between 0 and 99
                firstCell.setCellValue(IbanNo);
                System.out.println(firstCell);

                Thread.sleep(1);
            }
            rowIndex++;
        }
*/


        AdminPage.get_Eos_Template().click();

        // Replace with the actual download directory path
        File downloadDir = new File("D:\\Hrcms\\src\\test\\java\\document");

        // Ensure downloadDir is a directory and files array is not null
        if (downloadDir.isDirectory()) {
            File[] files = downloadDir.listFiles();
            if (files != null) {
                File latestFile = null;
                long lastModifiedTime = Long.MIN_VALUE;

                // Find the latest modified file
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".xlsx") && file.lastModified() > lastModifiedTime) {
                        lastModifiedTime = file.lastModified();
                        latestFile = file;
                    }
                }

                if (latestFile != null) {
                    String downloadedFileName = latestFile.getName();
                    System.out.println("Downloaded file name: " + downloadedFileName);
                    System.out.println("Downloaded file name: " + latestFile);

                    // Read the contents of the downloaded XLSX file
                    Sheet sheet;
                    try (FileInputStream fileInputStream = new FileInputStream(latestFile)) {
                        Workbook workbook = new XSSFWorkbook(fileInputStream);
                        sheet = workbook.getSheetAt(0);
                        Object[][] data = {{IbanNo, "EOS"}};
                        int rowIndex = 0;
                        for (Row row : sheet) {
                            if (rowIndex > 0) {
                                Cell firstCell = row.createCell(1);
                                firstCell.setCellValue(Arrays.deepToString(data));
                                System.out.println("empibanNo" + IbanNo);
                                System.out.println(firstCell);
                            }
                            rowIndex++;
                        }

                    }
                        /*
                        // Make sure IbanNo is defined and initialized before using it here
                        int rowIndex = 0;
                        for (Row row : sheet) {
                            if (rowIndex > 0) {
                                Cell firstCell = row.createCell(1);
                                firstCell.setCellValue(Arrays.deepToString(data));
                                System.out.println("empibanNo" + IbanNo);
                                System.out.println(firstCell);
                            }
                            rowIndex++;
                        }*/

                    // Save the modified data back to the file (optional)
//                    try (FileOutputStream fileOutputStream = new FileOutputStream(latestFile)) {
//                        workbook.write(fileOutputStream);
//                    }
//                } catch(IOException e){
//                    e.printStackTrace();
//                    // Handle the exception as needed
//                }
//            } else {
//                System.out.println("No XLSX files found in the download directory.");
//            }
//        }
//    } else
//
//    {
//        System.out.println("Invalid download directory path or directory does not exist.");
//    }
                }
            }
        }
    }
}