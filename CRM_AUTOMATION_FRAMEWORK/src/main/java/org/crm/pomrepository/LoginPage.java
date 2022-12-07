package org.crm.pomrepository;

import org.crm.genericUtility.ThreadSafeInstanceClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM class contains Login Page WebElements and its Business Layer
 * 
 * @author ymulk
 *
 */
public final class LoginPage {

	/**
	 * This Constructor is used to initialize Login Page WebElements
	 * 
	 * @param driver
	 */
	public LoginPage() {
		PageFactory.initElements(ThreadSafeInstanceClass.getThreadSafeDriverObject(), this);
	}

	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement userNameTextField;

	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement passwordTextField;

	@FindBy(xpath = "//input[@id='submitButton']")
	private WebElement loginBtn;

	// Business Layer

	/**
	 * This method is used to get userNameTextField WebElement
	 * 
	 * @return
	 */
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	/**
	 * This method is used to get passwordTextField WebElement
	 * 
	 * @return
	 */
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	/**
	 * This method is used to get loginBtn WebElement
	 * 
	 * @return
	 */
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	/**
	 * This method is used to login to Application
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public CommonPage login(String userName, String password) {
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		loginBtn.click();
		return new CommonPage();
	}

}
