package LandingPage;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import com.aventstack.extentreports.Status;
import Base.Base;

public class BeCognizant extends Base {

	// xapth of web elements
	By email = By.xpath("//input[@name='loginfmt']");
	By next = By.xpath("//input[@type='submit' and @id='idSIButton9']");
	By pass = By.xpath("//input[@type='password' and @id='i0118']");
	By call = By.xpath("//*[contains(text(),'Call +XX XXXXXXXX86')]");
	By yes = By.xpath("//*[@id='idSIButton9']");
	By userName = By.xpath("//*[@id='user-name']");
	By culture = By.xpath("//*[@class='nav navbar-nav']//child::li/button[contains(text(),'Culture')]");
	By practicesMarket = By
			.xpath("//*[@class='nav navbar-nav']//child::li/button[contains(text(),'Practices & Markets')]");
	By corporateFunction = By
			.xpath("//*[@class='nav navbar-nav']//child::li/button[contains(text(),'Corporate Functions')]");
	By humanResources = By.xpath("//*[@class='nav navbar-nav']//child::li/button[contains(text(),'Human Resources')]");
	By forWait = By.xpath("//html/body//child::div[@id='workspacesMulti']");
	
	//xpath of culture options
	By cultureoption1 = By.xpath("//*[contains(text(),'About Cognizant')]//preceding::span[1]");
	By cultureoption2 = By.xpath("//*[contains(text(),'Strategy and Latest Thinking')]//preceding::span[1]");
	By cultureoption3 = By.xpath("//*[contains(text(),'Inclusion and Values')]//preceding::span[1]");
	
	
	//xpath of practices & market options
	
	By practicesoption1 = By.xpath("");
	
	
	
	//xpath of corporate functons options
	
	
	
	
	
	
	//xpath of human Resources options
	
	
	
	
	
	

	// login to the be cognizant
	public void login() {

		try {
			wait(20, email);
			driver.findElement(email).sendKeys(prop.getProperty("email"));
			driver.findElement(next).click();
			logger.log(Status.INFO, "XpathLocator of email is identified: " + email);

			wait(20, pass);
			driver.findElement(pass).sendKeys(prop.getProperty("password"));
			driver.findElement(next).click();
			logger.log(Status.INFO, "XpathLocator of password is identified: " + pass);
			reportPass("Username and Password Successfully entered");

			wait(20, call);
			driver.findElement(call).click();
			logger.log(Status.INFO, "XpathLocator of Call is identified: " + call);
			logger.log(Status.INFO, "Call WebElement is successfully clicked");

			wait(20, yes);
			driver.findElement(yes).click();
			logger.log(Status.INFO, "Yes WebElement is successfully clicked");

			// verification of title page
			wait(30, userName);
			String titlePage = driver.getTitle();
			try {
				assertEquals(titlePage, "Be.Cognizant");
				reportPass("Title of WebPage is verified");
			} catch (Exception e) {
				reportFail(e.getMessage());
				takeScreenShotOnFailure();
			}

		} catch (Exception e) {
			reportFail(e.getMessage());
			takeScreenShotOnFailure();
		}

	}

	public void verfiyUser() {
		try {
			String nameOfUser = driver.findElement(userName).getText();
			logger.log(Status.INFO, "XpathLocator of username is found " + userName);

			try {
				assertEquals(nameOfUser, "Kumar, Rupam (Contractor)");
				logger.log(Status.INFO, "User Name is Found " + nameOfUser);
				logger.log(Status.PASS, "User Name is successfully verified ");
			} catch (Exception e) {
				reportFail(e.getMessage());
				takeScreenShotOnFailure();
			}

		} catch (Exception e) {
			reportFail(e.getMessage());
			takeScreenShotOnFailure();
		}
	}

	public void captureAndVerifyOptions() {
		try {

			driver.findElement(culture).click();
			logger.log(Status.INFO, "XpathLocator of Culture is found");

			
			Thread.sleep(8000);
			//assert all options for culture
			try {
				assertEquals(driver.findElement(cultureoption1).getText(),"2");
				assertEquals(driver.findElement(cultureoption2).getText(),"2");
				assertEquals(driver.findElement(cultureoption3).getText(),"3");
				reportPass("About Cognizant options verified");
				
			} catch (Exception e) {
				reportFail(e.getMessage());
				takeScreenShotOnFailure();
			}

		} catch (Exception e) {
			reportFail(e.getMessage());
			takeScreenShotOnFailure();
		}

		
		
		//for parcricesmarket
		try {

			driver.findElement(practicesMarket).click();
			logger.log(Status.INFO, "XpathLocator of Practice & Market is found");
			Thread.sleep(8000);

			Thread.sleep(8000);
			
			//assert all options for practices & market
			try {
				
				
				
			}catch(Exception e) {
				reportFail(e.getMessage());
				takeScreenShotOnFailure();
			}
			

		} catch (Exception e) {
			reportFail(e.getMessage());
			takeScreenShotOnFailure();
		}

		try {

			driver.findElement(humanResources).click();
			logger.log(Status.INFO, "XpathLocator of Human Resources is found");
			Thread.sleep(8000);

			// wait(20, forWait);
			// String humanResourcesOptions = "";

		} catch (Exception e) {
			reportFail(e.getMessage());
			takeScreenShotOnFailure();
		}

		try {

			driver.findElement(corporateFunction).click();
			logger.log(Status.INFO, "XpathLocator of Corporate Functon is found");
			Thread.sleep(8000);

			// wait(20, forWait);
			// String corporateFunctionOptions = "";

		} catch (Exception e) {
			reportFail(e.getMessage());
			takeScreenShotOnFailure();
		}
	}

}
