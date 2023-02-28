package browserFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowserInstance()
	{
		return driver;
	}
	
	public static WebDriver StartBrowser(String browser,String applicationurl)
	{
		
		if(browser.contains("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.contains("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.contains("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.contains("Safari"))
		{
			driver=new SafariDriver();
		}
		else
		{
			Reporter.log("Sorry " + browser + " name is not supported Running test in default browser");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		driver.get(applicationurl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		return driver;
	}

}
