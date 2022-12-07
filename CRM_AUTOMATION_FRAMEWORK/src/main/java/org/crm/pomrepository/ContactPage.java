package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM Class contains Contact Page WebElements and its Business Layer
 * 
 * @author ymulk
 *
 */
public final class ContactPage {

	/**
	 * This Constructor initializes Contact Page WebElements
	 * 
	 * @param driver
	 */
	public ContactPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactBtn;

	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}

	// Business Layer
	/**
	 * This method is used to click on create contact button
	 * 
	 * @return
	 */
	public CreateNewContatctPage clickOnCreateContactBtn() {
		createContactBtn.click();
		return new CreateNewContatctPage();
	}
}
