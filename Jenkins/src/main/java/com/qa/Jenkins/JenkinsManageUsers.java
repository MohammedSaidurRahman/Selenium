package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsManageUsers {
	
	@FindBy(xpath = "//*[@id=\"management-links\"]/tbody/tr[16]/td[2]/div[1]/a")
	private WebElement createUserLink;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/h1")
	private WebElement manageTitle;

	public String getManageTitle() {
		return manageTitle.getText();
	}
	
	public void navigateToCreateUser() {
		createUserLink.click();
	}
	


}
