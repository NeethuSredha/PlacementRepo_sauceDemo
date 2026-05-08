package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	@FindBy(xpath = "//input[@id='user-name']") WebElement userName;
	@FindBy(xpath = "//input[@id='password']") WebElement password;
	@FindBy(xpath = "//input[@id='login-button']") WebElement login;
	@FindBy(xpath = "//span[text()='Products']") WebElement products;
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public LoginPage enterUserNameOnUserNameField(String username2) {
		userName.sendKeys(username2);
		return this;
	}

	public LoginPage enterPassswordOnPasswordField(String password2) {
		password.sendKeys(password2);
		return this;
	}

	public InventoryPage clickLogin() {
		 login.click();
		 return new InventoryPage(driver);

	}
	
	public boolean isProductsPageDisplayed() {
		return products.isDisplayed();
	}

}
