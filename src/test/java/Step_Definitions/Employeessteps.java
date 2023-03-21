package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.AdminPage;
import Pages.Android.EmployeesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

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


}