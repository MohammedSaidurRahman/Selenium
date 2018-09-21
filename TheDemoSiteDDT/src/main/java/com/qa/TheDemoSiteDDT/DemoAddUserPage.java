package com.qa.TheDemoSiteDDT;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;

import Utils.ExcelUtils;

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

	public String getTextCheck() {
		return textCheck.getText();
	}

	int i = 1;

	public void userDetails() {
		
		for (; i < ExcelUtils.getExcelWSheet().getPhysicalNumberOfRows(); i++) {
			userName.click();
			userName.sendKeys(ExcelUtils.getCellData(i, 0));
			DemoLoginTest.testReport.log(LogStatus.INFO, "Input Username");
			userPassword.click();
			userPassword.sendKeys(ExcelUtils.getCellData(i, 1));
			DemoLoginTest.testReport.log(LogStatus.INFO, "Input password");
			submitDetails.click();
			DemoLoginTest.testReport.log(LogStatus.INFO, "Created New User");
			loginPage.click();
			DemoLoginTest.testReport.log(LogStatus.INFO, "Navigated to login page");
			break;
		}
	}
	
}


