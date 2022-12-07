package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM Class contains Campaign Information Page WebElements and its
 * Business Layer
 * 
 * @author ymulk
 *
 */
public final class CampaignInformationPage {

	/**
	 * This Constructor is used to initialize Campaign Information Page WebElements
	 * 
	 * @param driver
	 */
	public CampaignInformationPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement actualCampaignNameTextField;

	@FindBy(xpath = "//span[@id='dtlview_Product']")
	private WebElement actualProductNameTextField;

	/**
	 * This method is used to get Campaign Name Text Field WebElement
	 * 
	 * @return
	 */
	public WebElement getActualCampaignNameTextField() {
		return actualCampaignNameTextField;
	}

	/**
	 * This method is used to get Product Name Text Field WebElement
	 * 
	 * @return
	 */
	public WebElement getActualItemNameTextField() {
		return actualProductNameTextField;
	}

	// Business Layer
	/**
	 * This method is used to return text from Campaign Name TextField
	 * 
	 * @return
	 */
	public String getActualProductName() {
		return actualProductNameTextField.getText();
	}

	/**
	 * This method is used to return text from Product Name TextField
	 * 
	 * @return
	 */
	public String getActualCampaignName() {
		return actualCampaignNameTextField.getText();
	}
}
