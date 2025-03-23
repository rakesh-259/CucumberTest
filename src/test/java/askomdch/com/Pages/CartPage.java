package askomdch.com.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "td[class='product-name'] a") private WebElement productNameFld;
    @FindBy(xpath = "//input[@type=\"number\"]") private WebElement ProductQuantityNumber;
    @FindBy(xpath ="//a[normalize-space()='Proceed to checkout']") private WebElement checkOutBtn;
    @FindBy(xpath = "//a[@class=\"remove\"]") private List<WebElement> xButtonsOfAllIteamCarts;
    public String getProductFld()
    {
        return wait.until(ExpectedConditions.visibilityOf(productNameFld)).getText();
    }
    public  int getProductQualityNum()
    {
        return  Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(ProductQuantityNumber))
                .getAttribute("value"));
    }
    public void ClickCheckOutBtn()
    {
        wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn)).click();
    }

    public int ClickonXButton() throws InterruptedException
    {
        Thread.sleep(2000);
        int itemCount= xButtonsOfAllIteamCarts.size();
//        int start=0;
//        while(start<itemCount)
//        {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            itemCount= xButtonsOfAllIteamCarts.size();
//            System.out.println(xButtonsOfAllIteamCarts.get(start++)+" index is going to delete");
//            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(xButtonsOfAllIteamCarts.get(start++)));
//            //System.out.println("Item number+" xButtonsOfAllIteamCarts.get(start++)"+ going to delete");
//            element.click();
//            Thread.sleep(4000);
//             itemCount= xButtonsOfAllIteamCarts.size();
////            xButtonsOfAllIteamCarts.get(start++).click();
//
//        }
//        return xButtonsOfAllIteamCarts.size();
        for (int i = 0; i < itemCount; i++) {
            try {
                xButtonsOfAllIteamCarts = driver.findElements(By.xpath("//a[@class='remove']"));
                if (!xButtonsOfAllIteamCarts.isEmpty()) {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", xButtonsOfAllIteamCarts.get(0));
                    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(xButtonsOfAllIteamCarts.get(0))); // Always clicking the first available
                    element.click();

                    System.out.println("Removed item " + (i + 1) + " of " + itemCount);
                    Thread.sleep(2000);
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element encountered. Re-fetching elements...");
                i--; // Retry the same index in the next iteration
            }
        }
        xButtonsOfAllIteamCarts = driver.findElements(By.xpath("//a[@class='remove']"));
        return xButtonsOfAllIteamCarts.size();
    }

}
