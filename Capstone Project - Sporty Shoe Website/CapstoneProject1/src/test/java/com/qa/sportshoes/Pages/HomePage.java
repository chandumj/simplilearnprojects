package com.qa.sportshoes.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.sportshoes.base.TestBase;

public class HomePage extends TestBase {

	// driver.findElement(localtor).methods

	// @FindBy(loacatorname="value")
	// WebElement name;

	@FindBy(linkText = "New User? Register Here")
	WebElement registerlink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// action methods

	public void getURL_page() {
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
	}

	public void Click_registerlink() {
		registerlink.click();
	}

}
