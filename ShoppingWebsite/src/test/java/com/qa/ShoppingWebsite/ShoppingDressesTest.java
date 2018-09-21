package com.qa.ShoppingWebsite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingDressesTest {
	
	WebDriver driver;
	
	String URL = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dresses&submit_search=";
	
	final String cDFilePath = "webdriver.chrome.driver";
			
	final String driverType = "C:\\Testing\\chromedriver.exe";
	
	
	@Before
	public void setUp() {
		System.setProperty(cDFilePath, driverType);
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		
	}

	@Test
	public void method1() {
		ShoppingDressesPage dressPage = PageFactory.initElements(driver, ShoppingDressesPage.class);
		dressPage.dressSelect();
		
		assertEquals("Printed Summer Dress", dressPage.getDressTitle());

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
