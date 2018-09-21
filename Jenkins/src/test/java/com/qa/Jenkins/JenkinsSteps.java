package com.qa.Jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.Constant;
import Utils.HelperMethods;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class JenkinsSteps {
	
	WebDriver driver;
	static ExtentReports report;
	static ExtentTest testReport;
	static int i=1;
	
	JenkinsLogin jenkinsLogin;
	JenkinsHome jenkinsHome;
	JenkinsManageUsers jenkinsManageUsers;
	JenkinsCreateUsers jenkinsCreateUsers;
	JenkinsCreateUsersFinal jenkinsCreateUsersFinal;
	JenkinsViewUserInformation jenkinsViewUserInformation;
	JenkinsConfigureDetails jenkinsConfigureDetails;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Testing\\chromedriver.exe");
		driver = new ChromeDriver();
		report = Constant.report;
		testReport = report.startTest("Jenkins Test: " + i);
		driver.manage().window().maximize();
	}
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() {
	    // Write code here that turns the phrase above into concrete actions

		driver.get(Constant.loginURL);
		
		//log in page
		jenkinsLogin = PageFactory.initElements(driver, JenkinsLogin.class);
		jenkinsLogin.login();
		testReport.log(LogStatus.INFO, "Admin has logged in.");
		
		
		//home page
		jenkinsHome = PageFactory.initElements(driver, JenkinsHome.class);
		if(jenkinsHome.getCheckHomeTitle().equals("Welcome to Jenkins!")) {
			testReport.log(LogStatus.PASS, "Admin has logged in and been directed to the home page.");
		} else {
			testReport.log(LogStatus.FAIL, "Admin has logged in and been directed to the incorrect page.");
		}
		assertEquals("Welcome to Jenkins!", jenkinsHome.getCheckHomeTitle());
		jenkinsHome.navigateToManageUser();

		
		//manage users
		jenkinsManageUsers = PageFactory.initElements(driver, JenkinsManageUsers.class);
		if(jenkinsManageUsers.getManageTitle().equals("Manage Jenkins")) {
			testReport.log(LogStatus.PASS, "The user has sucessfully nagivated to the 'Manage Users' page.");
		} else {
			testReport.log(LogStatus.FAIL, "The user has navigated to the incorrect page.");
		}
		assertEquals("Manage Jenkins", jenkinsManageUsers.getManageTitle());
		jenkinsManageUsers.navigateToCreateUser();
		//log test
		
		
		//list of users page
		jenkinsCreateUsers = PageFactory.initElements(driver, JenkinsCreateUsers.class);
		if(jenkinsCreateUsers.getCreateUserTitle().equals("Users")) {
			testReport.log(LogStatus.PASS, "The user has navigated onto the list of users.");
		} else {
			testReport.log(LogStatus.FAIL, "The user has navigated to the incorrect page.");
		}
		assertEquals("Users", jenkinsCreateUsers.getCreateUserTitle());
		jenkinsCreateUsers.navigateToCreateUserFinal();
		
		//log test
		
		jenkinsCreateUsersFinal = PageFactory.initElements(driver, JenkinsCreateUsersFinal.class);
		if(jenkinsCreateUsersFinal.getUserFinalStageTitle().equals("Create User")) {
			testReport.log(LogStatus.PASS, "The user has navigated the last stage of user creation.");
		} else {
			testReport.log(LogStatus.FAIL, "The user has navigated to the incorrect page..");
		}
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() {
	    // Write code here that turns the phrase above into concrete actions
		jenkinsCreateUsersFinal = PageFactory.initElements(driver, JenkinsCreateUsersFinal.class);
		jenkinsCreateUsersFinal.createNewUser();
		testReport.log(LogStatus.INFO, "The user has entered details for a new user.");
		
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() {
	    // Write code here that turns the phrase above into concrete actions
		jenkinsCreateUsersFinal = PageFactory.initElements(driver, JenkinsCreateUsersFinal.class);
		HelperMethods.screenshot(driver);
		jenkinsCreateUsersFinal.submitNewUserDetails();
		testReport.log(LogStatus.INFO, "The user has tried to submit the user details.");
		
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() {
	    // Write code here that turns the phrase above into concrete actions
		jenkinsCreateUsers = PageFactory.initElements(driver, JenkinsCreateUsers.class);
		if(jenkinsCreateUsers.getCheckNames().contains("Mohammed")) {
			testReport.log(LogStatus.PASS, "The submission has worked correctly.");
		} else {
			testReport.log(LogStatus.FAIL, "The submission has not worked.");

		}
		assertEquals(true, jenkinsCreateUsers.getCheckNames().contains("Mohammed"));
		
		//see if you can do it for an existing member
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Fullname and \"([^\"]*)\" EmailAddress are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_Fullname_and_EmailAddress_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4, String arg5) {
	    // Write code here that turns the phrase above into concrete actions
		
		jenkinsCreateUsersFinal = PageFactory.initElements(driver, JenkinsCreateUsersFinal.class);
		jenkinsCreateUsersFinal.createNewUserFromFile(arg1, arg2, arg3, arg4, arg5);
		HelperMethods.screenshot(driver);
		testReport.log(LogStatus.INFO, "The user has tried to create a new user from the feature file.");
		//could improve
	
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		jenkinsCreateUsers = PageFactory.initElements(driver, JenkinsCreateUsers.class);
		if(jenkinsCreateUsers.getCheckNames().contains(arg1)) {
			testReport.log(LogStatus.PASS, "The user has successfully created a new user from the feature file.");
		} else {
			testReport.log(LogStatus.FAIL, "The user has failed to create a new user from the feature file.");

		}

	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		jenkinsCreateUsers = PageFactory.initElements(driver, JenkinsCreateUsers.class);
		if(driver.findElement(By.linkText(arg1)).isDisplayed()) {	
		testReport.log(LogStatus.PASS, "The user is able to view the list of all users.");
			} else {
		testReport.log(LogStatus.FAIL, "The user cannot view the list of all users.");

			}			
	}
	
	//Because I did not do the previous test the rest of the tests have not been tested
	//however I wrote the code that I thought would work so that if I fix the previous error it will run

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		jenkinsCreateUsers = PageFactory.initElements(driver, JenkinsCreateUsers.class);
		driver.findElement(By.linkText(arg1)).click();
		testReport.log(LogStatus.INFO, "The user is clicking on the username of a new user.");
	} 

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    jenkinsViewUserInformation = PageFactory.initElements(driver, JenkinsViewUserInformation.class);
	    jenkinsViewUserInformation.getUserID(arg1); 
	    assertEquals(arg1, jenkinsViewUserInformation.getUserID(arg1));
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		  jenkinsViewUserInformation = PageFactory.initElements(driver, JenkinsViewUserInformation.class);
		  jenkinsViewUserInformation.getUserID(arg1); 
		  assertEquals(arg1, jenkinsViewUserInformation.getUserID(arg1));
		    
		  testReport.log(LogStatus.INFO, "The correct page has loaded.");
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() {
	    // Write code here that turns the phrase above into concrete actions
	    jenkinsViewUserInformation.configureDetails();
	    
	    
	}

	@When("^I change the old email address on the Configure Page to a new email address \"([^\"]*)\"$")
	public void i_change_the_old_email_address_on_the_Configure_Page_to_a_new_email_address(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    jenkinsConfigureDetails.changeEmail(arg1);
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() {
	    // Write code here that turns the phrase above into concrete actions
	    jenkinsConfigureDetails.saveChange();
	}

	@Then("^the Configure Page should show the new email address \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_new_email_address(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    if(jenkinsConfigureDetails.checkEmail().equals(arg1)) {
			testReport.log(LogStatus.PASS, "The email address field has successfully been changed.");
	    } else {
			testReport.log(LogStatus.FAIL, "The email address has not changed.");
	    }
	    assertEquals(arg1, jenkinsConfigureDetails.checkEmail().equals(arg1));
	}
	
	@After
	public void tearDown() {
		report.endTest(testReport);
		report.flush();
		i=i+1;
		driver.quit();
		
	}


}
