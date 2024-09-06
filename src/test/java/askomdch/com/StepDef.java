package askomdch.com;

import askomdch.com.Pages.HomePage;
import askomdch.com.Pages.StorePage;
import askomdch.com.factory.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class StepDef {
    private   WebDriver driver;
    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        // Write code here that turns the phrase above into concrete actions
        driver=DriverFactory.getDriver();
        //driver.get("https://askomdch.com/");
        new StorePage(driver).load("https://askomdch.com/");
    }
    @When("I add a {string} to the cart")
    public void i_add_a_to_the_cart(String product) throws InterruptedException {
        new HomePage(driver).ClickStoreBtn();
//         driver.findElement(By.xpath("//li[@id='menu-item-1227']")).click();
        new StorePage(driver).addToCart(product);
         //By ProductNameBtn= By.xpath("//a[aria-label='Add “"+product+"” to your cart']");
//         By productNameBtn1=By.xpath("//a[@aria-label='Add “"+product+"” to your cart']");
//         Thread.sleep(3000);
//         driver.findElement(productNameBtn1).click();
//        wait.until(ExpectedConditions.elementToBeClickable(productNameBtn1)).click();

         //String actualproductName= driver.findElement(ProductNameFld).getText();
//         By viewCartLink= By.xpath("//a[@title=\"View cart\"]");
//         driver.findElement(viewCartLink).click();
//        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }
    @Then("I should see {int} {string} in the cart")
    public void i_should_see_in_the_cart(Integer quantity, String product) {
            By productNameFld= By.cssSelector("td[class='product-name'] a");
            String actualProductName=driver.findElement(productNameFld).getText();
            By ProductQuantityNumber= By.xpath("//input[@type=\"number\"]");
            String actualQuality= driver.findElement(ProductQuantityNumber).getAttribute("value");
             Assert.assertEquals(product,actualProductName);
             Assert.assertEquals(quantity,Integer.parseInt(actualQuality));
    }

    @Given("I am at dummy code")
    public void i_am_at_dummy_code() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("dummy code");
    }
    @When("i perform dummy things")
    public void i_perform_dummy_things() {
        System.out.println("dummy perform");
    }
    @Then("dummy things happen")
    public void dummy_things_happen() {
       System.out.println("dummy happened");
    }


}

