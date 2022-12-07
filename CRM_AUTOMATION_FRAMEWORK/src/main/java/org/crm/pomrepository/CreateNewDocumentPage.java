package org.crm.pomrepository;

import org.crm.genericUtility.JavaUtility;
import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.crm.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM class contains Create New Document Page WebElements and its Business
 * Layer
 * 
 * @author ymulk
 *
 */
public final class CreateNewDocumentPage {

	/**
	 * This Constructor initializes Create New Document Page WebElements
	 * 
	 * @param driver
	 */
	public CreateNewDocumentPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//input[@name='notes_title']")
	private WebElement titleTextField;

	@FindBy(xpath = "//td[@id='cke_contents_notecontent']/iframe")
	private WebElement iFrame;

	@FindBy(xpath = "//body[@class='cke_show_borders']")
	private WebElement descriptionTextEditor;

	@FindBy(xpath = "//input[@id='filename_I__']")
	private WebElement chooseFilePath;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//input[@class='crmbutton small cancel']")
	private WebElement cancelBtn;

	// Business Layer

	/**
	 * This method is used to get titleTextField WebElement
	 * 
	 * @return
	 */
	public WebElement getTitleTextField() {
		return titleTextField;
	}

	/**
	 * This method is used to get iFrame WebElement
	 * 
	 * @return
	 */
	public WebElement getIFrame() {
		return iFrame;
	}

	/**
	 * This method is used to get Description Text Editor WebElement
	 * 
	 * @return
	 */
	public WebElement getDescriptionTextEditor() {
		return descriptionTextEditor;
	}

	/**
	 * This method is used to get Choose File Path WebElement
	 * 
	 * @return
	 */
	public WebElement getChooseFilePath() {
		return chooseFilePath;
	}

	/**
	 * This method is used to get Save Button WebElement
	 * 
	 * @return
	 */
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/**
	 * This method is used to get Cancel WebElement
	 * 
	 * @return
	 */
	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	/**
	 * This method is used to enter title in titleTextField
	 * 
	 * @param title
	 * @return
	 */
	public CreateNewDocumentPage enterTitle(String title) {
		titleTextField.sendKeys(title);
		return this;
	}

	/**
	 * This method is used to switch to Frame with the help of WebElement
	 * 
	 * @param webDriverUtility
	 * @return
	 */
	public CreateNewDocumentPage switchToFrame(WebDriverUtility webDriverUtility) {
		webDriverUtility.switchToFrame(iFrame);
		return this;
	}
	
	
	public CreateNewDocumentPage switchToCreateNewDocumentPage(WebDriverUtility webDriverUtility) {
		webDriverUtility.switchToParentFrame();
		return this;
	}
	

	/**
	 * This method is used to enter description in Description Text Editor
	 * 
	 * @param title
	 * @return
	 */
	public CreateNewDocumentPage enterDescription(String description) {
		descriptionTextEditor.sendKeys(description);
		return this;
	}

	/**
	 * This method is used to enter File Path in Choose File Path WebElement
	 * 
	 * @param filePath
	 * @return
	 */
	public CreateNewDocumentPage enterFilePath(JavaUtility javaUtility, String filePath) {
		chooseFilePath.sendKeys(javaUtility.getAbsoluteFilePath(filePath));
		return this;
	}

	/**
	 * This method is used to click on Save button WebElement
	 * 
	 * @return
	 */
	public DocumentInformationPage clickOnSaveBtn() {
		saveBtn.click();
		return new DocumentInformationPage();
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
