package phase1endproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonMobilesPage {
	private WebDriver driver;
	private By mobileslocator = By.linkText("Mobiles");
	private By navigatetomobiles=By.xpath("//div[@id='nav-progressive-subnav']/descendant::span[2]");
	private By applelocator=By.linkText("Apple");
	private By sampleapplelocator=By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span/div/div/div[1]/span/a/div/img");
	private By addtowishlistlocator=By.xpath("//*[@id=\"wishListMainButton\"]/span/a");
	public AmazonMobilesPage(WebDriver driver) {
		this.driver = driver;
	}
	public void takescreenshot_method(String filepath) throws IOException
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		FileUtils.copyFile(srcFile, destFile);
	}

	public void clickOnMobiles() {
		driver.findElement(mobileslocator).click();
	}
	public void selectApple() throws InterruptedException, IOException {
		
		Actions a = new Actions(driver);
		
		a.moveToElement(driver.findElement(navigatetomobiles)).perform();
		
		Thread.sleep(2000);
		
		takescreenshot_method("./Screenshot/mobile1.png");

		driver.findElement(applelocator).click();
	}
	public void selectSampleMobile() throws IOException {
		driver.findElement(sampleapplelocator).click();
		takescreenshot_method("./Screenshot/mobile2.png");
	}
	public String addToWishList() throws InterruptedException, IOException {
ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs);
		driver.switchTo().window(tabs.get(1));
	
		
		Thread.sleep(1500);
		driver.findElement(addtowishlistlocator).click();
		
		takescreenshot_method("./Screenshot/mobile3.png");
		
		String title=driver.getTitle();
		return title;

	}

}
