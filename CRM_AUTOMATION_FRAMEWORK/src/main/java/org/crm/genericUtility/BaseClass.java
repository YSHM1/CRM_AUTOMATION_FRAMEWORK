package org.crm.genericUtility;

import org.crm.pomrepository.CommonPage;
import org.crm.pomrepository.LoginPage;
import org.crm.pomrepository.MoreTabPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass extends ThreadSafeInstanceClass {

	@BeforeSuite
	public void connectionSetup() {
//		ThreadSafeInstanceClass.setThreadSafeFileUtilityObject();
//		ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().loadPropertyFile(IConstants.VTIGERPROPERTYFILEPATH);
//		ThreadSafeInstanceClass.setThreadSafeDatabaseUtilityObject();
//
//		String dbUrl = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("dburl");
//		String databaseName = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject()
//				.getPropertyFileData("databaseName");
//		String dbUserName = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("dbuserName");
//		String dbPwd = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("dbpwd");
//
//		ThreadSafeInstanceClass.setThreadSafeDatabaseUtilityObject();
//		getThreadSafeDatabaseUtilityObject().establishDriverConnection(dbUrl, databaseName, dbUserName, dbPwd);

//		browser = fileUtility.getPropertyFileData("browser");
	}

	@Parameters("BROWSER")
	@BeforeTest
	public void testscriptExecutionSetup(String browser) {
		
		ThreadSafeInstanceClass.setThreadSafeFileUtilityObject();
		ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().loadPropertyFile(IConstants.VTIGERPROPERTYFILEPATH);
//		browser=ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("browser");
		url = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("url");
		
		ThreadSafeInstanceClass.setThreadSafeWebDriverUtilityObject();
		WebDriver driver = ThreadSafeInstanceClass.getThreadSafeWebDriverUtilityObject().openBrowser(browser);
//		DriverClass.getInstance().setDriver(driver);
		ThreadSafeInstanceClass.setThreadSafeDriverObject(driver);
//		ThreadSafeClass.setSafeDriver(driver);

		ThreadSafeInstanceClass.setThreadSafeJavaUtilityObject();
		
		ThreadSafeInstanceClass.setThreadSafeFileUtilityObject();
//		ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().loadPropertyFile(IConstants.VTIGERPROPERTYFILEPATH);
//		url = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("url");
		ThreadSafeInstanceClass.getThreadSafeWebDriverUtilityObject().enterUrl(url);
	}

	@BeforeMethod
	public void userLogin() {
		ThreadSafeInstanceClass.setThreadSafeFileUtilityObject();
		ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().loadPropertyFile(IConstants.VTIGERPROPERTYFILEPATH);
//		url = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("url");
		userName = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("userName");
		pwd = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("pwd");
		browser = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("browser");
		timeout = ThreadSafeInstanceClass.getThreadSafeFileUtilityObject().getPropertyFileData("timeout");

		ThreadSafeInstanceClass.setThreadSafeExcelUtilityObject();
		ThreadSafeInstanceClass.getThreadSafeExcelUtilityObject().loadExcelFile(IConstants.VTIGEREXCELFILEPATH);
		loginPage = new LoginPage();
		commonPage = new CommonPage();
		moreTabPage = new MoreTabPage();
		loginPage.login(userName, pwd);
		
		longTimeout = ThreadSafeInstanceClass.getThreadSafeJavaUtilityObject().convertStringToLong(timeout);
		randomNumber = ThreadSafeInstanceClass.getThreadSafeJavaUtilityObject().getRandomNumber();
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
	}

	@AfterSuite
	public void closeConnection() {
//		ThreadSafeInstanceClass.getThreadSafeDatabaseUtilityObject().closeDatabaseConnection();
		ThreadSafeInstanceClass.getThreadSafeExcelUtilityObject().closeExcelFile();
	}
}
