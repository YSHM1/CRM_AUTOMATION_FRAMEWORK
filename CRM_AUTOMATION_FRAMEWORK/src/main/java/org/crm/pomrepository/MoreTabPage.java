package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.crm.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM Class contains More Tab WebElements and its Business Layer
 * 
 * @author ymulk
 *
 */
public class MoreTabPage {

	/**
	 * This Constructor initializes MoreTab WebElements
	 * 
	 * @param driver
	 */
	public MoreTabPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//a[text()='More']")
	private WebElement moreTab;

	@FindBy(xpath = "//a[text()='Campaigns']")
	private WebElement campaignLink;

	// business Layer
	/**
	 * This method is used to get Campaign Link WebElement
	 * 
	 * @return
	 */
	public WebElement getCampaignLink() {
		return campaignLink;
	}

	/**
	 * This method is used to click on Campaign Link WebElement
	 * @return 
	 * 
	 * @return
	 */
	public CampaignPage ClickOnCampaignLink(WebDriverUtility webDriverUtility) {
		webDriverUtility.mouseHover(moreTab);
		campaignLink.click();
		return new CampaignPage();
	}
}
