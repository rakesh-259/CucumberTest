package askomdch.com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"html:target/cucumber/cucumber.html"},
        glue = {"askomdch.com"},
        features = "src/test/resources/Features/addToCart1.feature"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

}
