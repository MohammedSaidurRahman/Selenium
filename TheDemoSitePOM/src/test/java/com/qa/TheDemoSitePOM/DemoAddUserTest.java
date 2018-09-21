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

public class DemoAddUserTest {
	
	public static ExtentReports report;
	public ExtentTest test;
	public static String testName = "AddingUser.html";
	
	WebDriver driver;
	
	@BeforeClass
	public static void intitial() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\DemoSiteReport\\" + testName, true);
	}
	
	@Before
	public void setUp() {
		System.setProperty(Constant.cDFilePath, Constant.driverType);
		driver = new ChromeDriver();
		driver.get(Constant.URL2);
		driver.manage().window().maximize();
		
	}

	@Test
	public void navigationMethod() {
		test = report.startTest("Adding a user to the site.");
		DemoAddUserPage addUserPage = PageFactory.initElements(driver, DemoAddUserPage.class);
		addUserPage.userDetails();
		
		
	//	assertEquals("", addUserPage.getCheckLogin());
		
		addUserPage.navigate();
		
		if(addUserPage.getTextCheck().equals("4. Login")) {
			test.log(LogStatus.PASS, "The site has successfully added a user.");
		} else {
			test.log(LogStatus.FAIL, "The site has failed to added a user.");
		}
		assertEquals("4. Login", addUserPage.getTextCheck());
		test.log(LogStatus.INFO, "The login page has been loaded successfully.");

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
