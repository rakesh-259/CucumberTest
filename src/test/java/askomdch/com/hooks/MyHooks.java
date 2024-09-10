package askomdch.com.hooks;

import askomdch.com.context.TestContext;
import askomdch.com.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class MyHooks {
    private  WebDriver driver;
    private final TestContext context;
    public MyHooks(TestContext context)
    {
        this.context= context;
    }

    @Before
    public  void before(Scenario scenario){

//        context.scenarioName= scenario.getName();
//        System.out.println("DI:Scenario Name: "+context.scenarioName);
        driver = DriverFactory.initializeDriver(System.getProperty("browser","chrome"));
        context.driver=driver;
    }

    @After
    public void After(Scenario scenario){
        driver.quit();
    }
}
