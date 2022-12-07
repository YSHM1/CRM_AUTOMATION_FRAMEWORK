package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM Class contains all the WebElement of OrganizationInformationPage and
 * its Business Layer
 * 
 * @author ymulk
 *
 */
public class ProductInformationPage {

	/**
	 * This Constructor is used to Initialize the WebElements
	 * 
	 * @param driver
	 */
	public ProductInformationPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
	private WebElement actualProductNameTextField;

	// Business Layer
	/**
	 * This is used to get Actual Product name
	 * 
	 * @return
	 */
	public String getActualProductName() {
		return actualProductNameTextField.getText();
	}
}
