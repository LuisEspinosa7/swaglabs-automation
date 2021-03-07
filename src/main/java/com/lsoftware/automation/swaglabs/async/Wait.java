/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.async;

import java.util.function.Function;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lsoftware.automation.swaglabs.managers.FileReaderManager;


/**
 * The Class Wait.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 07/03/2021
 */
public class Wait {
	
	/** The Constant logger. */
	private static final Logger logger = LogManager.getLogger(Wait.class);


	/**
	 * Until ajax is done. (Call from outside Class)
	 *
	 * @param driver the driver
	 */
	public static void untilElementOnScreen(WebDriver driver, WebElement webElement) {
		untilElementOnScreen(driver, webElement, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
	}

	/**
	 * Until ajax is done.
	 *
	 * @param driver the driver
	 * @param timeoutInSeconds the timeout in seconds
	 */
	public static void untilElementOnScreen(WebDriver driver, WebElement webElement, Long timeoutInSeconds) {
		until(driver, (d) -> {
			boolean isElementOnScreen = webElement.isDisplayed();
			if (!isElementOnScreen)
				logger.info("Element not yet on screen");
			return isElementOnScreen;
		}, timeoutInSeconds);
	}

	/**
	 * Until page load complete. (Call from outside Class)
	 *
	 * @param driver the driver
	 */
	public static void untilPageLoadComplete(WebDriver driver) {
		untilPageLoadComplete(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
	}

	/**
	 * Until page load complete.
	 *
	 * @param driver the driver
	 * @param timeoutInSeconds the timeout in seconds
	 */
	public static void untilPageLoadComplete(WebDriver driver, Long timeoutInSeconds) {
		until(driver, (d) -> {
			Boolean isPageLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState")
					.equals("complete");
			if (!isPageLoaded)
				logger.info("Document is loading...");
			return isPageLoaded;
		}, timeoutInSeconds);
	}

	/**
	 * Until.
	 *
	 * @param driver the driver
	 * @param waitCondition the wait condition
	 */
	private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition) {
		until(driver, waitCondition, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
	}

	/**
	 * Until.
	 *
	 * @param driver the driver
	 * @param waitCondition the wait condition
	 * @param timeoutInSeconds the timeout in seconds
	 */
	@SuppressWarnings("deprecation")
	private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds) {		
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
		try {
			webDriverWait.until(waitCondition);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

}
