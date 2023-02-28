package base;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import browserFactory.BrowserFactory;
import dataProvider.ConfigReader;

public class BaseClass {

	public WebDriver driver;

	@BeforeMethod
	public void setupBrowser() {
		System.out.println("LOG:INFO - Setting up browser");
		// approach -1 when we take config values from a file in this approach parallel
		// execution is not supported
		// This approach is suitable if we are not doing cross browser testing
		// approach - 1 - Config - does not suite for cross browser

		// Note: If we want to apply cross browser testing we need to apply parameters
		// in testNG.xml file
		driver = BrowserFactory.StartBrowser(ConfigReader.getProperty("browser"),
				ConfigReader.getProperty("applicationurl"));
		System.out.println("LOG:INFO - Application is up and running");

	}

	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
		System.out.println("LOG:INFO - Closing the browser and application");

	}

}
