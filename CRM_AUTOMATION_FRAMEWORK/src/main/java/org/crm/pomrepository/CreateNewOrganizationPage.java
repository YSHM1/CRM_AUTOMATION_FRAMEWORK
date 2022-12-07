package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.crm.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM class contains Create New Organiztion Page WebElements and its
 * Business Layer
 * 
 * @author ymulk
 *
 */
public final class CreateNewOrganizationPage {
	/**
	 * This Constructor initializes Create New Organization Page WebElements
	 * 
	 * @param driver
	 */
	public CreateNewOrganizationPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement organizationNameTextField;

	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industry;

	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement type;

	@FindBy(xpath = "//input[@name='assigntype' and @value='T']")
	private WebElement assignedTo;

	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//input[@class='crmbutton small cancel']")
	private WebElement cancelBtn;

	// Business Layer
	/**
	 * This method is used to get organiztionNameTextField WebElement
	 * 
	 * @return
	 */
	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	/**
	 * This method is used to get saveBtn WebElement
	 * 
	 * @return
	 */
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/**
	 * This method is used to get cancelBtn WebElement
	 * 
	 * @return
	 */
	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	/**
	 * This method is used to enter Organization Name in organizationNameTextField
	 * 
	 * @param title
	 * @return
	 */
	public CreateNewOrganizationPage enterOrganiztionName(String organizationName) {
		organizationNameTextField.sendKeys(organizationName);
		return this;
	}

	/**
	 * This method is used to select industry
	 * 
	 * @param webDriverUtility
	 * @param chooseValueOrVisibleText
	 * @param data
	 * @return
	 */
	public CreateNewOrganizationPage selectIndustry(WebDriverUtility webDriverUtility, String chooseValueOrVisibleText,
			String data) {
		webDriverUtility.initializeSelectClass(industry);
		webDriverUtility.selectOption(chooseValueOrVisibleText, data);
		return this;
	}

	/**
	 * This method is used to select industry
	 * 
	 * @param webDriverUtility
	 * @param chooseValueOrVisibleText
	 * @param data
	 * @return
	 */
	public CreateNewOrganizationPage selectType(WebDriverUtility webDriverUtility, String chooseValueOrVisibleText,
			String data) {
		webDriverUtility.initializeSelectClass(type);
		webDriverUtility.selectOption(chooseValueOrVisibleText, data);
		return this;
	}

	/**
	 * This method is used to select Group
	 * 
	 * @return
	 * @return
	 */
	public CreateNewOrganizationPage selectAssignToGroup() {
		assignedTo.click();
		return this;
	}

	/**
	 * This method is used to click on Save button WebElement
	 * 
	 * @return
	 */
	public OrganizationInformationPage clickOnSaveBtn() {
		saveBtn.click();
		return new OrganizationInformationPage();
	}

	/**
	 * This method is used to click on Cancel button WebElement
	 * 
	 * @return
	 */
	public void clickOnCancelBtn() {
		cancelBtn.click();
	}
}
