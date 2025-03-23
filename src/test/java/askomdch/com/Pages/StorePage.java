package askomdch.com.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;
import java.util.List;

public class StorePage extends  BasePage{
    @FindBy(xpath = "//a[@title=\"View cart\"]") private WebElement viewCartLink;
    @FindBy(xpath ="//div[@class=\"ast-woocommerce-container\"]//span[@class=\"woocommerce-Price-amount amount\" and not(parent::del)]")  List<WebElement> ListCartPrize;
//    @FindBy(xpath ="//select[@name='orderby']") private  WebElement  sortByElement;
   // WebElement sortByElement= driver.findElement(By.xpath("//select[@name='orderby']"));
    public StorePage(WebDriver driver) {
        super(driver);

    }
    public void addToCart(String ProductName)
    {
        By productNameBtn1=By.xpath("//a[@aria-label='Add “"+ProductName+"” to your cart']");
        wait.until(ExpectedConditions.elementToBeClickable(productNameBtn1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        //driver.findElement(productNameBtn1).click();
        //driver.findElement(productNameBtn1).click();
    }

    public void ScrollByFilter(String p02)
    {
        WebElement minSlider = driver.findElement(By.xpath("//div[@class=\"price_slider_wrapper\"]//span[1]"));
        WebElement maxSlider = driver.findElement(By.xpath("//div[@class=\"price_slider_wrapper\"]//span[2]"));

        Actions actions = new Actions(driver);
           actions.dragAndDropBy(maxSlider,-200,0).perform();

    }
    public void clickFilterBtn()
    {
        WebElement clickFilterBtn= driver.findElement(By.xpath("//button[normalize-space()='Filter']"));
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",clickFilterBtn);
    }
    public void verifyFilteredPricesWithinLimit(WebDriver driver, double maxPrice) {
        // Locate the elements displaying product prices
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='price']"));
        // Parse and validate each price
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText(); // Example: "$25" or "25 USD"
            double price = parsePrice(priceText);

            if (price > maxPrice) {
                throw new AssertionError("Price exceeds the limit: " + price);
            }
        }
        System.out.println("All prices are within the limit of $" + maxPrice);
    }

    // Helper method to parse price text (e.g., "$25" -> 25.0)
    private double parsePrice(String priceText) {
        priceText = priceText.replace("$", "").trim(); // Remove currency symbol
        return Double.parseDouble(priceText); // Convert to numeric value
    }
    //div[@class="ast-woocommerce-container"]//span[@class="woocommerce-Price-amount amount" and not(parent::del)]

    public void select_sortBy(String selectedOne) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement orderBy = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='orderby']")));
            Select dropdownBySort = new Select(orderBy);
            dropdownBySort.selectByVisibleText(selectedOne); // Select by visible text
        } catch (NoSuchElementException e) {
            System.out.println("Dropdown not found: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void GetCartprize(String prize)
    {
          double prizeActual= parsePrice(prize);
          int expectedPrize= (int)prizeActual;
          for(WebElement e: ListCartPrize)
          {
              int actualPrize= (int)parsePrice(e.getText());
              if(actualPrize<expectedPrize)
              {
                  System.out.println(" The prize of  product's -> "+ actualPrize);
              }
          }
          
    }

}
