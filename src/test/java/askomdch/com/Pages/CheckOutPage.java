package askomdch.com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "billing_first_name") private WebElement firstName;
    @FindBy(id = "billing_last_name") private WebElement lastName;
    @FindBy(id = "billing_country") private WebElement country;
    @FindBy(id ="billing_address_1") private  WebElement StreetAddress;
    @FindBy(id="billing_city") private WebElement city;
    @FindBy( id="billing_state") private  WebElement state;
    @FindBy( id = "billing_postcode") private  WebElement zipCode;
    @FindBy( id="billing_email") private  WebElement email;
    @FindBy( id = "place_order") private  WebElement placeOrder;
    @FindBy( xpath = "//div[@class='woocommerce-order']/p") private WebElement notice;



    public CheckOutPage EnterFirstName(String FName){
        wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys(FName);
        return this;
    }
    public CheckOutPage EnterLastName(String LName){
        wait.until(ExpectedConditions.elementToBeClickable(lastName)).sendKeys(LName);
        return this;
    }
    public CheckOutPage EnterCoutnry(String cuntryName){
        SelectByName(cuntryName,country);
        return this;
    }
    public CheckOutPage EnterStreetAddress(String Eaddress){
        wait.until(ExpectedConditions.elementToBeClickable(StreetAddress)).sendKeys(Eaddress);
        return this;
    }
    public CheckOutPage EnterCity(String Ecity){
        wait.until(ExpectedConditions.elementToBeClickable(city)).sendKeys(Ecity);
        return this;
    }
    public CheckOutPage EnterState(String Estate){
        SelectByName(Estate,state);
        return this;
    }
    public CheckOutPage EnterzipCode(String Ezipcode){
        wait.until(ExpectedConditions.elementToBeClickable(zipCode)).sendKeys(Ezipcode);
        return this;
    }
    public CheckOutPage EnterEmail(String Eemail){
        wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(Eemail);
        return this;
    }
    public CheckOutPage SetBillingDetails(String billingFName,String billingLName,String billingCoutnry,
                                          String billingAdress ,String billingCity,String billingState,
                                          String billingZipCode,String billingEmail)
    {
        return  EnterFirstName(billingFName).
                EnterLastName(billingLName).EnterCoutnry(billingCoutnry).
                EnterStreetAddress(billingAdress).EnterCity(billingCity).EnterState(billingState).
                EnterzipCode(billingZipCode).EnterEmail(billingEmail);
    }

    public CheckOutPage EnterPlaceOrder()
    {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();
        return this;
    }

    public String GetNotice()
    {
        return wait.until(ExpectedConditions.visibilityOf(notice)).getText();
    }




    public static void SelectByName(String name,WebElement Ename)
    {
        Select s= new Select(Ename);
        s.selectByVisibleText(name);
    }



}
