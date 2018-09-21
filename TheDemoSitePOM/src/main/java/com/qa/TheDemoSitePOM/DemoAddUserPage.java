package com.qa.TheDemoSitePOM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class DemoAddUserPage {
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
	private WebElement userName;

	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
	private WebElement userPassword;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
	private WebElement submitDetails;

	@FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement loginPage;
	
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/p[1]/big/strong")
	private WebElement  textCheck;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/blockquote/blockquote[2]/blockquote")
	private WebElement checkLogin;
	
	
	
/*	public String getCheckLogin() {
		return checkLogin.getText();
	}*/



	public String getTextCheck() {
		return textCheck.getText();
	}



	public void userDetails() {
		userName.click();
		userName.sendKeys("JulietPapa");
		userPassword.click();
		userPassword.sendKeys("JulietPapa");
		submitDetails.click();
	
	}
	
	public void navigate() {
		loginPage.click();
	}
}


