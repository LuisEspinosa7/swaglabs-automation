/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.managers;

import org.openqa.selenium.WebDriver;

import com.lsoftware.automation.swaglabs.pageObjects.HeaderPage;
import com.lsoftware.automation.swaglabs.pageObjects.LoginPage;
import com.lsoftware.automation.swaglabs.pageObjects.ProductsPage;

// TODO: Auto-generated Javadoc
/**
 * The Class PageObjectManager.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 04/03/2021
 */
public class PageObjectManager {

	/** The driver. */
	private WebDriver driver;
	
	/** The login page. */
	LoginPage loginPage;
	
	/** The products page. */
	ProductsPage productsPage;
	
	/** The header page. */
	HeaderPage headerPage;
	
	
	/**
	 * Instantiates a new page object manager.
	 *
	 * @param driver the driver
	 */
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Gets the login page.
	 *
	 * @return the login page
	 */
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	/**
	 * Gets the products page.
	 *
	 * @return the products page
	 */
	public ProductsPage getProductsPage() {
		return (productsPage == null) ? productsPage = new ProductsPage(driver) : productsPage;
	}
	
	/**
	 * Gets the header page.
	 *
	 * @return the header page
	 */
	public HeaderPage getHeaderPage() {
		return (headerPage == null) ? headerPage = new HeaderPage(driver) : headerPage;
	}

	
}
