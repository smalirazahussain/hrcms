package Step_Definitions;

import Pages.Android.ACLPAGE;
import Pages.Android.AdminPage;
import Pages.Android.SubAdminPages;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static Hooks.Base_Class.driver;
import static Pages.Android.AdminPage.Action_Successfully;

public class ACLsteps {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();
    //public static By spinnerLocator;


    @Then("[ACL Page] first user deselect the checkbox first")
    public void aclPageFirstUserDeselectTheCheckboxFirst() throws InterruptedException {
        boolean shouldSubmit = false;
        List<WebElement> selectedCheckboxes = ACLPAGE.get_Deselect_Check_Box();
        for (WebElement checkbox : selectedCheckboxes) {
            System.out.println("IN Loop");
            if(checkbox.isEnabled()){
                System.out.println("IF condition");
            checkbox.click();
                shouldSubmit = true;
            }
        }

        if (shouldSubmit) {
            SubAdminPages.get_Submit().click();
            String actual = "Admin Updated Successfully";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Action_Successfully(actual))));
            String expect = AdminPage.get_Action_Successfully(actual).getText();
            Assert.assertEquals(expect,actual);
        } else {
            // If no checkbox was enabled, proceed to the next steps
            driver.navigate().back();
            System.out.println("No enabled checkboxes found, proceeding to the next step...");
        }
    }

    // Method to select specific checkboxes by their labels
//    public void selectCheckboxesByLabels(List<String> labels) {
//        for (String label : labels) {
//            WebElement checkboxLabel = driver.findElement(By.xpath("//span[contains(text(), '" + label + "')]/preceding-sibling::input[@type='checkbox']"));
//            if (!checkboxLabel.isSelected()) {
//                checkboxLabel.click();
//            }
//        }
//    }


}
