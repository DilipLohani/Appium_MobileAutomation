package automation.TestUtils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;

import java.io.IOException;

import org.testng.ITestContext;

public class Listeners extends ExtentReporterNG implements ITestListener {
	
	ExtentTest test;
	AppiumDriver driver;
	
	ExtentReports extent = ExtentReporterNG.getReporterObject();
	
	 @Override
	    public void onTestStart(ITestResult result) {
	        // Code when test starts
		    test = extent.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        // Code when test passes
	    	test.log(Status.PASS, "Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        // Code when test fails
	    	test.fail(result.getThrowable());
	    	
	    	try {
				driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
						.get(result.getInstance());
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			try {
				test.addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        // Code when test is skipped
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Code for partial success
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        // Code before any test starts
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        // Code after all tests are finished
	    	
	    extent.flush();
	    
	    }

}

