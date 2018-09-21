package com.qa.ShoppingWebsite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;



public class ShoppingHomeTest {
	
	WebDriver driver;
	
	String URL = "http://automationpractice.com/index.php";
	
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
	public void checkDresses() {
		ShoppingHomePage shoppingHomePage = PageFactory.initElements(driver, ShoppingHomePage.class);
		shoppingHomePage.searchText();
		
		assertEquals("\"DRESSES\"", shoppingHomePage.getTextCheck());

	}

	@After
	public void tearDown() {
		driver.quit();
	}


}
