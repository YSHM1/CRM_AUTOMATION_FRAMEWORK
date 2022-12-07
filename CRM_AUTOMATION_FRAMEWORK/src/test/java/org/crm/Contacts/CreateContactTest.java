package org.crm.Contacts;

import org.crm.genericUtility.BaseClass1;
import org.crm.pomrepository.ContactPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateContactTest extends BaseClass1{


	@Test
	public  void createContactTest() {
		String expectedContatcName = getThreadSafeExcelUtilityObject()
											.getExcelData("CreateContact", 3, 1) + randomNumber;

		commonPage.clickOnContactTab();
		ContactPage contactPage = new ContactPage();
		String actualContatcName = contactPage.clickOnCreateContactBtn()
													.enterLastName(expectedContatcName)
														.clickOnSaveBtn()
															.getActualContactName();		
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(expectedContatcName.equals(actualContatcName));
		softAssert.assertAll();

	}
}
