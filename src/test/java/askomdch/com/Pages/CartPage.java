package askomdch.com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "td[class='product-name'] a") private WebElement productNameFld;
    @FindBy(xpath = "//input[@type=\"number\"]") private WebElement ProductQuantityNumber;
}
