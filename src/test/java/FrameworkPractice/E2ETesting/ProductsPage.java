package FrameworkPractice.E2ETesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractComponent.ReusableCode;

public class ProductsPage extends ReusableCode {
	WebDriver driver;
	@FindBy(css=".card-body")
	List<WebElement> ProductList;
	
	@FindBy(css="[routerlink*=cart]")
	WebElement CartRedirectButton;
	
	@FindBy(css=".ng-animating")
	WebElement ProductAddedPopup;
	By AddProductPage = By.cssSelector(".card-body");
	By AddtoCartBtn = By.cssSelector("button:last-of-type");
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProduct() {
		String productName = null;
		
		super.ByWait(driver,AddProductPage);
		for(int i=0;i<ProductList.size();i++) {
			 productName = ProductList.get(i).findElement(By.cssSelector("b")).getText();
				if(productName.equalsIgnoreCase("iphone 13 pro"))
				{			  
					  ProductList.get(i).findElement(AddtoCartBtn).click();
			    }
			}
		return productName;
	}
	
	public void gotoCart() {
	
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(20));
		w.until(ExpectedConditions.invisibilityOf(ProductAddedPopup));
		CartRedirectButton.click();
		 

	}

}
