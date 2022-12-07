package org.crm.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpathPrac {
public static void main(String[] args) {
	String expectedOrganizationName="efgh";
	String xpath = "//a[.="+expectedOrganizationName+"]/ancestor::tr[@class='lvtColData']/td/input";
	WebDriver driver = new ChromeDriver();
	driver.findElement(By.xpath(xpath)).click();
}
}
