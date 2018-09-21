package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsCreateUsersFinal {
	
	@FindBy(id= "username")
	private WebElement newUsername;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement newPassword;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement newConfirmPassword;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement newFullName;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	private WebElement newEmail;
	
	@FindBy(xpath ="//*[@id=\"main-panel\"]/form/h1")
	private WebElement userFinalStageTitle;

	
	public String getUserFinalStageTitle() {
		return userFinalStageTitle.getText();
	}

	public void createNewUser() {
		newUsername.click();
		newUsername.sendKeys("Mohammed");

		newPassword.click();
		newPassword.sendKeys("Mohammed");
		
		newConfirmPassword.click();
		newConfirmPassword.sendKeys("Mohammed");
		
		newFullName.click();
		newFullName.sendKeys("Mohammed Rahman");
		
		newEmail.click();
		newEmail.sendKeys("MohammedRahman@outlook.com");
		
		
	}
	
	public void createNewUserFromFile(String Username, String Password, String ConfirmPassword, String FullName, String EmailAddress) {
		newUsername.click();
		newUsername.sendKeys(Username);

		newPassword.click();
		newPassword.sendKeys(Password);
		
		newConfirmPassword.click();
		newConfirmPassword.sendKeys(ConfirmPassword);
		
		newFullName.click();
		newFullName.sendKeys(FullName);
		
		newEmail.click();
		newEmail.sendKeys(EmailAddress);
		
	}
	
	public void submitNewUserDetails() {
		newEmail.submit();
	}

	//

}
