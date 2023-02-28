package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By signoutElement=By.xpath("//button[text()='Sign out']");
	
	public String checkSigOutButton()
	{
		String value=driver.findElement(signoutElement).getText();
		return value;
	}
	
	public void clickOnSignOut()
	{
		driver.findElement(signoutElement).click();
	}

}
