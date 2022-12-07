package org.crm.practice;

import org.crm.genericUtility.IConstants;
import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderPracticeTest extends ThreadSafeInstanceClass {
	@Test(dataProvider = "userCredentials", dataProviderClass = DataProviderPracticeTest.class)
	public void dataProviderTest(String userName, String password)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.xpath("//input[@name = 'user_name']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name = 'user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id= 'submitButton']")).click();
		 String errorMsg = driver.findElement(By.xpath("//div[@class= 'errorMessage']")).getText();
		if (driver.getPageSource().contains(errorMsg)) {
			System.out.println("Test Case Failed");
		}
		else
			System.out.println("Test Case Passed");
		
		driver.quit();
	}
	
	@DataProvider(name = "userCredentials")
	public String[][] getData()
	{
		ThreadSafeInstanceClass.setThreadSafeExcelUtilityObject();
		ThreadSafeInstanceClass.getThreadSafeExcelUtilityObject().loadExcelFile(IConstants.LOGINFILEPATH);
		
		int lastRow = ThreadSafeInstanceClass.getThreadSafeExcelUtilityObject().getLastRowNum("CredentialData");
		int lastCell = ThreadSafeInstanceClass.getThreadSafeExcelUtilityObject().getLastCellNum("CredentialData",1);

		System.out.println(lastRow+"   "+ lastCell);
		
		String userCredential[][] = new String[lastRow][lastCell];
		
		for (int i = 1; i <= lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				userCredential[i-1][j] = ThreadSafeInstanceClass.getThreadSafeExcelUtilityObject().getExcelData("CredentialData", i, j);
			}
		}
		
		return userCredential;	
	}

}
