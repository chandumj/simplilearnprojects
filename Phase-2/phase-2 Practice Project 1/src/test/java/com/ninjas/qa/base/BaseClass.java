package com.ninjas.qa.base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	// add the code to generate extent report
	
		public static ExtentReports ex;
		public static WebDriver driver ;
		public static  ExtentTest extentTest;
		
		
		public void openBrowser()
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();	
			driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		}
		
		@BeforeSuite  // this will the first method exeucted before the suite of test cases run
		public void InitializeExtentReport() throws IOException
		{
			 ex = new ExtentReports();
			 ExtentSparkReporter sparkreporter = new ExtentSparkReporter("projectReport.html");
			 ex.attachReporter(sparkreporter);
			 ex.setSystemInfo("OS", System.getProperty("os.name"));
			 ex.setSystemInfo("JAVA", System.getProperty("os.name"));
			 ex.setSystemInfo("Browser","Chrome");
			 ex.setSystemInfo("SprintTest","Sprint1");	
			
		}
		
		
		@AfterSuite
		public void generateReports() throws IOException
		{
			ex.flush();
			Desktop.getDesktop().browse(new File("projectReport.html").toURI());
			
		}
		
		@BeforeTest // this method will execute before the tests in the runner file begin
		public void getNameMethod(ITestContext context)
		{
			extentTest = ex.createTest(context.getName());
		}
		@AfterTest
		public void closeBrowser() {
			driver.quit();
		}
		
		@AfterMethod
		public void generateTestStatus(Method m,ITestResult result)
		
		{
			if(result.getStatus() == ITestResult.FAILURE)
			{
				System.out.println("capture Screenshot");
				extentTest.fail(result.getThrowable());
			}
			else if (result.getStatus() == ITestResult.FAILURE)
			{
				extentTest.pass(m.getName() + "is passed");
			}
			
		}

}
