/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.testDataTypes;

/**
 * The Class Product.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 08/03/2021
 */
public class Product {

	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The price. */
	private double price;
	
	/**
	 * Instantiates a new product.
	 */
	public Product() {
		
	}

	/**
	 * Instantiates a new product.
	 *
	 * @param name the name
	 * @param description the description
	 * @param price the price
	 */
	public Product(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
