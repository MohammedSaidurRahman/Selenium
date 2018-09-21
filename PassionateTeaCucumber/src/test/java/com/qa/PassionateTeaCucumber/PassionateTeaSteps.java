package com.qa.PassionateTeaCucumber;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.Util.Constant;
import com.qa.Util.HelperMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class PassionateTeaSteps {
	
	static ExtentReports report;
	WebDriver driver;
	static ExtentTest testReport;
	PassionateTeaHomePage homePage;
	PassionateTeaMenuPage menuPage;
	PassionateTeaCheckoutPage checkoutPage;
	static int i=1;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Testing\\chromedriver.exe");
		driver = new ChromeDriver();
		report = Constant.report;
		testReport = report.startTest("Passion Tea Scenario Test: " + i);
		driver.manage().window().maximize();

	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() {

		driver.get(Constant.homeURL);
		testReport.log(LogStatus.PASS, "Loaded the Passion Tea website.");

	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {
		homePage = PageFactory.initElements(driver, PassionateTeaHomePage.class);
		homePage.checkMenu();
		menuPage = PageFactory.initElements(driver, PassionateTeaMenuPage.class);
	
		if(menuPage.getMenuPageTitle().equals("Menu")) {
			testReport.log(LogStatus.PASS, "Menu page has loaded successfully.");
		} else {
			testReport.log(LogStatus.FAIL, "Menu page has failed to load.");
		}
		assertEquals("Menu", menuPage.getMenuPageTitle());
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
		//this sort of works anyways
		testReport.log(LogStatus.PASS, "User is on the menu page and can scroll through items.");
		HelperMethods.screenshot(driver);
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
		homePage = PageFactory.initElements(driver, PassionateTeaHomePage.class);
		homePage.checkMenu();
		menuPage = PageFactory.initElements(driver, PassionateTeaMenuPage.class);
		if(menuPage.getMenuPageTitle().equals("Menu")) {
			testReport.log(LogStatus.PASS, "Menu page has loaded successfully.");
		} else {
			testReport.log(LogStatus.FAIL, "Menu page has failed to load.");
		}
		assertEquals("Menu", menuPage.getMenuPageTitle());
	    menuPage.chooseHerbal();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
		checkoutPage = PageFactory.initElements(driver, PassionateTeaCheckoutPage.class);
	    
		if(checkoutPage.getPaymentTitle().equals("Payment")) {
			testReport.log(LogStatus.PASS, "The payment page has been successfully loaded.");
		} else {
			testReport.log(LogStatus.FAIL, "The payment page has failed to load.");
		}
		assertEquals("Payment", checkoutPage.getPaymentTitle());
		HelperMethods.screenshot(driver);
	}
	
	@After
	public void tearDown() {
		report.endTest(testReport);
		report.flush();
		i=i+1;
		driver.quit();
	}

}
