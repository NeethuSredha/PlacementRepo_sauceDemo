package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepOne_Page {
	public WebDriver driver;
	@FindBy (xpath="//input[@id='first-name']") WebElement firstName;
	@FindBy (xpath="//input[@id='last-name']") WebElement lastName;
	@FindBy (xpath="//input[@id='postal-code']") WebElement postalCode;
	@FindBy (xpath="//input[@id='continue']") WebElement continueButton;
	@FindBy (xpath="//span[text()='Checkout: Overview']") WebElement checkOutStepOnePage;
	
	
	public CheckOutStepOne_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterTheInformation(String fname, String lname, String postalCode2) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		postalCode.sendKeys(postalCode2);
		continueButton.click();
	}
	
	public boolean isSuccessfullCheckOutStepOne() {
		return checkOutStepOnePage.isDisplayed();
	}
}
