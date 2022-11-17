
Feature: Bucket

  Scenario: Add product into bucket
    Given open list products
    And count order is 0
    When  add product 1
    And  add product 2
    And add product 3
    And count order is 3
    And checkout
    And remove all elements
    And open list products
    Then count order is 0

