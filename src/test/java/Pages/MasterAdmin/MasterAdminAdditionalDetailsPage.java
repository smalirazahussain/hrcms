package Pages.MasterAdmin;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MasterAdminAdditionalDetailsPage {
    public static String Additional_DetailsTab = "#rc-tabs-11-tab-2";
    public static String Add_Edit_Onboarding_Source_button = "button[title='Add/Edit Onboarding Source']";
    public static WebElement get_Additional_DetailsTab() {
        return Base_Class.driver.findElement(By.cssSelector(Additional_DetailsTab));
    }

    public static WebElement get_Add_Edit_Onboarding_Source_button() {
        return Base_Class.driver.findElement(By.cssSelector(Add_Edit_Onboarding_Source_button));
    }
}
