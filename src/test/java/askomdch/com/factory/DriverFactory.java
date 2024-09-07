package askomdch.com.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    private static  WebDriver driver;
    public static WebDriver initializeDriver(String browser){
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        //WebDriver driver;
        switch (browser) {
            case "chrome" : {
                //WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            }
            case "firefox" : {
                //WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            }
            default : throw new IllegalStateException("INVALID BROWSER: " + browser);
        }
        return  driver;
    }
    public static  WebDriver getDriver()
    {
        return driver;
    }
}
