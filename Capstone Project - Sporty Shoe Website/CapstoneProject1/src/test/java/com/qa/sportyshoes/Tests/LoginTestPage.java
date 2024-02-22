package com.qa.sportyshoes.Tests;

import org.testng.annotations.Test;

import com.qa.sportshoes.Pages.LoginPage;
import com.qa.sportshoes.base.TestBase;

public class LoginTestPage extends TestBase {

	LoginPage lp;

	@Test(priority = 1)
	public void start_browser() {
		openBrowser();
		lp = new LoginPage(driver);
	}

	@Test(priority = 2)
	public void test_user_login() throws InterruptedException {
		Thread.sleep(1000);
		lp.user_login();
	}

	@Test(priority = 3)
	public void test_validate_loginPage_url() {
		lp.validate_loginPage_url();

	}

}
