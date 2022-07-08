package Base;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.DateUtils;
import Utils.ExtentReportManager;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;
	
	

	// To call different browsers
	public void openBrowser() throws Exception {
		
		
		if (prop == null) {
			prop = new Properties();
			FileReader file = new FileReader(
					System.getProperty("user.dir") + "\\src\\main\\java\\Config\\config.properties");
			prop.load(file);
		}

		// To Open Chrome Browser
		// To Open Chrome Browser
		if (prop.getProperty("browserName").matches("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
			reportPass("Edge browser successfully invoked");

		}

		// To Open Firefox Browser
		if (prop.getProperty("browserName").matches("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			reportPass("FireFox browser successfully invoked");
		}
		
		if (prop.getProperty("browserName").matches("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			reportPass("Google Chrome browser successfully invoked");
		}

		// To maximize the Browser Window
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	// To open the Main Page URL
	public void openURL() {
		driver.get(prop.getProperty("websiteURLKey"));
		reportPass(prop.getProperty("websiteURLKey")+" WebSite is Successfully Launched");
	}

	// Function to show the failed test cases in the report
	public void reportFail(String report) {
		logger.log(Status.FAIL, report);
	}

	// Function to show the passed test cases in the report
	public void reportPass(String report) {
		logger.log(Status.PASS, report);
	}

	public void wait(int sec, By locator) {
		wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// To input all data to the report
	public void endReport() {
		report.flush();
	}

	// To close the Browser
	public void closeBrowser() {
		reportPass(prop.getProperty("browserName")+ " SuccessFully closed");
		driver.quit();
	}
	
	public void takeScreenShotOnFailure() {

		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		// takeScreenShot.getScreenshotAs(OutputType.FILE); = here the file is in binary
		// form so we are conveting it into file formate

		File destinationFile = new File(
				System.getProperty("user.dir") + "\\Screenshots\\" + DateUtils.getTimeStamp() + ".png");

		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			//this will add ss to report
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\Screenshots\\" + DateUtils.getTimeStamp() + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
