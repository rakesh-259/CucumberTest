package askomdch.com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //plugin = {"html:target/cucumber/cucumber.html"},
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","rerun:target/failed_scenarios.txt"},
        glue = {"askomdch.com"},
        features = "@target/failed_scenarios.txt"

)
public class RerunFailedTests extends AbstractTestNGCucumberTests {

}
