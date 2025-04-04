package step_Defination_Master_Admin;

import Pages.MasterAdmin.MasterAdminAdditionalDetailsPage;
import Utils.EmployerDataStorage;
import Utils.RandomDateGenerator;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static Hooks.Base_Class.driver;
import static org.apache.commons.exec.util.DebugUtils.handleException;

public class masterAdminAdditionalDetailsSteps {

    Duration timeout = Duration.ofSeconds(30);
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();
    @Then("[Additional Details] The user navigates to the {string} tab")
    public void additionalDetailsTheUserNavigatesToTheTab(String arg0) {
//        try {
            WebElement additionalDetailsTab = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Additional_DetailsTab()));
            additionalDetailsTab.click();
            System.out.println("✅ Navigated to Additional Details tab");
//        } catch (Exception e) {
//            handleException("Navigating to Additional Details tab", e);
//        }
    }

    @Then("[Additional Details] The user click to the AddEdit Onboarding Source button")
    public void additionalDetailsTheUserClickToTheAddEditOnboardingSourceButton() {
        try {
            // ✅ Wait for the button to be clickable
            WebElement addEditOnboardingSourceButton = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Add_Edit_Onboarding_Source_button()));

            // ✅ Click the button
            addEditOnboardingSourceButton.click();

            // ✅ Print confirmation message
            System.out.println("✅ Clicked on 'Add/Edit Onboarding Source' button.");

        } catch (Exception e) {
            handleException("Clicking 'Add/Edit Onboarding Source' button", e);
        }
    }

    @Then("[Additional Details] The user selects the Onboarding Source {string}")
    public void additionalDetailsTheUserSelectsTheOnboardingSource(String source) {

            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Onboarding_Source_Dropdown()));
            dropdown.sendKeys(source);
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Add_Onboarding_Source(source)));
            option.click();

        // ✅ Store the selected onboarding source
            EmployerDataStorage.storeData("onboardingSource", source);
            System.out.println("✅ Selected Onboarding Source: " + source);
      //  } catch (Exception e) {
        //    handleException("Selecting Onboarding Source", e);
        }

    @Then("[Additional Details] The user clicks on the Add Product button")
    public void additionalDetailsTheUserClicksOnTheAddProductButton() throws InterruptedException {
      //  try {
        Thread.sleep(3000);
            WebElement addProductBtn = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Add_Product_Button()));
            addProductBtn.click();
            System.out.println("✅ Clicked on Add Product button");
      //  } catch (Exception e) {
          //  handleException("Clicking Add Product button", e);
        //}
    }

    @Then("[Additional Details] The user selects product type {string}")
    public void additionalDetailsTheUserSelectsProductType(String productType) {
        try {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Product_Type_Dropdown()));
            dropdown.sendKeys(productType);

            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(MasterAdminAdditionalDetailsPage.get_Select_Product_Type(productType)));
            option.click();

            EmployerDataStorage.storeData("ProductType", productType);
            System.out.println("✅ Product Type Selected: " + productType);
        } catch (Exception e) {
            handleException("Select Product Type", e);
        }
    }

    @Then("[Additional Details] The user enters effect from {string} and effect to {string}")
    public void additionalDetailsTheUserEntersEffectFromAndEffectTo(String arg0, String arg1) {
        try {
            WebElement from = MasterAdminAdditionalDetailsPage.get_Effect_From();
            WebElement to = MasterAdminAdditionalDetailsPage.get_Effect_To();
            String fromDate = RandomDateGenerator.generateRandomPastTradeLicenseDate();
            from.sendKeys(fromDate);
            String toDate = RandomDateGenerator.generateRandomFutureExpiryDate();
            to.sendKeys(toDate);

            EmployerDataStorage.storeData("EffectFrom", fromDate);
            EmployerDataStorage.storeData("EffectTo", toDate);

            System.out.println("✅ Dates Entered: " + fromDate + " → " + toDate);
        } catch (Exception e) {
            handleException("Enter Effect Dates", e);
        }
    }

    @Then("[Additional Details] The user enables {string} and Four Line Printing")
    public void additionalDetailsTheUserEnablesAndFourLinePrinting(String pinMailerOption) throws InterruptedException {
        try {
            if (pinMailerOption.equalsIgnoreCase("Pin Mailer")) {
                WebElement pinCheckbox = MasterAdminAdditionalDetailsPage.get_Pin_Mailer();
                if (!pinCheckbox.isSelected()) {
                    pinCheckbox.click();
                }
                EmployerDataStorage.storeData("PinMailer", "Yes");
            } else {
                EmployerDataStorage.storeData("PinMailer", "No");
            }

            WebElement flpCheckbox = MasterAdminAdditionalDetailsPage.get_Four_Line_Printing();
            if (!flpCheckbox.isSelected()) {
                flpCheckbox.click();
            }

            EmployerDataStorage.storeData("FourLinePrinting", "Yes");

            System.out.println("✅ Checkbox Status: PinMailer=" + pinMailerOption + ", FLP=Yes");
        } catch (Exception e) {
            handleException("Select Pin Mailer and FLP", e);
        }
        Thread.sleep(5000);
    }
}


