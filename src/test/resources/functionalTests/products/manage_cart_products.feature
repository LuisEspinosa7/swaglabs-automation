#Author: lluisllanoss@gmail.com
#Manage Cart Products Feature
@products
Feature: Test of products management feature.
  A user logged in, add one or more products to the cart

  @productsManagement
  Scenario Outline: User successfully log in on the the web app
    Given user is on login page
    And fill "<customer>" credentials
    When click on login button, wait "SUCCESS" login
    Then products section is present

    Examples: 
      | customer                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |

  @productsManagement
  Scenario Outline: User blocked cant log in.
    Given user is on login page
    And fill "<customer>" credentials
    When click on login button, wait "FAIL" login
    Then error button and message is present

    Examples: 
      | customer        |
      | locked_out_user |
