@contact_us_PO @1
Feature: Webdriver university - contact us page - With Page Objects

  Scenario: Validate Successful submission - unique data

    Given I access the web driver university contact us page - With Page Objects
    When I enter a unique first name - With Page Objects
    And last name - With Page Objects
    And email - With Page Objects
    And comment - With Page Objects
    And submit - With Page Objects
    Then I should be present message - With Page Objects
