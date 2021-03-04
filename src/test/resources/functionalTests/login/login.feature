#Author: lluisllanoss@gmail.com
#Login Feature
Feature: Test of login feature.
  A user login in on the web app.

  
  Scenario: User successfully log in on the the web app
    Given user is on login page
    And fill username and password fields
    When click on login button
    Then products section is present
