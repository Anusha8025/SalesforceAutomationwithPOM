package com.automation.pages.forgotPasswd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.pages.base.BasePage;

public class CheckYourEmailPage extends BasePage {

	@FindBy(xpath ="/html/body/div[1]/div/div/div[2]/div/div/p[1]") WebElement messageEle;
	
	public CheckYourEmailPage(WebDriver driver) {
		super(driver);
	}
	
	public String getSentEmailMessage() {
		//return getTextFromElement(messageEle, "Email sent Message");
		return messageEle.getText();
	}
}
