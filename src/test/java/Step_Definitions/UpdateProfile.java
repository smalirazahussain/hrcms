package Step_Definitions;

//import static Pages.Android.LoginPage.create_Account_Button;
//import static Tests.Useful_functions.getRandomNumberLowerAndUpperBound;


import Pages.Android.AddEmployerPages;
import Pages.Android.AdminPage;
import Pages.Android.SignUpPage;
import Pages.Android.UpdateProliePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Instant;

import static Hooks.Base_Class.driver;
import static Pages.Android.AddEmployerPages.get_Add_Emplyer_Button;
import static Pages.Android.LoginPage.Error_Message_In_Password;
import static Pages.Android.LoginPage.Login_Button;
import static Pages.Android.UpdateProliePage.*;
import static Step_Definitions.SignUpSteps.companyName;
import static Step_Definitions.SignUpSteps.randomInt;
import static Tests.Current_Date.currentMonth;
import static Tests.Current_Date.currentYear;
import static Tests.Scroll.ScrollVertical;

public class UpdateProfile {

    public WebDriverWait wait = new WebDriverWait(driver, 60);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();

    @And("[Update Profile] User the address {string}")
    public void updateProfileUserTheAddress(String add) {
        long first14 = (long) (Math.random() * 100000000L);
        UpdateProliePage.getAddress().sendKeys(add+first14);

    }


    public static long first14;
    @Then("[Update Profile] User enter the establishment id {string}")
    public void updateProfileUserEnterTheEstablishmentId(String eid) {
         first14 = (long) (Math.random() * 10000000000000000L);
        UpdateProliePage.getEstablishmentId().sendKeys(first14+eid);


    }

    @And("[Update Profile] Select the state {string}")
    public void updateProfileSelectTheState(String name) throws InterruptedException {
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(name)));
        UpdateProliePage.getState().click();
        //        driver.findElement(By.xpath("div[title='Dubai'] div[class='ant-select-item-option-content']"));
        //UpdateProliePage.getStateDubai().click();
       // UpdateProliePage.getState().sendKeys(name);
       // UpdateProliePage.getState().sendKeys(Keys.ENTER);
        UpdateProliePage.getStateName(name).click();
//        UpdateProliePage.getStateName(name).sendKeys(Keys.ENTER);
        //Select sel = new Select();



    }

    @Then("[Update Profile] User enter the document name {string}")
    public void updateProfileUserEnterTheDocumentName(String docnamentName) throws InterruptedException {
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(docnamentName)));
        UpdateProliePage.getDocument().click();
        UpdateProliePage.getDocumentName(docnamentName).click();


    }

    @And("[Update Profile] User enter the document tittle {string}")
    public void updateProfileUserEnterTheDocumentTittle(String perdetail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(personalDetail)));
        UpdateProliePage.getPersonalDetail().sendKeys(perdetail);
    }

    @When("[Update Profile] User enter the city {string}")
    public void updateProfileUserEnterTheCity(String cityname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(city)));
        UpdateProliePage.getcity().sendKeys(cityname);
    }

    @Then("[Update Profile] User enter the issue date {string}")
    public void updateProfileUserEnterTheIssueDate(String isdate) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(issueDate)));
        UpdateProliePage.getIssueDate().sendKeys(isdate);
        Thread.sleep(4000);
    }

    @And("[Update Profile] User enter the expire date {string}")
    public void updateProfileUserEnterTheExpireDate(String expdate) throws InterruptedException, AWTException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(expireDate)));
        UpdateProliePage.getExpireDate().sendKeys(expdate);
        UpdateProliePage.getExpireDate().click();
        Thread.sleep(5000);
    }

    @Then("[Update Profile] User tap on browse file")
    public void updateProfileUserTapOnBrowseFile() throws InterruptedException, AWTException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(browseFile)));
        UpdateProliePage.getBrowseFile().click();
        Thread.sleep(3000);


        Robot rb = new Robot();
        StringSelection str = new StringSelection("D:\\Hrcms\\src\\test\\java\\document\\Trade doc.pdf");
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



    @And("[Update Profile] User enter the submit button")
    public void updateProfileUserEnterTheSubmitButton() throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]")));
        UpdateProliePage.getSubmitButton().click();


    }


    @And("[Update Profile] User enter the month {string}")
    public void updateProfileUserEnterTheMonth(String moth) throws InterruptedException {
        String current_month = currentMonth();

        if (current_month == moth) {

        }

        else {
            get_secondmonth_select(current_month).click();
//             get_month_select(current_month).click();
//             UpdateProliePage.get_month(current_month).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(user_month(moth))));
            get_user_month(moth).click();
        }
    }



    @Then("[Update Profile] Validate the establishment id error {string}")
    public void updateProfileValidateTheEstablishmentIdError(String esterror) {
        UpdateProliePage.getEstablishmentIdError().isDisplayed();
        Assert.assertEquals(esterror,"Please enter establishment Id");

    }

    @Then("[Update Profile] Validate the address error {string}")
    public void updateProfileValidateTheAddressError(String adderror) {
        UpdateProliePage.getAddress().isDisplayed();
        Assert.assertEquals(adderror,"Please enter address 1");
    }

    @Then("[Update Profile] User enter the year {int}")
    public void updateProfileUserEnterTheYear(int isYear) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(issueDate)));
        UpdateProliePage.getIssueDate().click();

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickYear_xpath)));
        String year = currentYear();
        int year1 = Integer.parseInt(year);
        year1 = year1 - isYear;

        for(int i=0; i<year1; i++) {
            get_year_arrow_xpath().click();

        }

    }

    @Then("[Update Profile] User enter the day {string}")
    public void updateProfileUserEnterTheDay(String isDay) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(date_select(isDay))));
        UpdateProliePage.get_date_select(isDay).click();

    }
