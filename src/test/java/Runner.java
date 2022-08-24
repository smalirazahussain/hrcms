
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",            //@Cucumber.Options(features={"login.feature", "smoketest.feature"}) for priority
        monochrome = true,
        glue = {"Step_Definitions","Hooks"},
        plugin = {"pretty", "html:target/Reports/HtmlReport/report.html",
                  "pretty", "json:target/Reports/JSONReport/report.json",
                  "pretty", "junit:target/Reports/XMLReports/report.xml",
                  "json:target/cucumber.json" },
        tags = "@ @SignUp @SignUp001"
)

//Example of logical tags:     tags = "@smoketest or @regression"
//@Signuptest or @Logintest or @CardManagement or @MobileTopUpCase or @PayBillTest or @Sendmoney or @Settingstest or @MyCountryTest


public class Runner  {

}
