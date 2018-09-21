package com.qa.TheDemoSiteDDT;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.Constant;
import Utils.ExcelUtils;
import Utils.HelperMethods;

public class DemoLoginTest{

	static ExtentReports report;
	WebDriver driver;
	static ExtentTest testReport;
	
	@BeforeClass
	public static void intitial() {
		
	}

	@Before
	public void setUp() throws Exception {
		ExcelUtils.setExcelFile(Constant.pathTestData + Constant.fileTestData, 0);

		System.setProperty("webdriver.chrome.driver", "C:\\Testing\\chromedriver.exe");
		driver = new ChromeDriver();

		report = new ExtentReports(
				"C:\\Users\\Admin\\Desktop\\DemoSiteData\\DDTData.html", true);

	}


	@Test
	public void test() throws InterruptedException {

		System.out.println(ExcelUtils.getExcelWSheet().getPhysicalNumberOfRows());
		
		DemoHomePage homePage = PageFactory.initElements(driver, DemoHomePage.class);
		DemoAddUserPage addUserPage = PageFactory.initElements(driver, DemoAddUserPage.class);
		DemoLoginPage loginPage = PageFactory.initElements(driver, DemoLoginPage.class);
		
		for (int i = 1; i < ExcelUtils.getExcelWSheet().getPhysicalNumberOfRows(); i++) {

			testReport = report.startTest("Excel Data Test: " + i);

			testReport.log(LogStatus.INFO, "Opening Browser");

			driver.get(Constant.websiteURL);

			testReport.log(LogStatus.INFO, "Navigated to thedemosite.co.uk");

			testReport.log(LogStatus.INFO, "Set up Excel Utils path - Opened file stream");

			
			homePage.navigateToUserPage();
			testReport.log(LogStatus.INFO, "Clicked on link to addUser page");

		
			addUserPage.userDetails();
			
	
			loginPage.loginUser();
			
			addUserPage.i = addUserPage.i +1;
			loginPage.i = loginPage.i +1;
			
			Actions action = new Actions(driver);

			action.moveByOffset(10, 10).perform();


			String title = loginPage.getSuccess();
			
			String expected = "**Successful Login**";

			if(title.equals(expected)) {
				testReport.log(LogStatus.PASS, "User logged in successfully.");
			} else {
				testReport.log(LogStatus.FAIL, "User has failed to log in.");
				ExcelUtils.setCellData("Fail", i, 2);
			}
			
		

			assertEquals(expected, title);

			ExcelUtils.setCellData("Pass", i, 2);
			testReport.log(LogStatus.PASS, "Demo Site Login Test");
			HelperMethods.screenshot(driver);
			report.endTest(testReport);
		}

	
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@AfterClass
	public static void end() {
		report.flush();
	}


}