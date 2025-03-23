package askomdch.com.Pages;

import askomdch.com.utils.HoverActionUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;
import java.util.List;

public class MensPage extends BasePage {

    public MensPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[text()='Add to cart']")   List<WebElement> allAddToCartButtons;
    @FindBy(xpath = "(//a[@title=\"View your shopping cart\"]//span)[1]") WebElement viewYourShopToCart;
    @FindBy(xpath = "(//a[@class=\"button wc-forward\" and text()=\"View cart\"])[1]") WebElement viewCartFromHeaderView;

    public  void ClickOnAddToCartButton()
    {
        for(WebElement addToCart: allAddToCartButtons)
        {
            addToCart.click();
        }
    }
    HoverActionUtils hoveractions=  HoverActionUtils.getInstance(driver);

    public void MoveToTheHoverViewShopOverElement()
    {

        hoveractions.hoverOverElement(viewYourShopToCart);
    }
    public void  MoveToViewShopOverandClickshopcart() throws InterruptedException {
        hoveractions.hoverAndClick(viewYourShopToCart,viewCartFromHeaderView);
    }



}
