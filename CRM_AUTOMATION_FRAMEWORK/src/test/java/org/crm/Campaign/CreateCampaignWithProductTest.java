package org.crm.Campaign;

import org.crm.genericUtility.BaseClass1;
import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.crm.pomrepository.CampaignInformationPage;
import org.crm.pomrepository.CreateNewCampaignPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateCampaignWithProductTest extends BaseClass1 {
	@Test
	public void createCampaignWithProductTest() {
		
		String expectedCampaignName = ThreadSafeInstanceClass.getThreadSafeExcelUtilityObject()
																.getExcelData("CreateCampaign", 2, 1) + randomNumber;
		
		String expectedProductName = ThreadSafeInstanceClass.getThreadSafeExcelUtilityObject()
																	.getExcelData("CreateProduct", 2, 1) + randomNumber;
		
		commonPage.clickOnProductsTab().clickOnCreateNewProductBtn()
											.enterProductName(expectedProductName)
																.clickOnSaveBtn();
		
		CreateNewCampaignPage createNewCampaignPage = moreTabPage.ClickOnCampaignLink(getThreadSafeWebDriverUtilityObject())
				.clickOnCreateCampaignBtn().enterDataToCampaignNameTextField(expectedCampaignName)
				.clickOnSelectProductBtn();

		ThreadSafeInstanceClass.getThreadSafeWebDriverUtilityObject()
										.switchToWindow("Url", "Products");

		createNewCampaignPage.selectProduct(expectedProductName);

		ThreadSafeInstanceClass.getThreadSafeWebDriverUtilityObject()
									.switchToWindow("url", "Campaigns");

		createNewCampaignPage.clickOnSaveBtn();

		CampaignInformationPage campaignInformationPage = new CampaignInformationPage();
		String actualCampaignName = campaignInformationPage.getActualCampaignName();
		String actualProductName = campaignInformationPage.getActualProductName();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(expectedCampaignName.equals(actualCampaignName) 
				&& expectedProductName.equals(actualProductName));
		softAssert.assertAll();
	}
}
