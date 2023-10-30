package com.automation.pages.login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.pages.base.BasePage;

public class LoginPage extends BasePage {
	@FindBy(id="username") WebElement userNameElement;
	@FindBy(id="password") WebElement passwordElement;
	@FindBy(id="Login") WebElement loginButtonElement;
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/div[1]") WebElement loginErrorElement;
	@FindBy(name="rememberUn") WebElement CheckBoxEle;
	@FindBy(id="forgot_password_link") WebElement forgot_password_linkEle;
	@FindBy(id="error") WebElement incorrectCredentialsEle;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserName(String data) {
		//userNameElement.sendKeys(data);
		clearElement(userNameElement, "userName");
		enterText(userNameElement, data, "Username textbox");
	}
	
	public void clearPassword() {
		clearElement(passwordElement, "password");
	}
	
	public void enterPassword(String data) {
		clearElement(passwordElement, "password");
		enterText(passwordElement, data, "password textbox");
	}
	
	
	public void clickCheckBox() {
		clickElement(CheckBoxEle, "Check Box");
	}
	
	public  WebDriver clickForgotPasswordLink() {
		clickElement(forgot_password_linkEle, "forgot_password_linkEle");
		return driver;
	}
	
		
	
	public WebDriver clickLoginButton() {
		clickElement(loginButtonElement,"login button");
		return driver;
		
	}
	
	
	
	public String getTextFromincorrectCredentials () {
		String data = incorrectCredentialsEle.getText();
		System.out.println("text extracted from incorrectCredentialsEle="+data);
		
		
		return data;
	}
	
	public String getTextFromLoginError () {
		WebElement loginError1 =driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/div[3]/form/div[1]"));
		//waitForVisibility(loginErrorElement, 30,"login Error");
		//String data= getTextFromElement(loginError1, "loginError text");
		String data = loginError1.getText();
		System.out.println("text extracted from loginErrorElement="+data);
		
		
		return data;
	}
	
	public String getTitleOfThePAge() {
		//waitUntilPageLoads();
		return getPageTitle();
	}
	
	
	

}
