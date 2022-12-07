package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM class contains Create New Campaign Page WebElements and its Business
 * Layer
 * 
 * @author ymulk
 *
 */
public final class CreateNewCampaignPage {


	/**
	 * This Constructor initializes Create New Campaign Page WebElements
	 * 
	 * @param driver
	 */
	public CreateNewCampaignPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement campaignNameTextField;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement selectProductBtn;

	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//input[@class='crmbutton small cancel']")
	private WebElement cancelBtn;

	private String selectProduct = "//a[text()='%s']";

	/**
	 * This method is used to convert Dynamic xpath into WebElement
	 * 
	 * @param partialXpath
	 * @param replaceCharacter
	 * @return
	 */
	private WebElement getWebElementOfDynamicXpath(String partialXpath, String replaceCharacter) {
		String xpath = String.format(partialXpath, replaceCharacter);
		return ThreadSafeInstanceClass.getThreadSafeDriverObject().findElement(By.xpath(xpath));
	}

	// business layer

	/**
	 * This method is used to get Campaign Name Text field WebElement
	 * 
	 * @return
	 */
	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	/**
	 * This method is used to get SelectProduct button WebElement
	 * 
	 * @return
	 */
	public WebElement getSelectProductBtn() {
		return selectProductBtn;
	}

	/**
	 * This method is used to get Save button WebElement
	 * 
	 * @return
	 */
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	/**
	 * This method is used to get Cancel button WebElement
	 * 
	 * @return
	 */
	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	/**
	 * This method is used write data to Campaign Name Text field WebElement
	 * 
	 * @return
	 * @return
	 */
	public CreateNewCampaignPage enterDataToCampaignNameTextField(String data) {
		campaignNameTextField.sendKeys(data);
		return this;
	}

	/**
	 * This method is used to click on SelectProduct button WebElement
	 * 
	 * @return
	 * @return
	 */
	public CreateNewCampaignPage clickOnSelectProductBtn() {
		selectProductBtn.click();
		return this;
	}

	/**
	 * This method is used to select product for Create New Campaign Page
	 * 
	 * @param replaceCharacter
	 * @return
	 */
	public CreateNewCampaignPage selectProduct(String product) {
		getWebElementOfDynamicXpath(selectProduct, product).click();
		return this;
	}

	/**
	 * This method is used to click on Save button WebElement
	 * 
	 * @return
	 * 
	 */
	public CampaignInformationPage clickOnSaveBtn() {
		saveBtn.click();
		return new CampaignInformationPage();
	}

	/**
	 * This method is used to click on Cancel button WebElement
	 * 
	 * @return
	 * @return
	 */
	public CreateNewCampaignPage clickOnCancelBtn() {
		cancelBtn.click();
		return this;
	}
}