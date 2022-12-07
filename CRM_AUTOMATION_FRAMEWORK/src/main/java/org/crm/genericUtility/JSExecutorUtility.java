package org.crm.genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This Class contains all the JavaScript reusable methods
 * 
 * @author ymulk
 *
 */
public final class JSExecutorUtility {
	private JavascriptExecutor js;

	/**
	 * This method is used to initialize the JavascriptExecutor Object/ to convert WebDriver Object to JavascriptExecutor Type
	 * 
	 * @param driver
	 */
	public void initializeJavascriptExecutor(WebDriver driver) {
		js = (JavascriptExecutor) driver;
	}

	/**
	 * This method is used to enter the URL using JavascriptExecutor
	 * 
	 * @param url
	 */
	public void enterUrl(String url) {
		js.executeScript("window.location=arguments[0]", url);
	}

	/**
	 * This method is used to enter the data into element using JavascriptExecutor
	 * 
	 * @param element
	 * @param data
	 */
	public void writeDataIntoElement(WebElement element, String data) {
		js.executeScript("argument[0].value=argument[1]", element, data);
	}

	/**
	 * This method is used to either Scroll to beginning or end of the Webpage
	 * 
	 * @param strategy
	 * @param yAxisPostion
	 */
	public void scrollToPageBeginningOrEnd(String strategy, int yAxisPosition) {
		String sign = strategy.equalsIgnoreCase("up") ? "-" : "+";
		js.executeScript("window.scrollBy(0," + sign + "argument[0])", yAxisPosition);
	}

	/**
	 * This method is used to Scroll vertically to specified position
	 * 
	 * @param strategy
	 * @param yAxisPosition
	 */
	public void scrollToVerticalPosition(String strategy, int yAxisPosition) {
		String sign = strategy.equalsIgnoreCase("up") ? "-" : "+";
		js.executeScript("window.scrollBy(0," + sign + "argument[0])", yAxisPosition);
	}

	/**
	 * This method is used to scroll to particular WebElement
	 * 
	 * @param element
	 */
	public void scrollToWebElement(WebElement element) {
		// js.executeScript("window.scrollBy(0,argument[0])", element);
		js.executeScript("argument[0].scrollIntoView()", element);
	}

	/**
	 * This method is use to highlight particular WebElement
	 * 
	 * @param element
	 */
	public void highlightWebElement(WebElement element) {
		js.executeScript("argument[0].setAttribute('Style', 'border:3px solid green;')", element);
	}

}
