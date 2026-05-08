package sauceDemoBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void initializeBrowser()  {
		
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

	}
}
