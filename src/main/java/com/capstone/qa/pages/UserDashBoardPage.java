package com.capstone.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capstone.qa.base.TestBase;
import com.capstone.qa.util.TestUtil;

public class UserDashBoardPage extends TestBase {

	// 1. Locators: OR
	@FindBy(xpath = "//a[contains(text(),'Dashboard')]")
	WebElement dashboardtab;

	@FindBy(xpath = "//a[contains(text(),'Finance Dashboard')]")
	WebElement financedashboardtab;

	@FindBy(xpath = "//a[contains(text(),'Providers Dashboard')]")
	WebElement providersdashboardtab;

	// Initializing the Page Objects:
	public UserDashBoardPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateUserDashBoardPageTitle() {
		TestUtil.waitUntilPageLoad();
		String title= driver.getTitle();
		System.out.println("The title of the current page is --->" +title);
		return title;
	}
	
	public String validateUserDashBoardPageURL() throws InterruptedException {
		TestUtil.waitUntilPageLoad();
		String currentURL= driver.getCurrentUrl();
		System.out.println("The Current URL of the page is---> " +currentURL);
		return driver.getCurrentUrl();
	}
	
	public boolean isDashBoardTabPresent() {
		return dashboardtab.isDisplayed();
	}
	
	public boolean isFinanceDashBoardtabPresent() {
		return financedashboardtab.isDisplayed();
	}
	
	public boolean isProvidersDashBoardtabPresent() {
		return providersdashboardtab.isDisplayed();
	}


}
