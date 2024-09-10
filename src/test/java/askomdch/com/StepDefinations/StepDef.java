package askomdch.com.StepDefinations;

import askomdch.com.Pages.CartPage;
import askomdch.com.Pages.CheckOutPage;
import askomdch.com.Pages.HomePage;
import askomdch.com.Pages.StorePage;
import askomdch.com.constants.EndPoint;
import askomdch.com.context.TestContext;
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

import java.awt.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;

public class StepDef {
    private final  WebDriver driver;
    private BillingDetails billingDetails;
    private  TestContext context;

    public StepDef(TestContext context)
    {
        //System.out.println("step def D1 : scenario name: "+context.scenarioName);
        driver= context.driver;
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
}







