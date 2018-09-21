package com.qa.TheDemoSitePOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoHomePage 
{

	@FindBy(xpath="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement userLink;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td[1]/p[1]/big/strong")
	private WebElement checkText;
	
	
	public String getCheckText() {
		return checkText.getText();
	}

	public void navigateToUserPage() {
		
		userLink.click();

	}
	
}

