package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM class contains Document Page WebElements and its Business Layer
 * 
 * @author ymulk
 *
 */
public final class DocumentPage {

	/**
	 * This Constructor is used to initialize Document Page WebElements
	 * 
	 * @param driver
	 */
	public DocumentPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//img[@title='Create Document...']")
	private WebElement createDocumentBtn;

	// Business Layer

	/**
	 * This method is used to get createDocumentBtn WebElement
	 * 
	 * @return
	 */
	public WebElement getCreateDocumentBtn() {
		return createDocumentBtn;
	}

	/**
	 * This method is used to click on create document button
	 * 
	 * @return
	 */
	public CreateNewDocumentPage clickOnCreateDocumentBtn() {
		createDocumentBtn.click();
		return new CreateNewDocumentPage();
	}
}
