package org.crm.genericUtility;

import org.crm.pomrepository.CommonPage;
import org.crm.pomrepository.LoginPage;
import org.crm.pomrepository.MoreTabPage;
import org.openqa.selenium.WebDriver;

public class ThreadSafeInstanceClass {
	
//	public DatabaseUtility databaseUtility = new DatabaseUtility();
//	public ExcelUtility excelUtility = new ExcelUtility();
//	public FileUtility fileUtility = new FileUtility();
//	public JavaUtility javaUtility = new JavaUtility();
//	public JSExecutorUtility jsExecutorUtility = new JSExecutorUtility();
//	public WebDriverUtility webDriverUtility = new WebDriverUtility();
	
	protected LoginPage loginPage;
	protected CommonPage commonPage;
	protected MoreTabPage moreTabPage;
	
	protected int randomNumber;
	String browser;
	String url;
	String userName;
	String pwd;
	String timeout;
	protected long longTimeout;
	
	
	private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
	private static ThreadLocal<WebDriverUtility> webDriverUtilityThreadLocal = new ThreadLocal<>();
	private static ThreadLocal<JavaUtility> javaUtilityThreadLocal = new ThreadLocal<>();
	private static ThreadLocal<FileUtility> fileUtilityThreadLocal = new ThreadLocal<>();
	private static ThreadLocal<ExcelUtility> excelUtilityThreadLocal = new ThreadLocal<>();
	private static ThreadLocal<JSExecutorUtility> jsExecutorUtilityThreadLocal = new ThreadLocal<>();
	private static ThreadLocal<DatabaseUtility> databaseUtilityThreadLocal = new ThreadLocal<>();

	
	public static void setThreadSafeDriverObject(WebDriver driver) {
		webDriverThreadLocal.set(driver);
	}

	public static WebDriver getThreadSafeDriverObject() {
		return webDriverThreadLocal.get();
	}
	
	public static void setThreadSafeWebDriverUtilityObject() {
		webDriverUtilityThreadLocal.set(new WebDriverUtility());
	}

	public static WebDriverUtility getThreadSafeWebDriverUtilityObject() {
		return webDriverUtilityThreadLocal.get();
	}

	public static void setThreadSafeJavaUtilityObject() {
		javaUtilityThreadLocal.set(new JavaUtility());
	}

	public static JavaUtility getThreadSafeJavaUtilityObject() {
		return javaUtilityThreadLocal.get();
	}

	public static void setThreadSafeFileUtilityObject() {
		fileUtilityThreadLocal.set(new FileUtility());
	}

	public static FileUtility getThreadSafeFileUtilityObject() {
		return fileUtilityThreadLocal.get();
	}

	public static void setThreadSafeExcelUtilityObject() {
		excelUtilityThreadLocal.set(new ExcelUtility());
	}

	public static ExcelUtility getThreadSafeExcelUtilityObject() {
		return excelUtilityThreadLocal.get();
	}

	public static void setThreadSafeJSExecutorUtilityObject() {
		jsExecutorUtilityThreadLocal.set(new JSExecutorUtility());
	}

	public static JSExecutorUtility getThreadSafeJSExecutorUtilityObject() {
		return jsExecutorUtilityThreadLocal.get();
	}

	public static void setThreadSafeDatabaseUtilityObject() {
		databaseUtilityThreadLocal.set(new DatabaseUtility());
	}

	public static DatabaseUtility getThreadSafeDatabaseUtilityObject() {
		return databaseUtilityThreadLocal.get();
	}

}
