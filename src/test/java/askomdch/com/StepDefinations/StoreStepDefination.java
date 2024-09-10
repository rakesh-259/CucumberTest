package askomdch.com.StepDefinations;

import askomdch.com.Pages.CartPage;
import askomdch.com.Pages.PageFactoryManager;
import askomdch.com.Pages.StorePage;
import askomdch.com.constants.EndPoint;
import askomdch.com.context.TestContext;
import askomdch.com.workobject.BillingDetails;
import askomdch.com.workobject.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StoreStepDefination {
    private BillingDetails billingDetails;
    private TestContext context;
    private StorePage storePage;

    public StoreStepDefination(TestContext context){
         storePage= PageFactoryManager.getStorePage(context.driver);
    }
    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        storePage.load(EndPoint.STORE.url);
    }
    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) throws InterruptedException {
        storePage.addToCart(product.getName());
    }


    @Given("I am application User")
    public void i_am_application_user() {
      storePage.load(EndPoint.STORE.url);

    }
    @Given("I have the product in cart")
    public void i_have_the_product_in_cart() {
        storePage.addToCart("Blue Tshirt");
    }
}
