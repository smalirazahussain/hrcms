package Pages.MasterAdmin;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MasterAdminAdditionalDetailsPage {
    public static String Additional_DetailsTab = "div[class='ant-tabs-tab']";
    public static String Add_Edit_Onboarding_Source_button = "button[title='Add/Edit Onboarding Source']";
    public static String Onboarding_Source_Dropdown = "input[id=kamelpayOnboardingSourceCode]";
    public static String Add_Onboarding_Source(String source) {
        return "//div[contains(text(),'" + source + "')]";
    }
    public static String Add_Product_Button="button[title='Add Product'] span";
    public static String Product_Type_Dropdown = "button[title='Add Product'] span";
    public static String Select_Product_Type(String productType) {
        return "//div[contains(text(),'"+productType+"')]";
    }
    public static String Effect_From = "#from";
    public static String Effect_To = "#to";
    public static String Pin_Mailer="";
    public static String Four_Line_Printing="";

    public static WebElement get_Additional_DetailsTab() {
        return Base_Class.driver.findElement(By.cssSelector(Additional_DetailsTab));
    }

    public static WebElement get_Add_Edit_Onboarding_Source_button() {
        return Base_Class.driver.findElement(By.cssSelector(Add_Edit_Onboarding_Source_button));
    }

    public static WebElement get_Onboarding_Source_Dropdown() {
        return Base_Class.driver.findElement(By.cssSelector(Onboarding_Source_Dropdown));
    }

    public static WebElement get_Add_Onboarding_Source(String source) {
        return Base_Class.driver.findElement(By.xpath(Add_Onboarding_Source(source)));
    }


    public static WebElement get_Add_Product_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Add_Product_Button));
    }

    public static WebElement get_Product_Type_Dropdown() {
        return Base_Class.driver.findElement(By.cssSelector(Product_Type_Dropdown));
    }
    public static WebElement get_Select_Product_Type(String productType){
        return Base_Class.driver.findElement(By.xpath(Select_Product_Type(productType)));
    }


    public static WebElement get_Effect_From() {
        return Base_Class.driver.findElement(By.cssSelector(Effect_From));
    }

    public static WebElement get_Effect_To() {
        return Base_Class.driver.findElement(By.cssSelector(Effect_To));
    }

    public static WebElement get_Pin_Mailer() {

        return Base_Class.driver.findElement(By.cssSelector(Pin_Mailer));
    }

    public static WebElement get_Four_Line_Printing() {
        return Base_Class.driver.findElement(By.cssSelector(Four_Line_Printing));
    }
}
