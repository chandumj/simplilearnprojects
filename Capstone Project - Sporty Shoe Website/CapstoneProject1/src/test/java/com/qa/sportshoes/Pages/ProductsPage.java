package com.qa.sportshoes.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	@FindBy(xpath = "//*[@id='cart101']")
	WebElement addtocartBTN;

	@FindBy(linkText = "Home")
	WebElement HomeBTN;

	@FindBy(linkText = "Cart")
	WebElement CartBTN;

	@FindBy(xpath = "//*[@id='place-order']")
	WebElement placeOrderBTN;

	@FindBy(linkText = "Orders")
	WebElement OrdersBTN;

	@FindBy(linkText = "Logout")
	WebElement logoutBTN;

	JavascriptExecutor executor;

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		executor = (JavascriptExecutor) driver;
	}

	public void click_addtoCart() {
		executor.executeScript("arguments[0].click();", addtocartBTN);
	}

	public void click_homebtn() {
		HomeBTN.click();
	}

	public void click_cartbtn() {
		CartBTN.click();
	}

	public void click_placeorder() {
		executor.executeScript("arguments[0].click();", placeOrderBTN);
	}

	public void click_Ordersbtn() {
		OrdersBTN.click();
	}

	public void click_Logoutbtn() {
		logoutBTN.click();
	}

}
