package org.crm.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this class contains all the WebDriver generic methods
 * 
 * @author ymulk
 *
 */
public final class WebDriverUtility {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	private Select select;

//	private static WebDriverUtility webDriverUtility;
//	
//	private WebDriverUtility() {
//		
//	}
//	
//	public static WebDriverUtility getInstance() {
//		if (Objects.isNull(webDriverUtility)) {
//			webDriverUtility = new WebDriverUtility();
//		}
//		return webDriverUtility;
//	}

	/**
	 * this method is used to open the browser
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver openBrowser(String browser) {

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
//			ListenerImplementation.testLog.info("Brwoser Maximized Successfully");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		default:
			System.out.println("Enter valid browser name");
			break;
		}

		return driver;
	}

	/**
	 * this method is used to enter the Url
	 * 
	 * @param url
	 * @return
	 */
	public void enterUrl(String url) {
		ThreadSafeInstanceClass.getThreadSafeDriverObject().get(url);
	}

	/**
	 * this method is used to execute implicitly wait
	 * 
	 * @param timeouts
	 */
	public void implicitWait(long timeouts) {
		ThreadSafeInstanceClass.getThreadSafeDriverObject().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeouts));
	}

	/**
	 * This method is used to initialize Explicit Wait or WebDriverWait
	 * 
	 * @param timeout
	 * @param pollingPeriod
	 */
	public void initializeExplicitWait(long timeout, long pollingPeriod) {
		wait = new WebDriverWait(ThreadSafeInstanceClass.getThreadSafeDriverObject(), Duration.ofSeconds(timeout));
		wait.pollingEvery(Duration.ofMillis(pollingPeriod));
		wait.ignoring(Exception.class);
	}

	/**
	 * This method is used to wait till WebElement is Visible
	 * 
	 * @param element
	 */
	public void waitTillVisibilityOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to wait till WebElement is Invisible
	 * 
	 * @param element
	 */
	public void waitTillInvisibilityOfElement(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * This method is used to wait till the WebElement is Clickable
	 * 
	 * @param element
	 */
	public void waitTillElementIsClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used to create Custom Wait to click on WebElement
	 * 
	 * @param waitDuration
	 * @param pollingPeriod
	 * @param element
	 */
	public void customWaitToClickWebElement(int waitDuration, long pollingPeriod, WebElement element) {
		int count = 0;
		while (count <= waitDuration) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(pollingPeriod);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			count++;
		}
	}

	/**
	 * This method is used to accept Alert Popup/JS Popup/Confirmation Popup
	 */
	public void acceptAlertPopup() {
		ThreadSafeInstanceClass.getThreadSafeDriverObject().switchTo().alert().accept();
	}

	/**
	 * This method is used to dismiss Alert Popup/JS Popup/Confirmation Popup
	 */
	public void dismissAlertPopup() {
		ThreadSafeInstanceClass.getThreadSafeDriverObject().switchTo().alert().dismiss();
	}

	/**
	 * This method is used to send Data to Alert Popup/JS Popup/Confirmation Popup
	 * 
	 * @param data
	 */
	public void sendDataToAlertPopup(String data) {
		ThreadSafeInstanceClass.getThreadSafeDriverObject().switchTo().alert().sendKeys(data);
	}

	/**
	 * This method is used to get text from Alert Popup/JS Popup/Confirmation Popup
	 */
	public void getAlertPopupText() {
		ThreadSafeInstanceClass.getThreadSafeDriverObject().switchTo().alert().getText();
	}

	/**
	 * This method is used to get the address of Window
	 * 
	 * @return
	 */
	public String getWindowId() {
		String parentWindowId = ThreadSafeInstanceClass.getThreadSafeDriverObject().getWindowHandle();
		return parentWindowId;
	}

	/**
	 * This method is used to get the address of all Windows
	 * 
	 * @return
	 */
	public Set<String> getAllWindowId() {
		Set<String> allWindowId = ThreadSafeInstanceClass.getThreadSafeDriverObject().getWindowHandles();
		return allWindowId;
	}

	/**
	 * This method is used to switch to window based on either URL or Title
	 * 
	 * @param chooseURLOrTitle
	 * @param partialText
	 */
	public void switchToWindow(String chooseURLOrTitle, String partialText) {
		Set<String> allWindowHandles = ThreadSafeInstanceClass.getThreadSafeDriverObject().getWindowHandles();
		for (String windowHandle : allWindowHandles) {
			ThreadSafeInstanceClass.getThreadSafeDriverObject().switchTo().window(windowHandle);
			if (chooseURLOrTitle.equalsIgnoreCase("url")) {
				if (ThreadSafeInstanceClass.getThreadSafeDriverObject().getCurrentUrl().contains(partialText)) {
					break;
				}
			}

			if (chooseURLOrTitle.equalsIgnoreCase("title")) {
				if (ThreadSafeInstanceClass.getThreadSafeDriverObject().getTitle().contains(partialText)) {
					break;
				}
			}
		}
	}

	/**
	 * This method is used to switch the Frame based on frame index
	 * 
	 * @param frameIndex
	 */
	public void switchToFrame(int frameIndex) {
		ThreadSafeInstanceClass.getThreadSafeDriverObject().switchTo().frame(frameIndex);
	}

	/**
	 * This method is used to switch the Frame based on WebElement of frame
	 * 
	 * @param frameElement
	 */
	public void switchToFrame(WebElement frameElement) {
		ThreadSafeInstanceClass.getThreadSafeDriverObject().switchTo().frame(frameElement);
	}

	/**
	 * This method is used to switch Frame based on name or id of frame
	 * 
	 * @param nameOrId
	 */
	public void switchToFrame(String nameOrId) {
		ThreadSafeInstanceClass.getThreadSafeDriverObject().switchTo().frame(nameOrId);
	}

	/**
	 * This method is used to switch to Default Parent Frame
	 */
	public void switchToParentFrame() {
		ThreadSafeInstanceClass.getThreadSafeDriverObject().switchTo().defaultContent();
	}

	/**
	 * This method is used to initialize Select Class Object
	 * 
	 * @param element
	 */
	public void initializeSelectClass(WebElement element) {
		select = new Select(element);
	}

	/**
	 * This method is used to select Option either by Value or Visible Text
	 * 
	 * @param chooseValueOrVisibleText
	 * @param data
	 */
	public void selectOption(String chooseValueOrVisibleText, String data) {
		if (chooseValueOrVisibleText.equalsIgnoreCase("value")) {
			select.selectByValue(data);
		}

		else if (chooseValueOrVisibleText.equalsIgnoreCase("VisibleText")) {
			select.selectByVisibleText(data);
		}
	}

	/**
	 * This method is used to select option by index
	 * 
	 * @param index
	 */
	public void selectOption(int index) {
		select.selectByIndex(index);
	}

	/**
	 * this method is used to mouse hover
	 * 
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		actions = new Actions(ThreadSafeInstanceClass.getThreadSafeDriverObject());
		actions.moveToElement(element).perform();
	}

	/**
	 * This method is used to take Screenshot of Current Page
	 * 
	 * @param currentClass
	 * @param javaUtility
	 */
	public void takeScreenshot(String methodName, JavaUtility javaUtility) {
		TakesScreenshot ts = (TakesScreenshot) ThreadSafeInstanceClass.getThreadSafeDriverObject();
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ErrorShots/ "+ methodName +" _ "
				+ javaUtility.getSimpleCurrentDate("dd-MM-yyy_HH_mm_ss") + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public String takeScreenshotByBase64() {
		TakesScreenshot newScreenshot = (TakesScreenshot)ThreadSafeInstanceClass.getThreadSafeDriverObject();
		String screenShot = newScreenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println(screenShot);
		return screenShot;
	}

	/**
	 * This method is used to take Screenshot of particular WebElement
	 * 
	 * @param currentClass
	 * @param javaUtility
	 * @param element
	 */
	public void takeWebElementScreenshot(Object currentClass, JavaUtility javaUtility, WebElement element) {
		File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ElementScreenshots/" + currentClass.getClass().getSimpleName() + "_"
				+ javaUtility.getSimpleCurrentDate("dd-MM-yyy_HH_mm_ss") + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method is used to close the Browser
	 */
	public void closeBrowser() {
		ThreadSafeInstanceClass.getThreadSafeDriverObject().quit();
	}

	/**
	 * this method contains close Window
	 */
	public void closeTabs() {
		ThreadSafeInstanceClass.getThreadSafeDriverObject().close();
	}

}
