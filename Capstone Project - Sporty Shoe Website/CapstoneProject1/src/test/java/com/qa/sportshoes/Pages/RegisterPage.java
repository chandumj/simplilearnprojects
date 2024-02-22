package com.qa.sportshoes.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.sportshoes.base.TestBase;

public class RegisterPage extends TestBase {

	@FindBy(xpath = "/html/body/div[2]/form/button")
	WebElement registerButton;

	@FindBy(xpath = "//input[@id='name']")
	WebElement registerName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement registerEmail;

	@FindBy(xpath = "//input[@id='password']")
	WebElement registerPassword;

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void registerUser() {
		registerName.sendKeys("Chandu");
		registerEmail.sendKeys("chandu@gmail.com");
		registerPassword.sendKeys("Chandu@123");
		Actions a = new Actions(driver);
		a.moveToElement(registerButton).click().build().perform();
	}

	public void validate_url() {
		// TODO Auto-generated method stub
		String expectedURL = "http://localhost:8100/register-user";
		String RegisterPageURL = driver.getCurrentUrl();
		Assert.assertEquals(RegisterPageURL, expectedURL);

	}

}
