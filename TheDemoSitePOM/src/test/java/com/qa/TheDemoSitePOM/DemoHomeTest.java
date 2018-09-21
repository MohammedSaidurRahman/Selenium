package com.qa.TheDemoSitePOM;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoHomeTest {

	public static ExtentReports report;
	public ExtentTest test;
	public static String testName = "HomeToAddUser.html";
	
	WebDriver driver;
	
	@BeforeClass
	public static void intitial() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\DemoSiteReport\\" + testName, true);
	}
	
	@Before
	public void setUp() {
		System.setProperty(Constant.cDFilePath, Constant.driverType);
		driver = new ChromeDriver();
		driver.get(Constant.URL1);
		driver.manage().window().maximize();
	}

	@Test
	public void navigationMethod() {
		test = report.startTest("Navigating to the 'Add a User' page from the Home page.");
		test.log(LogStatus.INFO, "The site has loaded.");
		DemoHomePage demoPage = PageFactory.initElements(driver, DemoHomePage.class);
		test.log(LogStatus.INFO, "The home page has been loaded successfully.");
		demoPage.navigateToUserPage();
		test.log(LogStatus.INFO, "The user has clicked the 'Add User' link.");
		
		if(demoPage.getCheckText().equals("3. Add a User")) {
			test.log(LogStatus.PASS, "The site has successfully loaded the 'Add a User' page.");
		} else {
			test.log(LogStatus.FAIL, "The site has failed to reach the 'Add a User' page.");
		}
		assertEquals("3. Add a User", demoPage.getCheckText());
		
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

