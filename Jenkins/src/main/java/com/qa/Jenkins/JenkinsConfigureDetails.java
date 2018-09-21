package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsConfigureDetails {

	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/form/table/tbody/tr[17]/td[3]/input")
	private WebElement emailField;
	
	@FindBy(id = "yui-gen5-button")
	private WebElement saveButton;
	
	public void changeEmail(String arg1) {
		emailField.click();
		emailField.sendKeys(arg1);
	}
	
	public void saveChange() {
		saveButton.click();
	}
	
	public String checkEmail() {
		return emailField.getText();
	}
}
