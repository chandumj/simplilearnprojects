package com.qa.sportshoes.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.sportshoes.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//*[@id='email']")
	WebElement loginEmail;

	@FindBy(xpath = "//*[@id='password']")
	WebElement LoginPassword;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement LoginBtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void user_login() {
		loginEmail.sendKeys("chandu@gmail.com");
		LoginPassword.sendKeys("Chandu@123");
		LoginBtn.click();
	}

	public void validate_loginPage_url() {
		String expectedURL = "http://localhost:8100/login";
		String RegisterPageURL = driver.getCurrentUrl();
		Assert.assertEquals(RegisterPageURL, expectedURL);
	}

}
