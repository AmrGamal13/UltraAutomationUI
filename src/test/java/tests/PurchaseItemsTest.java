package tests;

import org.testng.annotations.Test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listener.TestAllureListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.CartPage;
import pages.CompletePage;
import pages.InformationPage;
import pages.InventoryPage;
import pages.LoginPage;
import pages.OverviewPage;
import utilities.Readprop;

@Listeners({TestAllureListener.class})
public class PurchaseItemsTest extends TestBase {

	LoginPage logObj;
	Readprop readObj;
	InventoryPage invObj;
	CartPage cartObj;
	InformationPage infoObj;
	OverviewPage overObj;
	CompletePage comObj;


	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify that user can purchase all the items successfully")
	@Story("Story Name: Purchase Items")
	@Test
	public void UserCanPurchaseItems() throws Exception {
		ArrayList<String> ActuaLNitemsNames = new ArrayList<String>();
		
		logObj = new LoginPage(driver);
		readObj = new Readprop();
		invObj = new InventoryPage(driver);
		cartObj = new CartPage(driver);
		infoObj = new InformationPage(driver);
		overObj = new OverviewPage(driver);
		comObj = new CompletePage(driver);
		
		String UserName = readObj.getPropValues("Username", "config.properties");
		String Password = readObj.getPropValues("Password", "config.properties");
		
		String firstnamevalue = readObj.getPropValues("firstname", "data.properties");
		String lastnamevalue = readObj.getPropValues("lastname", "data.properties");
		String postalcodevalue = readObj.getPropValues("Postalcode", "data.properties");
		String successMessageValue = readObj.getPropValues("successMessage", "data.properties");

		
		logObj.LoginToSauceDemo(UserName, Password);
		ActuaLNitemsNames = invObj.getAllItemsNames();
		
		invObj.addAllItemsToCart();
		
		invObj.clickOnShoppingCart();
		
		org.testng.Assert.assertTrue(ActuaLNitemsNames.containsAll(cartObj.getItemsNames_Added_Shopping_Cart() ));
		
		cartObj.clickOnCheckoutButton();
		
		infoObj.fillCustomerInfo(firstnamevalue, lastnamevalue, postalcodevalue);
		
		org.testng.Assert.assertTrue(ActuaLNitemsNames.containsAll(overObj.getAllItemsNames_overview()));
		
		overObj.clickOnFinishButton();
		
		Assert.assertTrue(comObj.getSuccessMessage().contains(successMessageValue));
		
	}
}
