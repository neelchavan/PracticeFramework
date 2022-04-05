package Academy.PracticeFramework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AmazonHome;
import resources.Base;

public class VerifySellText extends Base {
	public WebDriver driver;
	Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initializeChromeDriver() {
		driver = intializeDriver();
		log.info("Driver is initialized");
	}

	@Test
	public void verifyingSellText() {
		AmazonHome ah = new AmazonHome(driver);

		driver.get("https://Amazon.com");
		log.info("Navigated to home page");

		ah.getPopUp();
		log.info("Handled the pop-up");

		String text = ah.getSell().getText();
		Assert.assertEquals(text, "sell");
		log.info("Failing this test deliberately to test the functionality of ScreenshotOnFailure");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Exited the browser");
	}

}
