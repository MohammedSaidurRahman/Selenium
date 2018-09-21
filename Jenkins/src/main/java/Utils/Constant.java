package Utils;

import com.relevantcodes.extentreports.ExtentReports;

public class Constant {
	
	
	public static final String homeURL =
			"http://localhost:8080/";
	
	public static final String menuURL =
			"";
	
	public static final String loginURL = 
			"http://localhost:8080/login?from=%2F";
	
	public static final String reportPath = 
			"C:\\Users\\Admin\\Desktop\\JenkinsReport";
	
	public static final String Path_TestData = 
			"";
	
	public static final String File_TestData =
			"";
	
	public static final String cDFilePath =
			"webdriver.chrome.driver";
	
	public static final String driverType =
			"C:\\Testing\\chromedriver.exe";
	
	public static ExtentReports report = new ExtentReports(
			"C:\\Users\\Admin\\Desktop\\JenkinsReport\\JenkinsReport.html", true);

}
