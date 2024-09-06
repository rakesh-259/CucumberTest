package askomdch.com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends  BasePage{
    @FindBy(xpath = "//a[@title=\"View cart\"]") private WebElement viewCartLink;
    public StorePage(WebDriver driver) {
        super(driver);

    }
    public void addToCart(String ProductName)
    {
        By productNameBtn1=By.xpath("//a[@aria-label='Add “"+ProductName+"” to your cart']");
        wait.until(ExpectedConditions.elementToBeClickable(productNameBtn1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        //driver.findElement(productNameBtn1).click();
    }
}
