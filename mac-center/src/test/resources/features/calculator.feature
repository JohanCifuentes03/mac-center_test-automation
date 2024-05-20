Feature: Calculator SOAP Service
  As a user on mac-center.com
  I want to calculate the prices of the products
  So that I can manage my money efficiently

  @service
  Scenario Outline: Add numbers using SOAP service
    Given the user has access to SOAP services
    When sends an add service request with <numberOne> and <numberTwo>
    Then should see <response> in the result
    And should receive a response of 200

    Examples:
      | numberOne | numberTwo | response |
      | 3         | 2         | 5        |
      | 5         | 5         | 10       |