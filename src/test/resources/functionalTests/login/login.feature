#Author: lluisllanoss@gmail.com
#Login Feature
@sanity
Feature: Test of login feature.
  A user login in on the web app.

  @login
  Scenario Outline: User successfully log in on the the web app
    Given user is on login page
    And fill "<customer>" credentials
    When click on login button
    Then products section is present
    
Examples:
	|customer|
	|standard_user|
	|problem_user|
	|performance_glitch_user|
