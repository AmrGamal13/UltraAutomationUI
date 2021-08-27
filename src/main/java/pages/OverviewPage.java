package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;
import utilities.Readprop;

public class OverviewPage {

	WebDriver driver;
	ExtractorData ex;
	Readprop read;
	
	public OverviewPage(WebDriver driver) 
	{
		this.driver = driver;

		
	}
	
	@Step("get all the items in overview page")
	public ArrayList<String> getAllItemsNames_overview() throws Exception {
		ArrayList<String> names = new ArrayList<String>();
		
		ex= new ExtractorData();

		List<WebElement> itemsNames = driver.findElements(By.xpath(ex.Locaters("OverviewPage", 1)));

		for (WebElement element : itemsNames) {
			names.add(element.getText());
		}
		
		return names;

	}
	
	@Step("Click on finish button")
	public void clickOnFinishButton() throws Exception {
		ex= new ExtractorData();

		WebElement finishBttn = driver.findElement(By.id(ex.Locaters("OverviewPage", 2)));
		finishBttn.click();
	}
	
}
