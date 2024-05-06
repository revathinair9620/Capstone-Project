package com.capstone.qa.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capstone.qa.base.TestBase;
import com.capstone.qa.util.TestUtil;

public class FinancePage extends TestBase {

	String searchQuery = "sac"; // First three letters entered in the search bar
	String desiredUserName = "Sachin S"; // Name of the user you want to select

	// 1. Locators: OR
	@FindBy(xpath = "//mat-icon[contains(text(),'menu_open')]")
	WebElement menutab;

	@FindBy(xpath = "//div[@class='main-menu-name ng-star-inserted' and contains(text(),'Search')]")
	WebElement searchmenu;

	@FindBy(xpath = "//input[@id='mat-input-3']")
	WebElement searchPatientTab;

	@FindBy(xpath = "//div[@class='patient-search-result ng-tns-c142-5']")
	WebElement patientSearchResults;

	@FindBy(xpath = "//div[contains(text(),'Finance')]")
	WebElement financeTab;

	@FindBy(xpath = "//span[contains(text(),'New Estimate')]")
	WebElement newEstimate;

	// Initializing the Page Objects:
	public FinancePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String validateaddPatientPageTitle() {
		String title = driver.getTitle();
		System.out.println("The title of the current page is --->" + title);
		return title;
	}

	public String validateaddPatientPageURL() throws InterruptedException {
		String currentURL = driver.getCurrentUrl();
		System.out.println("The Current URL of the page is---> " + currentURL);
		return driver.getCurrentUrl();
	}

	public void searchPatientDetails() throws InterruptedException {
		menutab.click();
		searchmenu.click();
		searchPatientTab.sendKeys(searchQuery);
		TestUtil.waitUntilElementVisible(patientSearchResults);
		try {
			WebElement desiredUser = patientSearchResults.findElement(
					By.xpath("//div[contains(@class, 'user-name') and contains(text(), '" + desiredUserName + "')]"));
			// Click on the desired user
			desiredUser.click();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired user '" + desiredUserName + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired user '" + desiredUserName + "' not found in search results.");
			// throw an exception to fail the test case
		}
		financeTab.click();
		newEstimate.click();

	}

	public void createNewEstimate() {
		newEstimate.click();
		

	}

}
