//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import org.junit.runner.RunWith;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//
//import java.io.File;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = //"src/test/resources/features",  // 🔁 Path to your feature files
//                    "src/test/resources/masterAdminPortal/masterAdminPortal/employerSignup.feature",
//        glue = {
////                "Step_Definitions",
////                "Step_Definitions_Head_Ofiice",
////                "step_Defination_Master_Admin",
////                "Hooks"
//        },
//        plugin = {
//                "pretty",
//                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
//                "html:target/Reports/HtmlReport/index.html",             // ✅ Open this file for built-in HTML report
//                "json:target/cucumber.json",                              // ✅ Required for advanced/custom reports
//                "junit:target/Reports/XMLReports/report.xml",            // Optional JUnit style
//                "rerun:target/Reports/failed_scenarios.txt"              // Scenarios to re-run if failed
//        },
//        monochrome = true,
//        tags = "@employerSignUp1"
//)
//public class cucumberTestNGRunner extends AbstractTestNGCucumberTests {
//
//    @BeforeClass
//    public static void cleanOldReports() {
//        deleteDirectory(new File("target/Reports"));
//    }
//
//    private static void deleteDirectory(File file) {
//        if (file.exists()) {
//            File[] contents = file.listFiles();
//            if (contents != null) {
//                for (File f : contents) {
//                    deleteDirectory(f);
//                }
//            }
//            file.delete();
//        }
//    }
//
//    //@Override
//    //@DataProvider(parallel = true)
//    @Override
//    @DataProvider()
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//}
//
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;

@CucumberOptions(
        features = {"src/test/resources/masterAdminPortal/masterAdminPortal/employerSignup.feature",// ✅ All features
                "src/test/resources/Features"
        },
        glue = {
                "step_Defination_Master_Admin",
                "Step_Definitions",
                "Step_Definitions_Head_Office",
                "common_steps",
                "Hooks"
        },
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",           // ✅ Allure raw results
                "html:target/Reports/HtmlReport/index.html",                 // ✅ Built-in Cucumber report
                "json:target/cucumber.json",
                "junit:target/Reports/XMLReports/report.xml",
                "rerun:target/Reports/failed_scenarios.txt"
        },
        monochrome = true,
        tags = "@debug"  // ✅ Use tag filtering
)
public class cucumberTestNGRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void cleanOldReports() {
        deleteDirectory(new File("target/Reports"));           // 🧹 Built-in report
        deleteDirectory(new File("target/allure-results"));    // 🧹 Allure raw results
        deleteDirectory(new File("allure-report"));            // 🧹 Allure HTML output (if generated before)
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
    @DataProvider(parallel = false) // 🔁 Parallel execution option
    public Object[][] scenarios() {
        return super.scenarios();
    }
}


