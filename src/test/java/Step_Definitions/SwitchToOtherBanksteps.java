package Step_Definitions;

import Pages.Android.SwitchToOtherBankPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

import static Hooks.Base_Class.wait;
import static Pages.Android.SwitchToOtherBankPages.Bank_Name;

public class SwitchToOtherBanksteps {

    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(30);
    //public WebDriverWait wait = new WebDriverWait(driver, timeout);
    //create a soft-assertion object
    SoftAssert softAssert = new SoftAssert();


    @And("[Switch To Other Bank] User tap on the Switch to other bank button")
    public void switchToOtherBankUserTapOnTheSwitchToOtherBankButton() {
        SwitchToOtherBankPages.get_Switch_To_Other_Bank().click();
    }
    public static String randomBankName;
    @When("[Switch To Other Bank] User select the bank {string}")
    public void switchToOtherBankUserSelectTheBank(String bank) throws InterruptedException {

        String[] bankNames = {
                "Abu Dhabi Commercial Bank",
                "Abu Dhabi Islamic Bank",
                "Ajman Bank",
                "Al Hilal Bank",
                "Al Maryah Community Bank",
                "Al Masraf Arab Bank for Investment & Foreign Trade",
                "Bank of Sharjah",
                "Commercial Bank International",
                "Commercial Bank of Dubai",
                "Dubai Bank",
                "Dubai Finance Bank",
                "Dubai Islamic Bank",
                "Emirates Investment Bank",
                "Emirates Islamic",
                "Emirates NBD",
                "First Abu Dhabi Bank",
                "Invest Bank",
                "Mashreq",
                "National Bank of Fujairah",
                "National Bank of Ras Al-Khaimah PJSC (RAKBANK)",
                "National Bank of Umm Al-Quwain",
                "Noor Bank",
                "Sharjah Islamic Bank",
                "United Arab Bank",
                "United Bank Ltd.",
                "Standard Chartered Bank",
                "Saudi National Bank",
                "Rafidain Bank",
                "NatWest Markets Plc",
                "National Bank of Oman",
                "National Bank of Kuwait",
                "National Bank of Bahrain",
                "MCB Bank Limited",
                "KEB Hana Bank",
                "Janata Bank Limited",
                "Intesa Sanpaolo S.P.A",
                "Industrial & Commercial Bank of China",
                "HSBC Bank Middle East Limited",
                "Habib Bank Ltd.",
                "Habib Bank A.G Zurich",
                "Gulf International Bank",
                "El Nilein Bank",
                "Doha Bank",
                "Deutsche Bank AG",
                "Credit Agricloe",
                "CitiBank N. A.",
                "BOK International Bank",
                "BNP Paribas",
                "Barclays Bank PLC",
                "Banque Misr",
                "Banque Banorient France",
                "Bank Saderat Iran",
                "Bank of China Limited",
                "Bank of Baroda",
                "Bank Melli Iran",
                "Bank Al Falah Limited",
                "Arab Bank",
                "Arab African International Bank",
                "Al Khaliji",
                "Al Ahli Bank of Kuwait",
                "Agricultural Bank of China Ltd."};
        System.out.println(Arrays.toString(bankNames));

        //for(String bankName :bankNames){
        Random random = new Random();
        int randomIndex = random.nextInt(bankNames.length);
        randomBankName = bankNames[randomIndex];
//            Random randomBank = new Random(bankName.indexOf(Arrays.toString(bankNames)));
//            System.out.println(randomBank);
//            //if (bankName.indexOf(String.valueOf(bankNames)));
//            System.out.println("Selected bank:" + bankName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Bank_Name)));
            //Random randomBank = new Random();
            //SwitchToOtherBankPages.get_Bank_Name().click();
        SwitchToOtherBankPages.get_Bank_Name().sendKeys(randomBankName+ Keys.ENTER);

        //SwitchToOtherBankPages.get_Switch_Bank(randomBankName).click();
        System.out.println("bankName" + randomBankName);


           // AddEmployerPages.get_Select_Bank(randomBankName).click();
    }

    @And("[Switch To Other Bank] User tap on the change bank")
    public void switchToOtherBankUserTapOnTheChangeBank() {
        SwitchToOtherBankPages.get_Change_Banks().click();
    }
}



