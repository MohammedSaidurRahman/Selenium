package com.qa.TheDemoSitePOM;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoLoginTest {
	
	public static ExtentReports report;
	public ExtentTest test;
	public static String testName = "UserLoginTest.html";
	
	WebDriver driver;
	
	
	@BeforeClass
	public static void intitial() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\DemoSiteReport\\" + testName, true);
	}
	
	@Before
	public void setUp() {
		System.setProperty(Constant.cDFilePath, Constant.driverType);
		driver = new ChromeDriver();
		driver.get(Constant.URL3);
		driver.manage().window().maximize();
		
	}

	@Test
	public void userLogin() {
		test = report.startTest("User Login test.");

		DemoLoginPage loginPage = PageFactory.initElements(driver, DemoLoginPage.class);
		loginPage.loginUser();
		
		if(loginPage.getSuccess().equals("**Successful Login**")) {
			test.log(LogStatus.PASS, "The user has successfully logged in.");
		} else {
			test.log(LogStatus.FAIL, "The user has failed to log in.");
		}
		
		assertEquals("**Successful Login**", loginPage.getSuccess());

	}

	@After
	public void tearDown() {
		report.endTest(test);
		driver.quit();
	}
	
	@AfterClass
	public static void end() {
		report.flush();
	}


}
