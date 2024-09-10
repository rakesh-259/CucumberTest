package askomdch.com.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver initializeDriver(String browser){

        WebDriver driver;
        switch (browser) {
            case "chrome" : {
                driver = new ChromeDriver();
                break;
            }
            case "firefox" : {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
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
