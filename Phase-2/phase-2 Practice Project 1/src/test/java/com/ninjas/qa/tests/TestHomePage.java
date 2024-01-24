package com.ninjas.qa.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ninjas.qa.base.BaseClass;
import com.ninjas.qa.pages.HomePage;

public class TestHomePage extends BaseClass{
 
	HomePage hp;
	
	@BeforeClass
	public void openApp()
	{
		openBrowser();
		hp = new HomePage(driver);
	}
	
	@Test(testName="title",priority='1')
	public void test_homepagegettitle()
	{
		hp.gettitle();
		extentTest.pass("Test Passed");
	}
	
	
	@Test(testName="myaccount", priority='2')
	public void test_ClickonMyAccount()
	{
		hp.ClickonMyAccount();
		System.out.println(driver.getTitle());
		extentTest.pass("Test Passed");
	}
	

	@Test(testName="loginlink", priority='3')
	public void test_ClickonLogin()
	{
		hp.ClickonLogin();
		System.out.println(driver.getTitle());
		extentTest.pass("Test Passed");
	}
	
	

	@Test(testName="registerpage",priority='4')
	public void test_ClickonRegister() throws InterruptedException
	{
		hp.ClickonMyAccount();
		Thread.sleep(1000);
		hp.ClickonRegister();
		System.out.println(driver.getTitle());
		extentTest.pass("Test Passed");
	}
	

	@Test(testName="wishlist",priority='5')
	public void test_ClickonWishlist()
	{
		hp.Clickonwishlist();
		System.out.println(driver.getTitle());
		extentTest.pass("Test Passed");
	}
	
	@Test(testName="cart" , priority='6')
	public void test_ClickonShoppingcart()
	{
		hp.Clickonshoppingcart();
		System.out.println(driver.getTitle());
		extentTest.pass("Test Passed");
	}
	
	
	
}
