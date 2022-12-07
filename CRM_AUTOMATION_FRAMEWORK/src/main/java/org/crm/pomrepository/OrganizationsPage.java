package org.crm.pomrepository;

import java.util.ArrayList;
import java.util.List;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.crm.genericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM class contains Organizations Page WebElements and its Business Layer
 * 
 * @author ymulk
 *
 */
public final class OrganizationsPage {

	/**
	 * This Constructor is used to initialize Organizations Page WebElements
	 * 
	 * @param driver
	 */
	public OrganizationsPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganizationBtn;

	@FindBy(xpath = "//span[@name='Accounts_listViewCountContainerName']")
	private WebElement pageNumber;

	@FindBy(xpath = "//input[@name='pagenum']")
	private WebElement pageNumTextField;

	@FindBy(xpath = "//div[@id='status']")
	private WebElement status;

	@FindBy(xpath = "//div/table[@class='lvt small']/tbody/tr/td[3]/a")
	private List<WebElement> organizationsNameList;

	@FindBy(xpath = "//input[@class='crmbutton small delete']")
	private WebElement deleteBtn;

	@FindBy(xpath = "//a[@title='Next']/img")
	private WebElement nextBtn;

	private String checkboxDynamicXpath = "//table[@class='lvt small']/tbody/tr[%s]/td/input";

	int count = 0;

	// Business Layer
	/**
	 * This method is used to get createOrganizationBtn WebElement
	 * 
	 * @return
	 */
	public WebElement getcreateOrganizationBtn() {
		return createOrganizationBtn;
	}

	/**
	 * This method is used to get status WebElement
	 * 
	 * @return
	 */
	public WebElement getStatus() {
		return status;
	}

	/**
	 * This method is used to click on create organization button
	 * 
	 * @return
	 */
	public CreateNewOrganizationPage clickOnCreateOrganizationBtn() {
		createOrganizationBtn.click();
		return new CreateNewOrganizationPage();
	}

	/**
	 * This method is used to click on next page
	 * @return 
	 */
	public OrganizationsPage clickNextPageButton() {
		nextBtn.click();
		return this;
	}

	/**
	 * This method is used to count total numbers of page present
	 * 
	 * @return
	 */
	public String totalPages() {
		String[] arrayPageCount = pageNumber.getText().split(" ");
		return arrayPageCount[arrayPageCount.length - 1];
	}

	/**
	 * This method is used goto Specific Page
	 * 
	 * @param pageNum
	 */
	public void gotoPage(String pageNum) {
		pageNumTextField.clear();
		pageNumTextField.sendKeys(pageNum, Keys.ENTER);
	}

	/**
	 * This method is used to get List of Organization Names
	 * 
	 * @return
	 */
	public List<String> getAllOrganizationsName() {
		List<String> text = new ArrayList<>();
		for (WebElement organizationName : organizationsNameList) {
			text.add(organizationName.getText());
		}
		return text;
	}

	/**
	 * This method is used to Select a particular Organization
	 * 
	 * @param expectedOrganizationName
	 * @return
	 */
//	private int selectOraganization(String expectedOrganizationName) {
//		int j =0;
//		List<String> organizationNameList = getAllOrganizationsName(); 
//		for(int i = 0; i<organizationNameList.size();i++) {
//			String organizationName = organizationNameList.get(i);
//			if (organizationName.equals(expectedOrganizationName)) {
//				count++;
//				break;
//			}
//			j=i;
//		}
//		return j;
//	}

	/**
	 * This method is used to select Checkbox
	 * 
	 * @param expectedOrganizationName
	 */
	private void selectOrganizationCheckbox(String expectedOrganizationName, int i) {
		int j = i + 2;
		String k = String.valueOf(j);
		String xpath = String.format(checkboxDynamicXpath, k);
		ThreadSafeInstanceClass.getThreadSafeDriverObject().findElement(By.xpath(xpath)).click();
	}

	/**
	 * This method is used to delete a particular Organization
	 * 
	 * @param expectedOrganizationName
	 * @return
	 */
	public void deleteOrganization(WebDriverUtility webDriverUtility, String expectedOrganizationName, int i) {
		selectOrganizationCheckbox(expectedOrganizationName, i);
		deleteBtn.click();
		webDriverUtility.acceptAlertPopup();
	}

	/**
	 * This is used to wait till the WebElement is invisible
	 * 
	 * @return
	 */
	public void waitTillElementInvisible(WebDriverUtility webDriverUtility, WebElement element) {
		webDriverUtility.initializeExplicitWait(10, 300);
		webDriverUtility.waitTillInvisibilityOfElement(element);
	}
}
