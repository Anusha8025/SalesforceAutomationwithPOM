package com.automation.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class HomePage extends BasePage{

@FindBy(id ="userNav-arrow") WebElement userMenuDropDownEle;
	
	public HomePage (WebDriver driver) {
		super(driver);
	}
	
	/*
	 * public String getTextFromStudentRegistrationFormText() {
	 * waitForVisibility(studentRegistration, 30,"studetn resitration text area");
	 * String data= getTextFromElement(studentRegistration, "stu regi form text");
	 * System.out.println("text extracted from registartion page="+data); return
	 * data; }
	 */
	
	/*
	 * public String getPageTitle() { myLog.info("page tittle is returned"); return
	 * driver.getTitle(); }
	 */
	public String getTitleOfThePAge() throws InterruptedException {
		Thread.sleep(2000);
		String data = driver.getTitle();
		System.out.println("data ="+ data);
		return data;
		
	}
	
	public  WebDriver clickuserMenuDropDown() {
		clickElement(userMenuDropDownEle, "userMenuDropDown");
		return driver;
	}
	
}
