package org.crm.pomrepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class OrganizationsPage1 {
	
	private WebDriver driver;
		public OrganizationsPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganizationBtn;

	@FindBy(xpath = "//span[@name='Accounts_listViewCountContainerName']")
	private WebElement pageNumber;
	
	@FindBy(xpath = "//input[@name='pagenum']")
	private WebElement pageNumTextField;
	
	@FindBy(xpath = "//div/table[@class='lvt small']/tbody/tr/td[3]/a")
	private List<WebElement> organizationsNameList ;

	@FindBy(xpath = "//input[@class='crmbutton small delete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "//a[@title='Next']/img")
	private WebElement nextBtn;
	
	private String dynamicXpath = "//table[@class='lvt small']/tbody/tr[%s]/td/input";
	
	int count = 0;

	
	public void clickOnCreateOrganizationBtn() {
		createOrganizationBtn.click();
	}

	
	public void nextPageButton() {
		nextBtn.click();
	}
	
	
	public String totalPages() {
		String[] arrayPageCount = pageNumber.getText().split(" ");
		return arrayPageCount[arrayPageCount.length - 1];
	}
	
	
	public void gotoPage(String pageNum) {
		pageNumTextField.clear();
		pageNumTextField.sendKeys(pageNum, Keys.ENTER);
	}
	
	
	public List<String> getAllOrganizationsName() {
		List<String> text = new ArrayList<>();
		for (WebElement organizationName : organizationsNameList) {
			text.add(organizationName.getText());
		}
		return text;
	}
	
	
	private int selectOraganization(String expectedOrganizationName) {
		int j =0;
		List<String> organizationNameList = getAllOrganizationsName(); 
		for(int i = 0; i<organizationNameList.size();i++) {
			String organizationName = organizationNameList.get(i);
			if (organizationName.equals(expectedOrganizationName)) {
				count++;
				break;
			}
			j=i;
		}
		return j;
	}
	
	
	private void selectOrganizationCheckbox(String expectedOrganizationName) {
		int j = selectOraganization(expectedOrganizationName) + 2;
		String i=String.valueOf(j);
		String xpath = String.format(dynamicXpath, i);
		driver.findElement(By.xpath(xpath)).click();
	}
	
	
	public void deleteOrganization(String expectedOrganizationName) {
		selectOrganizationCheckbox(expectedOrganizationName);
		deleteBtn.click();
		driver.switchTo().alert().accept();
	}
	
}
