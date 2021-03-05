/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */
package com.lsoftware.automation.swaglabs.stepDefinitions.login;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.lsoftware.automation.swaglabs.managers.PageObjectManager;
import com.lsoftware.automation.swaglabs.pageObjects.LoginPage;
import com.lsoftware.automation.swaglabs.pageObjects.ProductsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * The Class LoginSteps.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 03/03/2021
 */
public class LoginSteps {

	/** The Constant logger. */
	private static final Logger logger = LogManager.getLogger(LoginSteps.class);

	/** The driver. */
	WebDriver driver;
	
	/** The login page. */
	LoginPage loginPage;
	
	/** The products page. */
	ProductsPage productsPage;
	
	PageObjectManager pageManager;

	/**
	 * User is on login page.
	 */
	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		logger.info("=====================");
		logger.info("user_is_on_login_page");
		logger.info("=====================");

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		pageManager = new PageObjectManager(driver);
		loginPage = pageManager.getLoginPage();
		
		loginPage.navigateToLoginPage();
	}

	/**
	 * Fill username and password fields.
	 */
	@And("^fill username and password fields$")
	public void fill_username_and_password_fields() {
		logger.info("=================================");
		logger.info("fill_username_and_password_fields");
		logger.info("=================================");
		
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");		
	}

	/**
	 * Click on login button.
	 */
	@When("^click on login button$")
	public void click_on_login_button() {
		logger.info("=====================");
		logger.info("click_on_login_button");
		logger.info("=====================");
		
		loginPage.clickLoginButton();		
	}
	
	/**
	 * Products section is present.
	 */
	@Then("^products section is present$")
	public void products_section_is_present() {
		logger.info("===========================");
		logger.info("products_section_is_present");
		logger.info("===========================");
		
		productsPage = pageManager.getProductsPage();
		assertTrue(productsPage.productsTitleIsPresent());
		driver.quit();
	}
	

}
