/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.pageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * The Class ProductsPage.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 04/03/2021
 */
public class ProductsPage {
	
	/** The Constant logger. */
	private static final Logger logger = LogManager.getLogger(ProductsPage.class);

	/**
	 * Instantiates a new products page.
	 *
	 * @param driver the driver
	 */
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/** The products title. */
	@FindBy(how = How.CSS, using = ".product_label")
	private WebElement productsTitle;

	
	/**
	 * Products title is present.
	 *
	 * @return true, if successful
	 */
	public boolean productsTitleIsPresent() {
		logger.info("Validating Products Title is present.");
		return productsTitle.isDisplayed();
	}

}
