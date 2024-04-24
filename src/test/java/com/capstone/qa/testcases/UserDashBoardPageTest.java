package com.capstone.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capstone.qa.base.TestBase;
import com.capstone.qa.pages.LoginPage;
import com.capstone.qa.pages.UserDashBoardPage;

public class UserDashBoardPageTest extends TestBase {

	LoginPage loginPage;
	UserDashBoardPage userDashBoardPage;

	public UserDashBoardPageTest() {
		super(); // call the test base class constructor
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		userDashBoardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void userDashBoardPageTitleTest() {
		String title = userDashBoardPage.validateUserDashBoardPageTitle();
		Assert.assertEquals(title, "Capstone");
	}

	@Test
	public void userDashBoardPageURLTest() throws InterruptedException {
		String URL = userDashBoardPage.validateUserDashBoardPageURL();
		Assert.assertEquals(URL, "https://adactin.capstonesystemdev.com.au/dashboard");
	}

	@Test
	public void dashBoardTabTest() {
		boolean dashBoardTab = userDashBoardPage.isDashBoardTabPresent();

		if (dashBoardTab) {
			System.out.println("dashBoardTab is present on the page");
		} else {
			System.out.println("DashboardTab is not present on the page");

			Assert.assertTrue(dashBoardTab, "DashboardTab is not present on the page");
		}

	}

	@Test
	public void providersDashBoardtabPresent() {
		boolean providersDashBoardtab = userDashBoardPage.isProvidersDashBoardtabPresent();

		if (providersDashBoardtab) {
			System.out.println("providersDashBoardtab is present on the page");
		} else {
			System.out.println("providersDashBoardtab is not present on the page");

			Assert.assertTrue(providersDashBoardtab, "providersDashBoardtab is not present on the page");
		}

	}

	@Test
	public void financeDashBoardtabPresent() {
		boolean financeDashBoardtab = userDashBoardPage.isFinanceDashBoardtabPresent();

		if (financeDashBoardtab) {
			System.out.println("financeDashBoardtab is present on the page");
		} else {
			System.out.println("financeDashBoardtab is not present on the page");

			Assert.assertTrue(financeDashBoardtab, "financeDashBoardtab is not present on the page");
		}

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
