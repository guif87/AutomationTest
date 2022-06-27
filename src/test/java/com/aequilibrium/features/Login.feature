@AllTests
Feature: Login
  As a user, I want to log into SwagLabs, this feature will check if the page correctly loads and validate positive and negative tests

  @LoginTests
  Scenario: LOGIN001 - Validate login screen labels and button
    Given I have accessed SwagLabs login page
    Then I Validate that labels and button are correct
    
  @LoginTests
  Scenario: LOGIN002 - Successful Login - standard_user
    Given I have accessed SwagLabs login page
    Then I fill in the user 'standard_user'
    And I fill the password 'secret_sauce'
    And I click on Login button to proceed
    Then I validate list of products after login
    
  @LoginTests
  Scenario: LOGIN003 - Successful Login - problem_user
    Given I have accessed SwagLabs login page
    Then I fill in the user 'problem_user'
    And I fill the password 'secret_sauce'
    And I click on Login button to proceed
    Then I validate list of products with wrong photos
    
  @LoginTests
  Scenario: LOGIN004 - Successful Login - performance_glitch_user
    Given I have accessed SwagLabs login page
    Then I fill in the user 'performance_glitch_user'
    And I fill the password 'secret_sauce'
    And I click on Login button to proceed
    #Create step to validate performance
    Then I validate list of products after login
    
  @LoginTests
  #Tests will fail as I wasn't able to properly add the h3 error message by xpath and not even by css
  Scenario Outline: LOGIN005 - Unsuccessful Login
    Given I have accessed SwagLabs login page
    Then I fill in the user '<username>'
    And I fill the password '<password>'
    And I click on Login button to proceed
    Then I validate the error message '<type>'
    
  Examples: 
    | username        | password     | type              |
    |                 | secret_sauce | Username required |
    | standard_user   |              | Password required |
    | test_qa         | TestQA       | Not in system     |
    | locked_out_user | secret_sauce | Locked Out        |
    
   