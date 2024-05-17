package com.capstone.qa.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capstone.qa.base.TestBase;
import com.capstone.qa.util.TestUtil;

public class FinancePage extends TestBase {

	private String searchQuery = "Sac"; // First three letters entered in the search bar
	private String desiredUserName = "Sachin S"; // Name of the user you want to select
	private String appointmentName = "RevApp - 30-04-2024";
	private String internalProviderQuery = "Cary Davidson";
	private String entityListName = " 12Internal Company ";
	private String accHolderName = " Patient ";
	private String searchListQuery = "31363"; // First three letters entered in the search bar
	private String episodeListName = "31363";
	private String childsearchListQuery = "15518";
	private String episodeListName2 = "15518";

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
	
	@FindBy(xpath = "//span[contains(text(),'New Invoice')]")
	WebElement newInvoiceBtn;
	
	@FindBy(xpath = "//span[contains(text(),'New Estimate')]")
	WebElement newEstimateBtn;

	@FindBy(xpath = "//mat-label[contains(text(),'Appointment')]")
	WebElement appointmentBtn;

	@FindBy(xpath = "//*[@id='mat-select-12-panel']")
	WebElement appointmentList;

	@FindBy(xpath = "//mat-label[contains(text(),'Search Internal Provider')]")
	WebElement searchInternalProviderBtn;
	
	@FindBy(xpath ="(//mat-label[contains(text(),'Search Internal Provider')])[2]")
	WebElement searchInternalProviderChildBtn;

	@FindBy(xpath = "//*[@id='mat-input-7']")
	WebElement searchInternalProviderTab;
	
	@FindBy(xpath = "//*[@id='mat-input-28']") 
	WebElement searchInternalProviderChildTab;
	
	@FindBy(xpath = "//*[@id='mat-autocomplete-0']")
	WebElement searchInternalProviderList;
	
	@FindBy(xpath = "//*[@id='mat-autocomplete-4']")
	WebElement searchInternalProviderChildList;
	
	@FindBy(xpath = "//mat-label[contains(text(),'Entity')]")
	WebElement entityBtn;
	
	@FindBy(xpath = "(//mat-label[contains(text(),'Entity')])[2]")
	WebElement entityChildBtn;
	
	@FindBy(xpath = "//*[@id='mat-select-8-panel']")
	WebElement entityList;
	
	@FindBy(xpath = "//*[@id='mat-select-22-panel']")
	WebElement entityChildList;

	@FindBy(xpath = "//mat-label[contains(text(),'Account holder')]")
	WebElement accountHolderBtn;
	
	@FindBy(xpath = "(//mat-label[contains(text(),'Account holder')])[2]")
	WebElement accountHolderChildBtn;

	@FindBy(xpath = "//*[@id='mat-select-10-panel']")
	WebElement accountHolderList;
	
	@FindBy(xpath = "//*[@id='mat-select-24-panel']")
	WebElement accountHolderChildList;
	
	@FindBy(xpath = "//mat-label[contains(text(),'Search episode item')]")
	WebElement episodeItem;
	
	@FindBy(xpath = "//mat-label[contains(text(),'Search episode item')]")
	WebElement episodeChildItem;
	
	@FindBy(xpath = "//input[@id='episode-search-input-auto-complete-id-0-0']")
	WebElement searchEpisodeTab;
	
	@FindBy(xpath = "//input[@id='episode-search-input-auto-complete-id-1-0']")
	WebElement searchEpisodeChildTab;
	
	@FindBy(xpath = "//*[@id='mat-autocomplete-1']")
	WebElement episodeItemList;
	
	@FindBy(xpath = "//*[@id='mat-autocomplete-5']")
	WebElement episodeItemChildList;
	
	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[11]")
	WebElement deleteBtn;
	
	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[9]")
	WebElement invoiceDeleteBtn;
	
	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[21]")
	WebElement childDeleteBtn;
	//span[@class='mat-mdc-button-touch-target']
	
