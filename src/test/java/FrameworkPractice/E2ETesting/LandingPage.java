package FrameworkPractice.E2ETesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {
	public WebDriver driver;
	public LandingPage landingpage;
	
	@FindBy(id="userEmail")
	WebElement userEmailID;
	@FindBy(id="userPassword")
	WebElement Password;
	@FindBy(id="login")
	WebElement submit;
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void Login(String email,String password) throws IOException {
		 
		
		 userEmailID.sendKeys(email);
    	 Password.sendKeys(password);
    	 submit.click();
  
    	 	   
	}
	public void Launch() throws IOException {
		driver.get("https://rahulshettyacademy.com/client");
	}
	

}
