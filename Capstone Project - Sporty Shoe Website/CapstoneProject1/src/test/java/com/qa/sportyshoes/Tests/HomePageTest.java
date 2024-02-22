package com.qa.sportyshoes.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.sportshoes.Pages.HomePage;
import com.qa.sportshoes.base.TestBase;

public class HomePageTest extends TestBase {

	HomePage hp;

	@Test(priority = '1')
	public void start_browser() {
		openBrowser();
		hp = new HomePage(driver);
	}

	@Test(priority = '2')
	public void test_getURL_method() {
		hp.getURL_page();
	}

	@Test(priority = '2')
	public void test_registerlink_method() {
		hp.Click_registerlink();
		String expectedURL = "http://localhost:8100/register";
		String RegisterPageURL = driver.getCurrentUrl();
		Assert.assertEquals(RegisterPageURL, expectedURL);
	}

}
