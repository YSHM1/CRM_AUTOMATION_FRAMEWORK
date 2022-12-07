package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.crm.genericUtility.WebDriverUtility;
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
public class OrganizationInformationPage {

	/**
	 * This Constructor is used to Initialize the WebElements
	 * 
	 * @param driver
	 */
	public OrganizationInformationPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//span[@class='small']")
	private WebElement waitingCondition;

	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement actualOrganizationTextField;

	@FindBy(xpath = "//span[@id='dtlview_Industry']")
	private WebElement industryTextField;

	@FindBy(xpath = "//span[@id='dtlview_Type']")
	private WebElement typeTextField;

	@FindBy(xpath = "//td[@class='moduleName']/a")
	private WebElement organizationBtn;

	// Business Layer
	/**
	 * This method is used to return waitingCondition WebElement
	 * 
	 * @return
	 */
	public WebElement getWaitingCondition() {
		return waitingCondition;
	}

	/**
	 * This method is used to get Actual Organization name
	 * 
	 * @return
	 */
	public String getActualOrganizationName() {
		return actualOrganizationTextField.getText();
	}

	/**
	 * This method is used to get selected Industry name
	 * 
	 * @return
	 */
	public String getIndustryName() {
		return industryTextField.getText();
	}

	/**
	 * This method is used to get selected type name
	 * 
	 * @return
	 */
	public String getTypeName() {
		return typeTextField.getText();
	}

	/**
	 * This method is used to goto Organization Page
	 * @return 
	 */
	public OrganizationsPage gotoOrganizationPage() {
		organizationBtn.click();
		return new OrganizationsPage();
	}

	/**
	 * This is used to wait till the WebElement is Visible
	 * 
	 * @return
	 */
	public void waitTillElementVisible(WebDriverUtility webDriverUtility) {
		webDriverUtility.initializeExplicitWait(10, 300);
		webDriverUtility.waitTillVisibilityOfElement(waitingCondition);
	}
}
