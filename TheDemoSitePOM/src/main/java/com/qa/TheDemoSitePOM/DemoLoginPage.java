package com.qa.TheDemoSitePOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoLoginPage {
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	private WebElement userNameLogin;
	
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement userPasswordLogin;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
	private WebElement loginAttempt;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement success;
	
	public String getSuccess() {
		return success.getText();
	}

	public void loginUser() {
		userNameLogin.click();
		userNameLogin.sendKeys("JulietPapa");
		
		userPasswordLogin.click();
		userPasswordLogin.sendKeys("JulietPapa");
		
		loginAttempt.click();
	}

}
