package phase1endproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSignInPage {
public static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
   
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(1500);
		
		AmazonSignInPage test=new AmazonSignInPage(driver);
		test.navigateToSignInPage();
		test.SignIn("chandumj787013@gmail.com", "Chandu@123");
		String mssg=test.getMessage();
		
		System.out.println(mssg);
		driver.quit();


		
	}

}
