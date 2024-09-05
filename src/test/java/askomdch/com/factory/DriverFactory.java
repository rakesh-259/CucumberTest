package askomdch.com.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    public static  WebDriver driver;
    public static WebDriver initializeDriver(String browser){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        //WebDriver driver;
//        switch (browser) {
//            case "chrome" : {
//                //WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//            }
//            case "firefox" : {
//                //WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//            }
//            default : throw new IllegalStateException("INVALID BROWSER: " + browser);
//        }
        return  driver;
    }
    public static  WebDriver getDriver()
    {
        return driver;
    }
}
