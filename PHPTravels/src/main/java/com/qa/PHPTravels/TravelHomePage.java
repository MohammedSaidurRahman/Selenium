package com.qa.PHPTravels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TravelHomePage {
	
	@FindBy(xpath = "//*[@id=\"s2id_autogen8\"]/a/span[1]")
	private WebElement location;
	
	@FindBy(xpath = "//*[@id=\"dpd1\"]/div/input")
	private WebElement leaveDate;
	
	@FindBy(xpath = "/html/body/div[8]/div[1]/table/tbody/tr[4]/td[3]")
	private WebElement chooseLeaveDate;
	
	@FindBy(xpath = "//*[@id=\"dpd2\"]/div/input")
	private WebElement returnDate;
	
	@FindBy(xpath = "/html/body/div[9]/div[1]/table/tbody/tr[4]/td[6]" )
	private WebElement chooseReturnDate;
	
	@FindBy(xpath = "//*[@id=\"travellersInput\"]")
	private WebElement people;
	
	@FindBy(xpath = "//*[@id=\"adultMinusBtn\"]/i")
	private WebElement removeAdult;
	
	@FindBy(xpath = "//*[@id=\"childPlusBtn\"]")
	private WebElement addChild;
	
	@FindBy(xpath = "//*[@id=\"HOTELS\"]/form/div[5]/button")
	private WebElement searchButton;
	
	public void bookHotel(Actions action) {
		action.click(location).perform();
		//location.click();
		action.sendKeys("london").perform();
		//location.sendKeys("london");
		action.click(leaveDate).perform();
		//leaveDate.click();
		action.click(chooseLeaveDate);
		//chooseLeaveDate.click();
		action.click(returnDate);
		//returnDate.click();
		action.click(chooseReturnDate);
		//chooseReturnDate.click();
		action.click(people);
		//people.click();
		action.click(removeAdult);
		//removeAdult.click();
		//addChild.click();
		action.click(addChild);
		//searchButton.click();
	}
	

}