	@FindBy(xpath = "/html/body/app-root/app-main-layout/mat-drawer-container/mat-drawer-content/div[2]/div[2]/app-patient-layout/div/div[2]/app-patient-estimate-crud/form/div[3]/div[1]/button[2]/span[2]")
	WebElement saveBtn;
	
	@FindBy(xpath = "/html/body/app-root/app-main-layout/mat-drawer-container/mat-drawer-content/div[2]/div[2]/app-patient-layout/div/div[2]/app-patient-estimate-crud/form/div[4]/div[1]/button[2]/span[2]")
	WebElement childSaveBtn;
	
	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[26]")
	WebElement floppySaveBtn;

	@FindBy(xpath = "/html/body/app-root/app-main-layout/mat-drawer-container/mat-drawer-content/div[2]/div[2]/app-patient-layout/div/div[2]/app-patient-estimate-crud/form/div[2]/div/div[5]/div[1]/div/div/div[1]/button/span[2]")
	WebElement createInvoiceBtn;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	WebElement createInvoiceYesBtn;

	@FindBy(xpath = "//span[contains(text(),'Add Estimate')]")
	WebElement addEstimateBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Pay')]")
	WebElement payBtn;
	

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

	public String validateaddPatientPageURL() {
		String currentURL = driver.getCurrentUrl();
		System.out.println("The Current URL of the page is---> " + currentURL);
		return driver.getCurrentUrl();
	}

