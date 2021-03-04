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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

	// static final Logger logger = Logger.getLogger(LoginSteps.class);
	private static final Logger logger = LogManager.getLogger(LoginSteps.class);

	WebDriver driver;

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
		driver.get("https://www.saucedemo.com/");
	}

	@And("^fill username and password fields$")
	public void fill_username_and_password_fields() {
		logger.info("=================================");
		logger.info("fill_username_and_password_fields");
		logger.info("=================================");
		
		WebElement usernameInput = driver.findElement(By.id("user-name"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		usernameInput.sendKeys("standard_user");
		passwordInput.sendKeys("secret_sauce");
	}

	@When("^click on login button$")
	public void click_on_login_button() throws InterruptedException {
		logger.info("=====================");
		logger.info("click_on_login_button");
		logger.info("=====================");
		
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		
		Thread.sleep(2000);
	}
	
	@Then("^products section is present$")
	public void products_section_is_present() {
		logger.info("===========================");
		logger.info("products_section_is_present");
		logger.info("===========================");
		
		WebElement productTitle = driver.findElement(By.className("product_label"));
		assertTrue(productTitle.isDisplayed());
	}
	

}
