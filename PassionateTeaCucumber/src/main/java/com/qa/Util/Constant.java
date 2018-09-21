package com.qa.Util;

import com.relevantcodes.extentreports.ExtentReports;

public class Constant {
	
	public static final String homeURL =
			"http://www.practiceselenium.com/welcome.html ";
	
	public static final String menuURL =
			"http://www.practiceselenium.com/menu.html";
	
	public static final String reportPath = 
			"C:\\\\Users\\\\Admin\\\\Desktop\\\\PassionateTeaReport\\\\PassionateTeaReport.html";
	
	public static final String Path_TestData = 
			"";
	
	public static final String File_TestData =
			"";
	
	public static final String cDFilePath =
			"webdriver.chrome.driver";
	
	public static final String driverType =
			"C:\\Testing\\chromedriver.exe";
	
	public static ExtentReports report = new ExtentReports(
			"C:\\Users\\Admin\\Desktop\\PassionateTeaReport\\PassionateTeaReport.html", true);
}
