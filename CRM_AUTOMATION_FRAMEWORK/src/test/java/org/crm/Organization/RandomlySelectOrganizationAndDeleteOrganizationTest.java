package org.crm.Organization;

import java.util.List;

import org.crm.genericUtility.BaseClass1;
import org.crm.pomrepository.OrganizationsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RandomlySelectOrganizationAndDeleteOrganizationTest extends BaseClass1 {
	@Test
	public void randomlySelectOrganizationAndDeleteOrganizationTest() {

		String organizationToBeDeleted = getThreadSafeExcelUtilityObject().getExcelData("CreateOrganization", 4, 1);
		System.out.println(organizationToBeDeleted);

		OrganizationsPage organizationsPage = commonPage.clickOnOrganizationTab();

		int count = 0;

		String pages = organizationsPage.totalPages();
		int totalPages = getThreadSafeJavaUtilityObject().convertStringToInteger(pages);

		for (int i = 1; i <= totalPages; i++) {
			boolean flag=false;
			List<String> organizationNameList = organizationsPage.getAllOrganizationsName();
			for (int j = 0; j < organizationNameList.size(); j++) {
				System.out.println(organizationNameList.get(j));
				if (organizationToBeDeleted.trim().equals(organizationNameList.get(j).trim())) {
					flag=true;
					organizationsPage.deleteOrganization(getThreadSafeWebDriverUtilityObject(), organizationToBeDeleted, j);
					count++;
					break;
				}
			}
			if(flag==false) {
			organizationsPage.clickNextPageButton().waitTillElementInvisible(getThreadSafeWebDriverUtilityObject(), organizationsPage.getStatus());
			}
			else
				break;
		}

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(count, 1);
	}
}