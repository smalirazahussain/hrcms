package Step_Definitions;

import Hooks.Base_Class;
import Pages.Android.AdminPage;
import Pages.Android.MolPages;
import Pages.Android.UpdateProliePage;
import Pages.HeadOfficePages.ManageEmployeesHeadOfficePage;
import Pages.HeadOfficePages.OnBoardApprovalHeadOfficePage;
import Utils.EmployeeAdditionalStorage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
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
import java.util.List;
import java.util.*;

import static Hooks.Base_Class.driver;
import static Hooks.Base_Class.enableNetworkLogging;
import static Pages.Android.AdminPage.*;
import static Pages.Android.MolPages.Mol_Cross_Button;
import static Pages.Android.RequestPage.Loading;
import static Pages.Android.UpdateProliePage.*;
import static Pages.HeadOfficePages.OnBoardApprovalHeadOfficePage.Phone_No;
import static Step_Definitions.AddEmployerSteps.IbanNo;
import static Step_Definitions.Employeessteps.*;
import static Step_Definitions.EndOfServicesSteps.filePath;
import static Step_Definitions.ProcessSalariesDepositSlipSteps.actualamount;
import static Step_Definitions.SignUpSteps.companyName;
import static Step_Definitions.SubAdminsteps.subadmincompanyTittle;
import static Step_Definitions.UpdateProfile.*;
import static Step_Definitions_Head_Ofiice.BrachesStepsHeadOffice.branch;
import static Step_Definitions_Head_Ofiice.BrachesStepsHeadOffice.phno;
import static Step_Definitions_Head_Ofiice.DashBoardStepsHeadOffice.exchangeHouseTittle;
import static Tests.Current_Date.currentMonth;


public class adminsteps {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();
    //public static By spinnerLocator;


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
    public void adminPageUserTapOnLoginPage() {
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

    //public static By spinnerLocator;
    public static By spinnerLocator;

    @And("[Admin Page] User tap on view button")
    public void adminPageUserTapOnViewButton() {
        spinnerLocator = By.cssSelector(".ant-spin.ant-spin-spinning.css-qgg3xn");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerLocator));
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(View)));
        AdminPage.get_View().click();
    }

    @When("[Admin Page] User tap on client Approvals")
    public void adminPageUserTapOnClientApprovals() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Loading)));
        AdminPage.get_Client_Approval().click();
    }

    @Then("[Admin Page] User enter the company name")
    public void adminPageUserEnterTheCompanyName() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Company_Client)));
        //AdminPage.get_Company_Client().sendKeys("Dart");
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
        enableNetworkLogging();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Action_Successfully(actual))));
        String expect = AdminPage.get_Action_Successfully(actual).getText();
        Assert.assertEquals(expect, actual);
    }

    private boolean waitForToastMessage(String expectedToastMessage) {
        try {
            String xpath = "//div[contains(text(), '" + expectedToastMessage + "')]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception e) {
            return false;
        }
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
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Browse_Button)));
        AdminPage.get_Browse_Button().click();
        Thread.sleep(3000);

        System.out.println("filePathsadmin" + filePaths);
        Robot rb = new Robot();
        StringSelection str = new StringSelection(filePaths);
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
        if (Objects.equals(phno, OnBoardApprovalHeadOfficePage.get_Phone_No_admin_Side().getText()))
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
//        By spinnerLocator = By.cssSelector(".ant-spin.ant-spin-spinning.css-qgg3xn");
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By) get_Action_Successfully(after));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Action_Successfully)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Admin_Action_Successfully)));
        String actual = AdminPage.get_Admin_Action_Successfully().getText();
        //String actual = AdminPage.get_Action_Successfully(after).getText();
        System.out.println("Actual MSG: " + actual);
        System.out.println(after);
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
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Admin_Employer_Button)));
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

    ;

    @Then("[Admin Page] User validate the toast message {string} and bank are some in the approval")
    public void adminPageUserValidateTheToastMessageAndBankAreSomeInTheApproval(String actual) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Action_Successfully)));
        String expect = get_Action_Successfully(actual).getText();
        Assert.assertEquals(actual, expect);
        System.out.println(expect);
    }

    @Then("[Admin Page] User tap on Exchange House Clients")
    public void adminPageUserTapOnExchangeHouseClients() throws InterruptedException {
        Thread.sleep(5000);
        AdminPage.get_Exchange_House_Clients_Button().click();
    }

    @Then("[Admin Page] User verify establishment id for the branch company and approve by admin")
    public void adminPageUserVerifyEstablishmentIdForTheBranchCompanyAndApproveByAdmin() throws InterruptedException {
        System.out.println("ESTID;" + first14);
        if (first14 == Long.parseLong(AdminPage.get_Establishmentid().getText()) && AdminPage.get_company_Name().getText().equals(companyName) && AdminPage.get_Trade_No().getText().equals(tradeno)) {
            AdminPage.get_Sponsor_No().getText();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Approve_Button)));
        AdminPage.get_Approve_Button().click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Approval_Ok)));
        AdminPage.get_Approval_Ok().click();
        System.out.println(companyName);
        System.out.println(SponsorDocNo);
        System.out.println(tradeno);
        Thread.sleep(5000);
    }

    @Then("[Approval Page] User tap on exchange house")
    public void approvalPageUserTapOnExchangeHouse() {
        AdminPage.get_Exchange_House_Button().click();
    }

    @When("[ExchangeHouse Page] User search the exchangehouse {string}")
    public void exchangehousePageUserSearchTheExchangehouse(String exchangeHouse) {
        AdminPage.get_Search().sendKeys(exchangeHouse);
    }

    @Then("[ExchangeHouse Page] User tap on the add branch")
    public void exchangehousePageUserTapOnTheAddBranch() {
        AdminPage.get_Add_Branch().click();
    }

    @And("[Admin Page] User tap on establishment id view button")
    public void adminPageUserTapOnEstablishmentIdViewButton() {
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Est_Id_View)));
        AdminPage.get_Est_Id_View().click();
    }

    @Then("[Admin Page] User validate the subadmin toast message {string}")
    public void adminPageUserValidateTheSubadminToastMessage(String actual) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(msg)));
        String approvalAlreadySubmitted = "You already submitted for approval. Please be patient";
        String expect = AdminPage.get_msg().getText();
        if (Objects.equals(expect, "Request generated successfully")) {
            System.out.println(expect);
            Assert.assertEquals(expect, actual);
        }
        if (Objects.equals(expect, "You already submitted for approval. Please be patient")) {
            System.out.println(expect);
            Assert.assertEquals(expect, approvalAlreadySubmitted);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(msg)));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Mol_Cross_Button)));
            //Thread.sleep(5000);
            MolPages.get_Mol_Cross_Button().click();
        } else {
            System.out.println("Can Not Read");
        }
    }


    @Then("[Admin Page] Sub admin enter the company in admin portal")
    public void adminPageSubAdminEnterTheCompanyInAdminPortal() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Company_Client)));
        AdminPage.get_Company_Client().sendKeys(subadmincompanyTittle + Keys.ENTER);
        System.out.println(subadmincompanyTittle);
    }

    private void manualPause() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

