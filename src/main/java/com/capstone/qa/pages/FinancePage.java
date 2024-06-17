package com.capstone.qa.pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.capstone.qa.base.TestBase;
import com.capstone.qa.util.TestUtil;

public class FinancePage extends TestBase {

	private String searchQuery = "Sac"; // First three letters entered in the search bar
	private String searchQuerypciClaim = "Sarah BECKER";
	private String desiredUserpciClaimName = "Sarah BECKER";
	private String desiredUserName = "Sachin S"; // Name of the user you want to select
	private String appointmentName = "RevApp - 30-04-2024";
	private String pciClaimAppointmentName = "Surgical Booking - 04-06-2024 - Cary Davidson";
	private String internalProviderQuery = "Cary Davidson";
	private String entityListName = " 12Internal Company ";
	private String accHolderName = " Patient ";
	private String searchListQuery = "31363"; // First three letters entered in the search bar
	private String episodeListName = "31363";
	private String childsearchListQuery = "15518";
	private String episodeListName2 = "15518";
	private String paymentType = "Debit Card";
	private String refundType = "Refund";

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
	
	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	WebElement yesBtn;

	@FindBy(xpath = "//span[contains(text(),'New Estimate')]")
	WebElement newEstimateBtn;

	@FindBy(xpath = "//mat-label[contains(text(),'Appointment')]")
	WebElement appointmentBtn;

	@FindBy(xpath = "//*[@id='mat-select-12-panel']")
	WebElement appointmentList;

	@FindBy(xpath = "//mat-label[contains(text(),'Search Internal Provider')]")
	WebElement searchInternalProviderBtn;

	@FindBy(xpath = "(//mat-label[contains(text(),'Search Internal Provider')])[2]")
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

	@FindBy(xpath = "/html/body/app-root/app-main-layout/mat-drawer-container/mat-drawer-content/div[2]/div[2]/app-patient-layout/div/div[2]/app-patient-estimate-crud/form/div[3]/div[1]/button[2]/span[2]")
	WebElement saveBtn;

	@FindBy(xpath = "/html/body/app-root/app-main-layout/mat-drawer-container/mat-drawer-content/div[2]/div[2]/app-patient-layout/div/div[2]/app-patient-estimate-crud/form/div[4]/div[1]/button[2]/span[2]")
	WebElement childSaveBtn;

	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[26]")
	WebElement floppySaveBtn;

	@FindBy(xpath = "/html/body/app-root/app-main-layout/mat-drawer-container/mat-drawer-content/div[2]/div[2]/app-patient-layout/div/div[2]/app-patient-estimate-crud/form/div[2]/div/div[5]/div[1]/div/div/div[1]/button/span[2]")
	WebElement createInvoiceBtn;

	@FindBy(xpath = "//span[contains(text(),'Add Invoice')]")
	WebElement addInvoiceBtn;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	WebElement createInvoiceYesBtn;

	@FindBy(xpath = "//span[contains(text(),'Add Estimate')]")
	WebElement addEstimateBtn;

	@FindBy(xpath = "//span[contains(text(),'Pay')]")
	WebElement payBtn;

	@FindBy(xpath = "//*[@id=\"mat-mdc-dialog-13\"]/div/div/app-pay-modal/div/mat-dialog-content/form/div[1]/mat-form-field[1]/div[1]/div/div[3]/mat-datepicker-toggle/button/span[4]")
	WebElement datepickerBtn;

	@FindBy(xpath = "//*[@id='mat-select-value-25']")
	WebElement payTypeBtn;

	@FindBy(xpath = "//*[@id='mat-select-24-panel']")
	WebElement payTypeList;

	@FindBy(xpath = "//*[@id=\"mat-mdc-dialog-13\"]/div/div/app-pay-modal/div/mat-dialog-actions/div/div/button[2]/span[5]")
	WebElement confirmBtn;

	@FindBy(xpath = "/html/body/app-root/app-main-layout/mat-drawer-container/mat-drawer-content/div[2]/div[2]/app-patient-layout/div/div[2]/app-patient-estimate-crud/form/div[2]/div/div[2]/div/div[2]/div/button/span[4]")
	WebElement estimateActionDeleteBtn;

	@FindBy(xpath = "//p[contains(text(),'Unable to delete. Please check if transaction exists')]")
	WebElement transactionErrorMessage;

	@FindBy(xpath = "//*[@id=\"mat-mdc-dialog-15\"]")
	WebElement errorDialogBox;

