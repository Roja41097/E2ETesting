package main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import FrameworkPractice.E2ETesting.CheckoutPage;
import FrameworkPractice.E2ETesting.LandingPage;
import FrameworkPractice.E2ETesting.ProductsPage;
import abstractComponent.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EcommerceApp extends Browser{
	

	@Test
   public void EcommerceWebApp() throws IOException {
		WebDriver driver = initializeBrowser();
	    LandingPage landingpage = new LandingPage(driver); 
	    landingpage.Login("roja.reddy@gmail.com","Hydrogen@01");
		ProductsPage addProduct = new ProductsPage(driver);
        String productName = addProduct.getProduct(); 
        addProduct.gotoCart();
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.VerifyTheProduct(productName);
        checkout.Checkout();
        //adding comment
    	
    }
}
