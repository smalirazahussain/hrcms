import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "D://Hrcms//src//test//resources",            //@Cucumber.Options(features={"login.feature", "smoketest.feature"}) for priority
        dryRun = false,
        monochrome = true,
        glue = {"Step_Definitions","Step_Definitions_Head_Ofiice","Hooks"},
        plugin = {"pretty", "html:target/Reports/HtmlReport/reports1.html",
                  "pretty", "json:target/Reports/JSONReport/reports2.json",
                  "pretty", "junit:target/Reports/XMLReports/reports3.xml",
                  "json:target/cucumber.json" },
        tags = "@SomkeTest31"
)

//Example of logical tags:     tags = "@smoketest or @regression"
//@Signuptest or @Logintest or @CardManagement or @MobileTopUpCase or @PayBillTest or @Sendmoney or @Settingstest or @MyCountryTest
//public class cucumberTestRunner {
//
//}

public class cucumberTestRunner extends AbstractTestNGCucumberTests {

}
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/resources/Features",
//        glue = {"Step_Definitions", "Hooks"},
//        plugin = {
//                "pretty",
//                "html:target/Reports/HtmlReport/report.html", // Changed the output directory for the HTML report
//                "json:target/Reports/JSONReport/report.json",
//                "junit:target/Reports/XMLReports/report.xml",
//                "rerun:target/Reports/failed_scenarios.txt"
//        },
//        monochrome = true,
//        tags = "@Branches@Branches1"
//)
//public class Runner {
//
//}

