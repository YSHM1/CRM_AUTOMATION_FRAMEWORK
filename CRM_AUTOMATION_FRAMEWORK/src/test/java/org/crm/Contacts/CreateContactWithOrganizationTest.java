package org.crm.Contacts;

import org.crm.genericUtility.BaseClass1;
import org.crm.pomrepository.ContactInformationPage;
import org.crm.pomrepository.CreateNewContatctPage;
import org.crm.pomrepository.OrganizationInformationPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateContactWithOrganizationTest extends BaseClass1{

	@Test
	public void createContactWithOrganizationTest() {

		String expectedContactLastName = getThreadSafeExcelUtilityObject()
											.getExcelData("CreateContact", 3, 1) + randomNumber;
		
		String expectedOrganizationName = getThreadSafeExcelUtilityObject()
											.getExcelData("CreateOrganization", 2, 1) + randomNumber;
		
		commonPage.clickOnOrganizationTab()
						.clickOnCreateOrganizationBtn()
								.enterOrganiztionName(expectedOrganizationName)
										.clickOnSaveBtn();
		
		OrganizationInformationPage organizationInformationPage = new OrganizationInformationPage();
		organizationInformationPage.waitTillElementVisible(getThreadSafeWebDriverUtilityObject());
		
		CreateNewContatctPage createNewContatctPage = commonPage.clickOnContactTab()
																	.clickOnCreateContactBtn()
																		.enterLastName(expectedContactLastName)
																				.clickOnSelectOrganizationBtn();
		
		getThreadSafeWebDriverUtilityObject().switchToWindow("Url", "Accounts&action");
		createNewContatctPage.selectOrganization(expectedOrganizationName).clickOnSaveBtn();
		
		
		getThreadSafeWebDriverUtilityObject().switchToWindow("url", "Contacts&action");
		
		createNewContatctPage.clickOnSaveBtn();
	
		String actualContactLastName = new ContactInformationPage().getActualContactName();
		String actualOrganizationName = new ContactInformationPage().getActualOrganizationName();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(expectedContactLastName.equals(actualContactLastName)
				&& expectedOrganizationName.equals(actualOrganizationName));
		softAssert.assertAll();

	}
}
