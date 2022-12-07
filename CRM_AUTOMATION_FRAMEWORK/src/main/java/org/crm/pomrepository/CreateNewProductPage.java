package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM class contains Create New Product Page WebElements and its Business
 * Layer
 * 
 * @author ymulk
 *
 */
public final class CreateNewProductPage {

	/**
	 * This Constructor is used to initialize Create New Product Page WebElements
	 * 
	 * @param driver
	 */
	public CreateNewProductPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productNameTextField;

	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//input[@class='crmbutton small cancel']")
	private WebElement cancelBtn;

	// Business Layer
	/**
	 * This method is used to get productNameTextField WebElement
	 * 
	 * @return
	 */
	public WebElement getProductNameTextField() {
		return productNameTextField;
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
	public CreateNewProductPage enterProductName(String productName) {
		productNameTextField.sendKeys(productName);
		return this;
	}

	/**
	 * This method is used to click on Save button WebElement
	 * 
	 * @return
	 */
	public ProductInformationPage clickOnSaveBtn() {
		saveBtn.click();
		return new ProductInformationPage();
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
