package org.crm.Contacts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.crm.genericUtility.BaseClass1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationAndDeleteOrganizationTest extends BaseClass1 {
	public static void main(String[] args) {
		try {
			int randomNumber = new Random().nextInt(1000);

			FileInputStream fis = null;
			WebDriver driver = null;

			fis = new FileInputStream("./src/test/resources/CommonData.properties");
			Properties p = new Properties();
			p.load(fis);
			String url = p.getProperty("url");
			String username = p.getProperty("userName");
			String pwd = p.getProperty("pwd");
			String browser = p.getProperty("browser");
			String timeout = p.getProperty("timeout");
			long time = Long.parseLong(timeout);

			fis = new FileInputStream("./src/test/resources/TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("CreateOrganization");
			String expectedOrganizationName = sheet.getRow(2).getCell(1).getStringCellValue() + randomNumber;

			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			default:
				System.out.println("Specified Browser isn't available");
				break;
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

			driver.get(url);
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(expectedOrganizationName);
			driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

			String actualOrganizationName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']"))
					.getText();
			driver.findElement(By.xpath("//td[@class='moduleName']/a")).click();

			String[] arrPageCount = driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName']"))
					.getText().split(" ");
			String pageCount = arrPageCount[arrPageCount.length - 1];
			driver.findElement(By.xpath("//input[@name='pagenum']")).clear();
			driver.findElement(By.xpath("//input[@name='pagenum']")).sendKeys(pageCount, Keys.ENTER);

			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='status']"))));

			
			int count = 0;
			List<WebElement> organizationNameList = driver.findElements(By.xpath("//div/table[@class='lvt small']/tbody/tr/td[3]/a"));
			for (int i=0;i<organizationNameList.size();i++) {
				String organizationName = organizationNameList.get(i).getText();
				if (organizationName.equals(expectedOrganizationName)) {
					driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(i+2)+"]/td/input")).click();
					driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
					driver.switchTo().alert().accept();
					count++;
					break;
				}
			}
			
			if (count==1) {
				System.out.println("Organization deleted successfully");
			}
			else
				System.out.println("Organization deletion failed");
			
			driver.close();
			wb.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
