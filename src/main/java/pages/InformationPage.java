package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utilities.Readprop;

public class InformationPage {

	WebDriver driver;
	ExtractorData ex;
	WebDriverWait wait;
	Readprop read;
	
	public InformationPage(WebDriver driver) 
	{
		this.driver = driver;

		
	}
	
	@Step("Fill customer data in information page, firstname : {0}, lastname : {1}, postalcode: {2}")
	public void fillCustomerInfo(String firstName, String lastName, String postalCode) throws Exception {
		
		ex = new ExtractorData();
		WebElement firstnameTxt =  driver.findElement(By.id(ex.Locaters("InformationPage", 1)));
		firstnameTxt.sendKeys(firstName);
		
		WebElement lastnameTxt =  driver.findElement(By.id(ex.Locaters("InformationPage", 2)));
		lastnameTxt.sendKeys(lastName);

		WebElement postalcodeTxt =  driver.findElement(By.id(ex.Locaters("InformationPage", 3)));
		postalcodeTxt.sendKeys(postalCode);
		
		WebElement continueBttn =  driver.findElement(By.id(ex.Locaters("InformationPage", 4)));
		continueBttn.click();

		
	}
}
