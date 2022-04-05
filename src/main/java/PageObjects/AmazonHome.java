package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHome {
	public WebDriver driver;

	public AmazonHome(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By dialogBoxPath = By.xpath("//div[@role='alertdialog']");
	By popup = By.xpath("//input[@data-action-type=\"DISMISS\"]");
	By todayDeals = By.linkText("Today's Deals");
	By Sell = By.xpath("//a[text()='Sell']");

	public void getPopUp() {
		WebElement dialogBox = driver.findElement(dialogBoxPath);
		if (dialogBox.isDisplayed()) {
			driver.findElement(popup).click();
		}
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public WebElement getTodayDeals() {
		return driver.findElement(todayDeals);
	}
	
	public WebElement getSell() {
		return driver.findElement(Sell);
	}
}
