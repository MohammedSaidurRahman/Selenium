package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsViewUserInformation {

	@FindBy(xpath = "//*[@id=\"tasks\"]/div[1]/a[2]")
	private WebElement backButton;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div[2]")
	private WebElement userID;
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement configureLink;
	
	public String getUserID(String arg1) {
		return userID.getText();
	}

	public void navigateBackToUserList() {
		backButton.click();
	}
	
	public void configureDetails() {
		configureLink.click();
	}
	
	
	
	
}
