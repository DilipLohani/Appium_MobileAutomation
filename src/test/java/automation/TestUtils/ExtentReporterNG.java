package automation.TestUtils;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.AppiumDriver;

public class ExtentReporterNG extends BaseTest{
	static ExtentReports extent;
	
	public static ExtentReports getReporterObject()
	
	{
			//extentreport , extentsprarkreports
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Mobile Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Dilip Lohani");
		return extent;
	
	
	}
	
	public String getScreenShotPath(String testCaseName, AppiumDriver driver) throws IOException
	{
		
	File source = driver.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports"+testCaseName+".png";
	FileUtils.copyFile(source, new File (destinationFile));
	return destinationFile;
		
	}
	
	

}
