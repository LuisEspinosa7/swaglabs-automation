/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.lsoftware.automation.swaglabs.enums.DriverType;
import com.lsoftware.automation.swaglabs.enums.EnvironmentType;
import com.lsoftware.automation.swaglabs.exceptions.CustomPropertyNotFound;

/**
 * The Class ConfigFileReader.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 04/03/2021
 */
public class ConfigFileReader {

	/** The properties. */
	private Properties properties;

	/** The property file path. */
	private final String propertyFilePath = "src/main/resources/configuration.properties";

	/**
	 * Instantiates a new config file reader.
	 */
	public ConfigFileReader() {
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new CustomPropertyNotFound("Configuration properties file not found at: " + propertyFilePath);
		}
	}

	/**
	 * Gets the user directory.
	 *
	 * @return the user directory
	 */
	public String getUserDirectory() {
		return System.getProperty("user.dir");
	}

	/**
	 * Gets the chrome driver path.
	 *
	 * @return the chrome driver path
	 */
	public String getChromeDriverPath() {
		String driverPath = properties.getProperty("chromeDriverPath");
		if (driverPath != null) {
			return driverPath;
		} else {
			throw new CustomPropertyNotFound("chromeDriverPath not specified in the configuration.properties file.");
		}
	}

	/**
	 * Gets the firefox driver path.
	 *
	 * @return the firefox driver path
	 */
	public String getFirefoxDriverPath() {
		String driverPath = properties.getProperty("firefoxDriverPath");
		if (driverPath != null) {
			return driverPath;
		} else {
			throw new CustomPropertyNotFound("firefoxDriverPath not specified in the configuration.properties file.");
		}
	}

	/**
	 * Gets the implicitly wait.
	 *
	 * @return the implicitly wait
	 */
	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null) {
			return Long.parseLong(implicitlyWait);
		} else {
			throw new CustomPropertyNotFound("implicitWait not specified in the Configuration.properties file.");
		}
	}

	/**
	 * Gets the application url.
	 *
	 * @return the application url
	 */
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null) {
			return url;
		} else {
			throw new CustomPropertyNotFound("url not specified in the Configuration.properties file.");
		}
	}

	/**
	 * Gets the browser.
	 *
	 * @return the browser
	 */
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equalsIgnoreCase("iexplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new CustomPropertyNotFound(
					"Browser Key Name value in configuration.properties not matched : " + browserName);
	}

	/**
	 * Gets the environment.
	 *
	 * @return the environment
	 */
	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if (environmentName == null || environmentName.equalsIgnoreCase("local"))
			return EnvironmentType.LOCAL;
		else if (environmentName.equals("remote"))
			return EnvironmentType.REMOTE;
		else
			throw new CustomPropertyNotFound(
					"Environment Key Type value in configuration.properties not matched : " + environmentName);
	}

	/**
	 * Gets the browser window size.
	 *
	 * @return the browser window size
	 */
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}

	/**
	 * Gets the test data resource path.
	 *
	 * @return the test data resource path
	 */
	public String getTestDataResourcePath() {
		String testDataResourcePath = properties.getProperty("testDataResourcePath");
		if (testDataResourcePath != null)
			return testDataResourcePath;
		else
			throw new CustomPropertyNotFound(
					"Test Data Resource Path not specified in the configuration.properties file for the Key:testDataResourcePath");
	}

}
