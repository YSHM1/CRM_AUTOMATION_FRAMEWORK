package org.crm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.crm.genericUtility.DatabaseUtility;
import org.crm.genericUtility.ExcelUtility;
import org.crm.genericUtility.FileUtility;
import org.crm.genericUtility.IConstants;
import org.crm.genericUtility.JavaUtility;
import org.crm.genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateTheData_RMGyantraTest {
	public static void main(String[] args) {

		JavaUtility javaUtility = new JavaUtility();
		FileUtility fileUtility = new FileUtility();
		ExcelUtility excelUtility = new ExcelUtility();
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		DatabaseUtility databaseUtility = new DatabaseUtility();

		int randomNumber = javaUtility.getRandomNumber();
		int randomNumber1 = javaUtility.getRandomNumber();
		String date = javaUtility.getSimpleCurrentDate("dd-MM-yyyy");

		fileUtility.loadPropertyFile(IConstants.ABSOLUTEVTIGERPROPERTYFILEPATH);
		String browser = fileUtility.getPropertyFileData("browser");
		String timeout = fileUtility.getPropertyFileData("timeout");
		long time = javaUtility.convertStringToLong(timeout);

		String rmgYantraUrl = fileUtility.getPropertyFileData("rmgyantraurl");
		String rmgYantraUserName = fileUtility.getPropertyFileData("rmgyantrauserName");
		String rmgYantraPwd = fileUtility.getPropertyFileData("rmgyantrapwd");

		String dbUrl = fileUtility.getPropertyFileData("dburl");
		String dbDatabaseName = fileUtility.getPropertyFileData("databaseName");
		String dbUserName = fileUtility.getPropertyFileData("dbuserName");
		String dbPwd = fileUtility.getPropertyFileData("dbpwd");

		WebDriver driver = webDriverUtility.openBrowser(browser);
		webDriverUtility.implicitWait(time);
		webDriverUtility.enterUrl(rmgYantraUrl);
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(rmgYantraUserName);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(rmgYantraPwd);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();

		String expectedProjectName = "TYSS_ProjectNumber" + randomNumber;
		System.out.println(expectedProjectName);
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(expectedProjectName);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("yashm");
		WebElement projectStatusDropDown = driver
				.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select"));
		Select select = new Select(projectStatusDropDown);
		select.selectByValue("Created");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();

		databaseUtility.establishDriverConnection(dbUrl, dbDatabaseName, dbUserName, dbPwd);
		databaseUtility.executeSelectQuery("select * from project;");
		List<String> allData = databaseUtility.getSelectQueryResult("project_name");
		boolean result = databaseUtility.verifyExpectedResultWithActualResult(allData, expectedProjectName);

		if (result) {
			System.out.println("Pass");
		} else
			System.out.println("fail");
		databaseUtility.closeDatabaseConnection();
		webDriverUtility.closeBrowser();
	}
}
