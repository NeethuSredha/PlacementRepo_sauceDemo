package testScripts;

import org.testng.Assert;

import org.testng.annotations.Test;

import constants.Constants;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import sauceDemoBase.Base;
import utilities.ExcelUtility;

public class CartTest extends Base{
	@Test(groups= {"smoke"})
	public void verifyWhetherUserCanSuccessfullyCheckOut() throws Exception {
		String username=ExcelUtility.getStringData(0, 0, "Login");
		String password=ExcelUtility.getStringData(0, 1, "Login");
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
