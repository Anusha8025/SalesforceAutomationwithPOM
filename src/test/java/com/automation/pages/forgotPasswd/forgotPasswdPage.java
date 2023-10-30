package com.automation.pages.forgotPasswd;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.pages.base.BasePage;

public class forgotPasswdPage extends BasePage {
	@FindBy(id="un") WebElement uNameEle;
	@FindBy(id="continue") WebElement continueEle;
	
	
	
	public forgotPasswdPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserName(String data) {
		//userNameElement.sendKeys(data);
		clearElement(uNameEle, "userName");
		enterText(uNameEle, data, "Username textbox");
	}
	
	public WebDriver clickContinue() {
		clickElement(continueEle, "Continue");
		return driver;
	}
	
	public String getTitleOfThePAge() {
		//waitUntilPageLoads();
		return driver.getTitle();
		//return getPageTitle();
	}
	
	
}
