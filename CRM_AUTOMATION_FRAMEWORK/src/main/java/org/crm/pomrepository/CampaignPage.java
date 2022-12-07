package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM Class contains all the WebElements of Campaign Page and its Business
 * Layer
 * 
 * @author ymulk
 *
 */
public final class CampaignPage {

	/**
	 * This Constructor is used to initialize Campaign Page WebElements
	 * 
	 * @param driver
	 */
	public CampaignPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createCampaignBtn;

	public WebElement getCreateCampaignsBtn() {
		return createCampaignBtn;
	}

	// Business Layer
	/**
	 * This method is used to click on create new campaign button
	 * 
	 * @return
	 */
	public CreateNewCampaignPage clickOnCreateCampaignBtn() {
		createCampaignBtn.click();
		return new CreateNewCampaignPage();
	}

}
