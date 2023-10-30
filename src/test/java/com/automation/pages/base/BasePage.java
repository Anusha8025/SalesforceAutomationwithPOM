package com.automation.pages.base;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.tests.utilities.ExtentReportsUtility;
import com.automation.tests.utilities.Log4JUtility;
public class BasePage {

	protected WebDriver driver;
	//protected static  WebDriverWait wait = null;
	WebDriverWait wait;
	protected Log4JUtility logObject=Log4JUtility.getInstance();
	protected static Logger myLog;
	protected ExtentReportsUtility report=ExtentReportsUtility.getInstance();
	

	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		myLog.info("page tittle is returned");
		return driver.getTitle();
	}

	public void refreshPage() {
		driver.navigate().refresh();
		myLog.info("page is refreshed");

	}
	
	public  void displayDrownDownItems() {

		List<WebElement> myElements = driver.findElements(By.cssSelector("#userNav-menuItems"));
		System.out.println("Size= " + myElements.size());
		for (WebElement e : myElements) {
			System.out.println(e.getText());
		}
	}

	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		myLog.info("extracted the text from" + objectName);
		return data;
	}

	
	/*
	 * public static void waitForVisibility(WebElement ele, int time, String
	 * objectNam) { wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 * wait.until(ExpectedConditions.visibilityOf(ele)); }
	 */
	
	public void enterText(WebElement ele, String data, String objectName) {
		waitForVisibility(ele,30,objectName);
		if (ele.isDisplayed()) {
			clearElement(ele, objectName);
			ele.sendKeys(data);
			System.out.println(objectName+" is entered to the username filed");
		} else {
			System.out.println(objectName + " element is not displayed");
		}
	}

	protected void waitForVisibility(WebElement ele, int i, String objectName) {
	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	protected void waitUntilPageLoads(WebElement ele, int i, String objectName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(objectName));
		}
	


	public void clearElement(WebElement ele, String ObjectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			System.out.println(ObjectName + " is cleared");
		} else {
			System.out.println(ObjectName + " element is not displayed");
		}
	}

	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			System.out.println(objectName + " is clicked");
			
		} else {
			System.out.println(objectName + "button element is not enabled");
			
		}
}
	
	
	
}