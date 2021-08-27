package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utilities.Readprop;

public class CartPage {
	
	WebDriver driver;
	ExtractorData ex;
	WebDriverWait wait;
	Readprop read;
	
	public CartPage(WebDriver driver) 
	{
		this.driver = driver;

		
	}
	@Step("get all the items in shopping cart page")
	public ArrayList<String> getItemsNames_Added_Shopping_Cart() throws Exception{
		ex= new ExtractorData();
		
		ArrayList<String> names = new ArrayList<String>();
		List<WebElement> addedItemsNames = driver.findElements(By.xpath(ex.Locaters("CartPage", 1)));

		for (WebElement element : addedItemsNames) {
			names.add(element.getText());
		}
		
		return names;
	}
	
	@Step("Click on checout button")
	public void clickOnCheckoutButton() throws Exception {
		ex= new ExtractorData();
		WebElement checkoutBttn = driver.findElement(By.id(ex.Locaters("CartPage", 2)));
		checkoutBttn.click();
	}

}
