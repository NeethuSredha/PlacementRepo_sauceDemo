package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.CartPage;
import pages.CheckOutStepOne_Page;
import pages.InventoryPage;
import pages.LoginPage;
import sauceDemoBase.Base;
import utilities.ExcelUtility;

public class CheckOutStepOne_Test extends Base{
@Test(groups="smoke")
	public void verifyWhetherUserCanSuccessfullyCheckOutByEnteringDetails() throws Exception {
		String username=ExcelUtility.getStringData(0, 0, "Login");
		String password=ExcelUtility.getStringData(0, 1, "Login");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPassswordOnPasswordField(password).clickLogin();
		InventoryPage inventoryPage=new InventoryPage(driver);
		inventoryPage.clickOnAddToCartBackPack();
		CartPage cartPage=new CartPage(driver);
		cartPage.clickOnCheckOutButton();
		CheckOutStepOne_Page checkOutStepOne=new CheckOutStepOne_Page(driver);
		String fname=ExcelUtility.getStringData(0, 0,"Details");
		String lname=ExcelUtility.getStringData(1, 0,"Details");
		String postalCode=ExcelUtility.getIntegerData(2, 0,"Details");
		checkOutStepOne.enterTheInformation(fname,lname,postalCode);
		boolean isCheckOutStepOneSuccessfull=checkOutStepOne.isSuccessfullCheckOutStepOne();
		Assert.assertTrue(isCheckOutStepOneSuccessfull, Constants.CHECKOUTSTEPONEERROR);
	}

@DataProvider(name = "ValueProvider")
public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "Neethu", "R", "12345" }

	};
}



//--------------------------
//@Test
/*public void verifyWhetherUserCanSuccessfullyCheckOutByEnteringDetails() throws Exception {
	String username=ExcelUtility.getStringData(0, 0, "Login");
	String password=ExcelUtility.getStringData(0, 1, "Login");
	LoginPage loginPage=new LoginPage(driver);
	loginPage.enterUserNameOnUserNameField(username).enterPassswordOnPasswordField(password).clickLogin();
	InventoryPage inventoryPage=new InventoryPage(driver);
	inventoryPage.clickOnAddToCartBackPack();
	CartPage cartPage=new CartPage(driver);
	cartPage.clickOnCheckOutButton();
	CheckOutStepOne_Page checkOutStepOne=new CheckOutStepOne_Page(driver);
	String fname=ExcelUtility.getStringData(0, 0,"Details");
	String lname=ExcelUtility.getStringData(1, 0,"Details");
	String postalCode=ExcelUtility.getIntegerData(2, 0,"Details");
	checkOutStepOne.enterTheInformation(fname,lname,postalCode);
	boolean isCheckOutStepOneSuccessfull=checkOutStepOne.isSuccessfullCheckOutStepOne();
	Assert.assertTrue(isCheckOutStepOneSuccessfull, Constants.CHECKOUTSTEPONEERROR);
}*/
}
