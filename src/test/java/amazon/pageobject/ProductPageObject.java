package amazon.pageobject;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import amazon.uistore.ProductPage;
import utilities.ExcelReader;
import utilities.LoggerHandler;
import utilities.Screenshot;
import utilities.WebDriverHelper;

public class ProductPageObject {
	
	ProductPage productpage = new ProductPage();
	
	String path = System.getProperty("user.dir")+"/TestData/testdata.xlsx";
	ExcelReader reader = new ExcelReader();

	public void verifySerachText(WebDriver driver,ExtentTest test) {
		try {
			WebDriverHelper helper = new WebDriverHelper(driver);
			helper.WaitForElement(productpage.verifytext,20);
			String data = helper.GetText(productpage.verifytext);
			String text = reader.readDataFromExcel(path,"Sheet1", 2, 0);
			System.out.println(text);
			if(data.equalsIgnoreCase(text)) {
				String path = Screenshot.GetScreenshot(driver,"Verify_");
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(path, "Verify Search Text "+ data + " Successed.").build());
				LoggerHandler.logInfo("Verify Search Text "+ data + " Successed.");
			}
			else {
				String path = Screenshot.GetScreenshot(driver,"Verify_");
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(path, "Verify Search Text "+ data + " Failed.").build());
				LoggerHandler.logError("Verify Search Text "+ data + " Failed.");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
}
