package org.crm.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricbuzzBowlersRatingTest {
	
	@Test
	public void getBowlersRatingTest() {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.cricbuzz.com/");
		 WebElement ranking = driver.findElement(By.xpath("//a[text()='Rankings']"));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(ranking).perform();
		 WebElement iccMenRanking = driver.findElement(By.xpath("//a[@title='ICC Rankings Men']"));
		 iccMenRanking.click();
		 driver.findElement(By.xpath("//a[@id='bowlers-tab']")).click();
		 driver.findElement(By.xpath("//a[@id='bowlers-odis-tab']")).click();
		 
		 WebElement bowlerRanking = driver.findElement(By.xpath("//div[@ng-show=\"'bowlers-odis' == act_rank_format\"]"
		 															+ "//descendant::a[text()='Trent Boult']"
		 																	+ "/ancestor::div[@class='cb-col cb-col-50 cb-lst-itm-sm text-left']"
		 																			+ "/following-sibling::div[@class='cb-col cb-col-17 cb-rank-tbl pull-right']"));
		 
	}

}
