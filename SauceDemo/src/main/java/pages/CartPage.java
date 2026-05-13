package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public WebDriver driver;
	
	@FindBy (xpath="//button[@id='checkout']") WebElement checkOut;
	@FindBy (xpath="//a[@class='shopping_cart_link']") WebElement viewCart;
	@FindBy (xpath="//span[text()='Checkout: Your Information']") WebElement checkOutPageInfo;
	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnCheckOutButton() {
		viewCart.click();
		checkOut.click();	
	}
	
	public boolean isCheckOutPageInfoDisplayed() {
		return checkOutPageInfo.isDisplayed();
	}
	public void handleTheAlertPopUp() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
}
