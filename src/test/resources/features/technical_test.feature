Feature: William Hill Test

  Scenario: Count A-Z games with logging site version and STACK cookie
    Given I navigate to the home page
    And I login to the member area
    Then I can count all A-Z games
    And log the names