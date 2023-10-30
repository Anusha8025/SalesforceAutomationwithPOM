package com.automation.tests.Scripts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtentTestScript {

	static ExtentTest test;
	public static void login_to_salesforce_failed() {
		test.info("inside login_to_salesforce_failed");
	}

	public static void login_to_salesforce_success() {
		test.info("inside login_to_salesforce_success");
	}

	public static void CheckRemeberMe() {
		test.info("inside CheckRemeberMe");
	}
	
	public static void ForgotPassword() {
		test.info("inside ForgotPassword");
	}
	
	public static void IncorrectUsernameAndPasswd() {
		test.info("inside IncorrectUsernameAndPasswd");
	}

	public static void main(String[] args) {
		ExtentReports extent = new ExtentReports();
		 extent.setSystemInfo("Host Name", "Salesforce");
	   	 extent.setSystemInfo("Environment", "Automation Testing");
	   	 extent.setSystemInfo("User Name", "Anusha");
		
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/results/extentreport/MySpark.html");
		spark.config().setDocumentTitle("Test Execution Report");
	   	spark.config().setReportName("firebase regression tests");
	   	spark.config().setTheme(Theme.DARK);
	   	 
		extent.attachReporter(spark);
		
		test= extent.createTest("login_to_salesforce_failed");
		test.info("login_to_salesforce_failed has started");
		login_to_salesforce_failed();
		test.info("login_to_salesforce_failed has ended");
		
		
		test= extent.createTest("login_to_salesforce_success");
		test.info("login_to_salesforce_success has started.....................");
		login_to_salesforce_success();
		test.info("login_to_salesforce_success has ended");
		
		
		test= extent.createTest("CheckRemeberMe");
		test.info("CheckRemeberMe has started*************************");
		CheckRemeberMe();
		test.info("CheckRemeberMe has ended");
		extent.flush();
		System.out.println("completed");
		
		test= extent.createTest("ForgotPassword");
		test.info("ForgotPassword has started*************************");
		ForgotPassword();
		test.info("ForgotPassword has ended");
		extent.flush();
		System.out.println("completed");
		
		test= extent.createTest("IncorrectUsernameAndPasswd");
		test.info("IncorrectUsernameAndPasswd has started*************************");
		IncorrectUsernameAndPasswd();
		test.info("IncorrectUsernameAndPasswd has ended");
		
		extent.flush();
		System.out.println("completed");
	}

}
