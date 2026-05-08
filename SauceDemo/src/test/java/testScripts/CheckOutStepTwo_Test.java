package testScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.CartPage;
import pages.CheckOutStepOne_Page;
import pages.CheckOutStepTwo_Page;
import pages.InventoryPage;
import pages.LoginPage;
import sauceDemoBase.Base;

public class CheckOutStepTwo_Test extends Base {
	
	@Test(dataProvider = "ValueProvider")
	public void verifyWhetherUserCanSuccessfullyFinishTheCheckOut(String fname,String lname,String postalCode) {
		String username="standard_user";
		String password="secret_sauce";
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(username).enterPassswordOnPasswordField(password).clickLogin();
		
		InventoryPage inventoryPage=new InventoryPage(driver);
		inventoryPage.clickOnAddToCartBackPack();
		
		CartPage cartPage=new CartPage(driver);
		cartPage.clickOnCheckOutButton();
		
		CheckOutStepOne_Page checkOutStepOne=new CheckOutStepOne_Page(driver);
		checkOutStepOne.enterTheInformation(fname,lname,postalCode);
		
		CheckOutStepTwo_Page checkOutTwo=new CheckOutStepTwo_Page(driver);
		checkOutTwo.clickOnFinishButton();
		String expected="Thank you for your order!";
		String actual=checkOutTwo.successMessage();
		assertEquals(actual, expected,Constants.CHECKOUTORDERERROR);
	}
	
	@DataProvider(name = "ValueProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "Neethu", "R", "12345" }

		};
	}
	
}
