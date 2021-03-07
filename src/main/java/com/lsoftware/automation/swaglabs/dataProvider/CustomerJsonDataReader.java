/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.lsoftware.automation.swaglabs.exceptions.JSONNotFoundException;
import com.lsoftware.automation.swaglabs.managers.FileReaderManager;
import com.lsoftware.automation.swaglabs.testDataTypes.Customer;

import io.cucumber.messages.internal.com.google.gson.Gson;

/**
 * The Class CustomerJsonDataReader.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 07/03/2021
 */
public class CustomerJsonDataReader {

	/** The customer json file path. */
	private final String customerJsonFilePath = FileReaderManager.getInstance().getConfigReader()
			.getTestDataResourcePath() + "Customer.json";
	
	/** The customer list. */
	private List<Customer> customerList;

	/**
	 * Instantiates a new customer json data reader.
	 */
	public CustomerJsonDataReader() {
		customerList = getCustomerData();
	}

	/**
	 * Gets the customer data.
	 *
	 * @return the customer data
	 */
	private List<Customer> getCustomerData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(customerJsonFilePath));
			Customer[] customers = gson.fromJson(bufferReader, Customer[].class);
			return Arrays.asList(customers);
		} catch (FileNotFoundException e) {
			throw new JSONNotFoundException("Json file not found at path : " + customerJsonFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	/**
	 * Gets the customer by name.
	 *
	 * @param customerUsername the customer username
	 * @return the customer by name
	 */
	public final Customer getCustomerByName(String customerUsername) {
		return customerList.stream().filter(x -> x.username.equalsIgnoreCase(customerUsername)).findAny().get();
	}

}
