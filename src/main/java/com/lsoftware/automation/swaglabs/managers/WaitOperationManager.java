/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.managers;

import org.openqa.selenium.WebDriver;

import com.lsoftware.automation.swaglabs.async.WaitOperation;

/**
 * The Class WaitOperationManager.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 07/03/2021
 */
public class WaitOperationManager {

	/** The wait operation manager. */
	private static WaitOperationManager waitOperationManager = new WaitOperationManager();

	/** The wait operation. */
	private static WaitOperation waitOperation;

	/**
	 * Instantiates a new wait operation manager.
	 */
	private WaitOperationManager() {
	}

	/**
	 * Gets the single instance of WaitOperationManager.
	 *
	 * @return single instance of WaitOperationManager
	 */
	public static WaitOperationManager getInstance() {
		return waitOperationManager;
	}

	/**
	 * Gets the wait operation.
	 *
	 * @param driver the driver
	 * @return the wait operation
	 */
	public WaitOperation getWaitOperation(WebDriver driver) {
		return (waitOperation == null) ? new WaitOperation(driver) : waitOperation;
	}

}
