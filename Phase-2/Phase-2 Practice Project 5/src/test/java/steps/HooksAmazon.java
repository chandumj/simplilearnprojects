package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class HooksAmazon {
	// As the name suggest hooks are used to connect a method to a scenario
		// Hooks can be used to determin pre-equiste for the test case execution
		// hooks come with annotation => 
		// @Before : Annotated method will run before a scenario in feature file
		
		//, @After : Annotated method will run after a scenario in feature file
		
		public static WebDriver driver;

		@BeforeAll
		public static void initialization()
		{
			System.out.println("Lesson End Project test Started");
			
		}
		
		@Before
		public void openBrowser() throws InterruptedException
		{
			// needed for Jenkins
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Downloads\\chromedriver\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.amazon.in/");
			Thread.sleep(3000);
		}
		
		@After
		public void CloseBrowser()
		{
			driver.quit();
		}
		
		
		@AfterAll
		public static void CompletedProject()
		{
			System.out.println("Lesson End Project test Completed");
			
		}
		

}
