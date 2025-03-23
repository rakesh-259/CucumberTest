package askomdch.com.hooks;

import askomdch.com.context.TestContext;
import askomdch.com.factory.DriverFactory;
import askomdch.com.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.opentelemetry.api.internal.Utils;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class MyHooks {
    private  WebDriver driver;
    private final TestContext context;
    public MyHooks(TestContext context)
    {
        this.context= context;
    }

    @Before
    public  void before(Scenario scenario) throws MalformedURLException {

//        context.scenarioName= scenario.getName();
//        System.out.println("DI:Scenario Name: "+context.scenarioName);
        driver = DriverFactory.initializeDriver(System.getProperty("browser","chrome"));
        if (driver == null) {
            throw new IllegalStateException("WebDriver initialization failed!");
        }
        context.driver=driver;
    }

    @After
    public void After(Scenario scenario){
        if(scenario.isFailed())
        {
            Allure.attachment("failed scenario",new ByteArrayInputStream(ScreenshotUtil.getCaptureScreenShor(driver)));
        }
        //driver.close();
        if (driver != null) {
            driver.quit();  // Use quit() instead of close()
            driver = null;   // Ensure driver is reset
        }
    }

//    @AfterAll
//    public static void generateAllureReport() {
//        try {
//            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"allure serve allure-results\"");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
