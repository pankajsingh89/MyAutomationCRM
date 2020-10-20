package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page factory

	@FindBy(xpath = "//span[text()='Log In']")
	WebElement loginbtn;

	@FindBy(name = "email")
	WebElement emailEditText;

	@FindBy(name = "password")
	WebElement passwordEditText;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement submitBtn;

	@FindBy(className = "header item")
	WebElement logo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMLogo() {
		return logo.isDisplayed();
	}

	public HomePage loginCRM(String uName, String uPass) {
		emailEditText.sendKeys(uName);
		passwordEditText.sendKeys(uPass);
		submitBtn.click();

		return new HomePage();
	}
}
