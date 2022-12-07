package org.crm.products;

import org.crm.genericUtility.BaseClass1;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateProductTest extends BaseClass1 {
	@Test
	public void createProductTest() {

		String expectedProductName = getThreadSafeExcelUtilityObject()
										.getExcelData("CreateProduct", 2, 1) + randomNumber;

		String actualProductName = commonPage.clickOnProductsTab()
												.clickOnCreateNewProductBtn()
													.enterProductName(expectedProductName)
														.clickOnSaveBtn()
															.getActualProductName();

		SoftAssert softAssert =  new SoftAssert();
		softAssert.assertTrue(expectedProductName.equals(actualProductName));
		
	}
}