package starHealthScenario2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StarHealthPage {
	
	
	@FindBy(xpath = "//*[@id=\"__next\"]/div/div/header/div[2]/div[1]/span/span/img")
	WebElement logo;
	
	@FindBy(xpath = "//div[@class='Header_nav-link-container__nlUUp dropdown-active flex only-desktop']/descendant::img[2]")
	WebElement plans;
	
	@FindBy(xpath = "//div[@class='ant-popover-inner']/descendant::a[2]")
	WebElement formyfamily;

	public StarHealthPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public String getAltText() {
		return	logo.getAttribute("alt");
	}
	
	public void hoverOnPlans(WebDriver driver) {
		Actions a=new Actions(driver);
		a.moveToElement(plans).build().perform();
	}
	public void clickOnForMyFamily() {
		formyfamily.click();
	}
	
}