//    @Then("[Admin Page] User verify the all data they have creates on the file")
//    public void adminPageUserVerifyTheAllDataTheyHaveCreatesOnTheFile() throws IOException, InterruptedException, AWTException {
//        int previousRowCount = 0;
//      //  manualPause();
//
//        try (FileInputStream fis = new FileInputStream(filePaths)) {
//            System.out.println(filePaths);
//            Workbook workbook = WorkbookFactory.create(fis);
//            System.out.println("workbook: " + workbook);
//            Sheet sheet = workbook.getSheetAt(0);
//
//            // Get header elements from the webpage
//            List<WebElement> employees_File_Header = get_Employee_File_Header();
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//
//            // Extract expected headers from Excel
//            Row headerRow = sheet.getRow(0);
//            List<String> expectedHeaders = new ArrayList<>();
//            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
//                expectedHeaders.add(headerRow.getCell(i).getStringCellValue().trim().toLowerCase());
//            }
//
//            // Extract actual headers from WebElements
//            List<String> actualHeaders = new ArrayList<>();
//            for (WebElement headerElement : employees_File_Header) {
//                js.executeScript("arguments[0].scrollIntoView(true);", headerElement);
//                actualHeaders.add(headerElement.getText().trim().toLowerCase());
//            }
//            actualHeaders.removeIf(header -> header.equalsIgnoreCase("action") || header.equalsIgnoreCase("camp"));
//            Map<String, String> headerConversionMap = new HashMap<>();
//            headerConversionMap.put("emirates id", "eid");
//            headerConversionMap.put("emirates id expiry", "eid expiry");
//            headerConversionMap.put("mol number", "mol no");
//            headerConversionMap.put("gender", "gender(m/f)");
//            List<String> convertedActualHeaders = new ArrayList<>();
//            for (String header : actualHeaders) {
//                convertedActualHeaders.add(headerConversionMap.getOrDefault(header, header));
//            }
//            // Sort both lists to perform unordered comparison
//            Collections.sort(expectedHeaders);
//            Collections.sort(convertedActualHeaders);
//            System.out.println("expectedHeaders:" + expectedHeaders);
//            System.out.println("convertedActualHeaders:" + convertedActualHeaders);
//            // Compare headers unordered
//            Assert.assertEquals(expectedHeaders.toArray(), convertedActualHeaders.toArray(), "Headers do not match");
//            // Prepare tabular output header
//            StringBuilder tableOutput = new StringBuilder();
//            tableOutput.append(String.format("%-10s | %-20s | %-20s | %-20s\n", "Row", "Header", "Excel Value", "Webpage Value"));
//            tableOutput.append("---------------------------------------------------------------------------\n");
//            System.out.println("tableOutput:"+tableOutput);
//
//            // If headers match, proceed with row data comparison
//            Map<Integer, Map<String, String>> excelData = new TreeMap<>();
//            Map<Integer, Map<String, String>> webpageData = new TreeMap<>();
//
//            while (true) {
//                List<WebElement> rowElements = driver.findElements(By.cssSelector(".ant-table-row.editable-row"));
//                if (rowElements.size() > previousRowCount) {
//                    previousRowCount = rowElements.size();
//
//                    // Scroll to the bottom to load more rows
//                    WebElement lastRowElement = rowElements.get(rowElements.size() - 1);
//                    js.executeScript("arguments[0].scrollIntoView(true);", lastRowElement);
//                    Thread.sleep(1000); // Allow time for rows to load
//
//                    for (int i = 0; i < rowElements.size(); i++) {
//                        // Re-locate elements to avoid StaleElementReferenceException
//                        rowElements = driver.findElements(By.cssSelector(".ant-table-row.editable-row"));
//                        String[] storedRow = EmployeeAdditionalStorage.getData(); // Get the employee row
//                        List<WebElement> cellElements = rowElements.get(i).findElements(By.cssSelector("td.ant-table-cell"));
//
//                        Map<String, String> excelRowMap = new HashMap<>();
//                        Map<String, String> webpageRowMap = new HashMap<>();
//
//                        for (int j = 1; j < Math.min(cellElements.size()-1, expectedHeaders.size()); j++) {
////                            if (j == cellElements.size() - 1) continue;
//
//                            js.executeScript("arguments[0].scrollIntoView(true);", cellElements.get(j));
//
//                            String header = expectedHeaders.get(j); // Excel column header
//                            String expectedCellValue = storedRow[j].trim();
//                            String actualCellValue = cellElements.get(j).getText().trim();
//
//                            expectedCellValue = expectedCellValue.replace("/", "-").replace(".", "-").replace(" ", "");
//                            actualCellValue = actualCellValue.replace("/", "-").replace(".", "-").replace(" ", "");
//
//                            excelRowMap.put(header, expectedCellValue);
//                            webpageRowMap.put(header, actualCellValue);
//
//                            tableOutput.append(String.format("%-10d | %-20s | %-20s | %-20s\n", i + 1, header, expectedCellValue, actualCellValue));
//                            System.out.println("header:"+header);
//                        }
//
//                        excelData.put(i + 1, excelRowMap);
//                        webpageData.put(i + 1, webpageRowMap);
//                    }
//
//                } else {
//                    break;
//                }
//            }
//            // Convert the map entries to a list for sorting
//            List<Map.Entry<Integer, Map<String, String>>> excelDataList = new ArrayList<>(excelData.entrySet());
//            List<Map.Entry<Integer, Map<String, String>>> webpageDataList = new ArrayList<>(webpageData.entrySet());
//
//            // Sort the lists based on a specific key (e.g., "eid")
//            Comparator<Map.Entry<Integer, Map<String, String>>> comparator = Comparator.comparing(entry -> entry.getValue().getOrDefault("eid", ""));
//            excelDataList.sort(comparator);
//            webpageDataList.sort(comparator);
//
//            // Comparing sorted rows one by one
//            for (int i = 0; i < excelDataList.size(); i++) {
//                Map<String, String> excelRowMap = excelDataList.get(i).getValue();
//                Map<String, String> webpageRowMap = webpageDataList.get(i).getValue();
//
//                for (String header : excelRowMap.keySet()) {
//                    if (header.equalsIgnoreCase("camp")) continue;  // ❌ Skip comparing 'camp'
//                    String excelValue = excelRowMap.get(header);
//                    String webpageValue = webpageRowMap.get(header);
//
//                    // Null check before accessing webpageValue
//                    if (webpageValue == null) {
//                        softAssert.fail("No matching cell found on the webpage for the header: " + header + " in row: " + (i + 1));
//                        continue; // Skip to the next cell
//                    }
//
//                    // Append the comparison result to the table output
//                    tableOutput.append(String.format("%-10d | %-20s | %-20s | %-20s\n", i + 1, header, excelValue, webpageValue));
//                    System.out.println("tableOutput;"+tableOutput);
//
//                    // Assert that the Excel value matches the Webpage value
//                    System.out.println("excelRowMap:"+excelRowMap);
//                    System.out.println("webpageRowMap"+webpageRowMap);
//
//                    Assert.assertEquals(excelRowMap, webpageRowMap, "Mismatch for header " + header + " at row " + (i + 1));
//
//                }
//            }
//
//            //softAssert.assertAll();
//            workbook.close();
//
//            // Print the table output
//            System.out.println(tableOutput.toString());
//
//        } catch (StaleElementReferenceException e) {
//            System.out.println("Encountered StaleElementReferenceException. Retrying...");
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw e;
//        }
//    }

    @Then("[Admin Page] User tap pn the first approve button")
    public void adminPageUserTapPnTheFirstApproveButton() {
        String approvalFirstTopic = AdminPage.get_first_Topic().getText();
        System.out.println("approvalFirstTopic : " + approvalFirstTopic);

        if (Objects.equals(approvalFirstTopic, "Employees File Upload")) {
            AdminPage.get_first_Approve_Button().click();
            wait.until(ExpectedConditions.elementToBeClickable(get_Approval_Ok()));
            AdminPage.get_Approval_Ok().click();
            System.out.println("Approve Button");
        }
    }

    @Then("[Admin Page] User Tap om the Process file button")
    public void adminPageUserTapOmTheProcessFileButton() {
        try {
            // Wait for the Process File button to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Process_File_Button)));

            // Click the Process File button
            AdminPage.get_Process_File_Button().click();

            // Optional: Log or print success message
            System.out.println("Process File button clicked successfully.");
        } catch (Exception e) {
            // Handle any exception that occurs
            e.printStackTrace();
            //System.out.println("Failed to click the Process File button: " + e.getMessage());
        }
    }

    @And("[Admin Page] User tap on the select all radio button")
    public void adminPageUserTapOnTheSelectAllRadioButton() {
        AdminPage.get_Select_All_Radio_Button().click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(Bulk_Approval_Submit_Button)));
        AdminPage.get_Bulk_Approval_Submit_Button().click();

    }

    @Then("[Admin Page] The user verifies the approval toast message {string}")
    public void adminPageTheUserVerifiesTheApprovalToastMessage(String expectedMessage) {
        try {
            By toastLocator = By.xpath("//span[normalize-space()='Request is ready for further approval']");
            WebDriverWait wait = new WebDriverWait(Base_Class.driver, Duration.ofSeconds(20));

            WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
            String actualMessage = toast.getText();

            Assert.assertEquals(actualMessage.trim(), expectedMessage.trim());
            System.out.println("✅ Verified toast message: " + actualMessage);
        } catch (TimeoutException e) {
            Assert.fail("❌ Toast message not visible in time.");
        } catch (Exception e) {
            Assert.fail("❌ Failed to verify toast message: " + e.getMessage());
        }
    }

    @Then("[Admin Page] User verify the all data they have creates for the employee")
    public void adminPageUserVerifyTheAllDataTheyHaveCreatesForTheEmployee() throws InterruptedException {
//        System.out.println("📋 All stored employee data from EmployeeAdditionalStorage:");
//        EmployeeAdditionalStorage.printAll();
//
//        List<WebElement> uiHeaderElements = get_Employee_File_Header();
//        List<String> uiHeaders = new ArrayList<>();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        for (WebElement headerElement : uiHeaderElements) {
//            String headerText = (String) js.executeScript("return arguments[0].innerText;", headerElement);
//            headerText = headerText.trim();
//            if (!headerText.equalsIgnoreCase("Action") && !headerText.equalsIgnoreCase("Camp")) {
//                uiHeaders.add(headerText);
//            }
//        }
//
//        int columnsPerRow = uiHeaders.size();
//
//        // ✅ Get all <td> cells flat
//        List<WebElement> allCells = driver.findElements(By.cssSelector(".ant-table-row.editable-row td.ant-table-cell"));
//
//        System.out.println("\n📋 Headers from UI:");
//        for (String header : uiHeaders) {
//            System.out.println("➡️ " + header);
//        }
//
//        StringBuilder tableOutput = new StringBuilder();
//        tableOutput.append("\n📊 Comparison Table:\n");
//        tableOutput.append(String.format("%-8s | %-25s | %-25s | %-25s%n", "Row", "Header", "Expected", "Actual"));
//        tableOutput.append("-".repeat(100)).append("\n");
//
//        int rowCount = allCells.size() / columnsPerRow;
//        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
//            for (int colIndex = 0; colIndex < columnsPerRow; colIndex++) {
//                int flatIndex = rowIndex * columnsPerRow + colIndex;
//
//                WebElement cell = allCells.get(flatIndex);
//                js.executeScript("arguments[0].scrollIntoView(true);", cell);
//
//                String actual = normalize(cell.getText().trim());
//                String header = uiHeaders.get(colIndex);
//                String key = "employee-" + rowIndex + "-" + header;
//                String expected = normalize(EmployeeAdditionalStorage.getData(key));
//
//                System.out.printf("🔍 Row %d | Header: %-20s | Expected: %-25s | Actual: %-25s%n",
//                        rowIndex + 1, header, expected, actual);
//
//                tableOutput.append(String.format("%-8d | %-25s | %-25s | %-25s%n", rowIndex + 1, header, expected, actual));
//
//                // Assertion
//                softAssert.assertEquals(actual, expected, "❌ Mismatch in '" + header + "' at row " + (rowIndex + 1));
//            }
//        }
//
//        System.out.println(tableOutput);
//    }
//
//    private String normalize(String value) {
//        return value == null ? "" : value.replace("/", "-").replace(".", "-").replace(" ", "").trim();
//    }
        System.out.println("📋 All stored employee data from EmployeeAdditionalStorage:");
        EmployeeAdditionalStorage.printAll();

        Map<String, String> allData = EmployeeAdditionalStorage.getAllData();
        Thread.sleep(2000); // Wait for UI to stabilize

        // Extract stored headers
        List<String> storedHeaders = Arrays.asList(allData.get("employee-headers").split(","));

        Map<String, String> headerMapping = Map.ofEntries(
                Map.entry("Mol Number", "Mol No"),
                Map.entry("Emp Code", "Emp Code"),
                Map.entry("First Name", "First Name"),
                Map.entry("Last Name", "Last Name"),
                Map.entry("Display Name", "Display Name"),
                Map.entry("Date Of Birth", "Date of Birth"),
                Map.entry("Gender", "Gender(M/F)"),
                Map.entry("Nationality", "Nationality"),
                Map.entry("Date Of Joining", "Date of Joining"),
                Map.entry("Email", "Email"),
                Map.entry("Mobile", "Mobile"),
                Map.entry("Alternate Phone", "Alternate Phone"),
                Map.entry("Home Address", "Home Address"),
                Map.entry("Home State", "Home State"),
                Map.entry("Home Post Code", "Home Post Code"),
                Map.entry("Work Address", "Work Address"),
                Map.entry("Work State", "Work State"),
                Map.entry("Work Post Code", "Work Post Code"),
                Map.entry("Passport Number", "Passport Number"),
                Map.entry("Passport Expiry", "Passport Expiry"),
                Map.entry("Emirates ID", "EID"),
                Map.entry("Emirates ID Expiry", "EID Expiry"),
                Map.entry("Establishment ID", "Establishment Id")
        );

        // Get headers from UI
        List<WebElement> headerElements = driver.findElements(By.cssSelector(".ant-table-header th.ant-table-cell:not(.ant-table-selection-column)"));
        List<String> uiHeaders = new ArrayList<>();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (WebElement element : headerElements) {
            String headerText = element.getText().trim();
            if (!headerText.equalsIgnoreCase("Action") && !headerText.equalsIgnoreCase("Camp")) {
                uiHeaders.add(headerText);
            }
        }

        // Get UI rows as flat list
        List<WebElement> allCells = driver.findElements(By.cssSelector(".ant-table-row.editable-row td[id]"));
        JavascriptExecutor jss = (JavascriptExecutor) driver;

        System.out.println("🧾 Extracted Cell Data:");
        for (WebElement cell : allCells) {
            jss.executeScript("arguments[0].scrollIntoView(true);", cell);
            String header = cell.getAttribute("id").trim();
            String value = cell.getText().trim();
            System.out.printf("➡️  %-20s : %s%n", header, value);

        }

        int totalColumns = uiHeaders.size();
        int totalRows = allCells.size() / totalColumns;
        // Validate all rows including employee-0
        for (int i = 0; i < totalRows; i++) {
            System.out.println("\n🔍 Validating Row: " + (i + 1));

            for (int j = 0; j < totalColumns; j++) {
                WebElement cell = allCells.get(i * totalColumns + j);
                js.executeScript("arguments[0].scrollIntoView(true);", cell);
                String actual = normalize(cell.getText().trim());

                String uiHeader = uiHeaders.get(j);
                String mappedHeader = headerMapping.getOrDefault(uiHeader, uiHeader);

                if (!storedHeaders.contains(mappedHeader)) {
                    System.out.printf("⚠️  Skipping header '%s' (mapped: '%s') - not found in stored headers%n", uiHeader, mappedHeader);
                    continue;
                }

                String expectedKey = "employee-" + i + "-" + mappedHeader;
                String expected = normalize(allData.getOrDefault(expectedKey, ""));

                // Print before assertion
                System.out.printf("   %-20s | Expected: %-25s | Actual: %-25s%n", mappedHeader, expected, actual);
                softAssert.assertEquals(actual, expected, "❌ Mismatch in row " + (i + 1) + " for field: " + mappedHeader);
            }

            System.out.println("✅ Row " + (i + 1) + " validated successfully.");
            System.out.println("---------------------------------------------");
        }

        System.out.println("✅ All rows processed.");
        softAssert.assertAll();
    }

    private String normalize(String value) {
        return value == null ? "" : value
                .replace("/", "-")
                .replace(".", "-")
                .replace("@", "")
                .replace("-", "")
                .replace(" ", "")
                .trim()
                .toLowerCase();
    }

    @Then("[Admin Page] check the data")
    public void adminPageCheckTheData() {
//        System.out.println("\n✅ Starting Assertions:");
//
//        List<WebElement> allRows = driver.findElements(By.cssSelector(".ant-table-row.editable-row"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        // Mapping between UI field IDs and stored keys
//        Map<String, String> headerMapping = Map.ofEntries(
//                Map.entry("molNo", "Mol No"),
//                Map.entry("empCode", "Emp Code"),
//                Map.entry("firstName", "First Name"),
//                Map.entry("lastName", "Last Name"),
//                Map.entry("displayName", "Display Name"),
//                Map.entry("dob", "Date of Birth"),
//                Map.entry("gender", "Gender(M/F)"),
//                Map.entry("nationality", "Nationality"),
//                Map.entry("doj", "Date of Joining"),
//                Map.entry("email", "Email"),
//                Map.entry("mobileNo", "Mobile"),
//                Map.entry("altMobileNo", "Alternate Phone"),
//                Map.entry("homeAddress", "Home Address"),
//                Map.entry("stateId", "Home State"),
//                Map.entry("homeZipCode", "Home Post Code"),
//                Map.entry("workAddress", "Work Address"),
//                Map.entry("workStateId", "Work State"),
//                Map.entry("workZipCode", "Work Post Code"),
//                Map.entry("passportNumber", "Passport Number"),
//                Map.entry("passportExpiry", "Passport Expiry"),
//                Map.entry("eid", "EID"),
//                Map.entry("eidExpiry", "EID Expiry"),
//                Map.entry("establishmentId", "Establishment Id")
//        );
//
//        // Get all stored employee data
//        Map<String, String> allData = EmployeeAdditionalStorage.getAllData();
//
//        for (int rowIndex = 0; rowIndex < allRows.size(); rowIndex++) {
//            WebElement row = allRows.get(rowIndex);
//            List<WebElement> cells = row.findElements(By.cssSelector("td[id]"));
//
//            System.out.printf("%n📌 Row %d:%n", rowIndex);
//
//            for (WebElement cell : cells) {
//                js.executeScript("arguments[0].scrollIntoView(true);", cell);
//
//                String fieldId = cell.getAttribute("id").trim();         // e.g., "dob", "firstName"
//                String uiValue = cell.getText().trim();                 // Value from UI
//                String mappedKey = headerMapping.getOrDefault(fieldId, fieldId);  // "Date of Birth"
//
//                String storageKey = "employee-" + rowIndex + "-" + mappedKey;
//                String storedValue = allData.get(storageKey);
//
//                System.out.printf("🔍 %-20s | UI: %-30s | Stored: %-30s%n", mappedKey, uiValue, storedValue);
//
//                if (storedValue == null) {
//                    System.out.printf("⚠️  No stored value found for header '%s'%n", mappedKey);
//                } else {
//                    // Normalize only for date or expiry fields
//                    if (mappedKey.toLowerCase().contains("date") || mappedKey.toLowerCase().contains("expiry")) {
//                        String normalizedUi = uiValue.replace("-", "/").trim();
//                        String normalizedStored = storedValue.replace("-", "/").trim();
//                        Assert.assertEquals(normalizedUi, normalizedStored, "❌ Mismatch in '" + mappedKey + "'");
//                    } else {
//                        Assert.assertEquals(uiValue.trim(), storedValue.trim(), "❌ Mismatch in '" + mappedKey + "'");
//                    }
//                }
//            }
//        }
    }

    @Then("[Admin Page] Checker reviews the employee records created by the Maker")
    public void adminPageCheckerReviewsTheEmployeeRecordsCreatedByTheMaker() {
        System.out.println("\n✅ Starting Assertions:");

        List<WebElement> allRows = driver.findElements(By.cssSelector(".ant-table-row.editable-row"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Mapping between UI field IDs and stored keys
        Map<String, String> headerMapping = Map.ofEntries(
                Map.entry("molNo", "Mol No"),
                Map.entry("empCode", "Emp Code"),
                Map.entry("firstName", "First Name"),
                Map.entry("lastName", "Last Name"),
                Map.entry("displayName", "Display Name"),
                Map.entry("dob", "Date of Birth"),
                Map.entry("gender", "Gender(M/F)"),
                Map.entry("nationality", "Nationality"),
                Map.entry("doj", "Date of Joining"),
                Map.entry("email", "Email"),
                Map.entry("mobileNo", "Mobile"),
                Map.entry("altMobileNo", "Alternate Phone"),
                Map.entry("homeAddress", "Home Address"),
                Map.entry("stateId", "Home State"),
                Map.entry("homeZipCode", "Home Post Code"),
                Map.entry("workAddress", "Work Address"),
                Map.entry("workStateId", "Work State"),
                Map.entry("workZipCode", "Work Post Code"),
                Map.entry("passportNumber", "Passport Number"),
                Map.entry("passportExpiry", "Passport Expiry"),
                Map.entry("eid", "EID"),
                Map.entry("eidExpiry", "EID Expiry"),
                Map.entry("establishmentId", "Establishment Id")
        );

        // Get all stored employee data
        Map<String, String> allData = EmployeeAdditionalStorage.getAllData();

        for (int rowIndex = 0; rowIndex < allRows.size(); rowIndex++) {
            WebElement row = allRows.get(rowIndex);
            List<WebElement> cells = row.findElements(By.cssSelector("td[id]"));

            System.out.printf("%n📌 Row %d:%n", rowIndex);

            for (WebElement cell : cells) {
                js.executeScript("arguments[0].scrollIntoView(true);", cell);

                String fieldId = cell.getAttribute("id").trim();         // e.g., "dob", "firstName"
                String uiValue = cell.getText().trim();                 // Value from UI
                String mappedKey = headerMapping.getOrDefault(fieldId, fieldId);  // "Date of Birth"

                String storageKey = "employee-" + rowIndex + "-" + mappedKey;
                String storedValue = allData.get(storageKey);

                System.out.printf("🔍 %-20s | UI: %-30s | Stored: %-30s%n", mappedKey, uiValue, storedValue);

                if (storedValue == null) {
                    System.out.printf("⚠️  No stored value found for header '%s'%n", mappedKey);
                } else {
                    // Normalize only for date or expiry fields
                    if (mappedKey.toLowerCase().contains("date") || mappedKey.toLowerCase().contains("expiry")) {
                        String normalizedUi = uiValue.replace("-", "/").trim();
                        String normalizedStored = storedValue.replace("-", "/").trim();
                        Assert.assertEquals(normalizedUi, normalizedStored, "❌ Mismatch in '" + mappedKey + "'");
                    } else {
                        Assert.assertEquals(uiValue.trim(), storedValue.trim(), "❌ Mismatch in '" + mappedKey + "'");
                    }
                }
            }
        }
    }
}


//        // Correcting the way the FileInputStream is initialized
//        try (FileInputStream fis = new FileInputStream(filePaths)) {
//            System.out.println(filePaths);
//            Workbook workbook = WorkbookFactory.create(fis);
//            System.out.println("workbook: " + workbook);
//            Sheet sheet = workbook.getSheetAt(0);
//
//
//            // Get header elements from the webpage
//            List<WebElement> employees_File_Header = get_Employee_File_Header();
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//
//            // Extract expected headers from Excel
//
//            Row headerRow = sheet.getRow(0);
//            ArrayList<String> expectedHeaders = new ArrayList<>();
//            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
//                expectedHeaders.add(headerRow.getCell(i).getStringCellValue().trim().toLowerCase());
//            }
//
//            // Extract actual headers from WebElements
//            ArrayList<String> actualHeaders = new ArrayList<>();
//            for (WebElement headerElement : employees_File_Header) {
//                js.executeScript("arguments[0].scrollIntoView(true);", headerElement);
//                actualHeaders.add(headerElement.getText().trim().toLowerCase());
//            }
//
//            // Sort both lists to ignore order differences
//            Collections.sort(expectedHeaders);
//            Collections.sort(actualHeaders);
//
//            // Remove "Action" and "No" from the actual headers list
//            actualHeaders.removeIf(header -> header.equalsIgnoreCase("Action"));
//            actualHeaders.removeIf(header -> header.equalsIgnoreCase("No"));
//
//            // Compare headers
//            for (int i = 0; i < expectedHeaders.size(); i++) {
//                String expectedHeader = expectedHeaders.get(i);
//                String actualHeader = actualHeaders.get(i);
//                System.out.println("Comparing expectedHeader: " + expectedHeader + " with actualHeader: " + actualHeader);
//                softAssert.assertEqualsNoOrder(new String[]{expectedHeader}, new String[]{actualHeader}, "Header mismatch at index " + (i + 1));
//            }
//            // Process and compare all rows of data
//            int lastRowIndex = sheet.getLastRowNum();
//            int previousRowCount = 0;
//
//            try {
//                Map<Integer, List<String>> excelData = new TreeMap<>();
//                Map<Integer, List<String>> webpageData = new TreeMap<>();
//
//                while (true) {
//                    List<WebElement> rowElements = driver.findElements(By.cssSelector(".ant-table-row.editable-row"));
//                    //div.ant-table-tbody-virtual-holder > div > div > div:nth-child(n)
//                    if (rowElements.size() > previousRowCount) {
//                        previousRowCount = rowElements.size();
//
//                        // Scroll to the bottom to load more rows
//                        WebElement lastRowElement = rowElements.get(rowElements.size() - 1);
//                        js.executeScript("arguments[0].scrollIntoView(true);", lastRowElement);
//                        Thread.sleep(1000); // Allow time for rows to load
//
//
//                        for (int i = 0; i < rowElements.size(); i++) {
//                            // Re-locate elements to avoid StaleElementReferenceException
//                            rowElements = driver.findElements(By.cssSelector(".ant-table-row.editable-row"));
//                            Row excelRow = sheet.getRow(i + 1); // Excel row index starts from 1 (skip header)
//                            List<WebElement> cellElements = rowElements.get(i).findElements(By.cssSelector("td.ant-table-cell"));
//                            System.out.println("cellElements: " +cellElements);
//
//                            List<String> excelRowData = new ArrayList<>();
//                            List<String> webpageRowData = new ArrayList<>();
//
//                            for (int j = 1; j < cellElements.size(); j++) {
//                                if (j == cellElements.size() - 1) {
//                                    continue; // Skip the comparison for the last column
//                                }
//
//                                js.executeScript("arguments[0].scrollIntoView(true);", cellElements.get(j));
//
//                                String expectedCellValue = (excelRow.getCell(j - 1) != null) ? excelRow.getCell(j - 1).toString().trim() : "";
//                                String actualCellValue = cellElements.get(j).getText().trim();
//                                System.out.println("actualCellValue;"+actualCellValue);
//
//                                // Normalize date formats before comparison
//                                expectedCellValue = expectedCellValue.replace("/", "-").replace(".", "-").replace(" ", "");
//                                actualCellValue = actualCellValue.replace("/", "-").replace(".", "-").replace(" ", "");
//
//                                excelRowData.add(expectedCellValue);
//                                webpageRowData.add(actualCellValue);
//                            }
//
//                            excelData.put(i + 1, excelRowData);
//                            webpageData.put(i + 1, webpageRowData);
//                        }
//
//                    } else {
//                        break;
//                    }
//                }
//                // Assuming the unique identifier is in the first column (index 0)
//                for (Map.Entry<Integer, List<String>> entry : excelData.entrySet()) {
//                    int rowIndex = entry.getKey();
//                    List<String> excelRowData = entry.getValue();
//
//                    // Identify the unique identifier from the Excel row (e.g., User ID, Employee ID, etc.)
//                    String uniqueIdentifier = excelRowData.get(0); // Assuming the unique ID is in the first column
//
//                    // Find the corresponding row in the webpageData
//                    List<String> webpageRowData = null;
//                    for (List<String> rowData : webpageData.values()) {
//                        if (rowData.get(0).equals(uniqueIdentifier)) { // Matching unique ID
//                            webpageRowData = rowData;
//                            break;
//                        }
//                    }
//
//                    if (webpageRowData == null) {
//                        softAssert.fail("No matching row found on the webpage for the unique identifier: " + uniqueIdentifier);
//                        continue;
//                    }
//
//                    System.out.println("Comparing Excel Row " + rowIndex + " with Webpage row matching unique identifier " + uniqueIdentifier + ":");
//
//                    for (int k = 0; k < excelRowData.size(); k++) {
//                        String excelValue = excelRowData.get(k);
//                        String webpageValue = webpageRowData.get(k);
//
//                        System.out.println("Column " + (k + 2) + ": Excel value = " + excelValue + " | Webpage value = " + webpageValue);
//
//                        // Normalize date formats before comparison
//                        excelValue = excelValue.replace("/", "-").replace(".", "-").replace(" ", "");
//                        webpageValue = webpageValue.replace("/", "-").replace(".", "-").replace(" ", "");
//
//                        softAssert.assertEquals(excelValue, webpageValue, "Mismatch at row " + rowIndex + ", column " + (k + 2));
//                    }
//                }
//                softAssert.assertAll();
//                workbook.close();
//            } catch (StaleElementReferenceException e) {
//                // Retry logic in case of StaleElementReferenceException
//                System.out.println("Encountered StaleElementReferenceException. Retrying...");
//                // adminPageUserVerifyTheAllDataTheyHaveCreatedOnTheFile(); // Uncomment and implement if needed
//            } catch (IOException e) {
//                e.printStackTrace();
//                throw e; // Rethrow the exception after logging it
//            }
//        }
//    }
//}
