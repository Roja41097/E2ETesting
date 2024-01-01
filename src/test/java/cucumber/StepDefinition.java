package cucumber;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import FrameworkPractice.E2ETesting.CheckoutPage;
import FrameworkPractice.E2ETesting.LandingPage;
import FrameworkPractice.E2ETesting.ProductsPage;
import abstractComponent.Browser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends Browser {
	String productName=null;
	LandingPage landingpage;
	CheckoutPage checkout;
	WebDriver driver;
   @Given("Launch the Ecommerce App")   
   public void Launch_the_Ecommerce_App() throws IOException
   {
	   driver = initializeBrowser();
	    landingpage = new LandingPage(driver);  
	    landingpage.Launch();
   }
   @Given("^login with valid (.+) and (.+)$")
   public void login_with_valid_username_and_password(String username, String password) throws IOException {
	   landingpage.Login(username,password);
   }
   @When("Add the product into cart")
   public void Add_the_product_into_cart()
   {
	   ProductsPage addProduct = new ProductsPage(driver);
       productName = addProduct.getProduct(); 
       addProduct.gotoCart();
   }
   @Then("verify the exact product is added into the card")
   public void verify_the_exact_product_is_added_into_the_card()
   {
	   checkout = new CheckoutPage(driver);
       checkout.VerifyTheProduct(productName);
       
   }
   @And("Checkout once product is verified")
   public void Checkout_once_product_is_verified()
   {
	   checkout.Checkout();
	   driver.close();
   }
}
