package com.ninjas.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninjas.qa.base.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myaccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath = " //a[normalize-space()='Login']")
	WebElement login;
	
	@FindBy(xpath = "//a[@id='wishlist-total']//i[@class='fa fa-heart']")
	WebElement wishlist;
	
	@FindBy(xpath = "//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']")
	WebElement shoppingcart;
	
	// we create a constructor of the current class to initiate these above objects and pass them to driver object
	// In every page class we have to write the below code
	
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	// Write the code to perform actions on each of these above page objects
	
	public void gettitle()
	{
		System.out.println(driver.getTitle());
	}
	
	
	public void ClickonMyAccount()
	{
		myaccount.click();
	}
	
	public void ClickonLogin()
	{
		login.click();
	}
	
	public void ClickonRegister()
	{
		register.click();
	}
	
	public void Clickonwishlist()
	{
		wishlist.click();
	}
	
	public void Clickonshoppingcart()
	{
		shoppingcart.click();
	}
	
	
	
}
