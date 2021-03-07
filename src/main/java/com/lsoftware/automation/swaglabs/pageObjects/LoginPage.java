/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.pageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.lsoftware.automation.swaglabs.async.Wait;
import com.lsoftware.automation.swaglabs.managers.FileReaderManager;

/**
 * The Class LoginPage.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 04/03/2021
 */
public class LoginPage {

	/** The Constant logger. */
	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	/** The driver. */
	WebDriver driver;

	/**
	 * Instantiates a new login page.
	 *
	 * @param driver the driver
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** The username input. */
	@FindBy(how = How.ID, using = "user-name")
	private WebElement usernameInput;

	/** The password input. */
	@FindBy(how = How.ID, using = "password")
	private WebElement passwordInput;

	/** The login button. */
	@FindBy(how = How.ID, using = "login-button")
	private WebElement loginButton;

	/**
	 * Enter username.
	 *
	 * @param username the username
	 */
	public void enterUsername(String username) {
		logger.info("Filling username");
		usernameInput.sendKeys(username);
	}

	/**
	 * Enter password.
	 *
	 * @param password the password
	 */
	public void enterPassword(String password) {
		logger.info("Filling password");
		passwordInput.sendKeys(password);
	}

	/**
	 * Click login button.
	 */
	public void clickLoginButton() {
		logger.info("Clicking on login button");
		loginButton.click();
		
		Wait.untilPageLoadComplete(driver);
	}
	
	/**
	 * Navigate to login page.
	 */
	public void navigateToLoginPage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

}
