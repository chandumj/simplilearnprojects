package com.ninjas.qa.tests;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ninjas.qa.base.BaseClass;
import com.ninjas.qa.utilities.Xls_DataProvider;

public class TestRegisterPage extends BaseClass{

public static WebDriver driver;
	
	@BeforeClass
	public void openBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
		
	}
	// Test method which should get data from excel sheet
	
	@Test(dataProvider = "testdata")
	public void register_user(String username, String lastName, String email, String telephone, String password, String confirm ) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='input-firstname']")).clear();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys(lastName);
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-telephone']")).clear();
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(telephone);
		driver.findElement(By.xpath("//input[@id='input-password']")).clear();
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='input-confirm']")).clear();
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(confirm);
		
		Thread.sleep(1500);
	}
	
	// We now have a testNG annotation that supplies test data to @Test method
	
	// the task of @DataProvider annotation is to supply data to test method
	
	@DataProvider(name="testdata")
	public   Object[][] datasupply() throws FileNotFoundException
	{
		// get the data from excel sheet 
		
		Object[][] inputdata = Xls_DataProvider.getTestData("Sheet1");
		
		return inputdata;
		
	}
	
	
	
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}
}
