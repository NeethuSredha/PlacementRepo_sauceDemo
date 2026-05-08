package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepTwo_Page {
	public WebDriver driver;
	@FindBy (xpath="//button[@id='finish']") WebElement finish;
	@FindBy (xpath="//h2[text()='Thank you for your order!']") WebElement successMsg;
	
	public CheckOutStepTwo_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnFinishButton() {
		finish.click();
	}
	
	public String successMessage() {
		return successMsg.getText();
	}
	
}
