package PracticeProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotScript {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
   
		driver.get("https://www.opera.com/download");
				
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		File destFile = new File("./Screenshot/opera1.png");
		
		FileUtils.copyFile(srcFile, destFile);
		
		
	}
}
