package Selenium;


import static org.junit.Assert.assertEquals;

import java.sql.Driver;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;






public class SeleniumTest {
	
	WebDriver driver;
	
	String URL = "https://www.google.co.uk/";
	
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
		WebElement searchBar = driver.findElement(By.id("lst-ib")); // this gets the element with this id and stores it into the checkElement variable. Otherwise it would just retrieve it and not store it anywhere
		searchBar.click();
		searchBar.sendKeys("hyde");
		searchBar.submit();
		
		assertEquals("hyde", searchBar.getText());

	} 

	@After
	public void tearDown() {
		driver.quit();
	}

}
