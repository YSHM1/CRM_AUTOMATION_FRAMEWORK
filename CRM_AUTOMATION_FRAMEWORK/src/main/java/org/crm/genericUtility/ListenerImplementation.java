package org.crm.genericUtility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation extends ThreadSafeInstanceClass implements ITestListener,ISuiteListener{

	private ExtentReports extentReports;
	private ExtentTest extentTest;
	public static ExtentTest testLog;
	
	@Override //@BeforeSuite
	public void onStart(ISuite suite) {
//		System.out.println(suite.getClass().getSimpleName());
	}

	@Override //@AfterSuite
	public void onFinish(ISuite suite) {
	}
	
	@Override //@BeforeTest
	public void onStart(ITestContext context) {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./Extent-Report-Output/emailable-extent_report.html");
		extentSparkReporter.config().setDocumentTitle("Document-Title");
		extentSparkReporter.config().setReportName(/*context.getName()*/"Report Name");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("OS", "Windows 11");
		extentReports.setSystemInfo("Browser", "Chrome");
		extentReports.setSystemInfo("Browser Version", "103.11.234");

	}

	@Override //@BeforeMethod
	public void onTestStart(ITestResult result) {
		String className = result.getMethod().getRealClass().getSimpleName();
		extentTest = extentReports.createTest(className+"  "+result.getMethod().getMethodName());
		extentTest.assignAuthor("Yash");
		extentTest.assignCategory("Smoke-Testing");
		testLog = extentTest;
	}

	@Override //@AfterMethod
	public void onTestSuccess(ITestResult result) {
		extentTest.pass(result.getMethod().getMethodName()+" is Pass");
		Reporter.log(result.getMethod().getMethodName()+" Success");
	}

	@Override //@AfterMethod
	public void onTestFailure(ITestResult result) {
		extentTest.fail(result.getMethod().getMethodName()+" is Fail"); 
		extentTest.fail(result.getThrowable()); //fail(throwable t)
		
		ThreadSafeInstanceClass.setThreadSafeWebDriverUtilityObject();
		ThreadSafeInstanceClass.setThreadSafeJavaUtilityObject();
		ThreadSafeInstanceClass.getThreadSafeWebDriverUtilityObject().takeScreenshot(result.getMethod().getMethodName(), getThreadSafeJavaUtilityObject());
		Reporter.log(result.getMethod().getMethodName()+" Fail");
		
		//extentTest.addScreenCaptureFromPath(ThreadSafeInstanceClass.getThreadSafeJavaUtilityObject().getAbsoluteFilePath("/ErrorShots"));	
		
		String screenShotPath = ThreadSafeInstanceClass.getThreadSafeWebDriverUtilityObject().takeScreenshotByBase64();
	
		extentTest.addScreenCaptureFromBase64String(screenShotPath, result.getMethod().getMethodName());
	}

	@Override //@AfterMethod
	public void onTestSkipped(ITestResult result) {
		extentTest.skip(result.getMethod().getMethodName()+" is skipped");
		extentTest.skip(result.getThrowable());
	}

	@Override //@AfterMethod
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override //@AfterMethod
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	

	@Override //@AfterTest
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
	

}
