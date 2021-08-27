package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;
import utilities.Readprop;

public class CompletePage {

	WebDriver driver;
	ExtractorData ex;
	Readprop read;
	
	public CompletePage(WebDriver driver) 
	{
		this.driver = driver;

		
	}
	
	@Step("Get the success message from the complete page")
	public String getSuccessMessage() throws Exception {
		
		ex = new ExtractorData();
		
		WebElement message = driver.findElement(By.xpath(ex.Locaters("CompletePage", 1)));
		
		return message.getText();
	}
}
