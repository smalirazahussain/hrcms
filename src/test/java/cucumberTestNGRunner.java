import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // 🔁 Path to your feature files
        glue = {
                "Step_Definitions",
                "Step_Definitions_Head_Ofiice",
                "step_Defination_Master_Admin",
                "Hooks"
        },
        plugin = {
                "pretty",
                "html:target/Reports/HtmlReport/index.html",             // ✅ Open this file for built-in HTML report
                "json:target/cucumber.json",                              // ✅ Required for advanced/custom reports
                "junit:target/Reports/XMLReports/report.xml",            // Optional JUnit style
                "rerun:target/Reports/failed_scenarios.txt"              // Scenarios to re-run if failed
        },
        monochrome = true,
        tags = "@employerSignUp"
)
public class cucumberTestNGRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void cleanOldReports() {
        deleteDirectory(new File("target/Reports"));
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
