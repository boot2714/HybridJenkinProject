package utilities;

import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	WebDriver driver;
	static Logger logger = LoggerHandler.InitLogger();

	public WebDriver openBrowser() {
		try {
			
			String path = System.getProperty("user.dir")+"/Config/browser.properties";
			FileReader fr = new FileReader(path);
			Properties prop = new Properties();
			prop.load(fr);
			
			if(prop.getProperty("browsername").equalsIgnoreCase("chrome")) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("incognito");
				driver = new ChromeDriver(option);
				LoggerHandler.logInfo("Browser Launched Successed .");
				
				driver.get(prop.getProperty("url"));
				LoggerHandler.logInfo("Application Open Successed .");
				driver.manage().window().maximize();
			}
			else if(prop.getProperty("browsername").equalsIgnoreCase("edge")) {
				EdgeOptions option = new EdgeOptions();
				option.addArguments("incognito");
				driver = new EdgeDriver(option);
				LoggerHandler.logInfo("Browser Launched Successed .");
				
				driver.get(prop.getProperty("url"));
				LoggerHandler.logInfo("Application Open Successed .");
				driver.manage().window().maximize();
			}
			else if(prop.getProperty("browsername").equalsIgnoreCase("ie")) {
				driver = new InternetExplorerDriver();
				LoggerHandler.logInfo("Browser Launched Successed .");
				
				driver.get(prop.getProperty("url"));
				LoggerHandler.logInfo("Application Open Successed .");
				driver.manage().window().maximize();
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			LoggerHandler.logError("Browser Launched Failed .");
			LoggerHandler.logError("Application Open Failed .");
		}
		return driver;

	}
}
