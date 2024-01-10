package PracticeProject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoItScript {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
   
		driver.get("https://www.remove.bg/");
		
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		// wait until the given condition is satisfied
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='prism'])[1]/descendant::button")));
		
		WebElement e1 = driver.findElement(By.xpath("(//div[@class='prism'])[1]/descendant::button"));
		
		e1.click();
		
		
		// selenium to run the autoID compiled script
		
		Runtime.getRuntime().exec("\"F:\\MPHASIS Practice Exersie\\AUTO IT Scripts\\script1.exe\"");
		
		
		
	}
}
