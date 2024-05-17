Feature: Search all heroes using GET service
  As a user of marvel.com
  I want to search for information about all the heroes
  So that I can view their details and enjoy the content

  @service
  Scenario: Search all heroes
    Given the user is connected to the Marvel Developer API
    When sends a GET request to retrieve all heroes
    Then response should contain information about all heroes including
      | id      | name                       |
      | 1017100 | A-Bomb (HAS)               |
      | 1009144 | A.I.M.                     |
      | 1009146 | Abomination (Emil Blonsky) |
      | 1009148 | Absorbing Man              |
    And should receive a response of 200

