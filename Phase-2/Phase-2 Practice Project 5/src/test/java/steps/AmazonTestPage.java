package steps;
import static steps.HooksAmazon.driver;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AmazonTestPage {
	@Given("User gets ttile of the main Page")
	public void user_gets_ttile_of_the_main_page() {
		
		
		System.out.println(driver.getTitle());
	
	}

	@Then("User clicks on link Mobiles")
	public void user_clicks_on_link_mobiles() throws InterruptedException {
		
	WebElement mobiles =	driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));

	mobiles.click();
	
	Thread.sleep(1500);
	}

	@Then("User navigates to Mobiles & accessories")
	public void user_navigates_to_mobiles_accessories() throws InterruptedException {
		Actions a = new Actions(driver);
		WebElement MA = driver.findElement(By.xpath("(//span[@class='nav-a-content'][normalize-space()='Mobiles & Accessories'])[1]"));
		a.moveToElement(MA).build().perform();
		Thread.sleep(1500);
		
	}

	@Then("User click on Apple product")
	public void user_click_on_apple_product() throws InterruptedException {
		
	WebElement product=	driver.findElement(By.xpath("(//a[contains(text(),'Apple')])[2]"));
	   product.click();
	   Thread.sleep(2500);
	   
	}

	@Then("User select the first apple product")
	public void user_select_the_first_apple_product() throws InterruptedException {
		

		
		WebElement appleproduct = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[1]/descendant::span[10]"));
		
		appleproduct.click();
		Thread.sleep(2500);
	}

	@Then("User will switch to new window and get title")
	public void user_will_switch_to_new_window_and_get_title() throws InterruptedException {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(1));
	
		Thread.sleep(1500);
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}

	@Then("user click on Add to Cart")
	public void user_click_on_add_to_cart() throws InterruptedException {
		
		WebElement cart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']")) ;
		
		cart.click();
		Thread.sleep(1500);
	}

	@Then("User refreshes the Page and click on Cart link")
	public void user_refreshes_the_page_and_click_on_cart_link() {
		
	driver.navigate().refresh();
	WebElement cartlink =	driver.findElement(By.xpath("//*[@id='nav-cart']/descendant::div[2]"));
	   cartlink.click();
	}

	@Then("User clicks on proceed to pay button")
	public void user_clicks_on_proceed_to_pay_button() throws InterruptedException {
	   WebElement proceed = driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']"));
	   proceed.click();
	   
	   Thread.sleep(1500);
	}
	
	
	@Given("User navigates to create account page")
	
	public void naviagte_createaccountPage()
	{
		driver.navigate().to("https://www.amazon.in/ap/register?showRememberMe=true&showRmrMe=0&openid.pape.max_auth_age=0&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&siteState=isRegularCheckout.1%7CIMBMsgs.%7CisRedirect.1&pageId=amazon_checkout_in&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fbuy%2Fsignin%2Fhandlers%2Fcontinue.html%3Fie%3DUTF8%26brandId%3D%26cartItemIds%3D%26eGCApp%3D%26hasWorkingJavascript%3D0%26isEGCOrder%3D0%26isFresh%3D%26oldCustomerId%3D0%26oldPurchaseId%3D%26preInitiateCustomerId%3D%26purchaseInProgress%3D%26ref_%3Dcart_signin_submit%26siteDesign%3D&prevRID=A7SSZK4G6K6J0QT8EA70&openid.assoc_handle=amazon_checkout_in&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&prepopulatedLoginId=&failedSignInCount=0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&suppressSignInRadioButtons=0");
		
		
	}
	
	@Then("User Enters {string},{string},{string}")
	public void user_enter_details(String name, String mobilenumber, String password) throws InterruptedException
	{
		WebElement e1 = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
		WebElement e2 = driver.findElement(By.xpath("//input[@id='ap_phone_number']"));
		WebElement e3 = driver.findElement(By.xpath("//input[@id='ap_password']"));
		
		e1.sendKeys(name);
		e2.sendKeys(mobilenumber);
		e3.sendKeys(password);
		
		Thread.sleep(2000);
		
	}
	
	@And("User clicks on Verify mobile number")
	public void click_on_varify()
	{
		driver.findElement(By.xpath("//input[@id='continue']")).click();
	}
	

}
