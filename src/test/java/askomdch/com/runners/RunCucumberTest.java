package askomdch.com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        //plugin = {"html:target/cucumber/cucumber.html"},
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","rerun:target/failed_scenarios.txt"},
        dryRun = false,
        glue = {"askomdch.com"},
        features = "src/test/resources/Features/addToCart1.feature",
        tags=""
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}
