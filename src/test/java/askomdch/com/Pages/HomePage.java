package askomdch.com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//li[@id='menu-item-1227']") private WebElement storeMenubtn;
    @FindBy(xpath = "//a[@class=\"wp-block-button__link\"]") private  WebElement shopNowButton;



    public void ClickStoreBtn()
    {
        wait.until(ExpectedConditions.elementToBeClickable(storeMenubtn)).click();
    }
    public void ClickOnShopNowButton(){
        wait.until(ExpectedConditions.elementToBeClickable(shopNowButton)).click();
        System.out.println("element got clicked");
    }

    public void  ClickOnShopNowButtonBasedOnTitle(String TitleName){
        String dynamicXpath="//h3[normalize-space()='"+TitleName+"']/parent::div//a";
        driver.findElement(By.xpath(dynamicXpath)).click();
        System.out.println(" The Tile with name "+ TitleName+" shop now button got clicked");
    }
}
