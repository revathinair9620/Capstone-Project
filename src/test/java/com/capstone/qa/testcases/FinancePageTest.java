package com.capstone.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capstone.qa.base.TestBase;
import com.capstone.qa.pages.FinancePage;
import com.capstone.qa.pages.LoginPage;
import com.capstone.qa.pages.UserDashBoardPage;

public class FinancePageTest extends TestBase {
	LoginPage loginPage;
	UserDashBoardPage userDashBoardPage;
	FinancePage financePage;

	public FinancePageTest() {
		super(); // call the test base class constructor
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		userDashBoardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		financePage = new FinancePage();
	}

	@Test
	public void performValidEstimateandInvoiceCreation() throws InterruptedException {
		financePage.createNewEstimate();
		quitAndRelaunchBrowser();
		financePage.createMoreEstimate();
		quitAndRelaunchBrowser();
		financePage.createEstimateWithNoDate();
		quitAndRelaunchBrowser();
		financePage.takePaymentWithDateAndDeleteEstimatewithPayment();
		quitAndRelaunchBrowser();
		financePage.takePaymentWithDateAndDeleteEstimatewithNoPayment();

		/*
		 * financePage.validateaddPatientPageURL();
		 * financePage.validateaddPatientPageTitle();
		 */

	}

	@Test
	public void performAddEstimate() throws InterruptedException {
		financePage.createMoreEstimate();

	}

	@Test
	public void performNewInvoice() throws InterruptedException {
		//financePage.createInvoice();
		//financePage.takePaymentWithDateAndDeleteInvoicewithPayment();
		financePage.createInvoicewithDateAndDeleteInvoicewithNoPayment();

	}

	@Test
	public void performwebTable() throws InterruptedException {
		financePage.webTable();

	}

	@Test
	public void estimateCreationWithNoDate() throws InterruptedException {
		financePage.createEstimateWithNoDate();

	}

	@Test
	public void performTakePaymentWithDateAndDeleteEstimatewithPayment() throws InterruptedException {
		financePage.takePaymentWithDateAndDeleteEstimatewithPayment();

	}

	@Test
	public void performTakePaymentWithDateAndDeleteEstimatewithNoPayment() throws InterruptedException {
		financePage.takePaymentWithDateAndDeleteEstimatewithNoPayment();
	}

	private void quitAndRelaunchBrowser() {
	    driver.quit();
	    initialization();
	    loginPage = new LoginPage();
		userDashBoardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		financePage = new FinancePage();// Assuming initialization() method is responsible for launching the browser again
	}
	
	
	 @Test
	    public void emailValidation() throws InterruptedException {
		 Thread.sleep(1000);
	       driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
	       driver.findElement(By.id("email-input")).sendKeys("password");
	       driver.findElement(By.id("password-input")).sendKeys("11");
	       driver.findElement(By.id("login-button")).click();
	WebElement msg=driver.findElement(By.xpath("//div[@class='validation error']"));
	String actualMessage= msg.getText();
	String expectedMessage="Enter a valid email";
	Assert.assertEquals(actualMessage, expectedMessage);


	    }
	/*
	 * @AfterMethod public void teardown() { driver.quit(); }
	 */

}
