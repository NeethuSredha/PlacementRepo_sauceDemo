package testScripts;


import  org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.InventoryPage;
import pages.LoginPage;
import sauceDemoBase.Base;

public class LoginTest extends Base{
	InventoryPage inventoryPage;
	
@Test
	public void verifyWhetherUserCanSuccessfullyLoginWithValidUserNameAndValidPassword() {
		String username="standard_user";
		String password="secret_sauce";
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPassswordOnPasswordField(password);
		inventoryPage=loginPage.clickLogin();
		boolean isProductsPageDisplayed=loginPage.isProductsPageDisplayed();
		Assert.assertTrue(isProductsPageDisplayed, Constants.VALIDCREDENTIALERROR);
	}
}
