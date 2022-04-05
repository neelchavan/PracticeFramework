package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TodayDeals {
	public WebDriver driver;

	By getGrocery = By.xpath("//li[@role='listitem'][23]");
	By nextButton = By.xpath("//i[@class='a-icon a-icon-next']");

	public TodayDeals(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getGroceryDeals() {
		return driver.findElement(getGrocery);
	}

	public WebElement getNextButton() {
		return driver.findElement(nextButton);
	}
}
