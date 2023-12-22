package utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static String GetScreenshot(WebDriver driver , String fileName) {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		     
		String directoryPath = System.getProperty("user.dir") + "/Screenshot/";
		File directory = new File(directoryPath);
		     
		if (!directory.exists()) {
		     directory.mkdir();
		}
		     
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = directoryPath + fileName + dateFormat.format(date) + ".png";
		File target = new File(destination);
		try {
			FileUtils.copyFile(scrFile, target);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		       
		return destination;
	}
}
