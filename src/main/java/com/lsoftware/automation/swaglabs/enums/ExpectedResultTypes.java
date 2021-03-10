/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.enums;


/**
 * The Class ExpectedResultTypes.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 07/03/2021
 */
public enum ExpectedResultTypes {
	
	/** The success. */
	SUCCESS("SUCCESS"),
	
	/** The fail. */
	FAIL("FAIL");
	
	/** The expected type. */
	private final String expectedType;

    
	/**
	 * Instantiates a new expected result types.
	 *
	 * @param expectedType the expected type
	 */
	ExpectedResultTypes(final String expectedType) {
        this.expectedType = expectedType;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return expectedType;
    }
}
