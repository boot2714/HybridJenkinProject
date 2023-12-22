package utilities;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {

	WebDriver driver;

	public WebDriverHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickOnElement(By element) {
		WebElement webelement = driver.findElement(element);
		webelement.click();
	}

	public void ClearInput(By element) {
		WebElement webelement = driver.findElement(element);
		webelement.clear();
	}

	public void SendKeys(By element,String data) {
		WebElement webelement = driver.findElement(element);
		webelement.sendKeys(data);
	}

	public String GetText(By element) {
		WebElement webElement = driver.findElement(element);
		return webElement.getText();
	}

	public void Hover(By element) {
		WebElement webElement = driver.findElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).perform();
	}

	public void SelectByIndex(By element,int index) {
		WebElement webElement = driver.findElement(element);
		Select s = new Select(webElement);
		s.selectByIndex(index);
	}

	public void SelectByVisibleText(By element,String text) {
		WebElement webElement = driver.findElement(element);
		Select s = new Select(webElement);
		s.selectByVisibleText(text);
	}

	public void ScrollByFiveHundred() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)","");
	}

	public void PageUp() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
	}

	public void ScrollByTwoFiveHundred() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2500)","");
	}

	public void ScrollByOneFiveHundred() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)","");
	}

	public void ScrollByThreeHundred() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)","");
	}

	public void ScrollByElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement e = driver.findElement(locator);
		js.executeScript("arguments[0].scrollIntoView();",e);
	}

	public void ScrollToElement(By ele1,By ele2) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(ele1)).scrollToElement(driver.findElement(ele2)).perform();
	}

	public void SwitchToNewWindow() 
	{
		Set<String> set = driver.getWindowHandles();
	
		try {
				for (String windowHandle : set) {
		           if (!windowHandle.isEmpty()) {
		               driver.switchTo().window(windowHandle);
		           } else {
		               throw new Exception("New window could not be retrieved");
		           }
		       }
		}
		catch(Exception e) {
	
		}
	}

	public void EnterKeys(By element) {
		WebElement webElement = driver.findElement(element);
		webElement.sendKeys(Keys.ENTER);
	}

	public void KeysDown(By element) {
		WebElement webElement = driver.findElement(element);
		webElement.sendKeys(Keys.DOWN);
	}

	public void WaitForElement(By element,int timeOuts) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOuts));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		}
		catch(Exception e) {
	
		}
	}

	public void ElementToBeClickable(By element,int timeOuts) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOuts));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e) {
	
		}
	}

	public void ElemenetToBeLocated(By element,int timeOuts) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOuts));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		}
		catch(Exception e) {
	
		}
	}

	public void ImplicitWait(int timeOuts) {
		try {
	
		driver.manage().timeouts().implicitlyWait(timeOuts, TimeUnit.SECONDS);
		}
		catch(Exception e) {
	
		}
	}
}
