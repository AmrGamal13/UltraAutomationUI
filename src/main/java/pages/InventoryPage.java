package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utilities.Readprop;

public class InventoryPage {

	WebDriver driver;
	ExtractorData ex;
	WebDriverWait wait;
	Readprop read;

	public InventoryPage(WebDriver driver) {
		this.driver = driver;

	}

	@Step("Click on Add to cart button for the all items in the inventory page")
	public void addAllItemsToCart() throws Exception {

		ex= new ExtractorData();

		List<WebElement> AddToCartButtons = driver.findElements(By.xpath(ex.Locaters("InventoryPage", 1)));

		for (WebElement element : AddToCartButtons) {
			element.click();
		}

	}

	@Step("Get all the items in ivnetory page")
	public ArrayList<String> getAllItemsNames() throws Exception {
		ArrayList<String> names = new ArrayList<String>();
		
		ex= new ExtractorData();

		List<WebElement> itemsNames = driver.findElements(By.xpath(ex.Locaters("InventoryPage", 2)));

		for (WebElement element : itemsNames) {
			names.add(element.getText());
		}
		
		return names;

	}
	
	@Step("Click on shopping cart button")
	public void clickOnShoppingCart() throws Exception {
		ex= new ExtractorData();
		WebElement cartButton = driver.findElement(By.xpath(ex.Locaters("InventoryPage", 3)));
		cartButton.click();
	}
}
