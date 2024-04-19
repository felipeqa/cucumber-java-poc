Feature: Webdriver university - contact us page

  Scenario: Validate Successful submission - unique data

    Given I access the web driver university contact us page
    When I enter a unique first name
    And last name
    And email
    And comment
    And submit
    Then I should be present message
