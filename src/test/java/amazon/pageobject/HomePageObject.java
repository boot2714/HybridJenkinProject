package amazon.pageobject;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import amazon.uistore.HomePage;
import utilities.ExcelReader;
import utilities.LoggerHandler;
import utilities.WebDriverHelper;

public class HomePageObject {

	HomePage homepage = new HomePage();
	
	String path = System.getProperty("user.dir")+"/TestData/testdata.xlsx";
	ExcelReader reader = new ExcelReader();
	
	public void clicksearchbox(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			helper.WaitForElement(homepage.searchbox,20);
			helper.ClickOnElement(homepage.searchbox);
			test.pass("Click on Search Box Successed.");
			LoggerHandler.logInfo("Click on Search Box Successed.");
		}
		catch(Exception e) {
			test.fail("Click on Search Box Failed.");
			LoggerHandler.logError("Click on Search Box Failed.");
			e.getMessage();
		}
	}
	
	public void EnterDataOnSearchbox(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			helper.WaitForElement(homepage.searchbox,20);
			String data = reader.readDataFromExcel(path,"Sheet1", 1, 0);
			helper.SendKeys(homepage.searchbox, data);
			test.pass("Enter Data on Search Box Successed.");
			LoggerHandler.logInfo("Enter Data on Search Box Successed.");
		}
		catch(Exception e) {
			test.fail("Enter Data on Search Box Failed.");
			LoggerHandler.logError("Enter Data on Search Box Failed.");
			e.getMessage();
		}
	}
	
	public void clickonsearchicon(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			helper.WaitForElement(homepage.searchicon,20);
			helper.ClickOnElement(homepage.searchicon);
			test.pass("Click on Search Icon Successed.");
			LoggerHandler.logInfo("Click on Search Icon Successed.");
		}
		catch(Exception e) {
			test.fail("Click on Search Icon Failed.");
			LoggerHandler.logError("Click on Search Icon Failed.");
			e.getMessage();
		}
	}
	
	
}
