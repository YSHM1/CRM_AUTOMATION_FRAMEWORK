package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.crm.genericUtility.WebDriverUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM Class contains Common Page WebElements and its Business Layer
 * 
 * @author ymulk
 *
 */
public final class CommonPage {

	/**
	 * This Constructor is used to initialize Common Page WebElements
	 * 
	 * @param driver
	 */
	public CommonPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homeTab;

	@FindBy(xpath = "//a[text()='Calendar']")
	private WebElement calenderTab;

	@FindBy(xpath = "//a[text()='Leads']")
	private WebElement leadTab;

	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement organizationTab;

	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactTab;

	@FindBy(xpath = "//a[text()='Opportunities']")
	private WebElement opportunitiesTab;

	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productsTab;

	@FindBy(xpath = "//a[text()='Documents']")
	private WebElement documentsTab;

	@FindBy(xpath = "//a[text()='Email']")
	private WebElement emailTab;

	@FindBy(xpath = "//a[text()='Trouble Tickets']")
	private WebElement troubleTicketTab;

	@FindBy(xpath = "//a[text()='Dashboard']")
	private WebElement dashboardTab;

	@FindBy(xpath = "//a[text()='More']")
	private WebElement moreTab;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIcon;

	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signOutLink;

	// Business Layer
	/**
	 * This method is used to fetch HomeTab WebElement
	 * 
	 * @return
	 */
	public WebElement getHomeTab() {
		return homeTab;
	}

	/**
	 * This method is used to fetch CalenderTab WebElement
	 * 
	 * @return
	 */
	public WebElement getCalenderTab() {
		return calenderTab;
	}

	/**
	 * This method is used to fetch Lead Tab WebElement
	 * 
	 * @return
	 */
	public WebElement getLeadTab() {
		return leadTab;
	}

	/**
	 * This method is used to fetch Organization Tab WebElement
	 * 
	 * @return
	 */
	public WebElement getOrganizationTab() {
		return organizationTab;
	}

	/**
	 * This method is used to fetch Contact Tab WebElement
	 * 
	 * @return
	 */
	public WebElement getContactTab() {
		return contactTab;
	}

	/**
	 * This method is used to fetch Opportunities Tab WebElement
	 * 
	 * @return
	 */
	public WebElement getOpportunitiesTab() {
		return opportunitiesTab;
	}

	/**
	 * This method is used to fetch Product Tab WebElement
	 * 
	 * @return
	 */
	public WebElement getProductsTab() {
		return productsTab;
	}

	/**
	 * This method is used to fetch Documents Tab WebElement
	 * 
	 * @return
	 */
	public WebElement getDocumentsTab() {
		return documentsTab;
	}

	/**
	 * This method is used to fetch Email Tab WebElement
	 * 
	 * @return
	 */
	public WebElement getEmailTab() {
		return emailTab;
	}

	/**
	 * This method is used to fetch TroubleTicket Tab WebElement
	 * 
	 * @return
	 */
	public WebElement getTroubleTicketTab() {
		return troubleTicketTab;
	}

	/**
	 * This method is used to fetch Dashboard Tab WebElement
	 * 
	 * @return
	 */
	public WebElement getDashboardTab() {
		return dashboardTab;
	}

	/**
	 * This method is used to fetch More Tab WebElement
	 * 
	 * @return
	 */
	public WebElement getMoreTab() {
		return moreTab;
	}

	/**
	 * This method is used to fetch Administrator Icon WebElement
	 * 
	 * @return
	 */
	public WebElement getAdministratorIcon() {
		return administratorIcon;
	}

	/**
	 * This method is used to fetch Signout Link WebElement
	 * 
	 * @return
	 */
	public WebElement getSignOutLink() {
		return signOutLink;
	}

	// Business Layer

	/**
	 * This method is used to to click on Home Tab
	 */
	public void clickOnHomeTabBtn() {
		homeTab.click();
	}

	/**
	 * This method is used to to click on Organization Tab
	 * 
	 * @return
	 */
	public OrganizationsPage clickOnOrganizationTab() {
		organizationTab.click();
		return new OrganizationsPage();
	}

	/**
	 * This method is used to to click on Contact Tab
	 * 
	 * @return
	 */
	public ContactPage clickOnContactTab() {
		contactTab.click();
		return new ContactPage();
	}

	/**
	 * This method is used to to click on Product Tab
	 * 
	 * @return
	 */
	public ProductPage clickOnProductsTab() {
		productsTab.click();
		return new ProductPage();
	}

	/**
	 * This method is used to to click on Documents Tab
	 * 
	 * @return
	 */
	public DocumentPage clickOnDocumentsTab() {
		documentsTab.click();
		return new DocumentPage();
	}

	/**
	 * This method is used to logout from application
	 */
	public void logOut(WebDriverUtility webDriverUtility) {
		webDriverUtility.mouseHover(administratorIcon);
		signOutLink.click();
	}
}
