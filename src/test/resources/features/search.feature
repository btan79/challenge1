@SearchChallange
Feature: User performs search for a product and clicks on a product from the search results returned

  @PositiveScenario
  Scenario: Popular searches drop-down menu is displayed
    Given user is on the Bunnings home page
    When user clicks on the search field
    Then a drop-down menu with popular searches is displayed

  @PositiveScenario
  Scenario: User performs search for a product available on the website
    Given user is on the Bunnings home page
    When user searches for "plant"
    Then search results should be displayed to the user

  @PositiveScenario
  Scenario: User clicks on a particular search result to view the product
    Given user is on the search results page
    When user clicks on any product
    Then user should be redirected to that product page

  @NegativeScenario
  Scenario: User performs search for a product unavailable on the website
    Given user is on the Bunnings home page
    When user searches for "qaz"
    Then relevant error message should be displayed to the user

