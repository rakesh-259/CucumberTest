package askomdch.com.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    public static WebDriver initializeDriver(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        //capabilities.setBrowserName("chrome");
        capabilities.setBrowserName("MicrosoftEdge");
        //WebDriver driver= new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
        WebDriver driver;
        switch (browser) {
            case "chrome" : {
                driver = new ChromeDriver();
                //driver = new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
                break;
            }
            case "edge" : {
                //driver = new EdgeDriver();
                driver = new RemoteWebDriver(new URL("http://localhost:4444"),capabilities);
                driver.manage().window().maximize();
                break;
            }
            case "remote":{

            }
            default : throw new IllegalStateException("INVALID BROWSER: " + browser);
        }
        driver.manage().window().maximize();
        return  driver;
    }
//    public static  WebDriver getDriver()
//    {
//        return driver;
//    }
}
