package askomdch.com.StepDefinations;

import askomdch.com.Pages.HomePage;
import askomdch.com.Pages.PageFactoryManager;
import askomdch.com.Pages.StorePage;
import askomdch.com.constants.EndPoint;
import askomdch.com.context.TestContext;
import askomdch.com.workobject.BillingDetails;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.qameta.allure.Step;

public class HomeStepDefination {
    private HomePage homePage;

    public HomeStepDefination(TestContext context){
        homePage= PageFactoryManager.getHomepage(context.driver);
    }

    @Step("I am Home Page of askomdch")
    @Given("I am Home Page of askomdch")
    public void iAmHomePageOfAskomdch() {
        homePage.load(EndPoint.HOME.url);
    }

    @And("click on {string} button")
    public void clickOnButton(String arg0) {
        if(arg0.equals("SHOP NOW"))
        {
            System.out.println(arg0);
            homePage.ClickOnShopNowButton();
        }
    }
    @Step("Click on the SHOP NOW button based on the title {0}")
    @And("Click on the SHOP NOW button based on the title {string}")
    public void clickOnTheSHOPNOWButtonBasedOnTheTitle(String arg0) {
        homePage.ClickOnShopNowButtonBasedOnTitle(arg0);

    }
}