	@FindBy(xpath = "//*[@id=\"mat-mdc-dialog-15\"]/div/div/app-generic-confirm-modal/mat-dialog-actions/button/span[2]")
	WebElement okBtn;

	@FindBy(xpath = "//*[@id=\"mat-mdc-dialog-16\"]")
	WebElement invoiceErrorDialogBox;

	@FindBy(xpath = "//*[@id='mat-mdc-dialog-16']/div/div/app-generic-confirm-modal/mat-dialog-actions/button/span[2]")
	WebElement invoiceErrorDialogBoxokBtn;

	@FindBy(xpath = "/html/body/app-root/app-main-layout/mat-drawer-container/mat-drawer-content/div[2]/div[2]/app-patient-layout/div/div[2]/app-patient-estimate-crud/form/div[2]/div/div[2]/div/div[2]/div/div")
	WebElement okadjustmentBtn;

	@FindBy(xpath = "//*[@id=\"mat-mdc-dialog-31\"]/div/div/app-adjustment-modal")
	WebElement adjustmentDialogBox;

	@FindBy(xpath = "//*[@id='mat-select-value-27']")
	WebElement refundTypeDropDown;

	@FindBy(xpath = "//*[@id='mat-select-26-panel']")
	WebElement refundOptionList;

	@FindBy(xpath = "//*[@id='mat-select-value-29']")
	WebElement paymentTypeDropDown;

	@FindBy(xpath = "//*[@id='mat-select-28-panel']")
	WebElement paymentTypeOptionList;

	@FindBy(xpath = "//*[@id='mat-input-34']")
	WebElement totalAmtBox;

	@FindBy(xpath = "//*[@id='mat-input-32']")
	WebElement reasonBox;

	@FindBy(xpath = "//*[@id=\"mat-mdc-dialog-17\"]/div/div/app-adjustment-modal/div/mat-dialog-actions/div/div/button/span[5]")
	WebElement adjustmentConfirmBtn;

	@FindBy(xpath = "//*[@id='mat-input-28']")
	WebElement deleteReasonBox;

	@FindBy(xpath = "//span[contains(text(),'Delete')]")
	WebElement deleteReasonCloseBtn;

	@FindBy(xpath = "/html/body/app-root/app-main-layout/mat-drawer-container/mat-drawer-content/div[2]/div[2]/app-patient-layout/div/div[2]/app-patient-estimate-crud/form/div[2]/div[2]/div/span")
	WebElement estimateDeletionValidationMsg;

	@FindBy(xpath = "//*[@id='mat-select-26-panel']")
	WebElement childInvoiceAppList;

	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[19]")
	WebElement childInvoiceDeleteBtn;

	@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[23]")
	WebElement childInvoiceFloppySaveBtn;

	@FindBy(xpath = "//*[@id=\"mat-mdc-dialog-15\"]/div/div/app-medicare-claim-confirm-modal/mat-dialog-actions/button[1]/span[2]")
	WebElement medicareClaimCancelBtn;

	@FindBy(xpath = "//*[@id='mat-mdc-checkbox-6-input']")
	WebElement adjustmentCheckbox;

	@FindBy(xpath = "//div[@class= 'increment-decrement-section']")
	WebElement incrementBtn;

	@FindBy(xpath = "//*[@id=\"mat-mdc-dialog-18\"]/div/div/app-adjustment-modal/div/mat-dialog-actions/div/div/button/span[5]")
	WebElement invoiceAdjustmentConfirmBtn;

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

	public void createNewEstimate() throws InterruptedException {
		TestUtil.scrollIntoView(menutab, driver);
		TestUtil.waitUntilElementVisible(menutab);
		TestUtil.waitForElement(menutab, Duration.ofSeconds(30), Duration.ofSeconds(2));
		((JavascriptExecutor) driver).executeScript("arguments[0].click", menutab);
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
		// createInvoiceBtn.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", createInvoiceBtn);
		createInvoiceYesBtn.click();

	}

	/*
	 * Scenario1: Create estimate with date, add child estimate, convert it to
	 * invoice
	 */
	public void createMoreEstimate() throws InterruptedException {

		FinancePage obj = new FinancePage(); // creating obj of that page
		obj.createNewEstimate(); // calling method of same class
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", addEstimateBtn);
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
		// ((JavascriptExecutor)driver).executeScript("arguments[0].click",
		// floppySaveBtn);
		childSaveBtn.click();

	}

