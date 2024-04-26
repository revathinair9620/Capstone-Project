package com.capstone.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.capstone.qa.base.TestBase;
import com.capstone.qa.util.TestUtil;

public class AddPatientPage extends TestBase {
	// 1. Locators: OR
	@FindBy(xpath = "//mat-icon[contains(text(),'menu_open')]")
	WebElement menutab;

	@FindBy(xpath = "//div[@class='main-menu-name ng-star-inserted' and contains(text(),'Search')]")
	WebElement searchmenu;

	@FindBy(xpath = "//span[contains(text(),'Add patient')]")
	WebElement addpatientmenu;

	@FindBy(xpath = "//*[@id=\"mat-select-4-panel\"]")
	WebElement title;

	@FindBy(xpath = "//*[@id=\"mat-input-4\"]")
	WebElement firstname;
	
	@FindBy(xpath = "//*[@id=\"mat-input-5\"]")
	WebElement lastname;


	// Initializing the Page Objects:
	public AddPatientPage() {
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

	public void enterPatientDetails() throws InterruptedException {
		TestUtil.waitUntilElementVisible(menutab);
		Thread.sleep(1000);
		menutab.click();
		searchmenu.click();
		addpatientmenu.click();

		/*
		 * Select patientTitle = new Select(title);
		 * patientTitle.selectByVisibleText("Mrs");
		 */
		/*
		 * title.click();
		 * 
		 * TestUtil.waitUntilElementVisible(title);
		 * title.findElement(By.xpath("\"//span[text()='Mr']\"")).click();
		 */

		TestUtil.waitUntilElementVisible(firstname);
		firstname.sendKeys("April");
		TestUtil.waitUntilElementVisible(lastname);
		lastname.sendKeys("M");
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].value='Revathi';", firstname);
		 */

	}
}
