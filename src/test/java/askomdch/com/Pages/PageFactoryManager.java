package askomdch.com.Pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private static  StorePage  storePage;
    private static  CartPage  cartPage;
    private static  CheckOutPage  checkOutPage;
    private static  HomePage homepage;
    private static  MensPage menspage;
    public static MensPage getMenspage(WebDriver driver)
    {
        return menspage==null ? new MensPage(driver): menspage;
    }
    public  static HomePage getHomepage(WebDriver driver)
    {
        return homepage==null ? new HomePage(driver): homepage;
    }

    public  static  StorePage getStorePage(WebDriver driver)
    {
        return storePage==null ? new StorePage(driver): storePage;
    }
    public  static  CartPage getCartPage(WebDriver driver)
    {
        return cartPage==null ? new CartPage(driver): cartPage;
    }

    public  static  CheckOutPage getCheckOutPage(WebDriver driver)
    {
        return checkOutPage==null ? new CheckOutPage(driver): checkOutPage;
    }
}
