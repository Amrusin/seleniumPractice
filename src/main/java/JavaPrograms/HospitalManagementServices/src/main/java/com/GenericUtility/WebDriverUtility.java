package com.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
 
	/**
	 * This method is used to maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used for wait until page is loaded
	 * @param driver
	 * @param sec
	 */
	public void waitForPageLoad(WebDriver driver, int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	/**
	 * This method is used for waiting until Element is visible
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public WebDriverWait webDriverWaitObj(WebDriver driver, int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		return wait;
	}
	public void waitUntilEleVisible(WebDriver driver, int sec, WebElement element)
	{
		webDriverWaitObj(driver,sec).until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used for waiting until Element is clickable
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitUntilEleToBeClickable(WebDriver driver, int sec, WebElement element)
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used for waiting until title is present
	 * @param driver
	 * @param sec
	 * @param title
	 */
	public void waitUntilTogetTitle(WebDriver driver, int sec, String title)
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.titleContains(title));
	}
	
	public void waitUntilAlertToBEPresent(WebDriver driver, int sec)
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.alertIsPresent());
	}
	
	public Select dropdownObject(WebElement element)
	{
		Select s = new Select(element);
		return s;
	}
	/**
	 * This method is used to handle Drop Down
	 * @param element
	 * @param text
	 */
	
	public void handleDropdown(WebElement element, String text)
	{
		
		dropdownObject(element).selectByVisibleText(text);
	}
	
	public void handleDropdown (WebElement element, int index)
	{
		
		dropdownObject(element).selectByIndex(index);
	}
	
	public void HandleDropDown(WebElement element, String value)
	{
		dropdownObject(element).selectByValue(value);;
	}
	
	
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.click(element).perform();
	}
	
	public Actions performActions(WebDriver driver)
	{
		Actions act = new Actions(driver);
		return act;
	}
	
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst)
	{
		
		performActions(driver).dragAndDrop(src, dst);
	}
	
	public void dropAndDrop(WebDriver driver, WebElement element, int x, int y)
	{
		
		performActions(driver).dragAndDropBy(element, x, y);
	}
	public void doubleClick(WebDriver driver)
	{
		performActions(driver).doubleClick().perform();
	}
	public void doubleClick(WebDriver driver, WebElement element)
	{
		performActions(driver).doubleClick(element).perform();
	}
	public void rightClick(WebDriver driver)
	{
		performActions(driver).contextClick().perform();
	}
	public void rightClick(WebDriver driver, WebElement element)
	{
		performActions(driver).contextClick(element).perform();
	}

	public void enterKeyPress(WebDriver driver)
	{
		performActions(driver).sendKeys(Keys.ENTER).perform();
	}
	public void switchToWindow(WebDriver driver, String expWindow)
	{
		Set<String> window= driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		while(it.hasNext())
		{
			String win=it.next();
			String currentTitle=driver.switchTo().window(win).getTitle();
			if(currentTitle.contains(expWindow))
			{
				break;
			}
		}
	}
	
	public Robot robotObj()throws AWTException
	{
		Robot rb=new Robot();
		return rb;
	}
	
	public void enterKey()throws Throwable
    {
		robotObj().keyPress(KeyEvent.VK_ENTER);
    }
	
	public void enterRelease()throws Throwable
	{
		robotObj().keyRelease(KeyEvent.VK_ENTER);
	}
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This is for Dismissing the Alert
	 * @param driver
	 */
	public void CancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This is for Taking Screen Shots
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
	public static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{
		JavaUtility jutils=new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path="./screenshot/"+screenShotName+" "+jutils.getSystemDateInFormat()+".png";
		File dest=new File(path);
		String scrpath= dest.getAbsolutePath();
		FileUtils.copyFile(src, dest);
		return scrpath;
	}
	
	/**
	 * This method will perform random scroll
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)", "");
	}
	/**
	 * This is for performing action using JavaScript
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
	/**
	 * This is for Click On Element using JavaScript
	 * @param driver
	 * @param element
	 */
	
	public void ClickOnElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",element );
		
	}
	/**
	 * This is for scrolling till Element
	 * @param driver
	 * @param element
	 */
	public void ScrollTillElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",element );	
	}
	/**
	 * This is for Scrolling till bottom of the page
	 * @param driver
	 */
	public void ScrollToBottom(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	/**
	 * This is for Scrolling Top of the Page
	 * @param driver
	 * @param element
	 */
	public void ScrollTopOfPage(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	/**
	 * This is for sending text using JavaScript
	 * @param driver
	 * @param element
	 * @param expecData
	 */
	public void jsUsingSendKeys(WebDriver driver, WebElement element, String expecData)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1]",element,expecData );	
	}
	/**
	 * This is for Launching Browser
	 * @param driver
	 * @param element
	 * @param text
	 */
	public void LaunchingBrow(WebDriver driver, WebElement element, String text)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.location=arguments[0]","" );	
	}
	/**
	 * This is for scrolling up Till Element is visible
	 * @param driver
	 * @param element
	 */
	public void ScrollUpTillElementToBeVisible(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Point loc = element.getLocation();
		int x=loc.getX();
		int y=loc.getY();
		js.executeScript("window.scrollBy("+x+", "+y+")");
	}
}
