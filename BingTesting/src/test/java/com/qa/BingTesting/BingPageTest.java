package com.qa.BingTesting;

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

public class BingPageTest {

public static ExtentReports report;
public ExtentTest test;
public static String testname = "testNamer1.html";


	@BeforeClass
	public static void initial() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\BingTest\\" + testname, true);
	}
	
	WebDriver driver = null;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Testing\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void bingSearchBox() {
		test = report.startTest("Search Text");
		driver.get("https://www.bing.com/");
		test.log(LogStatus.INFO, "Bing has opened.");
		BingPage page = PageFactory.initElements(driver, BingPage.class);
		page.searchFor("Selenium");
		WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
		
		test.log(LogStatus.INFO, "The String Selenium has been searched.");
		if(checkBox.getText().equals("Selenium")) {
			test.log(LogStatus.PASS, "The search text was found.");
		}else {
			test.log(LogStatus.FAIL, "The search text was not found.");
		}
		
	}
	
	@Test
	public void bingSearchBoxKitens() {
		test = report.startTest("Search Text");
		driver.get("https://www.bing.com/");
		test.log(LogStatus.INFO, "Bing has opened.");
		BingPage page = PageFactory.initElements(driver, BingPage.class);
		page.searchFor("Kittens");
		WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li/div/div[2]/h2"));
		
		test.log(LogStatus.INFO, "The String Selenium has been searched.");
		if(checkBox.getText().equals("Selenium")) {
			test.log(LogStatus.PASS, "The search text was found.");
		}else {
			test.log(LogStatus.FAIL, "The search text was not found.");
		}
		assertEquals("Selenium", checkBox.getText());
		
	}
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		driver.quit();
	}
	
	@AfterClass
	public static void end() {
		report.flush();
	}

}
