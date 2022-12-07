package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM class contains Create New Contact Page WebElements and its Business
 * Layer
 * 
 * @author ymulk
 *
 */
public final class CreateNewContatctPage {

	/**
	 * This Constructor initializes Create New Contact Page WebElements
	 * 
	 * @param driver
	 */
	public CreateNewContatctPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameTextField;

	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement selectOrganizationBtn;

	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//input[@class='crmbutton small cancel']")
	private WebElement cancelBtn;

	String selectOrganization = "//tr[@class='lvtColData']/td/a[text()='%s']";

	/**
	 * This method is used to get the WebElement of Dynamic Xpath
	 * 
	 * @param replaceCharacter
	 * @return
	 */
	private WebElement convertDynamicXpathToWebElement(String replaceCharacter) {
		String xpath = String.format(selectOrganization, replaceCharacter);
		return ThreadSafeInstanceClass.getThreadSafeDriverObject().findElement(By.xpath(xpath));
	}

	// Business Layer

	/**
	 * This method is used to get lastNameTextField WebElement
	 * 
	 * @return
	 */
	public WebElement getlastNameTextField() {
		return lastNameTextField;
	}

	/**
	 * This method is used to get selectOrganiztion button WebElement
	 * 
	 * @return
	 */
	public WebElement getSelectOrganizationtBtn() {
		return selectOrganizationBtn;
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
	 * This method is used enter data to Last Name Text field WebElement
	 * 
	 * @return
	 */
	public CreateNewContatctPage enterLastName(String data) {
		lastNameTextField.sendKeys(data);
		return this;
	}

	/**
	 * This method is used to click on Save button WebElement
	 * 
	 * @return
	 */
	public ContactInformationPage clickOnSaveBtn() {
		saveBtn.click();
		return new ContactInformationPage();
	}

	/**
	 * This method is used to click on Cancel button WebElement
	 * 
	 * @return
	 */
	public void clickOnCancelBtn() {
		cancelBtn.click();
	}

	/**
	 * This method is used to click on Select Organization Button WebElement
	 * 
	 * @return
	 */
	public CreateNewContatctPage clickOnSelectOrganizationBtn() {
		selectOrganizationBtn.click();
		return this;
	}

	/**
	 * This method is used to click on Select Organization Button WebElement
	 * 
	 * @return
	 */
	public CreateNewContatctPage selectOrganization(String organizationName) {
		convertDynamicXpathToWebElement(organizationName).click();
		return this;
	}
}