	/* Method to validate account history table */
	public void webTable() throws InterruptedException {
		TestUtil.scrollIntoView(menutab, driver);
		TestUtil.waitUntilElementVisible(menutab);
		TestUtil.waitForElement(menutab, Duration.ofSeconds(30), Duration.ofSeconds(2));
		((JavascriptExecutor) driver).executeScript("arguments[0].click", menutab);
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

		// tbody/tr[1]/td[1]
		// tbody/tr[2]/td[1]
		// tbody/tr[3]/td[1]
		// tbody/tr[4]/td[1]
		// tbody/tr[5]/td[1]
		// tbody/tr[6]/td[1]
		// tbody/tr[7]/td[1]
		// handle webtable rows
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//table/tbody/tr"), 1));
		Thread.sleep(2000); // Adjust the delay as needed

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println("Rows found: " + rows.size());
		// prints all the row values
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			StringBuilder rowText = new StringBuilder();

			for (WebElement cell : cells) {
				rowText.append(cell.getText()).append(" ");
			}

			// Print the concatenated row text
			System.out.println(rowText.toString().trim());
			// System.out.println("Row: " + row.getText());
		}

		/*
		 * int rowcount = rows.size(); String beforeXpath = "//tbody/tr["; String
		 * afterXpath = "]/td[1]";
		 * 
		 * for (int i = 1; i <= rowcount; i++) { String actualXpath = beforeXpath + i +
		 * afterXpath; WebElement element = driver.findElement(By.xpath(actualXpath));
		 * System.out.println(element.getText()); }
		 * 
		 * // tbody/tr[1]/td[2] String beforeXpathType = "//tbody/tr["; String
		 * afterXpathType = "]/td[2]";
		 * 
		 * for (int i = 1; i <= rowcount; i++) { String actualXpathType =
		 * beforeXpathType + i + afterXpathType; WebElement element =
		 * driver.findElement(By.xpath(actualXpathType));
		 * System.out.println(element.getText()); }
		 */

		// handle webtable coloums

		// th[contains(text(),'Number')]
		// table[1]/thead[1]/tr[1]/th[1]
		// table[1]/thead[1]/tr[1]/th[2]
		// table[1]/thead[1]/tr[1]/th[3]

		String beforeXpathColoumn = "//table[1]/thead[1]/tr[1]/th[";
		String afterXpathColoum = "]";
		List<WebElement> cols = driver.findElements(By.xpath("//table[1]/thead[1]/tr[1]/th"));
		int colcount = cols.size();
		System.out.println("Total no of column in webtable:" + colcount);

