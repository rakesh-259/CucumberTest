package askomdch.com.StepDefinations;

import askomdch.com.Pages.CartPage;
import askomdch.com.Pages.PageFactoryManager;
import askomdch.com.context.TestContext;
import askomdch.com.workobject.BillingDetails;
import askomdch.com.workobject.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartStepDefination {
    private BillingDetails billingDetails;
    private TestContext context;
    private CartPage cartPage;

    public CartStepDefination(TestContext context){
        cartPage= PageFactoryManager.getCartPage(context.driver);
    }
    @Given("I'm check out page")
    public void i_m_check_out_page() {

        cartPage.ClickCheckOutBtn();
    }
    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(Integer quantity, Product product) {

        Assert.assertEquals(product.getName(),cartPage.getProductFld());
        Assert.assertEquals(quantity,cartPage.getProductQualityNum());
    }
    @Step("Verify the Item should be zero after removing all the Items")
    @Then("Verify the Item should be zero after removing all the Items")
    public void verifyTheItemShouldBeZeroAfterRemovingAllTheItems() throws InterruptedException {

        Assert.assertEquals(cartPage.ClickonXButton(),0,"Item are got deleted presently no item are there at cart");
//        if(cartPage.ClickonXButton()==1)
//        {
//            System.out.println(" Item are got deleted presently no item are there at cart");
//        }

    }
}
