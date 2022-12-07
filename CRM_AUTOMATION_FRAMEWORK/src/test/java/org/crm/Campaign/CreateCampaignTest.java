package org.crm.Campaign;

import org.crm.genericUtility.BaseClass1;
import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.crm.pomrepository.CampaignPage;
import org.crm.pomrepository.MoreTabPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateCampaignTest extends BaseClass1 {
	@Test
	public void executeTestScript() {
		
		SoftAssert softAssert = new SoftAssert();
		
		int randomNumber = ThreadSafeInstanceClass.getThreadSafeJavaUtilityObject()
																.getRandomNumber(1000);

		String expectedCampaignName = ThreadSafeInstanceClass
											.getThreadSafeExcelUtilityObject()
												.getExcelData("CreateCampaign", 2, 1) + randomNumber;
		
		ThreadSafeInstanceClass.getThreadSafeExcelUtilityObject().closeExcelFile();
		
		MoreTabPage moreTabPage = new MoreTabPage();
		CampaignPage campaignPage = new CampaignPage();

		ThreadSafeInstanceClass.getThreadSafeWebDriverUtilityObject()
											.mouseHover(commonPage.getMoreTab());

		moreTabPage.getCampaignLink().click();

		String actualCampaignName = campaignPage.clickOnCreateCampaignBtn()
											.enterDataToCampaignNameTextField(expectedCampaignName)
														.clickOnSaveBtn().getActualCampaignName();


		softAssert.assertTrue(expectedCampaignName.equals(actualCampaignName));
		softAssert.assertAll();		
	}
}
