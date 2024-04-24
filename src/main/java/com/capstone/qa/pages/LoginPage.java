package com.capstone.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capstone.qa.base.TestBase;
import com.capstone.qa.util.TestUtil;

public class LoginPage extends TestBase {

	// 1. Locators: OR
		@FindBy(xpath = "//input[@id='mat-input-0']")
		WebElement email;
		@FindBy(xpath = "//input[@id='mat-input-1']")
		WebElement password;
		@FindBy(xpath = "//span[contains(text(),'Login')]")
		WebElement loginbtn;
		@FindBy(xpath = "//*[@id=\"mat-radio-3-input\"]")
		WebElement emailotpraidobtn;
		@FindBy(xpath = "//span[contains(text(),'Send')]")
		WebElement sendbtn;
		@FindBy(xpath = "//span[contains(text(),'Submit')]")
		WebElement submitbtn;


	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		String title= driver.getTitle();
		System.out.println("The title of the current page is --->" +title);
		return title;
	}
	
	public UserDashBoardPage login(String un, String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		emailotpraidobtn.click();
		TestUtil.waitUntilElementClickable(sendbtn);
		sendbtn.click();
		TestUtil.waitUntilElementClickable(submitbtn);
		submitbtn.click();
		return new UserDashBoardPage();	
	}
	
	

	
	

}
