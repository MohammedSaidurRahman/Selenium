package com.qa.ShoppingWebsite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingHomePage {
	
	@FindBy(id = "search_query_top")
	private WebElement searchBar;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/h1/span[1]")
	private WebElement textCheck;
	
	
	
	public String getTextCheck() {
		return textCheck.getText();
	}



	public void searchText() {
		searchBar.sendKeys("Dresses");
		searchBar.submit();
		
	}

}
