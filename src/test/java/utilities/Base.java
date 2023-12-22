package utilities;

import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	WebDriver driver;
	static Logger logger = LoggerHandler.InitLogger();

	public WebDriver openBrowser() {
		try {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("incognito");
			driver = new ChromeDriver(option);
			LoggerHandler.logInfo("Browser Launched Successed .");
			String path = System.getProperty("user.dir")+"/Config/browser.properties";
			FileReader fr = new FileReader(path);
			Properties prop = new Properties();
			prop.load(fr);
			driver.get(prop.getProperty("url"));
			LoggerHandler.logInfo("Application Open Successed .");
			driver.manage().window().maximize();
		}
		catch(Exception e) {
			e.printStackTrace();
			LoggerHandler.logError("Browser Launched Failed .");
			LoggerHandler.logError("Application Open Failed .");
		}
		return driver;

	}
}
