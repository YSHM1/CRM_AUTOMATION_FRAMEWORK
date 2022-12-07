package org.crm.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
@Test
public void practiceTest() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.com/");
	driver.findElement(By.name("q")).sendKeys("Kohli", Keys.ENTER);
	Thread.sleep(3000);
	driver.close();
}
}
