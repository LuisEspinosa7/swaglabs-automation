/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.testContext;

import com.lsoftware.automation.swaglabs.managers.PageObjectManager;
import com.lsoftware.automation.swaglabs.managers.WebDriverManager;

/**
 * The Class TestContext.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 07/03/2021
 */
public class TestContext {

	/** The web driver manager. */
	private WebDriverManager webDriverManager;
	
	/** The page object manager. */
	private PageObjectManager pageObjectManager;
	
	/**
	 * Instantiates a new test context.
	 */
	public TestContext() {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getdriver());
	}
	
	/**
	 * Gets the web driver manager.
	 *
	 * @return the web driver manager
	 */
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	/**
	 * Gets the page object manager.
	 *
	 * @return the page object manager
	 */
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}
