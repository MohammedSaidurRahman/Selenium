package com.qa.ShoppingWebsite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ShoppingDressesPage {
	


	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
	private WebElement printedDress;
	
	
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/div/div/div[3]/h1")
	private WebElement dressTitle;
	
	public String getDressTitle() {
		return dressTitle.getText();
	}
	
	public void dressSelect() {
		printedDress.click();
	}
	
}
