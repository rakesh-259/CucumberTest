package askomdch.com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverActionUtils {
    private static HoverActionUtils instance;
    private Actions actions;

    private HoverActionUtils(WebDriver driver) {
        actions= new Actions(driver);
    }

    // Constructor to initialize WebDriver and Actions class
    public static HoverActionUtils getInstance(WebDriver driver)
    {
        instance= new HoverActionUtils(driver);
        return  instance;
    }
    // Method to perform hover action
    public void hoverOverElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    // Method to hover and click on a submenu
    public void hoverAndClick(WebElement mainElement, WebElement subElement) throws InterruptedException {
        //((JavascriptExecutor)instance ).executeScript("arguments[0].scrollIntoView({block: 'center'});", mainElement);
        Thread.sleep(500); // Small delay to ensure visibility
        actions.moveToElement(mainElement).perform();
        Thread.sleep(5000);
        //((JavascriptExecutor) actions).executeScript("arguments[0].scrollIntoView(true);", subElement);
        actions.moveToElement(subElement).click().perform();
    }
}
