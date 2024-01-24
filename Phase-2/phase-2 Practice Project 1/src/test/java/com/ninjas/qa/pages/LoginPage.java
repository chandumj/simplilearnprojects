package com.ninjas.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninjas.qa.base.BaseClass;

public class LoginPage extends BaseClass{
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement pswd;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement login;
	
      public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

      
      // Login with Valid credentials
      
      public void loginappValidCredentials(String emailid, String password)
      {
    	  email.sendKeys(emailid);
    	  pswd.sendKeys(password);
    	  login.click();
    	  
      }
      
      public void loginappInValidCredentials(String emailid, String password) throws InterruptedException
      {
    	  email.sendKeys(emailid);
    	  pswd.sendKeys(password);
    	  login.click();
    	  Thread.sleep(2000);
    	  
      }
      
}
