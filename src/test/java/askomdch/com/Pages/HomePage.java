package askomdch.com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//li[@id='menu-item-1227']") private WebElement storeMenubtn;

    public void ClickStoreBtn()
    {
        wait.until(ExpectedConditions.elementToBeClickable(storeMenubtn)).click();
    }
}
