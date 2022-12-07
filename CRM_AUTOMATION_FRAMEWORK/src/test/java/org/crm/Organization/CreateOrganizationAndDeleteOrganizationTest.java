package org.crm.Organization;

import java.util.List;

import org.crm.genericUtility.BaseClass1;
import org.crm.pomrepository.OrganizationInformationPage;
import org.crm.pomrepository.OrganizationsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateOrganizationAndDeleteOrganizationTest extends BaseClass1 {
	@Test
	public void createOrganizationAndDeleteOrganizationTest() {


		String expectedOrganizationName = getThreadSafeExcelUtilityObject()
											.getExcelData("CreateOrganization", 2, 1) + randomNumber;
		
		System.out.println(expectedOrganizationName);

		OrganizationInformationPage organizationInformationPage = commonPage.clickOnOrganizationTab()
																		.clickOnCreateOrganizationBtn()
																			.enterOrganiztionName(expectedOrganizationName)
																					.clickOnSaveBtn(); 
		
		OrganizationsPage organizationsPage = organizationInformationPage.gotoOrganizationPage();
		
		String pageCount = organizationsPage.totalPages();

		organizationsPage.gotoPage(pageCount);

		organizationsPage.waitTillElementInvisible(getThreadSafeWebDriverUtilityObject(), organizationsPage.getStatus());

		int count = 0;
		List<String> organizationNameList = organizationsPage.getAllOrganizationsName();
		for (int i = 0; i < organizationNameList.size(); i++) {
			String organizationName = organizationNameList.get(i);
			if (organizationName.equals(expectedOrganizationName)) {
					organizationsPage.deleteOrganization(getThreadSafeWebDriverUtilityObject(), expectedOrganizationName, i);
				count++;
				break;
			}
		}

		SoftAssert softAssert =  new SoftAssert();
		softAssert.assertEquals(count, 1);
	}
}
