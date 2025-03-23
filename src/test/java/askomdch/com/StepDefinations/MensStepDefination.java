package askomdch.com.StepDefinations;

import askomdch.com.Pages.MensPage;
import askomdch.com.Pages.PageFactoryManager;
import askomdch.com.Pages.StorePage;
import askomdch.com.context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class MensStepDefination {

    private MensPage menspage;
    private TestContext context;


    public MensStepDefination(TestContext context){
        menspage = PageFactoryManager.getMenspage(context.driver);
    }


    @Step("check out all the product in that page")
    @When("check out all the product in that page")
    public void check_out_all_the_product_in_that_page() {
        // Write code here that turns the phrase above into concrete actions
        menspage.ClickOnAddToCartButton();
    }

    @Step("Place the mouse to view to shopping card and click on the view to card")
    @And("Place the mouse to view to shopping card and click on the view to card")
    public void placeTheMouseToViewToShoppingCardAndClickOnTheViewToCard() throws InterruptedException {
           menspage.MoveToViewShopOverandClickshopcart();
    }


}
