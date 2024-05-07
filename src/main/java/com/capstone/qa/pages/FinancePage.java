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
	String appointmentName = "RevApp - 30-04-2024";
	String entityListName = " 12Internal Company ";
	String searchListQuery = "30029"; // First three letters entered in the search bar
	String episodeListName = "30029";

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
	WebElement newEstimateBtn;

	@FindBy(xpath = "//mat-label[contains(text(),'Appointment')]")
	WebElement appointmentBtn;

	@FindBy(xpath = "//*[@id='mat-select-12-panel']")
	WebElement appointmentList;

	@FindBy(xpath = "//mat-label[contains(text(),'Entity')]")
	WebElement entityBtn;

	@FindBy(xpath = "//*[@id='mat-select-8-panel']")
	WebElement entityList;

	@FindBy(xpath = "//mat-label[contains(text(),'Search episode item')]")
	WebElement episodeItem;

	@FindBy(xpath = "//input[@id='episode-search-input-auto-complete-id-0-0']")
	WebElement searchEpisodeTab;

	@FindBy(xpath = "//*[@id='mat-autocomplete-1']")
	WebElement episodeItemList;

	@FindBy(xpath = "//body/app-root[1]/app-main-layout[1]/mat-drawer-container[1]/mat-drawer[1]/div[1]/div[2]/mat-form-field[1]/div[1]/div[1]/div[4]/div[1]/button[1]/span[3]")
	WebElement deleteBtn;

	@FindBy(xpath = "//span[contains(text(),'Save')]")
	WebElement saveBtn;

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

	public void createNewEstimate() throws InterruptedException {
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
		newEstimateBtn.click();
		appointmentBtn.click();
		TestUtil.waitUntilElementVisible(appointmentList);
		try {
			WebElement appointmentoption = appointmentList
					.findElement(By.xpath("//span[contains(text(),'" + appointmentName + "')]"));
			// Click on the desired user
			appointmentoption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired appointment '" + appointmentName + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException(
					"Desired appointment '" + appointmentName + "' not found in search results.");
			// throw an exception to fail the test case
		}
		TestUtil.scrollIntoView(entityBtn, driver);
		entityBtn.click();
		TestUtil.waitUntilElementVisible(entityList);
		try {
			WebElement entitytoption = entityList
					.findElement(By.xpath("//span[contains(text(),'" + entityListName + "')]"));
			// Click on the desired user
			entitytoption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired appointment '" + entityListName + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired appointment '" + entityList + "' not found in search results.");
			// throw an exception to fail the test case
		}
		TestUtil.scrollIntoView(episodeItem, driver);
		episodeItem.click();
		searchEpisodeTab.sendKeys(searchListQuery);
		TestUtil.waitUntilElementVisible(episodeItemList);
		try {
			WebElement episodeOption = episodeItemList
					.findElement(By.xpath("//span[contains(text(),'" + episodeListName + "')]"));
			// Click on the desired user
			episodeOption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired MBS '" + episodeListName + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired MBS '" + episodeListName + "' not found in search results.");
			// throw an exception to fail the test case
		}
		deleteBtn.click();
		saveBtn.click();

	}

}
