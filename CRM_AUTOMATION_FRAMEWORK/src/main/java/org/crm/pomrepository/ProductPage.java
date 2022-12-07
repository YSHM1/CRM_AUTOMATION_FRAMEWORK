package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM class contains Product Page WebElements and its Business Layer
 * 
 * @author ymulk
 *
 */
public final class ProductPage {

	/**
	 * This Constructor is used to initialize Product Page WebElements
	 * 
	 * @param driver
	 */
	public ProductPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createNewProductBtn;

	// Business Layer
	/**
	 * This method is used to get createProductBtn WebElements
	 * 
	 * @return
	 */
	public WebElement getcreateProductBtn() {
		return createNewProductBtn;
	}

	/**
	 * This method is used to click on create product button
	 * 
	 * @return
	 */
	public CreateNewProductPage clickOnCreateNewProductBtn() {
		createNewProductBtn.click();
		return new CreateNewProductPage();
	}
}
