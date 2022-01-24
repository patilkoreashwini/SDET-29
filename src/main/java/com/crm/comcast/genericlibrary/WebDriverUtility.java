package com.crm.comcast.genericlibrary;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * this method is used to wait for webelement to be loaded
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 * this method is used to wait till expected element is visible 
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method is used to wait for the element to be clicked 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count  = 0;
		while(count<20) {
			try {
				element.click();
				break;
			}
			catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * this method enables user to handle dropdown using visible text
	 * @param element
	 * @param option
	 */
	public void select(WebElement element, String option) {
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}
	
	/**
	 * this method enables user to handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * this method is used to perform mouseover action
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * this method performs right click operations
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * this method helps to switch from one window to the other
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle) {
		Set<String> window = driver.getWindowHandles();
		 Iterator<String> it = window.iterator();
		while(it.hasNext()) 
		{
			String winld = it.next();
			String title = driver.switchTo().window(winld).getTitle();
			if(title.contains(partialWinTitle)) 
			{
				break;
			}
		}
	}
	
	/**
	 * this method is used to accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method is used to dismiss the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method is used to perform scrolling action in a webpage
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
	 /**
	  * this method is used to switch to frame using index
	  * @param driver
	  * @param index
	  */
	public void switchFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * this method is used to switch to frame using element
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * this method is used to switch to frame using id or name
	 * @param driver
	 * @param idOrName
	 */
	public void switchFrame(WebDriver driver,String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	/**
	 * this method is to take a screenshot and attach to report
	 * @param driver
	 * @param screenshotName
	 * @throws IOException
	 */
	public void takeScreenshot(WebDriver driver,String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+screenshotName+".PNG");
		Files.copy(src, dest);
	}
	
	/**
	 * this method is used to press enter key
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

}
