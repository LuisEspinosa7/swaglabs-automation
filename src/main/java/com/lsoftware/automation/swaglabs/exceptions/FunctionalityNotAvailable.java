/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.exceptions;


/**
 * The Class FunctionalityNotAvailable.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 07/03/2021
 */
public class FunctionalityNotAvailable extends RuntimeException {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9139622386579169603L;

	/**
	 * Instantiates a new custom property not found.
	 *
	 * @param message the message
	 */
	public FunctionalityNotAvailable(String message) {
		super(message);
	}

}
