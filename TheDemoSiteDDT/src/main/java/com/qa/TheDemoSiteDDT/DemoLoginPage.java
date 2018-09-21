package com.qa.TheDemoSiteDDT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;

import Utils.ExcelUtils;

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
	
	int i = 1;

	public void loginUser() {
		for (; i < ExcelUtils.getExcelWSheet().getPhysicalNumberOfRows(); i++) {
			userNameLogin.click();
			userNameLogin.sendKeys(ExcelUtils.getCellData(i, 0));
			DemoLoginTest.testReport.log(LogStatus.INFO, "Input Username");
			
			userPasswordLogin.click();
			userPasswordLogin.sendKeys(ExcelUtils.getCellData(i, 1));
			DemoLoginTest.testReport.log(LogStatus.INFO, "Input password");
			
			loginAttempt.click();
			DemoLoginTest.testReport.log(LogStatus.INFO, "Logged In");
			break;
		}
	}

}
