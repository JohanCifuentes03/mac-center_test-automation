Feature: Register account on mac-center.com
  As a user of the mac-center.com platform
  I want to register an account
  So that I can be notified for promotions


  @web
  Scenario Outline: Successfully register an account
    Given the user is on the mac-center.com platform using "<webBrowser>"
    When registers its account using valid credentials
    Then should be logged in the web page
    Examples:
      | webBrowser |
      | chrome     |
      | edge       |