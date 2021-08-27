package tests;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Readprop;
public class TestBase {

	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	//ReadProperties read;
	Readprop read;
	
	//public ExtentTest test;
	@BeforeSuite
	public WebDriver before() throws IOException 
	{
		
		System.out.println("Intitalizing the browser");
		read = new Readprop();
		if (read.getPropValues("browserName", "config.properties").equalsIgnoreCase("chrome")) {

			if (read.getPropValues("executionType", "config.properties").equalsIgnoreCase("local")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions capability = new ChromeOptions();
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
				driver =  new ChromeDriver(capability);
			}

			else if (read.getPropValues("executionType", "config.properties").equalsIgnoreCase("headless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver = new ChromeDriver(options);
			}
		}

		else if (read.getPropValues("browserName", "config.properties").equalsIgnoreCase("firefox")) {
			if (read.getPropValues("executionType", "config.properties").equalsIgnoreCase("local")) {
				WebDriverManager.firefoxdriver().setup();
				driver =  new FirefoxDriver();
			}
			else if (read.getPropValues("executionType", "config.properties").equalsIgnoreCase("headless")) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver = new FirefoxDriver();
			}
		}

		else if (read.getPropValues("browserName", "config.properties").equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();		
			driver =  new InternetExplorerDriver();
		}

		else if (read.getPropValues("browserName", "config.properties").equalsIgnoreCase("chrome-headless")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);

		}
		//test = extent.createTest("Intializing the driver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(read.getPropValues("URL", "config.properties"));
		
		tdriver.set(driver);
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	@AfterSuite
	public void quitBrowser() throws IOException 
	{
		driver.quit();
	}
}
