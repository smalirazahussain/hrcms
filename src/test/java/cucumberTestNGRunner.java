//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import org.junit.runner.RunWith;
//import org.testng.annotations.DataProvider;
//
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//
////        features = "src//test//resources",            //@Cucumber.Options(features={"login.feature", "smoketest.feature"}) for priority
////        dryRun = false,
////        monochrome = true,
////        glue = {"Step_Definitions","Step_Definitions_Head_Ofiice","Hooks"},
//////        glue = {"Step_Definitions", "Step_Definitions_Head_Ofiice", "Hooks"},
////        plugin = {"pretty", "html:target/Reports/HtmlReport/reports3.html",
////                  "pretty", "json:target/Reports/JSONReport/reports2.json",
////                  "pretty", "junit:target/Reports/XMLReports/reports3.xml",
////                  "json:target/cucumber.json" }
//        //tags = "@Update"
//        features = "src/test/resources/features",
//        glue =  {"Step_Definitions","Step_Definitions_Head_Ofiice","Hooks"},
//        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json","rerun:target/rerun.txt"},
//
//        tags = "@AddEmployer or @AddEmployer1 or @AddEmployer or @AddEmployer1"
//
//)
//
////Example of logical tags:     tags = "@smoketest or @regression"
////@Signuptest or @Logintest or @CardManagement or @MobileTopUpCase or @PayBillTest or @Sendmoney or @Settingstest or @MyCountryTest
////public class cucumberTestRunner {
////
////}
//public class cucumberTestNGRunner extends AbstractTestNGCucumberTests{
//
////    @Parameters("tags")
////    public void setTags(String tags) {
////        System.setProperty("tags", tags);
////    }
//
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//}
////public class cucumbertestrunner extends AbstractTestNGCucumberTests {
//
////}
////import io.cucumber.junit.Cucumber;
////import io.cucumber.junit.CucumberOptions;
////import org.junit.runner.RunWith;
////
////@RunWith(Cucumber.class)
////@CucumberOptions(
////        features = "src/test/resources/Features",
////        glue = {"Step_Definitions", "Hooks"},
////        plugin = {
////                "pretty",
////                "html:target/Reports/HtmlReport/report.html", // Changed the output directory for the HTML report
////                "json:target/Reports/JSONReport/report.json",
////                "junit:target/Reports/XMLReports/report.xml",
////                "rerun:target/Reports/failed_scenarios.txt"
////        },
////        monochrome = true,
////        tags = "@Branches@Branches1"
////)
////public class Runner {
//
////}
//



//new work

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = //"src/test/resources/features",
                    "employerSignup.feature",
        glue = {"Step_Definitions", "Step_Definitions_Head_Ofiice", "step_Defination_Master_Admin", "Hooks"},
        plugin = {
                "pretty",
                "html:target/Reports/HtmlReport/index.html",
                "json:target/Reports/cucumber.json",
                "junit:target/Reports/XMLReports/reports.xml",
                "rerun:target/Reports/failed_scenarios.txt"
        },
        monochrome = true,
        tags = //"@AddEmployer or @AddEmployer1",
                "@employerSignUp"
)
public class cucumberTestNGRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void cleanOldReports() {
        File reportDir = new File("target/Reports");
        deleteDirectory(reportDir);
    }

    private static void deleteDirectory(File file) {
        if (file.exists()) {
            File[] contents = file.listFiles();
            if (contents != null) {
                for (File f : contents) {
                    deleteDirectory(f);
                }
            }
            file.delete();
        }
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
