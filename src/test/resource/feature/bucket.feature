
Feature: Bucket

  Scenario: Add product into bucket
    Given count order is 0
    When  add product 1
    And  add product 2
    And add product 3
    Then count order is 3
    And remove all element
    Then count order is 0

