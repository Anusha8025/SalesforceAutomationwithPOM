package com.automation.tests.Scripts;

import java.util.Properties;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
// design pattern --- page object model
import com.automation.tests.Base.BaseTest;
import com.automation.tests.utilities.PropertiesUtility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.forgotPasswd.CheckYourEmailPage;
import com.automation.pages.forgotPasswd.forgotPasswdPage;
import com.automation.pages.home.HomePage;
import com.automation.pages.login.LoginPage;
import com.automation.tests.utilities.PropertiesUtility;


public class SalesForceAutomationScript extends BaseTest {
	
	@Test
	public void login_to_salesforce_failed () throws InterruptedException {
		//log4j: log
		//extent report
		myLog.info("******login_to_salesforce - password empty automation script started***********");
		String expected="Please enter your password.";
		PropertiesUtility pro=new PropertiesUtility();
		Properties p=pro.createPropertyObject();
		pro.loadFile("applicationDataProperties",p);
		String username=pro.getPropertyValue("login.valid.userid",p);
		String password=pro.getPropertyValue("login.valid.password",p);
		
		myLog.info("Password not entered");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName(username);
		loginPage.clearPassword();
		driver=loginPage.clickLoginButton();
		
		Thread.sleep(2000);
		
		String actual = loginPage.getTextFromLoginError();
		System.out.println("actual ="+ actual);
		Assert.assertEquals(actual, expected);
		myLog.info("Error message displayed");
		myLog.info("******login_to_salesforce - password empty automation script ended***********");
	}
		
		@Test
		public void login_to_salesforce_success () throws InterruptedException {
			//log4j: log
			//extent report
			myLog.info("******login_to_salesforce - Login Successful automation script started***********");
			String expected="Home Page ~ Salesforce - Developer Edition";
			PropertiesUtility pro=new PropertiesUtility();
			Properties p=pro.createPropertyObject();
			pro.loadFile("applicationDataProperties",p);
			String username=pro.getPropertyValue("login.valid.userid",p);
			String password=pro.getPropertyValue("login.valid.password",p);
			
			
			LoginPage loginPage=new LoginPage(driver);
			loginPage.enterUserName(username);
			loginPage.enterPassword(password);
			myLog.info("Username and password entered");
			driver=loginPage.clickLoginButton();
			
			
			HomePage homePage=new HomePage(driver);
			Thread.sleep(5000);
			String actual = homePage.getTitleOfThePAge();		
			System.out.println("actual ="+ actual);
			Assert.assertEquals(actual, expected);
			myLog.info("******login_to_salesforce - Login Successful***********");
		}
			
			
			@Test
			public void CheckRemeberMe () throws InterruptedException {
				//log4j: log
				//extent report
				myLog.info("******login_to_salesforce - CheckRemeberMe automation script started***********");
				String expected="Home Page ~ Salesforce - Developer Edition";
				PropertiesUtility pro=new PropertiesUtility();
				Properties p=pro.createPropertyObject();
				pro.loadFile("applicationDataProperties",p);
				String username=pro.getPropertyValue("login.valid.userid",p);
				String password=pro.getPropertyValue("login.valid.password",p);
				
				
				LoginPage loginPage=new LoginPage(driver);
				loginPage.enterUserName(username);
				loginPage.enterPassword(password);
				loginPage.clickCheckBox();
				myLog.info("Username and password entered and Rememberme check box clicked");
				driver=loginPage.clickLoginButton();
				
				
				HomePage homePage=new HomePage(driver);
				Thread.sleep(5000);
				String actual = homePage.getTitleOfThePAge();		
				System.out.println("actual ="+ actual);
				Assert.assertEquals(actual, expected);
				myLog.info("******login_to_salesforce - Login Successful***********");
			}
			
			@Test
			public void ForgotPassword () throws InterruptedException {
				//log4j: log
				//extent report
				myLog.info("******login_to_salesforce - ForgotPassword automation script started***********");
				String expected="Forgot Your Password | Salesforce";
				PropertiesUtility pro=new PropertiesUtility();
				Properties p=pro.createPropertyObject();
				pro.loadFile("applicationDataProperties",p);
				String username=pro.getPropertyValue("login.valid.userid",p);
				//String password=pro.getPropertyValue("login.valid.password",p);
				
				
				LoginPage loginPage=new LoginPage(driver);
				driver = loginPage.clickForgotPasswordLink();
				//loginPage.enterPassword(password);
				//loginPage.clickCheckBox();
				myLog.info("Forgot Password Link clicked");
				//driver=loginPage.clickLoginButton();
				
				Thread.sleep(5000);
				forgotPasswdPage forgotPasswdpage=new forgotPasswdPage(driver);
				Thread.sleep(5000);
				//waitUntilPageLoads(WebElement ele, int i, String objectName)
				
				String actual = forgotPasswdpage.getTitleOfThePAge();		
				System.out.println("actual ="+ actual);
				Assert.assertEquals(actual, expected);
				myLog.info("Inside Forgot Password Page");
				
				forgotPasswdpage.enterUserName(username);
				forgotPasswdpage.clickContinue();
				myLog.info("continue Link clicked");
				
				Thread.sleep(5000);
				CheckYourEmailPage chkYrEmailPage = new CheckYourEmailPage(driver);
				String Act = chkYrEmailPage.getSentEmailMessage();
				String Exp="We’ve sent you an email with a link to finish resetting your password.";
				Assert.assertEquals(Act, Exp);
				myLog.info("******login_to_salesforce - ForgotPassword Successful***********");
			}
			
			@Test
			public void IncorrectUsernameAndPasswd () throws InterruptedException {
				//log4j: log
				//extent report
				myLog.info("******login_to_salesforce - IncorrectUsernameAndPasswd automation script started***********");
				String expected="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
				PropertiesUtility pro=new PropertiesUtility();
				Properties p=pro.createPropertyObject();
				pro.loadFile("applicationDataProperties",p);
				String username=pro.getPropertyValue("login.invalid.userid",p);
				String password=pro.getPropertyValue("login.invalid.password",p);
				
				
				LoginPage loginPage=new LoginPage(driver);
				loginPage.enterUserName(username);
				loginPage.enterPassword(password);
				myLog.info("Invalid Username and password entered");
				driver=loginPage.clickLoginButton();
				
				Thread.sleep(5000);
				String actual = loginPage.getTextFromincorrectCredentials();		
				System.out.println("actual ="+ actual);
				Assert.assertEquals(actual, expected);
				myLog.info("******login_to_salesforce - IncorrectUsernameAndPasswd Successful***********");
			}
			
			@Test
			public void Selectusermenuforusernamdropdown() throws InterruptedException {
				//log4j: log
				//extent report
				myLog.info("******login_to_salesforce - Selectusermenuforusernamdropdown automation script started***********");
				String expected="Home Page ~ Salesforce - Developer Edition";
				PropertiesUtility pro=new PropertiesUtility();
				Properties p=pro.createPropertyObject();
				pro.loadFile("applicationDataProperties",p);
				String username=pro.getPropertyValue("login.valid.userid",p);
				String password=pro.getPropertyValue("login.valid.password",p);
				
				
				LoginPage loginPage=new LoginPage(driver);
				loginPage.enterUserName(username);
				loginPage.enterPassword(password);
				myLog.info(" Username and password entered");
				driver=loginPage.clickLoginButton();
				
				HomePage homePage=new HomePage(driver);
				Thread.sleep(5000);
				homePage.clickuserMenuDropDown();
				displayDrownDownItems();
				
				
				myLog.info("******login_to_salesforce - IncorrectUsernameAndPasswd Successful***********");
			}
		
}