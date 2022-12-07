package org.crm.Organization;

import org.crm.genericUtility.BaseClass1;
import org.crm.pomrepository.OrganizationInformationPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass1 {
	
	@Test
	public void createOrganizationWithIndustryAndTypeTest() {
		
		String expectedOrganizationName = getThreadSafeExcelUtilityObject()
											.getExcelData("CreateOrganization", 2, 1) + randomNumber;

		OrganizationInformationPage organizationInformationPage = commonPage.clickOnOrganizationTab().clickOnCreateOrganizationBtn().enterOrganiztionName(expectedOrganizationName).selectIndustry(getThreadSafeWebDriverUtilityObject(), "value", "Education").selectType(getThreadSafeWebDriverUtilityObject(), "value", "Press").selectAssignToGroup().clickOnSaveBtn();

		String industryNames = organizationInformationPage.getIndustryName();

		String typeNames = organizationInformationPage.getTypeName();
		String actualOrganizationName = organizationInformationPage
												.getActualOrganizationName();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(expectedOrganizationName.equals(actualOrganizationName) && industryNames.equals("Education")
				&& typeNames.equals("Press"));
		
	}
}
