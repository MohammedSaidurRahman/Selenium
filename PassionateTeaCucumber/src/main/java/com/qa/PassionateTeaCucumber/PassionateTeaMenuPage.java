package com.qa.PassionateTeaCucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PassionateTeaMenuPage {
	
	
	@FindBy(xpath = "//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]")
	private WebElement herbalTea;

	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914921\"]/div")
	private WebElement menuPageTitle;
	
	
	
	public void chooseHerbal() {
		herbalTea.click();
	}
	
	
	public String getMenuPageTitle() {
		return menuPageTitle.getText();
	}


}
