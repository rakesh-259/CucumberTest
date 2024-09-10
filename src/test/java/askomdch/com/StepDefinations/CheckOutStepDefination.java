package askomdch.com.StepDefinations;

import askomdch.com.Pages.CheckOutPage;
import askomdch.com.Pages.PageFactoryManager;
import askomdch.com.context.TestContext;
import askomdch.com.workobject.BillingDetails;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckOutStepDefination {
    private BillingDetails billingDetails;
    private TestContext context;
    private CheckOutPage checkOutPage;

    public CheckOutStepDefination(TestContext context){
        checkOutPage= PageFactoryManager.getCheckOutPage(context.driver);
    }

    @When("I place an order")
    public void i_place_an_order() {
        checkOutPage.EnterPlaceOrder();

    }
    @Then("the Order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        Assert.assertEquals("Thank you. Your order has been received.",
                checkOutPage.GetNotice());

    }
}
