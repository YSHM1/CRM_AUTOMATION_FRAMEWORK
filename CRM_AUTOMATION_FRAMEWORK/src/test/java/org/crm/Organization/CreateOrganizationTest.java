package org.crm.Organization;

import org.crm.genericUtility.BaseClass1;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateOrganizationTest extends BaseClass1 {
	@Test
	public void createOrganizationTest() {

		String expectedOrganizationName = getThreadSafeExcelUtilityObject()
											.getExcelData("CreateOrganization", 2, 1) + randomNumber;


		String actualOrganizationName = commonPage.clickOnOrganizationTab()
													.clickOnCreateOrganizationBtn()
														.enterOrganiztionName(expectedOrganizationName)
															.clickOnSaveBtn().getActualOrganizationName();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(expectedOrganizationName.equals(actualOrganizationName));
	}
}