		for (int i = 1; i <= colcount; i++) {

			String actualXpathColoumn = beforeXpathColoumn + i + afterXpathColoum;
			WebElement element = driver.findElement(By.xpath(actualXpathColoumn));
			String colText = element.getText();
			System.out.println("Columns values are:" + colText);

		}

	}

	/*
	 * Scenario 2: Estimate Creation – As part of Estimate creation – No need of any
	 * date Set (either appointment or Enable service Date)
	 */
	public void createEstimateWithNoDate() throws InterruptedException {
		TestUtil.scrollIntoView(menutab, driver);
		TestUtil.waitUntilElementVisible(menutab);
		TestUtil.waitForElement(menutab, Duration.ofSeconds(30), Duration.ofSeconds(2));
		((JavascriptExecutor) driver).executeScript("arguments[0].click", menutab);
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
		saveBtn.click();

	}

	/*
	 * Scenario 3: Taking Deposits (Payment) to against Estimate – Date is required
	 * (either appointment date or Enable service Date) to take a payment.
	 * Void/Delete Estimates
	 * 
	 * when there is a payment;(error msg will be displayed, refund and then delete)
	 */
	public void takePaymentWithDateAndDeleteEstimatewithPayment() throws InterruptedException {
		TestUtil.scrollIntoView(menutab, driver);
		TestUtil.waitUntilElementVisible(menutab);
		TestUtil.waitForElement(menutab, Duration.ofSeconds(30), Duration.ofSeconds(2));
		((JavascriptExecutor) driver).executeScript("arguments[0].click", menutab);
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
		TestUtil.waitForElement(payBtn, Duration.ofSeconds(2000), Duration.ofMillis(500));
		Thread.sleep(2000);
		payBtn.click();
		// Click the date input field to open the calendar widget
		datepickerBtn.click();
		try {
			// Wait for the calendar to be visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id='mat-datepicker-2']/div/mat-month-view/table")));

			// Locate the calendar table
			WebElement calendarTable = driver
					.findElement(By.xpath("//*[@id='mat-datepicker-2']/div/mat-month-view/table"));

			// Select the desired date
			List<WebElement> dates = calendarTable.findElements(By.tagName("td")); // This assumes dates are within <td>
																					// tags
			for (WebElement date : dates) {
				if (date.getText().equals("15")) { // Replace "15" with the desired day
					date.click();
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		payTypeBtn.click();
		TestUtil.waitUntilElementVisible(payTypeList);
		try {
			WebElement paymentTypeoption = payTypeList
					.findElement(By.xpath("//span[contains(text(),'" + paymentType + "')]"));
			// Click on the desired user
			paymentTypeoption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired payment type" + paymentType + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired payment type" + paymentType + "' not found in search results.");
			// throw an exception to fail the test case
		}

		confirmBtn.click();
		Thread.sleep(2000);
		// TestUtil.waitUntilElementVisible(afterPaymentDeleteBtn);
		// TestUtil.waitUntilPageRefresh();
		estimateActionDeleteBtn.click();
		TestUtil.waitUntilElementVisible(errorDialogBox);
		// Validate the error message
		WebElement errorMessageElement = errorDialogBox
				.findElement(By.xpath("//p[contains(text(),'Unable to delete. Please check if transaction exists')]"));
		String actualErrorMessage = errorMessageElement.getText();
		String expectedErrorMessage = "Unable to delete. Please check if transaction exists.";

		if (actualErrorMessage.equals(expectedErrorMessage)) {
			System.out.println("Error message validation passed: " + actualErrorMessage);
		} else {
			System.out.println("Error message validation failed. Expected: " + expectedErrorMessage + ", but got: "
					+ actualErrorMessage);
		}

		okBtn.click();
		okadjustmentBtn.click();

		refundTypeDropDown.click();
		TestUtil.waitUntilElementVisible(refundOptionList);
		try {
			WebElement refundTypeoption = refundOptionList
					.findElement(By.xpath("//span[contains(text(),'" + refundType + "')]"));
			// Click on the desired user
			refundTypeoption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired payment type" + refundType + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired payment type" + refundType + "' not found in search results.");
			// throw an exception to fail the test case
		}

		paymentTypeDropDown.click();
		TestUtil.waitUntilElementVisible(paymentTypeOptionList);
		try {
			WebElement paymentTypeoption = paymentTypeOptionList
					.findElement(By.xpath("//span[contains(text(),'" + paymentType + "')]"));
			// Click on the desired user
			paymentTypeoption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired payment type" + paymentType + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired payment type" + paymentType + "' not found in search results.");
			// throw an exception to fail the test case
		}

		totalAmtBox.clear();
		totalAmtBox.sendKeys("100.00");
		reasonBox.sendKeys("Payed By mistake");
		adjustmentConfirmBtn.click();

	}

	/*
	 * Scenario 4: Taking Deposits (Payment) to against Estimate – Date is required
	 * (either appointment date or Enable service Date) to take a payment.
	 * Void/Delete Estimates
	 * 
	 * when there is no payment
	 */
	public void takePaymentWithDateAndDeleteEstimatewithNoPayment() throws InterruptedException {
		TestUtil.scrollIntoView(menutab, driver);
		TestUtil.waitUntilElementVisible(menutab);
		TestUtil.waitForElement(menutab, Duration.ofSeconds(30), Duration.ofSeconds(2));
		((JavascriptExecutor) driver).executeScript("arguments[0].click", menutab);
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
		Thread.sleep(2000);
		estimateActionDeleteBtn.click();
		deleteReasonBox.sendKeys("Created By mistake");
		deleteReasonCloseBtn.click();
		String msg = estimateDeletionValidationMsg.getText();
		String expectedmsg = "Marked for deletion, click save at the bottom of the screen to apply your changes.";
		Assert.assertEquals(msg, expectedmsg);

		if (expectedmsg.equals(msg)) {
			System.out.println("Error message validation passed: " + msg);
		} else {
			System.out.println("Error message validation failed. Expected: " + expectedmsg + ", but got: " + msg);
		}

		saveBtn.click();

	}

	/* Scenario 5: create invoice, child invoice */
	public void createInvoice() throws InterruptedException {
		TestUtil.scrollIntoView(menutab, driver);
		TestUtil.waitUntilElementVisible(menutab);
		TestUtil.waitForElement(menutab, Duration.ofSeconds(30), Duration.ofSeconds(2));
		((JavascriptExecutor) driver).executeScript("arguments[0].click", menutab);
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
		// TestUtil.waitUntilElementVisible(appointmentBtn);
		Thread.sleep(1000);
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
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", addInvoiceBtn);

		appointmentBtn.click();
		TestUtil.waitUntilElementVisible(childInvoiceAppList);
		try {
			WebElement appointmentoption = childInvoiceAppList
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
		childInvoiceDeleteBtn.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click", childInvoiceFloppySaveBtn);
		childSaveBtn.click();
	}

	/*
	 * Scenario 6: Taking Deposits (Payment) to against Invoice – Date is required
	 * (either appointment date or Enable service Date) to take a payment.
	 * Void/Delete Estimates
	 * 
	 * when there is a payment;(error msg will be displayed, refund and then delete)
	 */
	public void takePaymentWithDateAndDeleteInvoicewithPayment() throws InterruptedException {
		TestUtil.scrollIntoView(menutab, driver);
		TestUtil.waitUntilElementVisible(menutab);
		TestUtil.waitForElement(menutab, Duration.ofSeconds(30), Duration.ofSeconds(2));
		((JavascriptExecutor) driver).executeScript("arguments[0].click", menutab);
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
		Thread.sleep(2000);
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
		TestUtil.waitForElement(payBtn, Duration.ofSeconds(2000), Duration.ofMillis(500));
		Thread.sleep(2000);
		payBtn.click();
		// Click the date input field to open the calendar widget
		datepickerBtn.click();
		try {
			// Wait for the calendar to be visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id='mat-datepicker-2']/div/mat-month-view/table")));

			// Locate the calendar table
			WebElement calendarTable = driver
					.findElement(By.xpath("//*[@id='mat-datepicker-2']/div/mat-month-view/table"));

			// Select the desired date
			List<WebElement> dates = calendarTable.findElements(By.tagName("td")); // This assumes dates are within <td>
																					// tags
			for (WebElement date : dates) {
				if (date.getText().equals("15")) { // Replace "15" with the desired day
					date.click();
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		payTypeBtn.click();
		TestUtil.waitUntilElementVisible(payTypeList);
		try {
			WebElement paymentTypeoption = payTypeList
					.findElement(By.xpath("//span[contains(text(),'" + paymentType + "')]"));
			// Click on the desired user
			paymentTypeoption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired payment type" + paymentType + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired payment type" + paymentType + "' not found in search results.");
			// throw an exception to fail the test case
		}

		confirmBtn.click();
		Thread.sleep(2000);
		medicareClaimCancelBtn.click();
		// TestUtil.waitUntilElementVisible(afterPaymentDeleteBtn);
		// TestUtil.waitUntilPageRefresh();
		Thread.sleep(1000);
		estimateActionDeleteBtn.click();
		TestUtil.waitUntilElementVisible(invoiceErrorDialogBox);
		// Validate the error message
		WebElement errorMessageElement = invoiceErrorDialogBox
				.findElement(By.xpath("//p[contains(text(),'Unable to delete. Please check if transaction exists')]"));
		String actualErrorMessage = errorMessageElement.getText();
		String expectedErrorMessage = "Unable to delete. Please check if transaction exists.";

		if (actualErrorMessage.equals(expectedErrorMessage)) {
			System.out.println("Error message validation passed: " + actualErrorMessage);
		} else {
			System.out.println("Error message validation failed. Expected: " + expectedErrorMessage + ", but got: "
					+ actualErrorMessage);
		}

		invoiceErrorDialogBoxokBtn.click();
		okadjustmentBtn.click();

		refundTypeDropDown.click();
		TestUtil.waitUntilElementVisible(refundOptionList);
		try {
			WebElement refundTypeoption = refundOptionList
					.findElement(By.xpath("//span[contains(text(),'" + refundType + "')]"));
			// Click on the desired user
			refundTypeoption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired payment type" + refundType + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired payment type" + refundType + "' not found in search results.");
			// throw an exception to fail the test case
		}

		paymentTypeDropDown.click();
		TestUtil.waitUntilElementVisible(paymentTypeOptionList);
		try {
			WebElement paymentTypeoption = paymentTypeOptionList
					.findElement(By.xpath("//span[contains(text(),'" + paymentType + "')]"));
			// Click on the desired user
			paymentTypeoption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired payment type" + paymentType + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired payment type" + paymentType + "' not found in search results.");
			// throw an exception to fail the test case
		}
		adjustmentCheckbox.click();
		incrementBtn.click();
		reasonBox.sendKeys("Payed By mistake");
		invoiceAdjustmentConfirmBtn.click();

	}

	/*
	 * Scenario 7:Create invoice – Date is required (either appointment date or
	 * Enable service Date). Void/Delete Estimates
	 * 
	 * when there is no payment
	 */
	public void createInvoicewithDateAndDeleteInvoicewithNoPayment() throws InterruptedException {
		TestUtil.scrollIntoView(menutab, driver);
		TestUtil.waitUntilElementVisible(menutab);
		TestUtil.waitForElement(menutab, Duration.ofSeconds(30), Duration.ofSeconds(2));
		((JavascriptExecutor) driver).executeScript("arguments[0].click", menutab);
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
		Thread.sleep(2000);
		estimateActionDeleteBtn.click();
		deleteReasonBox.sendKeys("Created By mistake");
		deleteReasonCloseBtn.click();
		String msg = estimateDeletionValidationMsg.getText();
		String expectedmsg = "Marked for deletion, click save at the bottom of the screen to apply your changes.";
		Assert.assertEquals(msg, expectedmsg);

		if (expectedmsg.equals(msg)) {
			System.out.println("Error message validation passed: " + msg);
		} else {
			System.out.println("Error message validation failed. Expected: " + expectedmsg + ", but got: " + msg);
		}

		saveBtn.click();

	}

	/*
	 * Scenario 8: PCI claim
	 */
	public void pciClaim() throws InterruptedException {
		TestUtil.scrollIntoView(menutab, driver);
		TestUtil.waitUntilElementVisible(menutab);
		TestUtil.waitForElement(menutab, Duration.ofSeconds(30), Duration.ofSeconds(2));
		((JavascriptExecutor) driver).executeScript("arguments[0].click", menutab);
		menutab.click();
		searchmenu.click();
		searchPatientTab.sendKeys(searchQuerypciClaim);
		TestUtil.waitUntilElementVisible(patientSearchResults);
		try {
			WebElement desiredUser = patientSearchResults.findElement(By.xpath(
					"//div[contains(@class, 'user-name') and contains(text(), '" + desiredUserpciClaimName + "')]"));
			// Click on the desired user
			desiredUser.click();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired user '" + desiredUserpciClaimName + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException(
					"Desired user '" + desiredUserpciClaimName + "' not found in search results.");
			// throw an exception to fail the test case
		}
		financeTab.click();
		newInvoiceBtn.click();
		Thread.sleep(2000);
		TestUtil.waitForElement(appointmentBtn, Duration.ofSeconds(5),Duration.ofMillis(100));
		appointmentBtn.click();
		TestUtil.waitUntilElementVisible(appointmentList);
		try {
			WebElement appointmentoption = appointmentList
					.findElement(By.xpath("//span[contains(text(),'" + pciClaimAppointmentName + "')]"));
			// Click on the desired user
			appointmentoption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired appointment '" + pciClaimAppointmentName + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException(
					"Desired appointment '" + pciClaimAppointmentName + "' not found in search results.");
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
		TestUtil.waitForElement(payBtn, Duration.ofSeconds(2000), Duration.ofMillis(500));
		Thread.sleep(2000);
		payBtn.click();
		// Click the date input field to open the calendar widget
		datepickerBtn.click();
		try {
			// Wait for the calendar to be visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id='mat-datepicker-2']/div/mat-month-view/table")));

			// Locate the calendar table
			WebElement calendarTable = driver
					.findElement(By.xpath("//*[@id='mat-datepicker-2']/div/mat-month-view/table"));

			// Select the desired date
			List<WebElement> dates = calendarTable.findElements(By.tagName("td")); // This assumes dates are within <td>
																					// tags
			for (WebElement date : dates) {
				if (date.getText().equals("13")) { // Replace "15" with the desired day
					date.click();
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		payTypeBtn.click();
		TestUtil.waitUntilElementVisible(payTypeList);
		try {
			WebElement paymentTypeoption = payTypeList
					.findElement(By.xpath("//span[contains(text(),'" + paymentType + "')]"));
			// Click on the desired user
			paymentTypeoption.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("Desired payment type" + paymentType + "' not found in search results.");
			// Handle the case where the desired user is not found
			throw new NoSuchElementException("Desired payment type" + paymentType + "' not found in search results.");
			// throw an exception to fail the test case
		}

		confirmBtn.click();
		
		Thread.sleep(2000);
		yesBtn.click();
		

	}
}
