package com.qa.sportyshoes.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.sportshoes.Pages.HomePage;
import com.qa.sportshoes.Pages.RegisterPage;
import com.qa.sportshoes.base.TestBase;

public class RegisterPageTest extends TestBase {

	HomePage hp;
	RegisterPage rp;

	@BeforeClass
	public void OpenBrowser() {
		openBrowser();

		hp = new HomePage(driver);
		rp = new RegisterPage(driver);

	}

	@Test(priority = '1')
	public void test_click_registerLink() throws InterruptedException {
		Thread.sleep(1500);
		hp.Click_registerlink();
	}

	@Test(priority = '2')
	public void test_register_user() {
		rp.registerUser();
	}

	@Test(priority = '3')
	public void test_newUser_url() {
		rp.validate_url();
	}

}
