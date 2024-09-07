package askomdch.com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.xml.xpath.XPath;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "td[class='product-name'] a") private WebElement productNameFld;
    @FindBy(xpath = "//input[@type=\"number\"]") private WebElement ProductQuantityNumber;
    @FindBy(xpath ="//a[normalize-space()='Proceed to checkout']") private WebElement checkOutBtn;
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
}
