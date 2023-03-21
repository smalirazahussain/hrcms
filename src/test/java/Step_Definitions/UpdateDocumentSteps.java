package Step_Definitions;

import Pages.Android.AddEmployerPages;
import Pages.Android.UploadDocumentPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static Hooks.Base_Class.driver;
import static Pages.Android.UpdateProliePage.getSubmitButton;
import static Tests.Scroll.ScrollVertical;

public class UpdateDocumentSteps {

    public WebDriverWait wait = new WebDriverWait(driver, 30);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();



    @And("[Upload Document] User tap on edit button")
    public void uploadDocumentUserTapOnEditButton() {
        UploadDocumentPages.get_Edit_Button().click();
    }


    @Then("[Upload Document] User select the document {string}")
    public void uploadDocumentUserSelectTheDocument(String document) throws InterruptedException {
        UploadDocumentPages.get_Document_Name(document).click();
    }

    @Then("[Upload Document] User tap in the document")
    public void uploadDocumentUserTapInTheDocument() {
        UploadDocumentPages.get_document().click();
    }

    @Then("[Update Document] User tap on browse document")
    public void updateDocumentUserTapOnBrowseDocument() throws AWTException, InterruptedException {
        UploadDocumentPages.get_Brows_Document().click();
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
        //ScrollVertical(getSubmitButton());

    }

    @And("[Update Document] User tap on Upload Document")
    public void updateDocumentUserTapOnUploadDocument() throws InterruptedException {
        UploadDocumentPages.get_Upload_Document().click();
    }

    public static void main(String[] args) {
        String currentURL  = driver.getCurrentUrl();
        System.out.println(currentURL);
    }
}
