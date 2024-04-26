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
	public void userDashBoardPageTest() throws InterruptedException {

		boolean dashBoardTab = userDashBoardPage.isDashBoardTabPresent();

		if (dashBoardTab) {
			System.out.println("dashBoardTab is present on the page");
		} else {
			System.out.println("DashboardTab is not present on the page");

			Assert.assertTrue(dashBoardTab, "DashboardTab is not present on the page");
		}

		boolean providersDashBoardtab = userDashBoardPage.isProvidersDashBoardtabPresent();

		if (providersDashBoardtab) {
			System.out.println("providersDashBoardtab is present on the page");
		} else {
			System.out.println("providersDashBoardtab is not present on the page");

			Assert.assertTrue(providersDashBoardtab, "providersDashBoardtab is not present on the page");
		}

		boolean financeDashBoardtab = userDashBoardPage.isFinanceDashBoardtabPresent();

		if (financeDashBoardtab) {
			System.out.println("financeDashBoardtab is present on the page");
		} else {
			System.out.println("financeDashBoardtab is not present on the page");

			Assert.assertTrue(financeDashBoardtab, "financeDashBoardtab is not present on the page");
		}
		String title = userDashBoardPage.validateUserDashBoardPageTitle();// checking the page title
		Assert.assertEquals(title, "DASH | Tester1");
		String URL = userDashBoardPage.validateUserDashBoardPageURL();// getting the currenturl
		Assert.assertEquals(URL, "https://adactin.capstonesystemdev.com.au/dashboard");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
