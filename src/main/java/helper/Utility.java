package helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static Alert waitForAlert(WebDriver driver) {
		Alert alt = null;
		for (int i = 0; i <= 15; i++) {
			try {
				alt = driver.switchTo().alert();
				break;
			} catch (NoAlertPresentException e) {
				System.out.println("No Alert Found - Waiting for Alert");
				waitForSeconds(1);
			}
		}

		return alt;
	}

	public static Alert waitForAlert(WebDriver driver, int time) {
		Alert alt = null;
		for (int i = 0; i <= time; i++) {
			try {
				alt = driver.switchTo().alert();
				break;
			} catch (NoAlertPresentException e) {
				System.out.println("No Alert Found - Waiting for Alert");
				waitForSeconds(1);
			}
		}

		return alt;
	}

	public static void waitForSeconds(int seconds)

	{
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String captureScreenshotInBase64(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String base64=ts.getScreenshotAs(OutputType.BASE64);
		return base64;
		
	}

	public static void captureScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir") + "/screenshots/Screenshot_" + getCurrentDateTime()+ ".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void captureScreenshotOfWebElement(WebDriver driver, WebElement element) {
		File src = element.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("./elementscreenshots/Element_" + getCurrentDateTime() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getCurrentDateTime() {
		Date d = new Date();
		SimpleDateFormat customFormat = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		String date = customFormat.format(d);
		return date;

	}

	public static WebElement highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid pink;')", element);
		waitForSeconds(1);
		js.executeScript("arguments[0].setAttribute('style','border:2px solid white;')", element);

		return element;
	}

	public static WebElement highlightElement(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid pink;')", element);
		waitForSeconds(1);
		js.executeScript("arguments[0].setAttribute('style','border:2px solid white;')", element);

		return element;
	}

}