/*
    @And("[Update Profile] User enter the expire year {string}")
    public void updateProfileUserEnterTheExpireYear(String expyear) throws InterruptedException {
        UpdateProliePage.getExpireDate().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickYear_xpath)));
        String year = currentYear();
        int year1 = Integer.parseInt(year);
        year1 = year1 + Integer.parseInt(expyear);

        for(int i=0; i<year1; i++) {
            getExpYearArrow(expyear).click();
            Thread.sleep(500);
        }
*/


    @And("[Update Profile] User enter the expire year {int}")
    public void updateProfileUserEnterTheExpireYear(int expyear) throws InterruptedException {
        UpdateProliePage.getExpireDate().click();
        String year = currentYear();
        int year1 = Integer.parseInt(year);
        year1 = expyear - year1;

        for(int i=0; i<year1; i++) {
            UpdateProliePage.getExpYearArrow().click();

        }

    }

    @And("[Update Profile] User enter the expire day {string}")
    public void updateProfileUserEnterTheExpireDay(String expDay) throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(date_select(expDay))));
        UpdateProliePage.get_Expire_Date_Select(expDay).click();
    }

    @Then("[Update Profile] Validate the state error {string}")
    public void updateProfileValidateTheStateError(String stateerror) {
        UpdateProliePage.get_State_Error().isDisplayed();
        Assert.assertEquals(stateerror,"Please enter state");
    }

    @Then("[Update Profile] user try to login and validate the city  error {string}")
    public void updateProfileUserTryToLoginAndValidateTheCityError(String city) {
        UpdateProliePage.get_City_Error().isDisplayed();
        Assert.assertEquals(city,"Please enter city");
    }

    @Then("[Update Profile] user try to login and validate the document no  error {string}")
    public void updateProfileUserTryToLoginAndValidateTheDocumentNoError(String errordocumentno) {
        UpdateProliePage.get_Document_No_Error().isDisplayed();
        Assert.assertEquals(errordocumentno,"Please enter Document Title");
    }


    @Then("[Update Profile] User try to login and validate the document name  error {string}")
    public void updateProfileUserTryToLoginAndValidateTheDocumentNameError(String errordocumentname) {
        UpdateProliePage.get_Document_Name_Error().isDisplayed();
        Assert.assertEquals(errordocumentname,"Please enter name");
    }

    @When("[Update Profile] User tap on the issue date")
    public void updateProfileUserTapOnTheIssueDate() throws InterruptedException {
        UpdateProliePage.getIssueDate().click();
        Thread.sleep(5000);
    }

    @Then("[Update Profile] User try to login and validate the issue date  error {string}")
    public void updateProfileUserTryToLoginAndValidateTheIssueDateError(String issuedateerror) {
        UpdateProliePage.get_Issue_Date_Error().isDisplayed();
        Assert.assertEquals(issuedateerror,"Please enter issue date");
    }

    @And("[Update Profile] User try to login and validate the expire date  error {string}")
    public void updateProfileUserTryToLoginAndValidateTheExpireDateError(String expdateerror) {
        UpdateProliePage.get_expire_Date_Error().isDisplayed();
        Assert.assertEquals(expdateerror,"Please enter expiry date");
    }

    @And("[Update Profile] User tap on the add more document")
    public void updateProfileUserTapOnTheAddMoreDocument() {
        UpdateProliePage.get_Add_More_Document().click();


    }

    @Then("[Update Profile] User enter the second  document  {string}")
    public void updateProfileUserEnterTheSecondDocument(String documentno) throws InterruptedException {
        UpdateProliePage.get_Second_Document().sendKeys(documentno);
    }

    @And("[Update Profile] User enter the document second name {string}")
    public void updateProfileUserEnterTheDocumentSecondName(String documentname) {
        UpdateProliePage.get_second_Documment_Name().sendKeys(documentname);
    }

    @Then("[Update Profile] User enter the second issue year {int}")
    public void updateProfileUserEnterTheSecondIssueYear(int secissuedate) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(issueDate)));
        UpdateProliePage.get_Second_Issue_Date().click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickYear_xpath)));
        String year = currentYear();
        int year1 = Integer.parseInt(year);
        year1 = year1 - secissuedate;

        for(int i=0; i<year1; i++) {
            get_Second_Issue_arrow_xpath().click();

        }

    }

    @Then("[Update Profile] User enter the  second day {string}")
    public void updateProfileUserEnterTheSecondDay(String secondissuedate) {
        UpdateProliePage.get_second_date_select(secondissuedate).click();

    }

    @And("[Update Profile] User enter the second month {string}")
    public void updateProfileUserEnterTheSecondMonth(String secondissuemonth) throws InterruptedException {
        String current_month = currentMonth();

        if (current_month == secondissuemonth) {
        }

        else {
            get_secondmonth_select(current_month).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(user_month(secondissuemonth))));
            get_user_month(secondissuemonth).click();
        }
    }

    @And("[Update Profile] User enter the second expire year {int}")
    public void updateProfileUserEnterTheSecondExpireYear(int secondexpyear) throws InterruptedException {
        UpdateProliePage.get_Second_Expire_Year().click();
        String year = currentYear();
        int year1 = Integer.parseInt(year);
        year1 = secondexpyear - year1;

        for (int i = 0; i < year1; i++) {
            UpdateProliePage.get_Second_Exp_Year_Arrow().click();
        }
        Thread.sleep(5000);
    }

    @And("[Update Profile] User enter the second expire day {string}")
    public void updateProfileUserEnterTheSecondExpireDay(String secexpDay) {
        UpdateProliePage.get_Second_Expire_Date_Select(secexpDay).click();
    }

    @Then("[Update Profile] User enter the second expire month {string}")
    public void updateProfileUserEnterTheSecondExpireMonth(String secexpmonth) {
        String current_month = currentMonth();

        if (current_month == secexpmonth) {

        }

        else {
            get_user_secondmonth(current_month).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(user_month(secexpmonth))));
            get_user_month(secexpmonth).click();
        }
    }

    @Then("[Update Profile] User tap on second browse file")
    public void updateProfileUserTapOnSecondBrowseFile() throws InterruptedException, AWTException {
        UpdateProliePage.get_Second_Brows_Button().click();
        Thread.sleep(3000);

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
        ScrollVertical(getSubmitButton());
        Thread.sleep(5000);
    }

    @Then("[Update Profile] User enter the building no {string}")
    public void updateProfileUserEhterTheBuildingNo(String BNO) throws InterruptedException {
        long buildingno = (long) (Math.random()*100000000L);
        UpdateProliePage.get_Building_No().sendKeys(buildingno+BNO);


    }



    @Then("[Update Profile] User select the Payroll type{string}")
    public void updateProfileUserSelectThePayrollType(String payroll) throws InterruptedException {
        UpdateProliePage.get_Payroll().sendKeys(payroll);
        UpdateProliePage.get_Payroll().sendKeys(Keys.ENTER);

    }

    @And("[Update Profile] User select the FreeZone")
    public void updateProfileUserSelectTheFreeZone() {
        UpdateProliePage.get_Free_Zone().click();
    }

    @And("[Update Profile] User select the Migrated")
    public void updateProfileUserSelectTheMigrated() {
        UpdateProliePage.get_Migrated().click();
    }

    public static String tradeno ;
    @Then("[Update Profile] User enter the Trade License Number {string}")
    public void updateProfileUserEnterTheTradeLicenseNumber(String TBL) {
        long Trade_License = (long)(Math.random()*1000000000000L);
        UpdateProliePage.get_Trade_License().sendKeys(TBL+Trade_License);
         tradeno = TBL + Trade_License;
    }

    @When("[Update Profile] User enter the Sponsor Document year {string}")
    public void updateProfileUserEnterTheSponsorDocumentYear(String isyear) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(issueDate)));
        UpdateProliePage.get_Sponsor_IssueDate().click();

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clickYear_xpath)));
        String year = currentYear();
        int year1 = Integer.parseInt(year);
        year1 = year1 - Integer.parseInt(isyear);

        for(int i=0; i<year1; i++) {
            UpdateProliePage.get_Sponsor_year_arrow_xpath().click();

        }

    }

    @When("[Update Profile] User enter the Sponsor Document month {string}")
    public void updateProfileUserEnterTheSponsorDocumentMonth(String moth) {
        String current_month = currentMonth();

        if (current_month == moth) {

        }

        else {
            get_month_select(current_month).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(user_month(moth))));
            get_user_month(moth).click();
        }
    }

    @Then("[Update Profile] User enter the Sponsor day {string}")
    public void updateProfileUserEnterTheSponsorDay(String isDay) throws InterruptedException {
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(date_select(isDay))));
        UpdateProliePage.get_Sponsor_date_select(isDay).click();
        //Thread.sleep(5000);
    }

    @And("[Update Profile] User enter the Sponsor expire year {int}")
    public void updateProfileUserEnterTheSponsorExpireYear(int expyear) {
        UpdateProliePage.getSponsorExpireDate().click();
        String year = currentYear();
        int year1 = Integer.parseInt(year);
        year1 = expyear - year1;

        for(int i=0; i<year1; i++) {
            UpdateProliePage.getSponsorExpYearArrow().click();

        }

    }

    @Then("[Update Profile] User enter the Sponsor expire month {string}")
    public void updateProfileUserEnterTheSponsorExpireMonth(String expmonth) {
        String current_month = currentMonth();

        if (current_month == expmonth) {

        }

        else {
            get_month_select(current_month).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(user_month(expmonth))));
            get_user_month(expmonth).click();
        }
    }

    @And("[Update Profile] User enter the Sponsor expire day {string}")
    public void updateProfileUserEnterTheSponsorExpireDay(String expDay) {
        UpdateProliePage.get_Sponsor_Expire_Date_Select(expDay).click();
    }
    public static String  SponsorDocNo;
    @And("[Update Profile] User enter the Sponsor document number {string}")
    public void updateProfileUserEnterTheSponsorDocumentNumber(String SD) {
        long Sponsor_Document = (long)(Math.random()*1000000000000L);
        UpdateProliePage.get_Sponsor_Document_No().sendKeys(SD+Sponsor_Document);
         SponsorDocNo = SD + Sponsor_Document;


    }

    @Then("[Update Profile] User tap on Sponsor document browse file")
    public void updateProfileUserTapOnSponsorDocumentBrowseFile() throws InterruptedException, AWTException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(browseFile)));
        UpdateProliePage.getSponsorDocumentBrowseFile().click();
        Thread.sleep(3000);


        Robot rb = new Robot();
        StringSelection str = new StringSelection("D:\\Hrcms\\src\\test\\java\\document\\Trade doc.pdf");
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

    @Then("[Update Profile] Validate the onboard approval message {string}")
    public void updateProfileValidateTheOnboardApprovalMessage(String beforemsg) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Approval_Msg)));
        String actualmsg = UpdateProliePage.get_Approval_Msg().getText();
        Assert.assertEquals(actualmsg,beforemsg);
    }

    @Then("[Admin Page] User verify establishment id and approve by admin")
    public void adminPageUserVerifyEstablishmentIdAndApproveByAdmin() throws InterruptedException {

        if(first14 == Long.parseLong(AdminPage.get_Establishmentid().getText())
                && AdminPage.get_company_Name().getText().equals(companyName)
                && AdminPage.get_Trade_No().getText().equals(tradeno)
                && AdminPage.get_Sponsor_No().getText().equals(SponsorDocNo)){
            AdminPage.get_Approve_Button().click();
            AdminPage.get_Approval_Ok().click();

        }

        System.out.println(companyName);
        Thread.sleep(5000);
    }

    @Then("[Update Profile] User enter the Passport expire month {string}")
    public void updateProfileUserEnterThePassportExpireMonth(String expmonth) throws InterruptedException {
        //Thread.sleep(5000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(user_month(expmonth))));
        String current_month = currentMonth();

        if (current_month == expmonth) {

        }

        else {
            AddEmployerPages.get_Passport_month_select(current_month).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(user_month(expmonth))));
            get_user_month(expmonth).click();
        }
    }

    @And("[Update Profile] User enter the Passport month {string}")
    public void updateProfileUserEnterThePassportMonth(String moth) {
        String current_month = currentMonth();

        if (current_month == moth) {

        }

        else {
             get_secondmonth_select(current_month).click();
//             get_month_select(current_month).click();
                UpdateProliePage.get_month(current_month).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(user_month(moth))));
            get_user_month(moth).click();
        }
    }

}







/*
    @Then("[Update Profile] User enter the year {string}")
    public void updateProfileUserEnterTheYear(String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(yaerno));
        SignUpPage.Year()
    }
/*
    @Then("[Update Profile] User upload the personal document")
    public void updateProfileUserUploadThePersonalDocument() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(browseFile)));


    }

 */

