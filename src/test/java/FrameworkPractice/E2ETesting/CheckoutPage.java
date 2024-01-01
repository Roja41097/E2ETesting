package FrameworkPractice.E2ETesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponent.ReusableCode;

public class CheckoutPage extends ReusableCode {
	WebDriver driver;
	@FindBy(xpath = "//div[@class = 'cartSection']/child::h3")
	List <WebElement> Checkoutproduct;
	@FindBy(css = ".totalRow button")
	WebElement CheckoutBtn;
	By checkoutProd = By.xpath("//div[@class = 'cartSection']/child::h3");
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void VerifyTheProduct(String productName) {
		ReusableCode.ByWait(driver,checkoutProd );
		Boolean verification = Checkoutproduct.stream().anyMatch(prod ->prod.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(verification);
		
	}
    public void Checkout() {
       
    	CheckoutBtn.click();	
    }
}
