package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test(dataProvider = "LoginDetails", dataProviderClass = CustomDataProvider.class)
	public void LoginToApplication(String username, String password) {

		LoginPage login = new LoginPage(driver);
		login.LoginToApplication(username, password);
		HomePage home=new HomePage(driver);
		Assert.assertTrue(home.checkSigOutButton().contains("Sign out"));
		home.clickOnSignOut();
		Assert.assertTrue(login.IsSignInPresent());
	
	}

}
