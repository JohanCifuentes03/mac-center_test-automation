Feature: Purchase items on mac-center.com
  As a user of the mac-center.com platform
  I want to buy various items
  So that I can enjoy and use them

  # generated data will be using data faker
  Scenario Outline: Successfully purchase items
    Given the user is on the mac-center.com platform using "<webBrowser>"
    When adds the following items to the cart
      | Iphone 13       |
      | Macbook pro     |
      | Airpods         |
    And confirms their credentials using bbva payment method
    Then should receive a confirmation message indicating a successful purchase
    Examples:
      | webBrowser |
      #| chrome     |
      | edge       |