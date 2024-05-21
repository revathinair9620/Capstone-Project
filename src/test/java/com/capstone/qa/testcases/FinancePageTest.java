package com.capstone.qa.testcases;

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
		financePage.validateaddPatientPageURL();
		financePage.validateaddPatientPageTitle();
			
	}
	
	@Test
	public void performAddEstimate() throws InterruptedException {
		financePage.createMoreEstimate();
		
	}
	
	@Test
	public void performNewInvoice() throws InterruptedException {
		financePage.createInvoice();
		
	}
	
	@Test
	public void performwebTable() throws InterruptedException {
		financePage.webTable();
		
	}
	
	@Test
	public void estimateCreationWithNoDate() throws InterruptedException {
		//financePage.createEstimateWithNoDate();
		financePage.takePaymentWithDate();
		
	}
	
	
}
