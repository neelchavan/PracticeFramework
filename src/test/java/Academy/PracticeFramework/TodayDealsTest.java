package Academy.PracticeFramework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AmazonHome;
import PageObjects.TodayDeals;
import resources.Base;

public class TodayDealsTest extends Base {
	public WebDriver driver;
	Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initializeChromeDriver() {
		// Why can we call intializeDriver() method without creating any object.
		driver = intializeDriver();
		log.info("Driver is initialized");
	}

	@Test
	public void openGrocery() throws InterruptedException {
		TodayDeals td = new TodayDeals(driver);

		AmazonHome ah = new AmazonHome(driver);

		// Open Today Deals page
		driver.get("https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb");
		log.info("Navigated to today's deals page");		

		// Handle PopUp if appears
		ah.getPopUp();
		log.info("Handled the address pop-up");
		
		// Open Grocery
		for (int i = 0; i < 2; i++) {
			td.getNextButton().click();
		}
		Thread.sleep(5);
		if(td.getGroceryDeals().isDisplayed()) {
			td.getGroceryDeals().click();
		}
		log.info("Clicked on grocery");
		Thread.sleep(2);
		log.info("Waited for 2 secs");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Exited the browser");
	}
}
