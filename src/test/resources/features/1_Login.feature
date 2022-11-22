@Login
Feature: Login

  Background:
    Given I am filling credentials at the login page

  Scenario: Successfully authorize with valid username and password
    Given I entered "Admin" in the username field
    And I entered "admin123" in the password field
    When I click on the "Login" button
