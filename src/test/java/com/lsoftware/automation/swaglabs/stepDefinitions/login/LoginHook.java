/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.stepDefinitions.login;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.lsoftware.automation.swaglabs.enums.ExpectedResultTypes;
import com.lsoftware.automation.swaglabs.managers.FileReaderManager;
import com.lsoftware.automation.swaglabs.managers.WaitOperationManager;
import com.lsoftware.automation.swaglabs.pageObjects.LoginPage;
import com.lsoftware.automation.swaglabs.pageObjects.ProductsPage;
import com.lsoftware.automation.swaglabs.testContext.TestContext;
import com.lsoftware.automation.swaglabs.testDataTypes.Customer;

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

	/** The login page. */
	LoginPage loginPage;
	
	/** The products page. */
	ProductsPage productsPage;

	/**
	 * Instantiates a new login hook.
	 *
	 * @param context the context
	 */
	public LoginHook(TestContext context) {
		logger.info("======================");
		logger.info("Login Hook initialized");
		logger.info("======================");

		testContext = context;

		loginPage = testContext.getPageObjectManager().getLoginPage();
		productsPage = testContext.getPageObjectManager().getProductsPage();
	}

	/**
	 * Before scenario.
	 */
	@Before("~@login")
	public void beforeScenario() {
		logger.info("=============");
		logger.info("beforeScenario");
		logger.info("=============");

		loginPage.navigateToLoginPage();
		WaitOperationManager.getInstance().getWaitOperation(testContext.getWebDriverManager().getdriver())
				.waitUntilLoadComplete();

		Customer customer = FileReaderManager.getInstance().getCustomerJsonReader()
				.getCustomerByName(FileReaderManager.getInstance().getConfigReader().getSuccessLoginCustomerUsername());

		loginPage.enterUsername(customer.username);
		loginPage.enterPassword(customer.password);

		loginPage.clickLoginButton(ExpectedResultTypes.SUCCESS.toString());

		WaitOperationManager.getInstance().getWaitOperation(testContext.getWebDriverManager().getdriver())
				.waitUntilLoadComplete();
		
		assertTrue(productsPage.productsTitleIsPresent());
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
