package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {


	public static void scroll_to_element(WebElement element, WebDriver driver) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}




	public static void captureScreenShot(WebDriver driver, String screenshotname) {

		Path dest = Paths.get("./Screenshots",screenshotname+".png");

		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out =  new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Exception while getting screenshot" + e.getMessage());
		}
	}


	public static String getScreenShotAsBase64(WebDriver driver) throws IOException {

		File Source =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshots/image.png";
		FileUtils.copyFile(Source, new File(path));
		byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(path));
		return Base64.getEncoder().encodeToString(imageBytes);
	}

	public static String getScreenshotPath(WebDriver driver) throws IOException {

		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshots/image.png";
		FileUtils.copyFile(source, new File(path));
		return path;
	}
}
