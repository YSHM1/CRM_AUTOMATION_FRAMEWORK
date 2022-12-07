package org.crm.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithPropertiesFileTest {
//	static {
//		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
//	}
@Test
	public static void test() throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url").trim();
		String userName = properties.getProperty("userName").trim();
		String pwd = properties.getProperty("pwd").trim();
		String browser = properties.getProperty("browser").trim();
		String timeout = properties.getProperty("timeout").trim();
		long time = Long.parseLong(timeout);
		WebDriver driver = null;
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
			System.out.println("Enter Valid Browser Name");
			break;
		}
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		Actions a = new Actions(driver);
		WebElement element = driver.findElement(By.linkText("More"));
		a.moveToElement(element).perform();
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		String eText = "abcd";
		driver.findElement(By.name("campaignname")).sendKeys(eText);
		driver.findElement(By.name("button")).click();
		String rText = driver.findElement(By.id("dtlview_Campaign Name")).getText();
		if (eText.equals(rText)) {
			System.out.println("pass");
		} else
			System.out.println("fail");
		WebElement element1 = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		a.moveToElement(element1).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
}
