package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM Class contains all the WebElement of ContactInformationPage and its
 * Business Layer
 * 
 * @author ymulk
 *
 */
public final class ContactInformationPage {

	/**
	 * This Constructor is used to Initialize the WebElements
	 * 
	 * @param driver
	 */
	public ContactInformationPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//span[@id='dtlview_Last Name']")
	private WebElement actualContactNameTextField;

	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']/a")
	private WebElement actualOrganizationNameTextField;

	// Business Layer
	public String getActualContactName() {
		return actualContactNameTextField.getText();
	}

	public String getActualOrganizationName() {
		return actualOrganizationNameTextField.getText();
	}
}
