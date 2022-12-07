package org.crm.documents;

import org.crm.genericUtility.BaseClass1;
import org.crm.pomrepository.DocumentInformationPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Listeners(org.crm.genericUtility.ListenerImplementation.class)
public class CreateDocumentTest extends BaseClass1 {
	@Test
	public void createDocumentTest() {

		String expectedTitleName = getThreadSafeExcelUtilityObject()
										.getExcelData("CreateDocument", 2, 1) + randomNumber;
		
		String expectedDescription = getThreadSafeExcelUtilityObject()
										.getExcelData("CreateDocument", 2, 2);

		String filePath = getThreadSafeExcelUtilityObject()
										.getExcelData("CreateDocument", 2, 3);
		
		String expectedFilePath = getThreadSafeJavaUtilityObject()
										.getAbsoluteFilePath(filePath);
		
		DocumentInformationPage documentInformationPage = commonPage.clickOnDocumentsTab().clickOnCreateDocumentBtn()
				.enterTitle(expectedTitleName).switchToFrame(getThreadSafeWebDriverUtilityObject()).enterDescription(expectedDescription)
				.switchToCreateNewDocumentPage(getThreadSafeWebDriverUtilityObject()).enterFilePath(getThreadSafeJavaUtilityObject(), filePath).clickOnSaveBtn();

		String actualTitleName = documentInformationPage.getActualTitle();

		String actualDescription = documentInformationPage.getActualDescription();

		String actualFileName = documentInformationPage.getActualFileName();

		String expectedFileName = getThreadSafeJavaUtilityObject()
										.getSplitStringValue(expectedFilePath, "/", 4);

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(expectedTitleName.equals(actualTitleName) && expectedDescription.equals(actualDescription)
				&& actualFileName.equals(expectedFileName));
	}
}
