package abstractComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public WebDriver driver;
	//@BeforeTest
	public WebDriver initializeBrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\abstractComponent\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"));
		{
			//WebDriverManager.chromedriver().setup();
	    	ChromeOptions cp = new ChromeOptions();
	    	cp.addArguments("remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\chromedriver-win64\\chromedriver.exe");
	    	driver = new ChromeDriver(cp);
	    	
	    }
		return driver;
	  
	}
	@AfterTest
	public void CloseTheTest() {
		driver.close();
	}
}