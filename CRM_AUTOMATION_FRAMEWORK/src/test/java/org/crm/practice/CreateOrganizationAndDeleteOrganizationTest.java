package org.crm.practice;

import org.crm.genericUtility.ExcelUtility;
import org.crm.genericUtility.FileUtility;
import org.crm.genericUtility.IConstants;
import org.crm.genericUtility.JavaUtility;
import org.crm.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganizationAndDeleteOrganizationTest {
	public static void main(String[] args) {
		JavaUtility javaUtility = new JavaUtility();
		FileUtility fileUtility = new FileUtility();
		ExcelUtility excelUtility = new ExcelUtility();
		WebDriverUtility webDriverUtility = new WebDriverUtility();

		int randomNumber = javaUtility.getRandomNumber();

		fileUtility.loadPropertyFile(IConstants.ABSOLUTEVTIGERPROPERTYFILEPATH);
		String url = fileUtility.getPropertyFileData("url");
		String userName = fileUtility.getPropertyFileData("userName");
		String pwd = fileUtility.getPropertyFileData("pwd");
		String timeout = fileUtility.getPropertyFileData("timeout");
		long timeDuration = javaUtility.convertStringToLong(timeout);
		String browser = fileUtility.getPropertyFileData("browser");

		excelUtility.loadExcelFile(IConstants.ABSOLUTEVTIGEREXCELFILEPATH);

		String expectedOrganizationName = excelUtility.getExcelData("CreateOrganization", 2, 1) + randomNumber;
		excelUtility.closeExcelFile();

		WebDriver driver = webDriverUtility.openBrowser(browser);
		webDriverUtility.implicitWait(timeDuration);
		webDriverUtility.enterUrl(url);
		webDriverUtility.initializeExplicitWait(timeDuration, 300);
		
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.login(userName, pwd);
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(userName);
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
//		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
//		CommonPage commonPage = new CommonPage(driver);
//		commonPage.clickOnOrganizationTab(); 
//		OrganizationsPage organizationsPage = new OrganizationsPage(driver);
//		organizationsPage.clickOnCreateOrganizationBtn();
//		CreateNewOrganizationPage createNewOrganizationPage = new CreateNewOrganizationPage(driver);
//		createNewOrganizationPage.enterOrganiztionName(expectedOrganizationName);
//		createNewOrganizationPage.clickOnSaveBtn();
//		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(expectedOrganizationName);
//		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
//		OrganizationInformationPage organizationInformationPage = new OrganizationInformationPage(driver);
//		String actualOrganizationName = organizationInformationPage.getActualOrganizationName();
		
//		organizationInformationPage.gotoOrganizationPage();
//		driver.findElement(By.xpath("//td[@class='moduleName']/a")).click();

		
//		String pageCount = organizationsPage.totalPages();
//		String[] arrPageCount = driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName']"))
//				.getText().split(" ");
//		String pageCount = arrPageCount[arrPageCount.length - 1];
		
//		organizationsPage.gotoPage(pageCount);
//		driver.findElement(By.xpath("//input[@name='pagenum']")).clear();
//		driver.findElement(By.xpath("//input[@name='pagenum']")).sendKeys(pageCount, Keys.ENTER);

		
//		organizationsPage.deleteOrganization(webDriverUtility, expectedOrganizationName);
//		List<String> organizationNameList = organizationsPage.getAllOrganizationsName();
//		for (int i = 0; i < organizationNameList.size(); i++) {
//			String organizationName = organizationNameList.get(i).getText();
//			if (organizationName.equals(expectedOrganizationName)) {
//				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[" + (i + 2) + "]/td/input")).click();
//				driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
//				driver.switchTo().alert().accept();
//				break;
//			}
//		}

//		WebElement element = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
//		webDriverUtility.mouseHover(element);
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
//		webDriverUtility.closeBrowser();

//			for (int i = 0; i < organizationNameList.size(); i++) {
//				String organizationName = organizationNameList.get(i).getText();
//				if (organizationName.equals(actualOrganizationName)) {
//					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Powered by vtiger CRM ']"))));
//					driver.findElement(By.xpath("//td[text()='"+actualOrganizationName+" "+"']/parent::tr/descendant::input")).click();					
//				}
//			}

	}
}
