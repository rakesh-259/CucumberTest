package askomdch.com.StepDefinations;

import askomdch.com.Pages.CartPage;
import askomdch.com.Pages.PageFactoryManager;
import askomdch.com.Pages.StorePage;
import askomdch.com.constants.EndPoint;
import askomdch.com.context.TestContext;
import askomdch.com.workobject.BillingDetails;
import askomdch.com.workobject.Product;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

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


    @When("Navigate to store Page and sort the product by {string}")
    public void navigateToStorePageAndSortTheProductBy(String arg0) throws InterruptedException {
        System.out.println(arg0);
         storePage.select_sortBy(arg0);
    }

    @And("Filter by scroll from {string} to {string}")
    public void filterByScrollFromTo(String arg0, String arg1) {
        storePage.ScrollByFilter(arg1);
    }

    @And("Click on Filter")
    public void clickOnFilter() {
        storePage.clickFilterBtn();
    }

    @Then("Verify the filtered data prize is with in the {string}")
    public void verifyTheFilteredDataPrizeIsWithInThe(String arg0) {
        storePage.GetCartprize(arg0);
    }

    // Helper method to parse price text (e.g., "$25" -> 25.0)
    private double parsePrice(String priceText) {
        priceText = priceText.replace("$", "").trim(); // Remove currency symbol
        return Double.parseDouble(priceText); // Convert to numeric value
    }

}
