package swagLabs.GenericUtility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/*
 * This class provides implementation to ITestListner interface of TestNG
 * @author Roopa H
 * */

public class ListnersImplementation implements ITestListener{
	
//	For Extent Reports
	ExtentReports report;
	ExtentTest test;
	
//	Configuring current system date for screenshot name and report name
	
	Date d = new Date();
	SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
	String date = f.format(d);
	
	@Override
	public void onTestStart(ITestResult result) {
		
//		Capture the Test Method name
		String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName+"@Test Exceution started");
		
//		Intimate the extent report for each @Test execution
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
//		Capture the Test Method name
		String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName+"@Test Pass");
		
//		Log the status as PASS in Extent Report
		test.log(Status.PASS, methodName+"TestPass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {

//		Capture the Test Method name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"@Test Fail");
		
//		Capture and print the exception
		System.out.println(result.getThrowable());
		
//		Log the status as Fail in Extent Report
		test.log(Status.FAIL, methodName + " Test FAIL");	
			
//		Log the Exception captured in Extent Report
		test.log(Status.WARNING, result.getThrowable());
		
//		Capture the screenshot
		
		/*formulate screenshot name*/
		String screenshotName = methodName+"-"+date;
		SeleniumUtility s = new SeleniumUtility();
		
		try {
			String path = s.captureScreenShot(BaseClass.sdriver, screenshotName);
			s.captureScreenShot(BaseClass.sdriver, screenshotName);
			
//			Attach screenshot to the Extent Report
			test.addScreenCaptureFromPath(path);
			
			
		}
		catch(IOException e)
//		TODO Auto-generated catch block
		{
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
//		Capture the Test Method name
		String methodName = result.getMethod().getMethodName();
		
		System.out.println(methodName+"@Test Skip");
		
//		Capture and print the exception
		System.out.println(result.getThrowable());
		
//		Log the status as Skip in Extent Report
		test.log(Status.SKIP, methodName+"Test SKIP");
		
//		Log the Exception captured in Extent Report
		test.log(Status.WARNING, result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("@Test Exceution started");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("@Test Exceution started");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite Exceution started");
		
//		Extent Report Configuration
		ExtentSparkReporter esr = new ExtentSparkReporter(".//ExtentReports//Report - "+date+".html");
		esr.config().setDocumentTitle("Swag Labs Execution Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Execution Report - Build Version 2.3.0");

//		attach cofiguration to Extent Reports class
		ExtentReports report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Chrome Browser");
		report.setSystemInfo("Base Platform", "MAC family");
		report.setSystemInfo("Base Environment", "Testing Env");
		report.setSystemInfo("Report Name", "Roopa");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite Exceution Finished");
		
		//Flush the content to extent Reports
		if(report != null)
		{
			report.flush(); //report will generate
		}				

	}
	
}