	public void createNewEstimate() throws InterruptedException  {
		TestUtil.scrollIntoView(menutab, driver);
		TestUtil.waitUntilElementVisible(menutab);
		TestUtil.waitForElement(menutab, Duration.ofSeconds(30), Duration.ofSeconds(2));
		((JavascriptExecutor)driver).executeScript("arguments[0].click", menutab);
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

		TestUtil.scrollIntoView(searchInternalProviderBtn, driver);
		searchInternalProviderBtn.click();
		searchInternalProviderTab.sendKeys(internalProviderQuery);
		TestUtil.waitUntilElementVisible(searchInternalProviderList);
		try {
			WebElement searchInternalProviderOption = searchInternalProviderList
					.findElement(By.xpath("//span[contains(text(),'" + internalProviderQuery + "')]"));
			// Click on the desired user
			searchInternalProviderOption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out
					.println("Desired internal provider '" + internalProviderQuery + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException(
					"Desired internal provider '" + internalProviderQuery + "' not found in search results.");
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
			System.out.println("Desired entity '" + entityListName + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired entity '" + entityList + "' not found in search results.");
			// throw an exception to fail the test case
		}

		TestUtil.scrollIntoView(accountHolderBtn, driver);
		accountHolderBtn.click();
		TestUtil.waitUntilElementVisible(accountHolderList);
		try {
			WebElement accholdertoption = accountHolderList
					.findElement(By.xpath("//span[contains(text(),'" + accHolderName + "')]"));
			// Click on the desired user
			accholdertoption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired acc holder '" + accHolderName + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired acc holder '" + accHolderName + "' not found in search results.");
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
		Thread.sleep(2000);
		saveBtn.click();
		//createInvoiceBtn.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", createInvoiceBtn);
		createInvoiceYesBtn.click();
		
	}

	public void createMoreEstimate() throws InterruptedException {

		FinancePage obj = new FinancePage(); // creating obj of that page
		obj.createNewEstimate(); // calling method of same class
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", addEstimateBtn);
		Thread.sleep(1000);
		TestUtil.scrollIntoView(searchInternalProviderChildBtn, driver);
		searchInternalProviderChildBtn.click();
		searchInternalProviderChildTab.sendKeys(internalProviderQuery);
		TestUtil.waitUntilElementVisible(searchInternalProviderChildList);
		try {
			WebElement searchInternalProviderOption = searchInternalProviderChildList
					.findElement(By.xpath("//span[contains(text(),'" + internalProviderQuery + "')]"));
			// Click on the desired user
			searchInternalProviderOption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out
					.println("Desired internal provider '" + internalProviderQuery + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException(
					"Desired internal provider '" + internalProviderQuery + "' not found in search results.");
			// throw an exception to fail the test case
		}
		Thread.sleep(1000);
		TestUtil.scrollIntoView(entityChildBtn, driver);
		entityChildBtn.click();
		TestUtil.waitUntilElementVisible(entityChildList);
		try {
			WebElement entitytoption = entityChildList
					.findElement(By.xpath("//span[contains(text(),'" + entityListName + "')]"));
			// Click on the desired user
			entitytoption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired entity '" + entityListName + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired entity '" + entityList + "' not found in search results.");
			// throw an exception to fail the test case
		}

		TestUtil.scrollIntoView(accountHolderChildBtn, driver);
		accountHolderChildBtn.click();
		TestUtil.waitUntilElementVisible(accountHolderChildList);
		try {
			WebElement accholdertoption = accountHolderChildList
					.findElement(By.xpath("//span[contains(text(),'" + accHolderName + "')]"));
			// Click on the desired user
			accholdertoption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired acc holder '" + accHolderName + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired acc holder '" + accHolderName + "' not found in search results.");
			// throw an exception to fail the test case
		}

		TestUtil.scrollIntoView(episodeItem, driver);
		episodeItem.click();
		searchEpisodeChildTab.sendKeys(childsearchListQuery);
		TestUtil.waitUntilElementVisible(episodeItemChildList);
		try {
			WebElement episodeOption1 = episodeItemChildList
					.findElement(By.xpath("//span[contains(text(),'" + episodeListName2 + "')]"));
			// Click on the desired user
			Thread.sleep(1000);
			episodeOption1.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired MBS '" + episodeListName2 + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired MBS '" + episodeListName2 + "' not found in search results.");
			// throw an exception to fail the test case
		}
		childDeleteBtn.click();
		floppySaveBtn.click();
		floppySaveBtn.click();
		Thread.sleep(1000);
		//((JavascriptExecutor)driver).executeScript("arguments[0].click", floppySaveBtn);
		childSaveBtn.click(); 
		
	}
	
	public void createInvoice() throws InterruptedException{
		TestUtil.scrollIntoView(menutab, driver);
		TestUtil.waitUntilElementVisible(menutab);
		TestUtil.waitForElement(menutab, Duration.ofSeconds(30), Duration.ofSeconds(2));
		((JavascriptExecutor)driver).executeScript("arguments[0].click", menutab);
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
		newInvoiceBtn.click();
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

		TestUtil.scrollIntoView(searchInternalProviderBtn, driver);
		searchInternalProviderBtn.click();
		searchInternalProviderTab.sendKeys(internalProviderQuery);
		TestUtil.waitUntilElementVisible(searchInternalProviderList);
		try {
			WebElement searchInternalProviderOption = searchInternalProviderList
					.findElement(By.xpath("//span[contains(text(),'" + internalProviderQuery + "')]"));
			// Click on the desired user
			searchInternalProviderOption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out
					.println("Desired internal provider '" + internalProviderQuery + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException(
					"Desired internal provider '" + internalProviderQuery + "' not found in search results.");
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
			System.out.println("Desired entity '" + entityListName + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired entity '" + entityList + "' not found in search results.");
			// throw an exception to fail the test case
		}

		TestUtil.scrollIntoView(accountHolderBtn, driver);
		accountHolderBtn.click();
		TestUtil.waitUntilElementVisible(accountHolderList);
		try {
			WebElement accholdertoption = accountHolderList
					.findElement(By.xpath("//span[contains(text(),'" + accHolderName + "')]"));
			// Click on the desired user
			accholdertoption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired acc holder '" + accHolderName + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired acc holder '" + accHolderName + "' not found in search results.");
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
		invoiceDeleteBtn.click();
		Thread.sleep(2000);
		saveBtn.click();	
	}
	
	
}
