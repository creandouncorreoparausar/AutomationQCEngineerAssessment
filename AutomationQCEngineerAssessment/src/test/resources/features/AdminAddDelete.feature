Feature: Admin User Management
  As an admin user
  I want to manage users on the OrangeHRM platform
  So that I can ensure the application functions correctly

  Scenario: Login to the website

    Given I am on the login page
    When I enter username and password and I click Login Button
    Then I should be logged in successfully
    And I handle the alert popup
    When I click on the Admin tab on the left side menu
    Then I should see the number of records displayed

    When I click the Add button
    And I fill in the required data
    Then the number of records should increase by one

    When I search for the username of the new user and I find them

    Then I delete the user
    And the number of records should decrease by one