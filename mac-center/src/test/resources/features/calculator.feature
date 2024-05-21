Feature: Calculator SOAP Service
  As a user on mac-center.com
  I want to calculate the prices of the products
  So that I can manage my money efficiently

  Background:
    Given the user has access to SOAP services

  @service
  Scenario Outline: Add numbers using SOAP service
    When sends an add service request with <numberOne> and <numberTwo>
    Then should see <response> in the result for the add method
    And should receive a response of 200

    Examples:
      | numberOne | numberTwo | response |
      | 3         | 2         | 5        |
      | 5         | 5         | 10       |

  @service
  Scenario Outline: Divide numbers using SOAP service
    When sends a divide service request with <numberOne> and <numberTwo>
    Then should see <response> in the result for the divide method
    And should receive a response of 200
    Examples:
      | numberOne | numberTwo | response |
      | 4         | 2         | 2        |
      | 10        | 2         | 5        |

  @service
  Scenario Outline: Multiply numbers using SOAP service
    When sends a multiply service request with <numberOne> and <numberTwo>
    Then should see <response> in the result for the multiply method
    And should receive a response of 200
    Examples:
      | numberOne | numberTwo | response |
      | 3         | 2         | 6        |
      | 5         | 5         | 25       |

  @service
  Scenario Outline: Subtract numbers using SOAP service
    Given the user has access to SOAP services
    When sends a subtract service request with <numberOne> and <numberTwo>
    Then should see <response> in the result for the subtract method
    And should receive a response of 200
    Examples:
      | numberOne | numberTwo | response |
      | 3         | 2         | 1        |
      | 5         | 5         | 0        |