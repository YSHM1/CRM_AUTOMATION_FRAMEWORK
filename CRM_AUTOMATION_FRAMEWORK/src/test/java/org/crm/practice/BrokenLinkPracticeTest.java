package org.crm.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkPracticeTest {
	
	@Test
	public void verifyLinks() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("http://localhost:8888/");
//		driver.findElement(By.xpath("//input[@name = 'user_name']")).sendKeys("admin");
//		driver.findElement(By.xpath("//input[@name = 'user_password']")).sendKeys("admin");
//		driver.findElement(By.xpath("//input[@id= 'submitButton']")).click();
		
		driver.get("https://www.softwaretestingmaterial.com/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		List<String> list = new ArrayList<String>();
		for (WebElement link : allLinks) {
			String linkString = link.getAttribute("href");
			list.add(linkString);
			list.remove(null);
		}
		
		for (String url : list) {
			System.out.println(url);
			URL u = new URL(url);
//		    URLConnection urlConnection = u.openConnection();
			HttpURLConnection response = (HttpURLConnection)u.openConnection();
			int statusCode = response.getResponseCode();
			if (statusCode != 200) {
				System.out.println(url +" ====> "+ statusCode +" ====> "+ response.getResponseMessage());
			}
					
		}
		
		driver.quit();
	}

}
