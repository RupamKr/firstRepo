package TestSuites;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import LandingPage.BeCognizant;


public class beCognizant extends Base {

	BeCognizant bCog = new BeCognizant();
	
	
	@BeforeTest
	public void invokeBrowser() throws Exception {
		logger = report.createTest("Invoke Browser");
		openBrowser();
	}
	
	@Test
	public void loginPage() {
		logger = report.createTest("Enter UserName and Password in Be Cognizant");
		openURL();
		bCog.login();
	}
	
	@Test(priority=1)
	public void userNameVerification() {
		logger = report.createTest("Verfication of User");
		bCog.verfiyUser();
	}
	
	@Test(priority=2)
	public  void captureHeader() {
		logger = report.createTest("Capture Be.Cognizant Header values and verify the options");
		bCog.captureAndVerifyOptions();
	}
	
	@AfterTest
	public void quitBrowser() {
		logger = report.createTest("Quit Browser");
		closeBrowser();
		endReport();
	}
	
}
