package eLearningProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestELearning {
	// write a test case with an assumption that we have a login button on the
		// https://www.simplilearn.com/ portal
		
		@Test
		public void testelearning()
		{
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get("https://www.simplilearn.com/");
			String actualtitle = driver.getTitle();
			
			String expectedttile = "Simplilearn | Online Courses - Bootcamp & Certification Platform";
			
			Assert.assertEquals(actualtitle, expectedttile);
			
			
			// developer will write locator for login button with an assumption of attribites will be same in the code
			
			driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
			
			String actualtitlePage = driver.getTitle();
			
			// correct the code and test case will pass
			
			String expectedtitlepage = "Login | Learning on Simplilearn";
			
			Assert.assertEquals(actualtitlePage, expectedtitlepage);
			
			driver.close();
		}

}
