package com.capstone.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capstone.qa.base.TestBase;
import com.capstone.qa.pages.AddPatientPage;
import com.capstone.qa.pages.LoginPage;
import com.capstone.qa.pages.UserDashBoardPage;

public class AddPatientPageTest extends TestBase {

	LoginPage loginPage;
	UserDashBoardPage userDashBoardPage;
	AddPatientPage addPatientPage;

	public AddPatientPageTest() {
		super(); // call the test base class constructor
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		userDashBoardPage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		addPatientPage = new AddPatientPage();
	}

	@Test
	public void patientDetailsTab() throws InterruptedException {
			addPatientPage.enterPatientDetails();
			addPatientPage.validateaddPatientPageTitle();
			addPatientPage.validateaddPatientPageURL();
		

	}

}
