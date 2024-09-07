package askomdch.com;

import askomdch.com.Pages.CartPage;
import askomdch.com.Pages.CheckOutPage;
import askomdch.com.Pages.HomePage;
import askomdch.com.Pages.StorePage;
import askomdch.com.constants.EndPoint;
import askomdch.com.factory.DriverFactory;
import askomdch.com.workobject.BillingDetails;
import askomdch.com.workobject.Product;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;

public class StepDef {
    private   WebDriver driver;
    private BillingDetails billingDetails;
    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        // Write code here that turns the phrase above into concrete actions
        driver=DriverFactory.getDriver();
        //driver.get("https://askomdch.com/");
        new StorePage(driver).load(EndPoint.STORE.url);
    }
    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) throws InterruptedException {
        //new HomePage(driver).ClickStoreBtn();
        new StorePage(driver).addToCart(product.getName());
    }
    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(Integer quantity, Product product) {
             CartPage cartPage= new CartPage(driver);
             Assert.assertEquals(product.getName(),cartPage.getProductFld());
             Assert.assertEquals(quantity,cartPage.getProductQualityNum());
    }

    @Given("I am application User")
    public void i_am_application_user() {
        driver=DriverFactory.getDriver();
        new StorePage(driver).load(EndPoint.STORE.url);

    }
    @Given("I have the product in cart")
    public void i_have_the_product_in_cart() {
        //new HomePage(driver).ClickStoreBtn();
        new StorePage(driver).addToCart("Blue Tshirt");


    }
    @Given("I'm check out page")
    public void i_m_check_out_page() {

        new CartPage(driver).ClickCheckOutBtn();
    }
    @When("I'm providing Billing Details")
    public void i_m_providing_billing_detials(DataTable dataTable) {
        List<List<String>> rows=dataTable.asLists(String.class);
        String billingFirstName="";
        String billingLastName="";
        String billingCountry="";
        String billingStreet_address="";
        String billingCity="";
        String billingState="";
        String billingZip_Code="";
        String billingEmail_address="";
        for(List<String> Coloumns: rows)
        {
            if(Coloumns.get(0).equalsIgnoreCase("firstname")) billingFirstName=Coloumns.get(1);
            else if(Coloumns.get(0).equalsIgnoreCase("lastname")) billingLastName=Coloumns.get(1);
            else if (Coloumns.get(0).equalsIgnoreCase("country")) billingCountry=Coloumns.get(1);
            else if (Coloumns.get(0).equalsIgnoreCase("street_address")) billingStreet_address=Coloumns.get(1);
            else if (Coloumns.get(0).equalsIgnoreCase("city")) billingCity=Coloumns.get(1);
            else if (Coloumns.get(0).equalsIgnoreCase("state")) billingState=Coloumns.get(1);
            else if (Coloumns.get(0).equalsIgnoreCase("zip_code")) billingZip_Code=Coloumns.get(1);
            else if (Coloumns.get(0).equalsIgnoreCase("email_address")) billingEmail_address=Coloumns.get(1);
        }
        CheckOutPage checkOutPage=new CheckOutPage(driver);
        checkOutPage.SetBillingDetails(billingFirstName,billingLastName,billingCountry,billingStreet_address,billingCity,
                billingState,billingZip_Code,billingEmail_address);




    }

    @When("I place an order")
    public void i_place_an_order() {
        new CheckOutPage(driver).EnterPlaceOrder();

    }
    @Then("the Order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        Assert.assertEquals("Thank you. Your order has been received.",
                new CheckOutPage(driver).GetNotice());

    }


}







