package com.ninjas.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninjas.qa.base.BaseClass;

public class SearchPage extends BaseClass{
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchBox;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement searchbutton;

	@FindBy(xpath = "//a[normalize-space()='iMac']")
	WebElement productlink;
	
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement productaddtocart;
	
	public SearchPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void SearchProduct(String product)
	{
		searchBox.sendKeys(product);
		searchbutton.click();
		
	}
	
	public void selectProduct()
	{
		productlink.click();
		
	}
	
	public void productaddtocart()
	{
		productaddtocart.click();
		
	}
	
	
}
