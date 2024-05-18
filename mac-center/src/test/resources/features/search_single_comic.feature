Feature: Search single comic using GET service
  As a user of marvel.com
  I want to search for information about a comic
  So that I can view its details and enjoy the content

  @service
  Scenario Outline: Search single comic
    Given the user is connected to the Marvel Developer API
    When sends a GET request using id <id>
    Then comic name should be <title>
    And  should receive a response of 200
    Examples:
      | id    | title                                                  |
      | 1332  | "X-Men: Days of Future Past (Trade Paperback)"         |
      | 1308  | "Marvel Age Spider-Man Vol. 2: Everyday Hero (Digest)" |
      | 15094 | "Silver Surfer (1987)"                                 |