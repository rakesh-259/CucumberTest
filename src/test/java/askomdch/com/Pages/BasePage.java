package askomdch.com.Pages;

import askomdch.com.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public void load(String url)
    {
        driver.get(ConfigLoader.getInstance().getBaseUrl()+url);
    }


}
