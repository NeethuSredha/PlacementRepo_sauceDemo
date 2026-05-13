package sauceDemoBase;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;

public class Base {

	public WebDriver driver;
	Properties prop;
	FileInputStream f;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browsers")
	public void initializeBrowser(String browsers) throws Exception {
		prop=new Properties();
		f=new FileInputStream(Constants.CONFIGFILE);
		prop.load(f);
		if (browsers.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browsers.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsers.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new Exception("Invalid browser");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}
	
	@AfterMethod(alwaysRun = true)
	public void driverClose() {
		driver.quit();
	}
}
