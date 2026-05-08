package testScripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import constants.Constants;
import pages.InventoryPage;
import pages.LoginPage;
import sauceDemoBase.Base;

public class InventoryTest extends Base{
	@Test
	public void verifyWhetherUserCanSuccessfullyAddBackPackToAddToCart() {
		String username="standard_user";
		String password="secret_sauce";
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPassswordOnPasswordField(password);
		loginPage.clickLogin();
		InventoryPage inventoryPage=new InventoryPage(driver);
		inventoryPage.clickOnAddToCartBackPack();
		String text=inventoryPage.getAddToCartButtonText();
		assertEquals(text,"Remove",Constants.PRODUCTNOTADDEDTOCARTERROR);
	}
}
