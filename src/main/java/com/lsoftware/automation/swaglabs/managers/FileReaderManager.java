/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.managers;

import com.lsoftware.automation.swaglabs.dataProvider.ConfigFileReader;
import com.lsoftware.automation.swaglabs.dataProvider.CustomerJsonDataReader;

/**
 * The Class FileReaderManager.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 04/03/2021
 */
public class FileReaderManager {

	/** The file reader manager. */
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	
	/** The config file reader. */
	private static ConfigFileReader configFileReader;
	
	/** The json data reader. */
	private static CustomerJsonDataReader jsonDataReader;

	/**
	 * Instantiates a new file reader manager.
	 */
	private FileReaderManager() {
	}

	/**
	 * Gets the single instance of FileReaderManager.
	 *
	 * @return single instance of FileReaderManager
	 */
	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}

	/**
	 * Gets the config reader.
	 *
	 * @return the config reader
	 */
	public ConfigFileReader getConfigReader() {
		return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	}

	/**
	 * Gets the customer json reader.
	 *
	 * @return the customer json reader
	 */
	public CustomerJsonDataReader getCustomerJsonReader() {
		return (jsonDataReader == null) ? new CustomerJsonDataReader() : jsonDataReader;
	}

}
