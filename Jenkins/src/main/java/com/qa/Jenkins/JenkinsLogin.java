package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsLogin {
	
	
	@FindBy(id = "j_username")
	private WebElement usernameLogin;
	
	@FindBy(xpath = "//*[@id=\"main-panel\"]/div/form/table/tbody/tr[2]/td[2]/input")
	private WebElement passwordLogin;
	
	public void login() {
		usernameLogin.click();
		usernameLogin.sendKeys("Admin");
		
		passwordLogin.click();
		passwordLogin.sendKeys("71524dc1dcde4dd3b41be19b1ed250bd");
		passwordLogin.submit();
	}

}
