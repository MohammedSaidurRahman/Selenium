package com.qa.PHPTravels;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;



public class TravelHomeTest {
	
	WebDriver driver;
	Actions action;
	String URL = "https://www.phptravels.net/";
	
	final String cDFilePath = "webdriver.chrome.driver";
			
	final String driverType = "C:\\Testing\\chromedriver.exe";
	
	
	
	@Before
	public void setUp() {
		System.setProperty(cDFilePath, driverType);
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		action = new Actions(driver);
	}
	
	@Test
	public void testName() {
		TravelHomePage travelHomePage = PageFactory.initElements(driver, TravelHomePage.class);
		travelHomePage.bookHotel(action);
	}
	
	@After
	public void tearDown() {
		driver.quit();
		
	}
}


