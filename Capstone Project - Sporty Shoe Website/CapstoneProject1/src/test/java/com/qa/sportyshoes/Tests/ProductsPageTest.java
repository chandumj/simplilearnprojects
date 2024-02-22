package com.qa.sportyshoes.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.sportshoes.Pages.LoginPage;
import com.qa.sportshoes.Pages.ProductsPage;
import com.qa.sportshoes.base.TestBase;

public class ProductsPageTest extends TestBase {

	LoginPage lp;
	ProductsPage pp;

	@BeforeClass
	public void start_browser() {
		openBrowser();
		lp = new LoginPage(driver);
		pp = new ProductsPage(driver);
	}

	@Test(priority = '1')
	public void test_user_login() throws InterruptedException {
		Thread.sleep(1000);
		lp.user_login();
	}

	@Test(priority = '2')
	public void test_product_addtoCart() throws InterruptedException {
		Thread.sleep(1000);
		pp.click_addtoCart();

	}

	@Test(priority = '3')
	public void test_HomeBTN() throws InterruptedException {
		Thread.sleep(1000);
		pp.click_homebtn();
	}

	@Test(priority = '4')
	public void test_CartBTN() throws InterruptedException {
		Thread.sleep(1000);
		pp.click_cartbtn();
	}

	@Test(priority = '5')
	public void test_placeorderBTN() throws InterruptedException {
		Thread.sleep(1000);
		pp.click_placeorder();
	}

	@Test(priority = '6')
	public void test_orders() throws InterruptedException {
		Thread.sleep(1000);
		pp.click_homebtn();
		pp.click_Ordersbtn();
	}

	@Test(priority = '7')
	public void test_logout() throws InterruptedException {
		Thread.sleep(1000);
		pp.click_Logoutbtn();
	}

	@AfterClass
	public void tearDown() {
		closebrowser();
	}

}
