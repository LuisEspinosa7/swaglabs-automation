/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.lsoftware.automation.swaglabs.enums.DriverType;
import com.lsoftware.automation.swaglabs.enums.EnvironmentType;
import com.lsoftware.automation.swaglabs.exceptions.FunctionalityNotAvailable;

/**
 * The Class WebDriverManager.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 07/03/2021
 */
public class WebDriverManager {

	/** The driver. */
	private WebDriver driver;

	/** The driver type. */
	private static DriverType driverType;

	/** The environment type. */
	private static EnvironmentType environmentType;

	/** The Constant CHROME_DRIVER_PROPERTY. */
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	/** The Constant FIREFOX_DRIVER_PROPERTY. */
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";

	/**
	 * Instantiates a new web driver manager.
	 */
	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public WebDriver getdriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	/**
	 * Creates the driver.
	 *
	 * @return the web driver
	 */
	private WebDriver createDriver() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	/**
	 * Creates the remote driver.
	 *
	 * @return the web driver
	 */
	private WebDriver createRemoteDriver() {
		throw new FunctionalityNotAvailable("RemoteWebDriver is not yet implemented");
	}

	/**
	 * Creates the local driver.
	 *
	 * @return the web driver
	 */
	private WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX:
			System.setProperty(FIREFOX_DRIVER_PROPERTY,
					FileReaderManager.getInstance().getConfigReader().getUserDirectory()
							.concat(FileReaderManager.getInstance().getConfigReader().getFirefoxDriverPath()));
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY,
					FileReaderManager.getInstance().getConfigReader().getUserDirectory()
							.concat(FileReaderManager.getInstance().getConfigReader().getChromeDriverPath()));
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER:
			driver = new InternetExplorerDriver();
			break;
		}

		if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
			driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * Close driver.
	 */
	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}
