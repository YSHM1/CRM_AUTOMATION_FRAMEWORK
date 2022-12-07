package org.crm.genericUtility;

public class InstanceClass extends ThreadSafeInstanceClass {
	public DatabaseUtility databaseUtility = new DatabaseUtility();
	public ExcelUtility excelUtility = new ExcelUtility();
	public FileUtility fileUtility = new FileUtility();
	public JavaUtility javaUtility = new JavaUtility();
	public JSExecutorUtility jsExecutorUtility = new JSExecutorUtility();
	public WebDriverUtility webDriverUtility = new WebDriverUtility();
}
