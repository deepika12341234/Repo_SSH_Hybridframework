package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By user=By.id("email1");
	By pass=By.name("password1");
	By login=By.xpath("//button[text()='Sign in']");
	
	public void LoginToApplication(String username,String password)
	{
		driver.findElement(user).clear();
		driver.findElement(pass).clear();
		driver.findElement(user).sendKeys(username);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(login).click();
	}
	
	public boolean IsSignInPresent()
	{
		boolean status=driver.findElement(login).isDisplayed();
		return status;
	}

}
