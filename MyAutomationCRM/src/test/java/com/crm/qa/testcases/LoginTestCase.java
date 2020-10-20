package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginTestCase extends TestBase {

	public LoginPage objLoginPage;

	public LoginTestCase() {
		super();
	}

	@BeforeTest
	public void setUp() {
		intialization();
	}

	@Test
	public void validateLoginPageTitleTest() {
		objLoginPage = new LoginPage();
		String titleName=objLoginPage.validateLoginPageTitle();
		Assert.assertEquals(titleName, "Cogmento CRM");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
