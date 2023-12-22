package amazon.runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import amazon.pageobject.HomePageObject;
import amazon.pageobject.ProductPageObject;
import utilities.Base;
import utilities.LoggerHandler;
import utilities.Reporter;

public class RunTest {

	WebDriver driver;
	Base b = new Base();
	ExtentReports reports;
	ExtentTest test;
	static int i=1;
	
	HomePageObject homepageobject = new HomePageObject();
	ProductPageObject productpageobject = new ProductPageObject();
	
	@BeforeTest
	public void createReport() {
		reports = Reporter.getReport("Report_");
	}

	@BeforeMethod
	public void ConfigBrowser() {
		driver = b.openBrowser();
	
		test = reports.createTest("Test Case : "+i);
		i++;
	}
	
	@Test
	public void testcaseone() {
		homepageobject.clicksearchbox(driver,test);
		homepageobject.EnterDataOnSearchbox(driver,test);
		homepageobject.clickonsearchicon(driver,test);
		productpageobject.verifySerachText(driver,test);
	}
	
	@AfterMethod
	public void exit() {
		driver.quit();
		LoggerHandler.logInfo("Browser Closed Successed .");
		test.pass("Browser Closed Successed .");
	}

	@AfterTest
	public void Flush() {
		reports.flush();
	}
}
