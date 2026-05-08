package testScripts;

import org.testng.Assert;

import org.testng.annotations.Test;

import constants.Constants;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import sauceDemoBase.Base;

public class CartTest extends Base{
	@Test
	public void verifyWhetherUserCanSuccessfullyCheckOut() {
		String username="standard_user";
		String password="secret_sauce";
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPassswordOnPasswordField(password).clickLogin();
		InventoryPage inventoryPage=new InventoryPage(driver);
		inventoryPage.clickOnAddToCartBackPack();
		CartPage cartPage=new CartPage(driver);
		cartPage.clickOnCheckOutButton();
		boolean checkOutPageDisplayed=cartPage.isCheckOutPageInfoDisplayed();
		Assert.assertTrue(checkOutPageDisplayed,Constants.USERNOTSUCCESSFULLYCHECKEDOUT);
	}
}
