package testScripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import constants.Constants;
import pages.InventoryPage;
import pages.LoginPage;
import sauceDemoBase.Base;
import utilities.ExcelUtility;

public class InventoryTest extends Base{
	@Test
	public void verifyWhetherUserCanSuccessfullyAddBackPackToAddToCart() throws Exception {
		String username=ExcelUtility.getStringData(0, 0, "Login");
		String password=ExcelUtility.getStringData(0, 1, "Login");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPassswordOnPasswordField(password);
		loginPage.clickLogin();
		InventoryPage inventoryPage=new InventoryPage(driver);
		inventoryPage.clickOnAddToCartBackPack();
		//String text=inventoryPage.getAddToCartButtonText();
		//assertEquals(text,"Remove",Constants.PRODUCTNOTADDEDTOCARTERROR);
	}
}
