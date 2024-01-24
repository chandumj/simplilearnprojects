package practiceProject;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {


	WebDriver driver ;
	
	@BeforeEach
	public void setup()
	{
	driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get("https://www.google.com/");
	}
	
	
	@Test
	public void testgooglesearchEngline() throws InterruptedException
	{
	
		driver.findElement(By.xpath("//div[@class='DPXIy']/child::textarea[1]")).sendKeys("Simplilearn");
	
	//Wait for few seconds for the dropdown to be visible
	Thread.sleep(7000);
	
	// Write an XPATH where selenium will fetch all the options in the drop down
	
	// Create a list object that will store the fetched options from the dropdown
	
	List<WebElement> li = driver.findElements(By.xpath("(//div[@role='presentation'])[2]/descendant::li"));
	
	// print the size of the list
	
	System.out.println(li.size());
	
	// iterate over the list of webelement, print them and click on the element that your desire
	
	for(WebElement text: li)
	{
		String elementText = text.getText();
		System.out.println(elementText);
		
		if(elementText.contains("customer"))
		{
			text.click();
			break;
		}
		
	}
	
	}
	
	@AfterEach
	public void teardown()
	{
		System.out.println(driver.getTitle());
		driver.close();
	}

}
