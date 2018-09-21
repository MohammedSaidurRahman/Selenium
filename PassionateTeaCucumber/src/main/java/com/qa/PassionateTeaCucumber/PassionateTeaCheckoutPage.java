package com.qa.PassionateTeaCucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PassionateTeaCheckoutPage {
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/fieldset[2]/legend")
	private WebElement paymentTitle;
	
	
	public String getPaymentTitle() {
		return paymentTitle.getText();
	}
	
	
	public void checkPayment() {
		
	}

}
