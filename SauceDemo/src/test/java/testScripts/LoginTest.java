package testScripts;


import  org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.InventoryPage;
import pages.LoginPage;
import sauceDemoBase.Base;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	InventoryPage inventoryPage;
	
@Test(groups = {"smoke"})
	public void verifyWhetherUserCanSuccessfullyLoginWithValidUserNameAndValidPassword() throws Exception {
		String username=ExcelUtility.getStringData(0, 0, "Login");
		String password=ExcelUtility.getStringData(0, 1, "Login");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPassswordOnPasswordField(password);
		inventoryPage=loginPage.clickLogin();
		boolean isProductsPageDisplayed=loginPage.isProductsPageDisplayed();
		Assert.assertTrue(isProductsPageDisplayed, Constants.VALIDCREDENTIALERROR);
	}
}
