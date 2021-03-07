/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.stepDefinitions.login;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.lsoftware.automation.swaglabs.testContext.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginHook.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 07/03/2021
 */
public class LoginHook {
	
	/** The Constant logger. */
	private static final Logger logger = LogManager.getLogger(LoginHook.class);


	/** The test context. */
	TestContext testContext;

	/**
	 * Instantiates a new login hook.
	 *
	 * @param context the context
	 */
	public LoginHook(TestContext context) {
		testContext = context;
	}

	/**
	 * Before scenario.
	 */
	@Before
	public void beforeScenario() {
		logger.info("=============");
		logger.info("beforeScenario");
		logger.info("=============");
		
		// Nothing Here
	}

	/**
	 * After scenario.
	 */
	@After
	public void afterScenario() {
		logger.info("=============");
		logger.info("afterScenario");
		logger.info("=============");
		
		testContext.getWebDriverManager().closeDriver();
	}

}
