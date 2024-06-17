package com.capstone.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capstone.qa.base.TestBase;
import com.capstone.qa.pages.LoginPage;
import com.capstone.qa.pages.UserDashBoardPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	UserDashBoardPage userDashBoardPage;

	public LoginPageTest() {
		super(); // call the test base class constructor
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Capstone");
	}
	
	@Test
	public void loginTest() {
		userDashBoardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
