package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

	public WebDriver driver;
	@FindBy (xpath="//button[@id='add-to-cart-sauce-labs-backpack']") WebElement addToCartBackPack;
	@FindBy (xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") WebElement addToCartTShirt;
	
	@FindBy(xpath="//a[@id='item_4_title_link']//following::div[@class='pricebar'][1]/button") WebElement addToCartBackPackButton;
	@FindBy(xpath="//a[@id='item_1_title_link']//following::div[@class='pricebar'][1]/button") WebElement addToCartTShirtButton;
	
	public InventoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddToCartBackPack() {
		addToCartBackPack.click();
		addToCartTShirt.click();
	}
	
	public String getAddToCartButtonText() {
		return addToCartBackPackButton.getText();
	}
	
	
}
