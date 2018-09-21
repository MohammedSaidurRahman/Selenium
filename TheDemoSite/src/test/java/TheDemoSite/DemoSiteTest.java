package TheDemoSite;


import static org.junit.Assert.assertEquals;

import java.sql.Driver;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;






public class DemoSiteTest {
	
	WebDriver driver;
	
	String URL = "http://thedemosite.co.uk/";
	
	final String cDFilePath = "webdriver.chrome.driver";
			
	final String driverType = "C:\\Testing\\chromedriver.exe";
	
	
	@Before
	public void setUp() {
		System.setProperty(cDFilePath, driverType);
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		
	}

	//I could have created a variable that says JulietPapa for efficiency however I chose not to 
	//I could not find any ID tags so I used Xpath because it is the next preferred choice
	@Test
	public void method1() {
		WebElement addUser = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		addUser.click();
		
		WebElement userName = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		userName.click();
		userName.sendKeys("JulietPapa");
		
		WebElement userPassword = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		userPassword.click();
		userPassword.sendKeys("JulietPapa");
		
		WebElement saveDetails = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		saveDetails.click();
	
		WebElement loginPage = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		loginPage.click();
		
		WebElement userNameLogin = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		userNameLogin.click();
		userNameLogin.sendKeys("JulietPapa");
		
		WebElement userPasswordLogin = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		userPasswordLogin.click();
		userPasswordLogin.sendKeys("JulietPapa");
		
		WebElement loginAttempt = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		loginAttempt.click();
		
		
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}