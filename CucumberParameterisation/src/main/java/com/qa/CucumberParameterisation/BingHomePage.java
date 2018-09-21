package com.qa.CucumberParameterisation;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class BingHomePage {

		@FindBy(id = "sb_form_q")
		private WebElement searchBox;
		
		
		public void sendKeysToSearch(String textToSearch) {
				searchBox.sendKeys(textToSearch);	
				searchBox.submit();
		}
}


