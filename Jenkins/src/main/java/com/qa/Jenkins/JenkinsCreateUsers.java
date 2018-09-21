package com.qa.Jenkins;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class JenkinsCreateUsers {
	
	@FindBy(xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	private WebElement createUserLinkSecurity;
	
	@FindBy(xpath ="//*[@id=\"main-panel\"]/h1")
	private WebElement createUserTitle;
	
	@FindBy(id = "people")
	private WebElement checkNames;	
	
	@FindBy(xpath = "//*[@id=\"people\"]/tbody/tr[3]/td[2]/a")
	private WebElement chris;
	
	@FindBy(linkText = "arg1")
	private WebElement listOfNames;	
	
	public String getListOfNames() {
		return listOfNames.getText();
	}
	

	public String getCheckNames() {
		return checkNames.getText();
	}

	public String getCreateUserTitle() {
		return createUserTitle.getText();
	}
	
	public void navigateToCreateUserFinal() {
		createUserLinkSecurity.click();
	}
	

}

//driver.get(linkText(arg1).click