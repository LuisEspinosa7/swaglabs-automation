/**
 * 
 */
package com.lsoftware.automation.swaglabs.pageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.lsoftware.automation.swaglabs.managers.WaitOperationManager;

/**
 * The Class HeaderPage.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 04/03/2021
 */
public class HeaderPage {

	/** The Constant logger. */
	private static final Logger logger = LogManager.getLogger(HeaderPage.class);

	/** The driver. */
	WebDriver driver;
	
	public HeaderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/** The cart link. */
	@FindBy(how = How.CSS, using = "a.shopping_cart_link")
	private WebElement cartLink;
	
	/** The cart product counter. */
	@FindBy(how = How.CSS, using = "span.shopping_cart_badge")
	private WebElement cartProductCounter;
	
	
	
	/**
	 * Click on cart link.
	 */
	public void clickOnCartLink() {
		logger.info("Clicking on cart link.");
		cartLink.click();
		WaitOperationManager.getInstance().getWaitOperation(driver).waitUntilLoadComplete();
	}
	
	/**
	 * Gets the product counter number.
	 *
	 * @return the product counter number
	 */
	public int getProductCounterNumber() {
		int counter = 0;

		if (cartProductCounter.isDisplayed()) {
			counter = Integer.valueOf(cartProductCounter.getText());
		}
		return counter;
	}


}
