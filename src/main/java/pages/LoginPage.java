package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import utilities.Readprop;

public class LoginPage {


	WebDriver driver;
	ExtractorData ex;
	WebDriverWait wait;
	Readprop read;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@Step("Login to Sauce Demo appliction using username: {0} , and Password: {1}")
	public void LoginToSauceDemo(String userName, String passWord) throws Exception {
		
		ex = new ExtractorData();
		
		WebElement usernameElement = driver.findElement(By.id(ex.Locaters("LoginPage", 1)));
		usernameElement.sendKeys(userName);
		
		WebElement passwordElement = driver.findElement(By.id(ex.Locaters("LoginPage", 2)));
		passwordElement.sendKeys(passWord);
		
		WebElement loginButton = driver.findElement(By.id(ex.Locaters("LoginPage", 3)));
		loginButton.click();

		
	}

}
