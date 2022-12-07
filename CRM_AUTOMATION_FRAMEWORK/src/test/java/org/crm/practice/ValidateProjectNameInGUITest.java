package org.crm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
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

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNameInGUITest {
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

		String expectedProjectName = "TYSS_" + randomNumber1;

		databaseUtility.establishDriverConnection(dbUrl, dbDatabaseName, dbUserName, dbPwd);
		databaseUtility.executeUpdateQuery("insert into project values('TY_Proj_/" + randomNumber + "','YashM','" + date
				+ "','" + expectedProjectName + "','Completed',20);");

		WebDriver driver = webDriverUtility.openBrowser(browser);
		webDriverUtility.implicitWait(time);

		webDriverUtility.enterUrl(rmgYantraUrl);
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(rmgYantraUserName);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(rmgYantraPwd);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		List<WebElement> projectNames = driver.findElements(By.xpath("//td[2]"));
		for (WebElement project : projectNames) {
			String name = project.getText();
			if (expectedProjectName.equals(name)) {
				System.out.println("New Project is created");
				break;
			}
		}
		webDriverUtility.closeBrowser();
	}
}