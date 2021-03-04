/*
 * Automation Framework for free web testing page (https://www.saucedemo.com/)
 * Author: Luis Hernan Espinosa Llanos
 * Email: lluisllanoss@gmail.com
 */

package com.lsoftware.automation.swaglabs.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


/**
 * The Class TestLoginRunner.
 *
 * @author Luis Espinosa
 * @version 1.0
 * @since 03/03/2021
 */
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/functionalTests/login",
 glue= {"com.lsoftware.automation.swaglabs.stepDefinitions.login"})
public class TestLoginRunner {

}
