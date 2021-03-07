/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.async;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The Class WaitOperation.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 07/03/2021
 */
public class WaitOperation {

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new wait operation.
	 *
	 * @param driver the driver
	 */
	public WaitOperation(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Click button and decide wait.
	 *
	 * @param expectedResult the expected result
	 * @param webElement the web element
	 */
	public void clickButtonAndDecideWait(String expectedResult, WebElement webElement) {

		switch (expectedResult) {
		case "SUCCESS":
			waitUntilLoadComplete();
			break;
		case "FAIL":
			waitUntilElementIsPresent(webElement);
			break;

		default:
			break;
		}
	}

	/**
	 * Wait until load complete.
	 */
	public void waitUntilLoadComplete() {
		Wait.untilPageLoadComplete(driver);
	}

	/**
	 * Wait until element is present.
	 *
	 * @param webElement the web element
	 */
	public void waitUntilElementIsPresent(WebElement webElement) {
		Wait.untilElementOnScreen(driver, webElement);
	}

}
