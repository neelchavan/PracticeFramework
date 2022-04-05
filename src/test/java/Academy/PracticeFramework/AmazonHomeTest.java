package Academy.PracticeFramework;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import PageObjects.AmazonHome;
import resources.Base;

public class AmazonHomeTest extends Base {
	public WebDriver driver;
	Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initializeChromeDriver() {
		driver = intializeDriver();
		log.info("Driver is initialized");
	}

	@Test
	public void openTodayDeals() throws InterruptedException {
		// Navigate to amazon
		driver.get("https://amazon.com");
		log.info("Navigated to home page of amazon.com");

		AmazonHome ah = new AmazonHome(driver);

		// Handle PopUp if appears
		ah.getPopUp();
		log.info("Handled the address pop-up");

		// Click on mobiles
		ah.getPageTitle();
		log.info("Got the title of the page");

		// Click on TodaysDeals
		ah.getTodayDeals().click();
		log.info("Clicked on get today deals");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Exited the browser");
	}
}
