package starHealthScenario2;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class StarHealthTest{
	WebDriver driver=new ChromeDriver();
	StarHealthPage hp=new StarHealthPage(driver);
	ExtentReports reports;
	ExtentTest extentTest;
	@BeforeClass
	public void openBrowser() {
		reports=new ExtentReports();
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter("report.html");
		reports.attachReporter(sparkreporter);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.starhealth.in/");
	}
	
	@Test(priority = 1)
	public void validateAltValueofLogo() {
		String actual= hp.getAltText();
		String expected="Star Health Logo";
		Assert.assertEquals(actual, expected);
		extentTest=reports.createTest("Test 1");
		extentTest.pass("Test Passed Successfully");
		
	}
	
	@Test(priority = 2)
	public void clickOnMyFamily() throws InterruptedException {
		hp.hoverOnPlans(driver);
		Thread.sleep(1000);
		hp.clickOnForMyFamily();
		Thread.sleep(1000);
		extentTest=reports.createTest("Test 2");
		extentTest.pass("Test Passed Successfully");
		
	}
	
	@Parameters({"Name","Mobile","pin"})
	@Test(priority=3)
	public void enter_user_details(String Name, String Mobile, String pin)
	{
		driver.findElement(By.id("name")).sendKeys(Name);
		driver.findElement(By.id("phoneNumber")).sendKeys(Mobile);
		driver.findElement(By.id("pinCode")).sendKeys(pin);
		
		// click on get quite button
		driver.findElement(By.xpath("//*[@id=\"get-quotes-form\"]/div/div[3]/div/div[2]/div/button/span[1]")).click();
		
		extentTest=reports.createTest("Test 3");
		extentTest.pass("Test Passed Successfully");
		
	}
	
	@Test(priority=4,dataProvider = "testdata")
	public void navigate_back(String expectedname, String expectedphone,String expectedpin ) throws InterruptedException
	{
		driver.navigate().back();
		Thread.sleep(1500);
	
	String actualname =	driver.findElement(By.id("name")).getText();
	Assert.assertEquals(actualname, expectedname);
	
	String actualphone =	driver.findElement(By.id("phoneNumber")).getText();
	Assert.assertEquals(actualphone, expectedphone);

	String actualpin =	driver.findElement(By.id("pinCode")).getText();
	Assert.assertEquals(actualpin, expectedpin);
		
	extentTest=reports.createTest("Test 4");
	extentTest.pass("Test Passed Successfully");
	
		
	}
	
	@DataProvider(name="testdata")
	public   Object[][] datasupply() throws FileNotFoundException
	{
		// get the data from excel sheet 
		
		Object[][] inputdata = Xls_DataProvider.getTestData("Sheet1");
		
		return inputdata;
		
	}
	@AfterClass
	public void closeBrowser() throws IOException {
		reports.flush();
		
		Desktop.getDesktop().browse(new File("report.html").toURI());
		driver.quit();
	}
	
}
