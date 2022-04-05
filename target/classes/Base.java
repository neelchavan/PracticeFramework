package resources;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	
	public WebDriver intializeDriver() {
		System.setProperty("webdriver.chrome.driver", "/home/neel/SeleniumSetup/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		return driver;
	}
	
	public String getScreenshotPath(String testMethodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		// This step stores the file into virtual location
		File source = ts.getScreenshotAs(OutputType.FILE);
		// This step stores the into local machine from virtual machine
		String destinationFile = "/home/neel/eclipse-workspace/PracticeFramework/reports/"+testMethodName+".png";	
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
}
