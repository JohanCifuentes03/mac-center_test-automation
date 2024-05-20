Feature: Purchase items on mac-center.com
  As a user of the mac-center.com platform
  I want to buy various items
  So that I can enjoy and use them

  @web_efecty
  Scenario Outline: Successfully purchase items using Efecty
    Given the user is on the mac-center.com platform using "<webBrowser>"
    When adds the following items to the cart
      | Iphone 15 pro max |
      | Apple Watch       |
      | iPad pro          |
    And goes to the cart
    And confirms their credentials using efecty payment method
    Then should be able to confirm the payment
    Examples:
      | webBrowser |
      | chrome     |
      | edge       |

  @web_bbva
  Scenario Outline: Successfully purchase items using BBVA
    Given the user is on the mac-center.com platform using "<webBrowser>"
    When adds the following items to the cart
      | Iphone 13   |
      | Macbook pro |
      | Airpods     |
    And goes to the cart
    And confirms their credentials using bbva payment method
    Then should see its information in the card
    And should be able to confirm the payment
    Examples:
      | webBrowser |
      | chrome     |
      | edge       |







