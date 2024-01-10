package phase1endproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AmazonSignInPage {

	private WebDriver driver;
	private By navigateTo = By.xpath("//*[@class='nav-line-2 ']");
	private By signInbutton = By.linkText("Sign in");
	private By email = By.id("ap_email");
	private By toPassword = By.xpath("//input[@id='continue']");
	private By password = By.id("ap_password");
	private By submit = By.id("signInSubmit");
	private By error = By.xpath("//div[@class='a-box-inner a-alert-container']/descendant::span");

	public AmazonSignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToSignInPage() throws InterruptedException {
		WebElement e1 = driver.findElement(navigateTo);
		Actions a = new Actions(driver);
		a.moveToElement(e1).perform();
		Thread.sleep(500);
		driver.findElement(signInbutton).click();
	}

	public void SignIn(String email, String password) {
		driver.findElement(this.email).sendKeys(email);
		driver.findElement(toPassword).click();

		// inspect password input box and click on sign button

		driver.findElement(this.password).sendKeys(password);
		driver.findElement(submit).click();
	}

	public String getMessage() {
		try {
			String error = driver.findElement(By.xpath("//div[@class='a-box-inner a-alert-container']/descendant::span"))
					.getText();
			return error;
		} catch (Exception e) {
			String title = driver.getTitle();
			return title;
		}
	}
}
