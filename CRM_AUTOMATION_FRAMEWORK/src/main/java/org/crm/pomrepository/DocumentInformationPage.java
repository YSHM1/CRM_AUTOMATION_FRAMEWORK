package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM Class contains Document Information Page WebElements and its
 * Business Layer
 * 
 * @author ymulk
 *
 */
public final class DocumentInformationPage {
	/**
	 * This Constructor is used to initialize Campaign Information Page WebElements
	 * 
	 * @param driver
	 */
	public DocumentInformationPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//span[@id='dtlview_Title']")
	private WebElement actualTitleNameTextField;

	@FindBy(xpath = "//td[@class='dvtCellInfo']/p")
	//td[@class='dvtCellInfo']/p
	private WebElement actualDescriptionTextField;

	@FindBy(xpath = "//td[@class='dvtCellInfo']/a")
	private WebElement actualFileNameTextField;

	// Business Layer
	/**
	 * This method is used to get Actual Title Name
	 * 
	 * @return
	 */
	public String getActualTitle() {
		return actualTitleNameTextField.getText();
	}

	/**
	 * This method is used to get Actual Description
	 * 
	 * @return
	 */
	public String getActualDescription() {
		return actualDescriptionTextField.getText();
	}

	/**
	 * This method is used to get Actual File Name
	 * 
	 * @return
	 */
	public String getActualFileName() {
		return actualFileNameTextField.getText();
	}
}
