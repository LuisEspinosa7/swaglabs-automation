/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.pageObjects;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

// TODO: Auto-generated Javadoc
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

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new products page.
	 *
	 * @param driver the driver
	 */
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** The products title. */
	@FindBy(how = How.CSS, using = ".product_label")
	private WebElement productsTitle;

	/** The order list. */
	@FindAll(@FindBy(how = How.CSS, using = "option.product_sort_container"))
	private List<WebElement> orderList;

	/** The product item. */
	@FindAll(@FindBy(how = How.CSS, using = ".inventory_item"))
	private List<WebElement> productItems;

	/**
	 * Products title is present.
	 *
	 * @return true, if successful
	 */
	public boolean productsTitleIsPresent() {
		logger.info("Validating Products Title is present.");
		return productsTitle.isDisplayed();
	}

	/**
	 * Select order option.
	 *
	 * @param orderOptionNumber the order option number
	 */
	public void selectOrderOption(int orderOptionNumber) {
		orderList.get(orderOptionNumber).click();
		//WaitOperationManager.getInstance().getWaitOperation(driver).waitUntilElementIsPresent(productItems);
	}

	/**
	 * Gets the order option name.
	 *
	 * @param orderOptionNumber the order option number
	 * @return the order option name
	 */
	public String getOrderOptionName(int orderOptionNumber) {
		return orderList.get(orderOptionNumber).getText();
	}

	/**
	 * Gets the product list size.
	 *
	 * @return the product list size
	 */
	public int getProductListSize() {
		return productItems.size();
	}

	/**
	 * Select product.
	 *
	 * @param productNumber the product number
	 */
	public void addProductToCart(int productNumber) {
		productItems.get(productNumber).findElement(By.cssSelector("btn_inventory")).click();
	}

	/**
	 * Gets the product name.
	 *
	 * @param productNumber the product number
	 * @return the product name
	 */
	public String getProductName(int productNumber) {
		return productItems.get(productNumber).findElement(By.cssSelector("inventory_item_name")).getText();
	}

	

}
