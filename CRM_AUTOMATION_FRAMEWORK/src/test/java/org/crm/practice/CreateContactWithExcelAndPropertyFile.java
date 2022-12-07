package org.crm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithExcelAndPropertyFile {
	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url").trim();
		String userName = properties.getProperty("userName").trim();
		String pwd = properties.getProperty("pwd").trim();
		String browser = properties.getProperty("browser").trim();
		String timeout = properties.getProperty("timeout").trim();
		long time = Long.parseLong(timeout);

		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Row row = wb.getSheet("Sheet1").getRow(2);
		String expectedContactName = row.getCell(1).getStringCellValue();
		System.out.println(expectedContactName);
		int randomNumber = new Random().nextInt(1000);
		WebDriver driver = null;
//		switch (browser) {
//		case "chrome":
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			break;
//		case "firefox":
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			break;
//		default:
//			System.out.println("Enter Valid Browser Name");
//			break;
//		}

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
			System.out.println("Enter Valid Browser Name");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(expectedContactName);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		String actualContactName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		System.out.println(actualContactName);
		if (expectedContactName.equals(actualContactName)) {
			System.out.println("Contact created Successfully");
		} else
			System.out.println("Contact creation Failed");

		Actions a = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		a.moveToElement(element).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
