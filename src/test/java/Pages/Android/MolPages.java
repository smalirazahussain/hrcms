package Pages.Android;

import Hooks.Base_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MolPages {

    public static String Edit_Personal_Details = "button[title='Edit Personal Details']";
    public static String Mol_EST_Id_Button = "button[title='Edit Mol/Est Id']";
    public static String Phone_Number_Button = "button[title='Edit Phone Number']";
    public static String Phone_No = "phone";
    public static WebElement get_Edit_Personal_Details() {
        return Base_Class.driver.findElement(By.cssSelector(Edit_Personal_Details));
    }

    public static WebElement get_Mol_EST_Id_Button() {

        return Base_Class.driver.findElement(By.cssSelector(Mol_EST_Id_Button));
    }

    public static WebElement get_Phone_Number_Button() {
        return Base_Class.driver.findElement(By.cssSelector(Phone_Number_Button));
    }

    public static WebElement get_Phone_No() {

        return Base_Class.driver.findElement(By.id(Phone_No));
    }
}




