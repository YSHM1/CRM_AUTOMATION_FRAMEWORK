package org.crm.genericUtility;

import org.crm.pomrepository.CommonPage;
import org.crm.pomrepository.LoginPage;
import org.crm.pomrepository.MoreTabPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass1 extends InstanceClass {
//	@Parameters("BROWSER")
	@BeforeTest
	public void testScriptExecutionSetup() {
		ThreadSafeInstanceClass.setThreadSafeFileUtilityObject();
		ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().loadPropertyFile(IConstants.VTIGERPROPERTYFILEPATH);
		browser = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("browser");
		url=ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("url");

		ThreadSafeInstanceClass.setThreadSafeWebDriverUtilityObject();
		WebDriver driver = ThreadSafeInstanceClass.getThreadSafeWebDriverUtilityObject().openBrowser(browser);
		ThreadSafeInstanceClass.setThreadSafeDriverObject(driver);
		ThreadSafeInstanceClass.getThreadSafeWebDriverUtilityObject().enterUrl(url);
	}
	
	@BeforeClass
	public void fileSetup() {
		ThreadSafeInstanceClass.setThreadSafeFileUtilityObject();
		ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().loadPropertyFile(IConstants.VTIGERPROPERTYFILEPATH);
		userName = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("userName");
		pwd = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("pwd");
		timeout = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("timeout");
		
		ThreadSafeInstanceClass.setThreadSafeExcelUtilityObject();
		ThreadSafeInstanceClass.getThreadSafeExcelUtilityObject().loadExcelFile(IConstants.VTIGEREXCELFILEPATH);
		
		ThreadSafeInstanceClass.setThreadSafeJavaUtilityObject();
		longTimeout = ThreadSafeInstanceClass.getThreadSafeJavaUtilityObject().convertStringToLong(timeout);
		randomNumber = ThreadSafeInstanceClass.getThreadSafeJavaUtilityObject().getRandomNumber();
	}
	
	@BeforeMethod
	public void login() {
		loginPage = new LoginPage();
		commonPage = new CommonPage();
		moreTabPage = new MoreTabPage();
	
//		browser = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("browser");
		loginPage.login(userName, pwd);
		ThreadSafeInstanceClass.getThreadSafeWebDriverUtilityObject().implicitWait(longTimeout);
		ThreadSafeInstanceClass.getThreadSafeWebDriverUtilityObject().initializeExplicitWait(longTimeout, 300);
	}
	
	@AfterMethod
	public void userLogout() {
		commonPage.logOut(ThreadSafeInstanceClass.getThreadSafeWebDriverUtilityObject());
	}

	@AfterTest
	public void closeBrowser() {
		ThreadSafeInstanceClass.getThreadSafeWebDriverUtilityObject().closeBrowser();
		ThreadSafeInstanceClass.getThreadSafeExcelUtilityObject().closeExcelFile();
	}

	@AfterSuite
	public void closeConnection() {
	}
}
