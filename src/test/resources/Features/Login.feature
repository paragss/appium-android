@login @RunAll
Feature: Test the Assigned functionality assigned by Lambda Test

  @standardUser @RunOne
  Scenario: Login with standard user
    Given application is launched
    When I select the standard user for login
#    And I click on login button
#    Then I should be logged in successfully

  @lockedUser
  Scenario: Login with locked user
    Given application is launched
    When I select the locked user for login
    And I click on login button
    Then I should get error for locked user

  @AndroidScenario
  Scenario: Scenario for Proverbial mobile automation app
    Given application is launched


