package org.crm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateTheData_RMGyantraTest1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8084/");
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		Random ran = new Random();
		int randomNumber = ran.nextInt(100);
		String expectedProjectName = "TYSS_ProjectNumber" + randomNumber;
		System.out.println(expectedProjectName);
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(expectedProjectName);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("yashm");
		WebElement projectStatusDropDown = driver
				.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select"));
		Select select = new Select(projectStatusDropDown);
		select.selectByValue("Created");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();

		try {
			Driver dbDriver = new Driver();
			DriverManager.registerDriver(dbDriver);
			// Connection connection =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root",
			// "root");
			// Statement statement = connection.createStatement();
			ResultSet result = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root")
					.createStatement().executeQuery("select project_name from project;");
			while (result.next()) {
				String actualProjectName = result.getString("project_name");
				if (expectedProjectName.equals(actualProjectName)) {
					System.out.println("New Project is created in Project Table");
					System.out.println("Actual Project Name is ====> " + result.getString("project_name"));
					break;
				} 
			}
			DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root").close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		driver.quit();
	}
}
