package phase1endproject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMobilePage {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
   
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(1500);
		 AmazonMobilesPage test=new AmazonMobilesPage(driver);
		 test.clickOnMobiles();
		 test.selectApple();
		 test.selectSampleMobile();
		 String mssg= test.addToWishList();
		 System.out.println(mssg);
		 AmazonSignInPage test1=new AmazonSignInPage(driver);
		 test1.SignIn("chandumj787013@gmail.com", "Chandu@123");
		 Thread.sleep(1000);
		 test.takescreenshot_method("./Screenshot/mobile4.png");
		 driver.quit();

	}

}
