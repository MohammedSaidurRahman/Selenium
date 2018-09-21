package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsHome {
	
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	private WebElement manageUserLink;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div[2]/h1")
	private WebElement checkHomeTitle;

	public String getCheckHomeTitle() {
		return checkHomeTitle.getText();
	}

	public void navigateToManageUser() {
		manageUserLink.click();
		
	}

}
