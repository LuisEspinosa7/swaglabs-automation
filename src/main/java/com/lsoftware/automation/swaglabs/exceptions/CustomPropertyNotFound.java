/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.exceptions;


/**
 * The Class CustomPropertyNotFound.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 04/03/2021
 */
public class CustomPropertyNotFound extends RuntimeException {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2825164111294919940L;

	/**
	 * Instantiates a new custom property not found.
	 *
	 * @param message the message
	 */
	public CustomPropertyNotFound(String message) {
		super(message);
	}

}
