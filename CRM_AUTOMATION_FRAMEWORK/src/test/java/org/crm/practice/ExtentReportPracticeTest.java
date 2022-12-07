package org.crm.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportPracticeTest {
	@Test
	public void extentReportPracticeTest() {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./Extent-Report/extentreport.html");
		extentSparkReporter.config().setDocumentTitle("extentReport");
		extentSparkReporter.config().setReportName("extentReportPracticeTest");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		ExtentTest test = extentReports.createTest(getClass().getSimpleName());
		
		WebDriverManager.chromedriver().setup();
		test.info("checking driver executable");
		WebDriver driver =  new ChromeDriver();
		test.info("opening browser");
		driver.get("https://www.google.com/");
		test.info("Entering url");
		driver.findElement(By.name("q")).sendKeys("Extent Report", Keys.ENTER);
		test.info("Searching in google");
		test.pass("Test script pass");
		driver.quit();
		extentReports.flush();
	}
}
