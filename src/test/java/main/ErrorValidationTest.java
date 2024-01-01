package main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import FrameworkPractice.E2ETesting.LandingPage;
import abstractComponent.Browser;
import abstractComponent.ReusableCode;

public class ErrorValidationTest extends Browser {
	WebDriver driver;
	public ErrorValidationTest() throws IOException {
		this.driver = initializeBrowser();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[contains(@aria-label,'Incorrect email or password.')]")
	WebElement LoginErrormessage;
	@Test
	public void LoginUsernameTest() throws IOException {
		
		LandingPage loginObj = new LandingPage(driver);
		loginObj.Launch();
		loginObj.Login("roja.reddy@gmail.com","Hydrogen01");
		ReusableCode.driverWait(driver,LoginErrormessage);
		String LoginUsrErrMsg = LoginErrormessage.getText();
		System.out.println(LoginUsrErrMsg);
		
			
	}

}
