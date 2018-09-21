package com.qa.PassionateTeaCucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PassionateTeaHomePage {
	
	
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	private WebElement menuBar;

	
	//Assert equals checkers
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914886\"]/div/h1")
	private WebElement homePageTitle;
	

	public String getHomePageTitle() {
		return homePageTitle.getText();
	}
	

	

	public void checkMenu() {
		menuBar.click();
		
	}
	

}
