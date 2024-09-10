package askomdch.com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {"html:target/cucumber/cucumber.html"},
        //plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        glue = {"askomdch.com"},
        features = "src/test/resources/Features/addToCart1.feature"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}
